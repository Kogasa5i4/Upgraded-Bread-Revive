package net.kogasachan.upgradedbread.event.handler;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.damage.BreadDamageTypes;
import net.kogasachan.upgradedbread.effect.BreadEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UpgradedBread.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class UnovertakableDeathEventHandler {

    private static final String DEATH_MARKER = "unovertakable_death";

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!player.hasEffect(BreadEffects.UNOVERTAKABLE.get())) return;
        // 防止递归
        if (player.getPersistentData().getBoolean(DEATH_MARKER)) return;

        // 移除可能冲突的经验护盾效果
        if (player.hasEffect(BreadEffects.EXPERIENCE_SHIELD.get())) {
            player.removeEffect(BreadEffects.EXPERIENCE_SHIELD.get());
        }

        // 取消原死亡事件
        event.setCanceled(true);
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

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!player.hasEffect(BreadEffects.UNOVERTAKABLE.get())) return;
        // 仅限致死伤害
        if (player.isAlive() || player.getHealth() > 0) return;
        // 防止递归
        if (player.getPersistentData().getBoolean(DEATH_MARKER)) return;

        // 移除可能冲突的经验护盾效果
        if (player.hasEffect(BreadEffects.EXPERIENCE_SHIELD.get())) {
            player.removeEffect(BreadEffects.EXPERIENCE_SHIELD.get());
        }

        // 取消原受伤事件
        event.setCanceled(true);
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

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (!player.hasEffect(BreadEffects.UNOVERTAKABLE.get())) return;
        // 仅限致死伤害
        if (player.isAlive() || player.getHealth() > 0) return;
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

    // 玩家重生时清除标记 (防止残留)
    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        event.getEntity().getPersistentData().remove(DEATH_MARKER);
    }
}