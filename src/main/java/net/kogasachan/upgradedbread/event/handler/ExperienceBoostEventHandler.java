package net.kogasachan.upgradedbread.event.handler;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.effect.BreadEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UpgradedBread.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ExperienceBoostEventHandler {
    // 当且仅当玩家获得经验 (original > 0) 时生效
    @SubscribeEvent
    public static void onXpChange(PlayerXpEvent.XpChange event) {
        Player player = event.getEntity();
        if (player.hasEffect(BreadEffects.EXPERIENCE_BOOST.get())) {
            int amplifier = player.getEffect(BreadEffects.EXPERIENCE_BOOST.get()).getAmplifier();
            float multiplier = 1.0f + (amplifier + 1) * 0.1f;
            int original = event.getAmount();
            if (original > 0) {
                int boosted = Math.round(original * multiplier);
                event.setAmount(boosted);
            }
        }
    }
}