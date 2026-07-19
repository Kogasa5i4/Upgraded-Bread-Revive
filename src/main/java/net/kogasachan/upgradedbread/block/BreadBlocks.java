package net.kogasachan.upgradedbread.block;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.item.BreadItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
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

public class BreadBlocks {
    //DeferredRegister: 延迟注册器, 正式注册物品, 创造模式标签页, 方块, 药水效果等的必须前置
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UpgradedBread.MODID);

    //方块(世界中的方块)注册
    public static final RegistryObject<Block> CARBOHYDRATE_BLOCK = BLOCKS.register("carbohydrate_block",
            //此处也可以使用BlockBehaviour.Properties.of()代替BlockBehaviour.Properties.copy()进行自定义
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK)
                    //定义方块的独特属性(若此处未定义，则按被copy的方块属性(如果用的是of, 应为铁块))
                    .sound(SoundType.GRASS)
                    .mapColor(MapColor.COLOR_YELLOW)
                    .instrument(NoteBlockInstrument.CREEPER)
                    .strength(0.5F)) {
                //覆写父类stepOn函数, 实现踩在方块上概率获取物品和药水效果
                //用event也能实现, 但是若使用playerTickEvent或livingEntityTickEvent, 对性能开销较大
                @Override
                public void stepOn(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Entity entity) {
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
            });

    //方块物品(手持时和物品栏里的方块)注册
    public static final RegistryObject<BlockItem> CARBOHYDRATE_BLOCK_ITEM = BreadItems.ITEMS.register("carbohydrate_block", () -> new BlockItem(CARBOHYDRATE_BLOCK.get(), new Item.Properties()) {
        @Override
        public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level,
                                    @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag flag) {
            super.appendHoverText(stack, level, tooltipComponents, flag);
            tooltipComponents.add(Component.translatable("tooltip.upgradedbread.carbohydrate_block.tooltip"));
        }
    });

    //注册方块注册的事件总线
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
