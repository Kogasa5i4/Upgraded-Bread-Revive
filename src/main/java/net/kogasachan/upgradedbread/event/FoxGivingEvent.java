package net.kogasachan.upgradedbread.event;

import net.kogasachan.upgradedbread.config.BreadConfigs;
import net.kogasachan.upgradedbread.item.BreadItems;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class FoxGivingEvent {
    @SubscribeEvent
    public void onBabyFoxSpawn(BabyEntitySpawnEvent event) {
        // 检查配置文件是否启用
        if (!BreadConfigs.SERVER.enableSpecialGain.get()) return;

        // 检查出生的幼崽是否是狐狸
        if (!(event.getChild() instanceof Fox)) return;

        // 检查促成这次繁殖的玩家是否存在
        Player player = event.getCausedByPlayer();
        if (player == null) return;

        // 按配置文件概率获得物品 (使用幼崽的随机源)
        if (event.getChild().getRandom().nextFloat() < BreadConfigs.SERVER.specialGainChance.get()) {
            // 给玩家一个狐赐长棍 (顾名思义嘛)
            player.getInventory().add(new ItemStack(BreadItems.FOX_GIFT_LONG_BREAD.get(), 1));
        }
    }
}