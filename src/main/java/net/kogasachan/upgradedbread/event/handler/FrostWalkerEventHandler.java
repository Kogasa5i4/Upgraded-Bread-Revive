package net.kogasachan.upgradedbread.event.handler;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FrostedIceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;

public class FrostWalkerEventHandler {
    //来自原版冰霜行者附魔的代码
    public static void onEntityMoved(LivingEntity pLiving, Level pLevel, BlockPos pPos, int pLevelConflicting) {
        if (pLiving.onGround() && !pLiving.isInWater()) {
            //新增!pLiving.isInWater()是为了防止在岸边1格深的水中前进并上浮时触发效果(所以这个bug到底是怎么发现的)
            BlockState blockstate = Blocks.FROSTED_ICE.defaultBlockState();
            int i = Math.min(16, 2 + pLevelConflicting);
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

            int dy;
            if (pLiving.getY() % 1 != 0) dy = 0;
            else dy = -1;
            //新增dy的判别防止因为不完整方块无法生效
            //但是也会导致在活板门等方块上方时玩家冻结周围的水, 还得跳一下才能走上去(baka修复了一个bug, 但是baka过拟合了)

            for (BlockPos blockpos : BlockPos.betweenClosed(pPos.offset(-i, dy, -i), pPos.offset(i, dy, i))) {
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
