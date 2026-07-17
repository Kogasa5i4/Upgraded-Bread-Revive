package net.kogasachan.upgradedbread.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
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
        Level plevel = pLivingEntity.level();
        if (!plevel.isClientSide()) {
            if (pLivingEntity.onGround()) {
                BlockPos position = pLivingEntity.blockPosition().below();
                BlockState blockstate = Blocks.FROSTED_ICE.defaultBlockState();
                BlockPos[] pos = new BlockPos[]{
                        position, position.east(), position.west(), position.south(), position.north(),
                        position.north().east(), position.north().west(), position.south().east(), position.south().west()
                };
                for (BlockPos p : pos) {
                    BlockState blockstate1 = plevel.getBlockState(p.above());
                    if (blockstate1.isAir()) {
                        BlockState blockstate2 = plevel.getBlockState(p);
                        boolean isFull = blockstate2.getBlock() == Blocks.WATER && blockstate2.getValue(LiquidBlock.LEVEL) == 0;
                        if (blockstate2.getBlock() == Blocks.WATER &&
                                isFull &&
                                blockstate.canSurvive(plevel, p) &&
                                plevel.isUnobstructed(blockstate, p, CollisionContext.empty()) &&
                                !net.minecraftforge.event.ForgeEventFactory.onBlockPlace(pLivingEntity, net.minecraftforge.common.util.BlockSnapshot.create(plevel.dimension(), plevel, p), net.minecraft.core.Direction.UP)) {
                            plevel.setBlockAndUpdate(p, blockstate);
                            plevel.scheduleTick(p, Blocks.FROSTED_ICE, Mth.nextInt(pLivingEntity.getRandom(), 60, 120));
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
