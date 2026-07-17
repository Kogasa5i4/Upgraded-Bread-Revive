package net.kogasachan.upgradedbread.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class PerfectFreeze extends MobEffect {
    public PerfectFreeze(MobEffectCategory mobEffectCategory, int color){
        super(mobEffectCategory,color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        @SuppressWarnings("resource")
        var level = pLivingEntity.level();
        if(!level.isClientSide()){
            double x = pLivingEntity.getX();
            double y = pLivingEntity.getY();
            double z = pLivingEntity.getZ();
            pLivingEntity.teleportTo(x,y,z);
            pLivingEntity.setDeltaMovement(0,0,0);
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
