package net.kogasachan.upgradedbread.event.handler;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.config.BreadConfigs;
import net.kogasachan.upgradedbread.effect.BreadEffects;
import net.kogasachan.upgradedbread.sound.BreadSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = UpgradedBread.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AutoRepairEventHandler {
    // 消耗一定经验对装备进行自动修补
    //每点经验修复的耐久值 (与原版经验修补一致)
    private static final int DURABILITY_PER_EXP = 2;
    // 基础修复间隔 (tick)
    private static final int BASE_INTERVAL = 20;

    // 存储每个玩家的 tick 计数器
    private static final Map<UUID, Integer> TICK_COUNTER = new HashMap<>();

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        Player player = event.player;
        if (player.level().isClientSide()) return;

        // 检查是否拥有效果
        MobEffectInstance effect = player.getEffect(BreadEffects.AUTO_REPAIR.get());
        if (effect == null) {
            // 效果不存在时清理计数器
            TICK_COUNTER.remove(player.getUUID());
            return;
        }

        int amplifier = effect.getAmplifier(); // 等级
        // 修复间隔 = 基础间隔 / (等级 + 1), 至少为 1
        int interval = Math.max(1, BASE_INTERVAL / (amplifier + 1));

        UUID uuid = player.getUUID();
        int count = TICK_COUNTER.getOrDefault(uuid, 0) + 1;
        if (count < interval) {
            TICK_COUNTER.put(uuid, count);
            return;
        }
        // 达到间隔, 执行修复
        TICK_COUNTER.put(uuid, 0); // 重置计数器

        // 获取当前总经验值
        int totalExp = player.totalExperience;
        if (totalExp <= 0) return;

        // 遍历所有装备槽位 (主手, 副手, 头盔, 胸甲, 腿甲, 靴子)
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            ItemStack stack = player.getItemBySlot(slot);
            if (stack.isEmpty()) continue; // 未装备物品
            if (!stack.isDamageableItem()) continue; // 不可修复
            if (stack.getDamageValue() == 0) continue; // 已满耐久

            // 计算修复所需经验 (每 DURABILITY_PER_EXP 经验修复 1 点耐久)
            int neededRepair = stack.getDamageValue();
            int expCost = (int) Math.ceil((double) neededRepair / DURABILITY_PER_EXP);
            if (expCost <= 0) continue;

            // 实际可消耗的经验
            int useExp = Math.min(totalExp, expCost);
            if (useExp <= 0) continue;

            // 当确定要施加抢救效果时, 播放自定义音效
            // 在服务端执行, 这样所有玩家都能听到
            if (!player.level().isClientSide() && BreadConfigs.SERVER.enableSpecialSound.get()) {
                player.level().playSound(null,
                        player.getX(), player.getY(), player.getZ(),
                        BreadSounds.AUTO_REPAIR.get(), // 注册的音效事件
                        SoundSource.PLAYERS,            // 音效分类, 影响音量滑块
                        1.0f,                           // 音量
                        1.0f);                          // 音高
            }

            // 扣除经验
            player.giveExperiencePoints(-useExp);

            // 修复物品
            int repairAmount = useExp * DURABILITY_PER_EXP;
            int newDamage = Math.max(0, stack.getDamageValue() - repairAmount);
            stack.setDamageValue(newDamage);

            // 更新剩余经验
            totalExp -= useExp;
            if (totalExp <= 0) break;
        }
    }
}