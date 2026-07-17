package net.kogasachan.upgradedbread.block;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.block.custom.CarbohydrateBlockItem;
import net.kogasachan.upgradedbread.item.BreadItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class BreadBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UpgradedBread.MODID);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return BreadItems.ITEMS.register(name, () -> new CarbohydrateBlockItem(block.get(), new Item.Properties()));
    }

    public static final RegistryObject<Block> CARBOHYDRATE_BLOCK = registerBlock("carbohydrate_block",
            () -> new net.kogasachan.upgradedbread.block.custom.CarbohydrateBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK)
                    .sound(SoundType.GRASS)
                    .mapColor(MapColor.COLOR_YELLOW)
                    .instrument(NoteBlockInstrument.CREEPER)
                    .strength(0.5F)) {
                public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag flag) {
                    super.appendHoverText(stack, level, tooltipComponents, flag);
                    tooltipComponents.add(Component.translatable("tooltip.upgradedbread.carbohydrate_block.tooltip"));
                }

                @Override
                public void stepOn(Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Entity entity) {
                    if (!level.isClientSide && entity instanceof Player player) {
                        if (ThreadLocalRandom.current().nextInt(99) == 0) {
                            player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 1, 0));
                            ItemStack result = new ItemStack(BreadItems.LOST_ENERGY_CORE.get());
                            if (!player.getInventory().add(result)) {
                                player.drop(result, false);
                            }
                        }
                    }
                    super.stepOn(level, pos, state, entity);
                }
            });// can also use BlockBehaviour.Properties.of()

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
