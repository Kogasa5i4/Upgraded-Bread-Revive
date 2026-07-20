package net.kogasachan.upgradedbread.event.handler;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.effect.BreadEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UpgradedBread.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AutoRepairEventHandler {
    //每点经验修复的耐久值 (与原版 Mending 一致)
    private static final int DURABILITY_PER_EXP = 2;

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        Player player = event.player;
        if (player.level().isClientSide()) return;
        if (!player.hasEffect(BreadEffects.AUTO_REPAIR.get())) return;

        // 获取当前总经验值
        int totalExp = player.totalExperience;
        if (totalExp <= 0) return;

        // 遍历所有装备槽位 (主手, 副手, 头盔, 胸甲, 腿甲, 靴子)
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            ItemStack stack = player.getItemBySlot(slot);
            if (stack.isEmpty()) continue;
            if (!stack.isDamageableItem()) continue;
            if (stack.getDamageValue() == 0) continue; // 已满耐久

            // 计算修复所需经验 (每 DURABILITY_PER_EXP 经验修复 1 点耐久)
            int neededRepair = stack.getDamageValue();
            int expCost = (int) Math.ceil((double) neededRepair / DURABILITY_PER_EXP);
            if (expCost <= 0) continue;

            // 实际可消耗的经验
            int useExp = Math.min(totalExp, expCost);
            if (useExp <= 0) continue;

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