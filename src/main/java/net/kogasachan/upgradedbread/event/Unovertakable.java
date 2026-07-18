package net.kogasachan.upgradedbread.event;

import net.kogasachan.upgradedbread.config.BreadConfigs;
import net.kogasachan.upgradedbread.effect.BreadEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Unovertakable {
    private static final UUID HEALTH_PENALTY_UUID = UUID.fromString("c3d4e5f6-a7b8-90ab-cdef-1234567890ab");
    private static final Map<UUID, Integer> PENALTY_COUNT = new HashMap<>();
    private static final Map<UUID, Integer> EAT_COUNT = new HashMap<>();

    @SubscribeEvent
    public void onEffectRemoved(MobEffectEvent.Remove event) {
        if (event.getEffect() != null && event.getEffect() == BreadEffects.UNOVERTAKABLE.get()) {
            applyPenalty(event.getEntity());
        }
    }

    @SubscribeEvent
    public void onEffectExpired(MobEffectEvent.Expired event) {
        MobEffectInstance instance = event.getEffectInstance();
        if (instance != null && instance.getEffect() == BreadEffects.UNOVERTAKABLE.get()) {
            applyPenalty(event.getEntity());
        }
    }

    private void applyPenalty(LivingEntity entity) {
        if (entity.level().isClientSide()) return;
        if (!(entity instanceof Player player)) return;

        UUID playerId = player.getUUID();
        int count = PENALTY_COUNT.getOrDefault(playerId, 0) + 1;
        PENALTY_COUNT.put(playerId, count);
        double totalPenalty = count * 4.0;

        var maxHealthAttr = player.getAttribute(Attributes.MAX_HEALTH);
        if (maxHealthAttr != null) {
            maxHealthAttr.removeModifier(HEALTH_PENALTY_UUID);
            maxHealthAttr.addPermanentModifier(new AttributeModifier(
                    HEALTH_PENALTY_UUID,
                    "forbidden_health_penalty",
                    -totalPenalty,
                    AttributeModifier.Operation.ADDITION
            ));
        }

        if (player.getHealth() > player.getMaxHealth()) {
            player.setHealth(player.getMaxHealth());
        }

        int eatCount = EAT_COUNT.getOrDefault(playerId, 0) + 1;
        EAT_COUNT.put(playerId, eatCount);

        if (eatCount >= 3) {
            EAT_COUNT.put(playerId, 0);
            player.setHealth(0.01f);
            return;
        }

        double chance = BreadConfigs.SERVER.penaltyDeathChance.get();
        if (player.getRandom().nextFloat() < chance) {
            player.setHealth(0);
        }
    }

    @SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        Player player = event.getEntity();
        UUID playerId = player.getUUID();
        PENALTY_COUNT.remove(playerId);
        EAT_COUNT.remove(playerId);

        var maxHealthAttr = player.getAttribute(Attributes.MAX_HEALTH);
        if (maxHealthAttr != null) {
            maxHealthAttr.removeModifier(HEALTH_PENALTY_UUID);
        }
    }
}