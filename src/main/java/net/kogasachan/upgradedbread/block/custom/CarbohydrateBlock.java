package net.kogasachan.upgradedbread.block.custom;

import net.kogasachan.upgradedbread.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CarbohydrateBlock extends Block {
    public CarbohydrateBlock(Properties pProperties) {
        super(pProperties);
    }

    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level,
                                @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltipComponents, flag);
        tooltipComponents.add(Component.translatable("tooltip.upgradedbread.carbohydrate_block.tooltip"));
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (!level.isClientSide && entity instanceof Player player) {
            if (ThreadLocalRandom.current().nextInt(99) == 0) {
                player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 1, 0));
                ItemStack result = new ItemStack(ModItems.LOST_ENERGY_CORE.get());
                if (!player.getInventory().add(result)) {
                    player.drop(result, false);
                }
            }
        }
        super.stepOn(level, pos, state, entity);
    }
}
