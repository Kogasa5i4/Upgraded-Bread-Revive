package net.kogasachan.upgradedbread.event.handler;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.effect.BreadEffects;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UpgradedBread.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GuaranteedFullnessHandler {
    // 再也不会饿了
    // 顺便获得了极快的回血速度 (满饱和度) , 可惜这里没有饱腹代偿
    // 现在有了 (逃)
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.START) return;
        Player player = event.player;
        if (player.level().isClientSide()) return;
        if (player.hasEffect(BreadEffects.GUARANTEED_FULLNESS.get())) {
            player.getFoodData().setExhaustion(0.0f);
            if (player.hasEffect(MobEffects.HUNGER)) {
                player.removeEffect(MobEffects.HUNGER);
            }
        }
    }
}