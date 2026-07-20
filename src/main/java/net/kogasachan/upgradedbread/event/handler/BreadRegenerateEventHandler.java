package net.kogasachan.upgradedbread.event.handler;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.config.BreadConfigs;
import net.kogasachan.upgradedbread.effect.BreadEffects;
import net.kogasachan.upgradedbread.item.BreadItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = UpgradedBread.MODID)
public class BreadRegenerateEventHandler {
    // 开启配置文件的情况下, 执行生命提升（小幅）属性叠加和伤害吸收
    private static final Map<UUID, Integer> EAT_COUNT = new HashMap<>();

    @SubscribeEvent
    public static void onItemFinish(LivingEntityUseItemEvent.Finish event) {
        ItemStack stack = event.getItem();
        if (stack.getItem() != BreadItems.LEES_WAFFLE.get()) return;
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) return;

        boolean enableIncrement = BreadConfigs.SERVER.healthBreadEnableLevelIncrement.get();
        int default_level = BreadConfigs.SERVER.healthBreadDefaultLevel.get();
        int level;
        if (enableIncrement) {
            UUID uuid = player.getUUID();
            int count = EAT_COUNT.getOrDefault(uuid, 0) + 1;
            EAT_COUNT.put(uuid, count);
            int maxExtra = BreadConfigs.SERVER.healthBreadMaxLevel.get();
            int maxLevel = Math.min(255, default_level + maxExtra);
            level = Math.min(count - 1 + default_level, maxLevel);
        } else {
            level = default_level;
        }

        int duration = -1;
        player.addEffect(new MobEffectInstance(BreadEffects.MINOR_HEALTH_BOOST.get(), duration, level));

        if (player.getHealth() == player.getMaxHealth() && BreadConfigs.SERVER.healthBreadEnableAbsorption.get())
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, BreadConfigs.SERVER.healthBreadAbsorptionMaxTime.get(), BreadConfigs.SERVER.healthBreadAbsorptionLevel.get()), player);
        player.setHealth(player.getMaxHealth());
    }
}