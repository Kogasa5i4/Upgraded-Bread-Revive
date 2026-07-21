package net.kogasachan.upgradedbread.event.handler;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.config.BreadConfigs;
import net.kogasachan.upgradedbread.effect.BreadEffects;
import net.kogasachan.upgradedbread.item.BreadItems;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;
import java.util.List;

@Mod.EventBusSubscriber(modid = UpgradedBread.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FoxGiftEffectEventHandler {
    // 触发概率
    private static final double TRIGGER_CHANCE = BreadConfigs.SERVER.specialEffectChance.get();
    // 效果持续时间
    private static final int DURATION = 1200;
    // 药水效果列表: 延迟初始化, 避免 runData 时因 RegistryObject 未注册而报错
    private static List<MobEffect> EFFECTS = null;
    private static List<MobEffect> getEffects() {
        if (EFFECTS == null) {
            EFFECTS = Arrays.asList(
                    BreadEffects.TIME_REVERSE.get(),
                    BreadEffects.EXPERIENCE_BOOST.get(),
                    BreadEffects.AUTO_REPAIR.get(),
                    BreadEffects.EXPERIENCE_SHIELD.get(),
                    BreadEffects.BURNING_ATTACK.get(),
                    MobEffects.LUCK
            );
        }
        return EFFECTS;
    }

    @SubscribeEvent
    public static void onItemFinish(LivingEntityUseItemEvent.Finish event) {
        // 检查配置文件是否启用
        if (!BreadConfigs.SERVER.enableSpecialEffect.get()) return;

        // 只处理玩家
        if (!(event.getEntity() instanceof Player player)) return;

        ItemStack usedItem = event.getItem();
        // 检查是否为指定的食物
        if (!usedItem.is(BreadItems.FOX_GIFT_LONG_BREAD.get())) return;

        // 概率判定
        if (player.getRandom().nextDouble() >= TRIGGER_CHANCE) {
            // 未触发, 什么都不做
            return;
        }

        // 随机选择一个效果
        List<MobEffect> effects = getEffects();
        MobEffect selectedEffect = effects.get(player.getRandom().nextInt(effects.size()));

        // 随机生成: 1 - 10 级
        int randomAmplifier = player.getRandom().nextInt(10); // 0 - 9

        // 应用效果
        player.addEffect(new MobEffectInstance(selectedEffect, DURATION, randomAmplifier));
    }
}