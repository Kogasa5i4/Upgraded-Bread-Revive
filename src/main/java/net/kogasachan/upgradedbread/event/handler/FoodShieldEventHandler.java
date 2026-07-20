package net.kogasachan.upgradedbread.event.handler;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.effect.BreadEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UpgradedBread.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FoodShieldEventHandler {
    // 用你的胃袋抵挡伤害
    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        // 仅对玩家有效
        if (!(event.getEntity() instanceof Player player)) return;
        // 检查是否有食御效果
        if (!player.hasEffect(BreadEffects.FOOD_SHIELD.get())) return;

        float damage = event.getAmount();
        if (damage <= 0) return;

        FoodData foodData = player.getFoodData();
        float saturation = foodData.getSaturationLevel();
        int foodLevel = foodData.getFoodLevel();

        // 可用总抵抗值 = 饱和度 + 饱食度
        float totalResist = saturation + foodLevel;
        if (totalResist <= 0) return;

        // 实际抵扣的伤害量
        float absorbed = Math.min(damage, totalResist);

        // 消耗饱和度 (优先)
        float consumeSaturation = Math.min(saturation, absorbed);
        saturation -= consumeSaturation;
        absorbed -= consumeSaturation;

        // 若还有剩余, 消耗饱食度
        int consumeFood = 0;
        if (absorbed > 0) {
            // 向上取整, 确保至少消耗 1 点饱食度 (即使剩余伤害小于 1)
            consumeFood = Math.min((int) Math.ceil(absorbed), foodLevel);
            foodLevel -= consumeFood;
        }

        // 更新饱和度和饱食度
        foodData.setSaturation(saturation);
        foodData.setFoodLevel(foodLevel);

        // 更新事件伤害值
        float finalDamage = Math.max(0, damage - consumeSaturation - consumeFood);
        event.setAmount(finalDamage);
    }
}