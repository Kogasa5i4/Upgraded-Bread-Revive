package net.kogasachan.upgradedbread.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FrostedIceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import org.jetbrains.annotations.NotNull;

public class FreezingBody extends MobEffect {
    public FreezingBody(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
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

    //来自原版冰霜行者附魔的代码
    public static void onEntityMoved(LivingEntity pLiving, Level pLevel, BlockPos pPos, int pLevelConflicting) {
        if (pLiving.onGround()) {
            BlockState blockstate = Blocks.FROSTED_ICE.defaultBlockState();
            int i = Math.min(16, 2 + pLevelConflicting);
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

            int dy;
            if (pLiving.getY() % 1 != 0) dy = 0; else dy = -1;
            //防止因为不完整方块无法生效

            for(BlockPos blockpos : BlockPos.betweenClosed(pPos.offset(-i, dy, -i), pPos.offset(i, dy, i))) {
                if (blockpos.closerToCenterThan(pLiving.position(), i)) {
                    blockpos$mutableblockpos.set(blockpos.getX(), blockpos.getY() + 1, blockpos.getZ());
                    BlockState blockstate1 = pLevel.getBlockState(blockpos$mutableblockpos);
                    if (blockstate1.isAir()) {
                        BlockState blockstate2 = pLevel.getBlockState(blockpos);
                        if (blockstate2 == FrostedIceBlock.meltsInto() && blockstate.canSurvive(pLevel, blockpos) && pLevel.isUnobstructed(blockstate, blockpos, CollisionContext.empty()) && !net.minecraftforge.event.ForgeEventFactory.onBlockPlace(pLiving, net.minecraftforge.common.util.BlockSnapshot.create(pLevel.dimension(), pLevel, blockpos), net.minecraft.core.Direction.UP)) {
                            pLevel.setBlockAndUpdate(blockpos, blockstate);
                            pLevel.scheduleTick(blockpos, Blocks.FROSTED_ICE, Mth.nextInt(pLiving.getRandom(), 60, 120));
                        }
                    }
                }
            }
        }
    }
}