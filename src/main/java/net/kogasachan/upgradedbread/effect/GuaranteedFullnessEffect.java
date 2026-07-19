package net.kogasachan.upgradedbread.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class GuaranteedFullnessEffect extends MobEffect {
    //管饱: 饱食度与饱和度保持不变, 且免疫饥饿效果
    //仅作为标记注册, 实际效果在event.handler软件包下
    public GuaranteedFullnessEffect(MobEffectCategory category, int color) { super(category, color); }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) { return false; }
}