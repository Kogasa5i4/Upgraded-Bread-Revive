package net.kogasachan.upgradedbread.event;

import net.kogasachan.upgradedbread.config.BreadConfigs;
import net.kogasachan.upgradedbread.item.BreadItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

public class BreadRefreshEvent {
    private static final Block[] WATER_BLOCKS = {
            Blocks.WATER,
            Blocks.WATER_CAULDRON
    };

    @SubscribeEvent
    public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        Player player = event.getEntity();
        BlockHitResult hitResult = event.getHitVec();
        BlockPos clickedPos = hitResult.getBlockPos();
        ItemStack heldItem = event.getItemStack();

        if (heldItem.isEmpty() || !heldItem.getItem().equals(BreadItems.DRY_LONG_BREAD.get())) {
            return;
        }

        double reachDistance = Integer.MAX_VALUE;
        Vec3 eyePos = player.getEyePosition(1.0F);
        Vec3 lookVec = player.getViewVector(1.0F);
        Vec3 endPos = eyePos.add(lookVec.scale(reachDistance));
        ClipContext context = new ClipContext(
                eyePos,
                endPos,
                ClipContext.Block.COLLIDER,
                ClipContext.Fluid.WATER,
                player
        );
        @NotNull BlockHitResult result = level.clip(context);
        boolean isWater = isWater(result, level);

        BlockState targetState = level.getBlockState(hitResult.getBlockPos());
        boolean isWaterCauldron = isWaterBlock(targetState.getBlock());

        if (!isWater && !isWaterCauldron) {
            return;
        }

        if (!level.isClientSide) {
            if (!player.isCreative()) {
                heldItem.shrink(1);
            }

            ItemStack resultStack = new ItemStack(BreadItems.FRESH_LONG_BREAD.get(), 1);

            if (!player.getInventory().add(resultStack)) {
                player.drop(resultStack, false);
            }
        }

        event.setCancellationResult(InteractionResult.SUCCESS);

        if (targetState.getBlock() == Blocks.WATER_CAULDRON) {
            BlockState cauldronState = level.getBlockState(clickedPos);
            if (!cauldronState.hasProperty(BlockStateProperties.LEVEL_CAULDRON)) {
                return;
            }

            int currentLevel = cauldronState.getValue(BlockStateProperties.LEVEL_CAULDRON);
            int mode = BreadConfigs.SERVER.waterConsumptionMode.get();

            if (mode == 1) {
                int newLevel = Math.max(currentLevel - 1, 0);
                if (newLevel == 0) {
                    level.setBlock(clickedPos, Blocks.CAULDRON.defaultBlockState(), 3);
                } else {
                    level.setBlock(clickedPos, cauldronState.setValue(BlockStateProperties.LEVEL_CAULDRON, newLevel), 3);
                }
            } else if (mode == 2) {
                level.setBlock(clickedPos, Blocks.CAULDRON.defaultBlockState(), 3);
            }
        }
    }

    private boolean isWater(BlockHitResult result, Level level) {
        if (result.getType() != HitResult.Type.BLOCK) {
            return false;
        }
        BlockPos pos = result.getBlockPos();
        FluidState fluidState = level.getFluidState(pos);
        return fluidState.getType() == Fluids.WATER || fluidState.getType() == Fluids.FLOWING_WATER;
    }

    private boolean isWaterBlock(Block block) {
        for (Block waterBlock : WATER_BLOCKS) {
            if (block == waterBlock) {
                return true;
            }
        }
        return false;
    }
}
