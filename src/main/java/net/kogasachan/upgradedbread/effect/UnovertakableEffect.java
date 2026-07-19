package net.kogasachan.upgradedbread.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class UnovertakableEffect extends MobEffect {
    private static final UUID SPEED_MOD_UUID = UUID.fromString("a1b2c3d4-e5f6-7890-abcd-ef1234567890");
    private static final UUID ATTACK_SPEED_MOD_UUID = UUID.fromString("b2c3d4e5-f6a7-8901-bcde-f234567890ab");

    public UnovertakableEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide()) {
            var speedAttr = entity.getAttribute(Attributes.MOVEMENT_SPEED);
            if (speedAttr != null && speedAttr.getModifier(SPEED_MOD_UUID) == null) {
                speedAttr.addPermanentModifier(new AttributeModifier(
                        SPEED_MOD_UUID,
                        "forbidden_speed_boost",
                        2.0,
                        AttributeModifier.Operation.MULTIPLY_TOTAL
                ));
            }

            var attackAttr = entity.getAttribute(Attributes.ATTACK_SPEED);
            if (attackAttr != null && attackAttr.getModifier(ATTACK_SPEED_MOD_UUID) == null) {
                attackAttr.addPermanentModifier(new AttributeModifier(
                        ATTACK_SPEED_MOD_UUID,
                        "forbidden_attack_speed_boost",
                        2.0,
                        AttributeModifier.Operation.MULTIPLY_TOTAL
                ));
            }
        }
        super.applyEffectTick(entity, amplifier);
    }

    public void removeAttributeModifiers(LivingEntity entity, @NotNull AttributeMap modifier, int amplifier) {
        var speedAttr = entity.getAttribute(Attributes.MOVEMENT_SPEED);
        if (speedAttr != null) speedAttr.removeModifier(SPEED_MOD_UUID);

        var attackAttr = entity.getAttribute(Attributes.ATTACK_SPEED);
        if (attackAttr != null) attackAttr.removeModifier(ATTACK_SPEED_MOD_UUID);

        super.removeAttributeModifiers(entity, modifier, amplifier);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}