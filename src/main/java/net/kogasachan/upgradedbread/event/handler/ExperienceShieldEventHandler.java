package net.kogasachan.upgradedbread.event.handler;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.effect.BreadEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UpgradedBread.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ExperienceShieldEventHandler {
    // 献祭你的经验, 重获新生
    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!player.hasEffect(BreadEffects.EXPERIENCE_SHIELD.get())) return;

        float damage = event.getAmount();
        float currentHealth = player.getHealth();
        // 判断是否致命伤害
        if (currentHealth - damage > 0) return;

        // 检查经验等级
        if (player.experienceLevel < 1) return;

        // 消耗一级经验
        player.giveExperienceLevels(-1);

        // 完全抵消伤害
        event.setAmount(0);

        // 回满血
        player.setHealth(player.getMaxHealth());

        // 清除所有状态效果 (包括正面和负面)
        player.removeAllEffects();
    }
}