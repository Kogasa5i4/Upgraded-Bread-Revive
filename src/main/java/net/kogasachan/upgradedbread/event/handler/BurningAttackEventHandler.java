package net.kogasachan.upgradedbread.event.handler;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.effect.BreadEffects;
import net.kogasachan.upgradedbread.sound.BreadSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UpgradedBread.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BurningAttackEventHandler {
    // 点燃你的敌人
    // 基础着火时间 (秒), 等级 0 为 2 秒, 每升一级增加 1 秒
    private static final int BASE_FIRE_SECONDS = 2;
    private static final int FIRE_PER_LEVEL = 1;

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        // 判断攻击者是否为玩家
        if (!(event.getSource().getEntity() instanceof Player player)) return;

        // 检查玩家是否拥有灼热效果
        MobEffectInstance effect = player.getEffect(BreadEffects.BURNING_ATTACK.get());
        if (effect == null) return;

        // 当确定要施加火焰效果时, 播放自定义音效
        // 在服务端执行, 这样所有玩家都能听到
        if (!player.level().isClientSide()) {
            player.level().playSound(null,
                    player.getX(), player.getY(), player.getZ(),
                    BreadSounds.BURNING_ATTACK.get(), // 注册的音效事件
                    SoundSource.PLAYERS,            // 音效分类, 影响音量滑块
                    1.0f,                           // 音量
                    1.0f);                          // 音高
        }

        // 获取效果等级 (0 - based)
        int amplifier = effect.getAmplifier();
        // 着火时间 (tick)
        int fireTicks = (BASE_FIRE_SECONDS + amplifier * FIRE_PER_LEVEL) * 20;

        // 对被攻击的目标施加火焰效果
        LivingEntity target = event.getEntity();
        target.setRemainingFireTicks(fireTicks);
    }
}