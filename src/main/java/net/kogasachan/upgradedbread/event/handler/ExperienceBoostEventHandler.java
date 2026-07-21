package net.kogasachan.upgradedbread.event.handler;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.config.BreadConfigs;
import net.kogasachan.upgradedbread.effect.BreadEffects;
import net.kogasachan.upgradedbread.sound.BreadSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = UpgradedBread.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ExperienceBoostEventHandler {
    // 当且仅当玩家获得经验 (original > 0) 时生效
    @SubscribeEvent
    public static void onXpChange(PlayerXpEvent.XpChange event) {
        Player player = event.getEntity();
        if (player.hasEffect(BreadEffects.EXPERIENCE_BOOST.get())) {
            int amplifier = Objects.requireNonNull(player.getEffect(BreadEffects.EXPERIENCE_BOOST.get())).getAmplifier();
            float multiplier = 1.0f + (amplifier + 1) * 0.1f;
            int original = event.getAmount();
            if (original > 0) {
                // 当确定要施加经验汲取效果时, 播放自定义音效
                // 在服务端执行, 这样所有玩家都能听到
                if (!player.level().isClientSide() && BreadConfigs.SERVER.enableSpecialSound.get()) {
                    player.level().playSound(null,
                            player.getX(), player.getY(), player.getZ(),
                            BreadSounds.EXPERIENCE_BOOST.get(), // 注册的音效事件
                            SoundSource.PLAYERS,            // 音效分类, 影响音量滑块
                            1.0f,                           // 音量
                            1.0f);                          // 音高
                }
                int boosted = Math.round(original * multiplier);
                event.setAmount(boosted);
            }
        }
    }
}