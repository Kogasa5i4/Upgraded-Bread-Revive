package net.kogasachan.upgradedbread.effect;

import net.kogasachan.upgradedbread.event.handler.FrostWalkerHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class FreezingBodyEffect extends MobEffect {
    //*操控冷气程度的能力: 效果相当于冰霜行者附魔, 但是有所改进
    //部分效果实现在event.handler软件包下
    public FreezingBodyEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    //来自原版冰霜行者附魔的代码, 已注册为单独的类方便调用
    public static void onEntityMoved(LivingEntity pLiving, Level pLevel, BlockPos pPos, int pLevelConflicting) {
        FrostWalkerHandler.onEntityMoved(pLiving, pLevel, pPos, pLevelConflicting);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);
        if (pLivingEntity.level().isClientSide()) return;
        onEntityMoved(pLivingEntity, pLivingEntity.level(), pLivingEntity.blockPosition(), pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}