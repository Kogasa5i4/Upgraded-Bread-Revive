package net.kogasachan.upgradedbread.event;

import net.kogasachan.upgradedbread.config.BreadConfigs;
import net.kogasachan.upgradedbread.damage.BreadDamageTypes;
import net.kogasachan.upgradedbread.effect.BreadEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UnovertakableEvent {
    // 晚上只睡 4 个小时, 三口吃掉一根巧乐兹, 然后跑 10 公里, 跑完一口气灌一瓶冰雪碧. ---- 雪人三项
    private static final UUID HEALTH_PENALTY_UUID = UUID.fromString("c3d4e5f6-a7b8-90ab-cdef-1234567890ab");
    private static final Map<UUID, Integer> PENALTY_COUNT = new HashMap<>();
    private static final Map<UUID, Integer> EAT_COUNT = new HashMap<>();

    // 完成雪人三项之后给予最大生命值惩罚
    @SubscribeEvent
    public void onEffectExpired(MobEffectEvent.Expired event) {
        MobEffectInstance instance = event.getEffectInstance();
        if (instance != null && instance.getEffect() == BreadEffects.UNOVERTAKABLE.get()) {
            applyPenalty(event.getEntity());
        }
    }

    // 逃课也没用哦~
    @SubscribeEvent
    public void onEffectRemoved(MobEffectEvent.Remove event) {
        if (event.getEffect() != null && event.getEffect() == BreadEffects.UNOVERTAKABLE.get()) {
            applyPenalty(event.getEntity());
        }
    }

    private void applyPenalty(LivingEntity entity) {
        if (entity.level().isClientSide()) return;
        if (!(entity instanceof Player player)) return;

        UUID playerId = player.getUUID();
        int count = PENALTY_COUNT.getOrDefault(playerId, 0) + 1;
        PENALTY_COUNT.put(playerId, count);
        double totalPenalty = count * 4.0;

        var maxHealthAttr = player.getAttribute(Attributes.MAX_HEALTH);
        if (maxHealthAttr != null) {
            maxHealthAttr.removeModifier(HEALTH_PENALTY_UUID);
            maxHealthAttr.addPermanentModifier(new AttributeModifier(
                    HEALTH_PENALTY_UUID,
                    "forbidden_health_penalty",
                    -totalPenalty,
                    AttributeModifier.Operation.ADDITION
            ));
        }

        // 防止血量超上限
        if (player.getHealth() > player.getMaxHealth()) {
            player.setHealth(player.getMaxHealth());
        }

        int eatCount = EAT_COUNT.getOrDefault(playerId, 0) + 1;
        EAT_COUNT.put(playerId, eatCount);

        // 吃太多概率给予巨大惩罚, 一定程度上防止玩家试图无限续杯来逃课
        if (eatCount >= 3) {
            EAT_COUNT.put(playerId, 0);
            player.setHealth(0.01f);
            return;
        }

        // 按配置文件决定吃完巧乐兹后玩家因药水效果结束而死亡的概率
        // 你一句别怂, 我就敢往前冲~
        double chance = BreadConfigs.SERVER.penaltyDeathChance.get();
        if (player.getRandom().nextFloat() < chance) {
            String DEATH_MARKER = "unovertakable_death";
            // 防止递归
            if (player.getPersistentData().getBoolean(DEATH_MARKER)) return;

            // 移除可能冲突的经验护盾效果
            if (player.hasEffect(BreadEffects.EXPERIENCE_SHIELD.get())) {
                player.removeEffect(BreadEffects.EXPERIENCE_SHIELD.get());
            }

            // 标记, 防止循环
            player.getPersistentData().putBoolean(DEATH_MARKER, true);

            // 获取自定义伤害类型
            Level level = player.level();
            Holder<DamageType> type = level.registryAccess()
                    .lookupOrThrow(Registries.DAMAGE_TYPE)
                    .getOrThrow(BreadDamageTypes.UNOVERTAKABLE);

            // 构造无来源伤害 (causingEntity 和 directEntity 均为 null)
            DamageSource source = new DamageSource(
                    type,
                    null, // 无造成者
                    null  // 无直接攻击者
            ) {
                @Override
                public boolean isIndirect() {
                    return true; // 间接伤害
                }
            };

            // 施加致命伤害 (会导致玩家死亡, 并触发自定义死亡信息)
            player.hurt(source, Float.MAX_VALUE);

            // 补刀防止不死
            while (player.isAlive() && player.getHealth() > 0) {player.setHealth(0);}
        }
    }

    // 玩家死亡后移除惩罚
    @SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        Player player = event.getEntity();
        UUID playerId = player.getUUID();
        PENALTY_COUNT.remove(playerId);
        EAT_COUNT.remove(playerId);

        var maxHealthAttr = player.getAttribute(Attributes.MAX_HEALTH);
        if (maxHealthAttr != null) {
            maxHealthAttr.removeModifier(HEALTH_PENALTY_UUID);
        }
    }
}