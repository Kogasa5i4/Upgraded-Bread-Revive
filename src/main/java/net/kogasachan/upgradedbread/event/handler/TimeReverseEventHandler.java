package net.kogasachan.upgradedbread.event.handler;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.effect.BreadEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = UpgradedBread.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TimeReverseEventHandler {
    // 逆转时间, 让你的生命值永远不会下降 ---- 前提是你活着
    // 记录每个玩家上一刻的血量
    private static final Map<UUID, Float> LAST_HEALTH = new HashMap<>();

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.START) return;
        Player player = event.player;
        if (player.level().isClientSide()) return;
        if (!player.isAlive()) return;

        if (player.hasEffect(BreadEffects.TIME_REVERSE.get())) {
            UUID uuid = player.getUUID();
            float currentHealth = player.getHealth();

            if (LAST_HEALTH.containsKey(uuid)) {
                float lastHealth = LAST_HEALTH.get(uuid);
                // 如果当前血量低于上一刻, 则回退到上一刻
                if (currentHealth < lastHealth) {
                    player.setHealth(lastHealth);
                }
            } else {
                // 第一次记录
                LAST_HEALTH.put(uuid, currentHealth);
            }
            // 更新记录为当前血量 (回退后的血量)
            LAST_HEALTH.put(uuid, player.getHealth());
        } else {
            // 效果消失时清理记录
            LAST_HEALTH.remove(player.getUUID());
        }
    }
}