package net.kogasachan.upgradedbread.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class MinorHealthBoostEffect extends MobEffect {
    private static final UUID HEALTH_MOD_UUID = UUID.fromString("a1b2c3d4-e5f6-7890-abcd-ef1234567890");

    public MinorHealthBoostEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    public void addAttributeModifiers(LivingEntity entity, @NotNull AttributeMap modifier, int amplifier) {
        double amount = amplifier + 1;
        var attr = entity.getAttribute(Attributes.MAX_HEALTH);
        if (attr != null) {
            attr.addPermanentModifier(new AttributeModifier(
                    HEALTH_MOD_UUID,
                    "minor_health_boost",
                    amount,
                    AttributeModifier.Operation.ADDITION
            ));
        }
        super.addAttributeModifiers(entity, modifier, amplifier);
    }

    public void removeAttributeModifiers(LivingEntity entity, @NotNull AttributeMap modifier, int amplifier) {
        var attr = entity.getAttribute(Attributes.MAX_HEALTH);
        if (attr != null) {
            attr.removeModifier(HEALTH_MOD_UUID);
        }
        super.removeAttributeModifiers(entity, modifier, amplifier);
    }
}