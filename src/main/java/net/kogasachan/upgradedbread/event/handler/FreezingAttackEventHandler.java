package net.kogasachan.upgradedbread.event.handler;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.effect.BreadEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = UpgradedBread.MODID, value = Dist.CLIENT)
public class FreezingAttackEventHandler {
    //玩家拥有完美冻结时攻击触发, 虽然能冻住敌人, 但是也有可能会冻住自己(果然是baka)
    @SubscribeEvent
    public static void FreezeAttack(AttackEntityEvent event) {
        Player player = event.getEntity();
        if (player.hasEffect(BreadEffects.FREEZING_BODY.get())) {
            if (event.getTarget() instanceof LivingEntity target) {
                Random r = new Random();
                target.addEffect(new MobEffectInstance(BreadEffects.PERFECT_FREEZE.get(), 80));
                if (r.nextInt(98) < 33) {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 2));
                }
            }
        }
    }
}