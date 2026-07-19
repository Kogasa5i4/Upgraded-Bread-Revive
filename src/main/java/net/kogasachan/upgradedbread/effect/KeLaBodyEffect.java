package net.kogasachan.upgradedbread.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class KeLaBodyEffect extends MobEffect {
    public KeLaBodyEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level().isClientSide() && pLivingEntity.tickCount % 20 == 0) {
            Level level = pLivingEntity.level();
            BlockPos pos = pLivingEntity.blockPosition().below();
            BlockState state = level.getBlockState(pos);
            if (state.getBlock() instanceof BonemealableBlock growable) {
                if (growable.isBonemealSuccess(level, level.random, pos, state)) {
                    if (level instanceof ServerLevel serverLevel) {
                        growable.performBonemeal(serverLevel, level.random, pos, state);
                    }
                }
            }
        }    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
