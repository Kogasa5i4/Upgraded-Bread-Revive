package net.kogasachan.upgradedbread.item;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UpgradedBread.MODID);

    public static final RegistryObject<CreativeModeTab> BREAD_TAB = CREATIVE_MODE_TABS.register("bread_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FRESH_LONG_BREAD.get()))
                    .title(Component.translatable("itemGroup.upgradedbreadtab"))
                    .displayItems((pParameters, pOutput) -> {
                        //essence----------------------------------------------------------------------------------------------->
                        pOutput.accept(ModItems.HARD_BREAD.get());
                        pOutput.accept(ModItems.HARDER_BREAD.get());
                        pOutput.accept(ModItems.CARBOHYDRATE_ESSENCE.get());
                        pOutput.accept(ModItems.SPEED_ESSENCE.get());
                        pOutput.accept(ModItems.STRENGTH_ESSENCE.get());
                        pOutput.accept(ModItems.REGENERATION_ESSENCE.get());
                        pOutput.accept(ModItems.JUMP_BOOST_ESSENCE.get());
                        pOutput.accept(ModItems.HEALTH_ESSENCE.get());
                        pOutput.accept(ModItems.NIGHT_VISION_ESSENCE.get());
                        pOutput.accept(ModItems.FIRE_RESISTANCE_ESSENCE.get());
                        pOutput.accept(ModItems.BREATHE_ESSENCE.get());
                        pOutput.accept(ModItems.INVISIBILITY_ESSENCE.get());
                        pOutput.accept(ModItems.SLOW_FALLING_ESSENCE.get());
                        pOutput.accept(ModItems.GREED_ESSENCE.get());
                        pOutput.accept(ModItems.INFLUENCE_ESSENCE.get());
                        pOutput.accept(ModItems.FISHING_ESSENCE.get());
                        pOutput.accept(ModItems.FREEZING_ESSENCE.get());
                        pOutput.accept(ModItems.CARBOHYDRATE_INGOT.get());

                        //food-------------------------------------------------------------------------------------------------->
                        pOutput.accept(Items.BREAD);
                        pOutput.accept(ModItems.FRESH_LONG_BREAD.get());
                        pOutput.accept(ModItems.DRY_LONG_BREAD.get());
                        pOutput.accept(ModItems.STRENGTH_LONG_BREAD.get());
                        pOutput.accept(ModItems.NIGHT_VISION_LONG_BREAD.get());
                        pOutput.accept(ModItems.BREATHE_LONG_BREAD.get());
                        pOutput.accept(ModItems.FIRE_RESISTANCE_LONG_BREAD.get());
                        pOutput.accept(ModItems.HEALTH_LONG_BREAD.get());
                        pOutput.accept(ModItems.INVISIBILITY_LONG_BREAD.get());
                        pOutput.accept(ModItems.JUMP_BOOST_LONG_BREAD.get());
                        pOutput.accept(ModItems.REGENERATION_LONG_BREAD.get());
                        pOutput.accept(ModItems.SLOW_FALLING_LONG_BREAD.get());
                        pOutput.accept(ModItems.SPEED_LONG_BREAD.get());
                        pOutput.accept(ModItems.GREED_LONG_BREAD.get());
                        pOutput.accept(ModItems.INFLUENCE_LONG_BREAD.get());
                        pOutput.accept(ModItems.FISHING_LONG_BREAD.get());
                        pOutput.accept(ModItems.FREEZING_LONG_BREAD.get());

                        //material(vanilla)---------------------------------------------------------------------------------------------->
                        pOutput.accept(Items.WHEAT);
                        pOutput.accept(Items.WHEAT_SEEDS);

                        //material(mod)---------------------------------------------------------------------------------------------->
                        pOutput.accept(ModItems.SUGAR_GROUP.get());
                        pOutput.accept(ModItems.BLAZE_GROUP.get());
                        pOutput.accept(ModItems.FOOT_GROUP.get());
                        pOutput.accept(ModItems.MELON_GROUP.get());
                        pOutput.accept(ModItems.PUFF_GROUP.get());
                        pOutput.accept(ModItems.MAGMA_GROUP.get());
                        pOutput.accept(ModItems.CARROT_GROUP.get());
                        pOutput.accept(ModItems.DECAYED_GROUP.get());
                        pOutput.accept(ModItems.TEAR_GROUP.get());
                        pOutput.accept(ModItems.MEMBRANE_GROUP.get());
                        pOutput.accept(ModItems.GREED_GROUP.get());
                        pOutput.accept(ModItems.EMERALD_GROUP.get());
                        pOutput.accept(ModItems.INFLUENCE_GROUP.get());
                        pOutput.accept(ModItems.FISHING_GROUP.get());
                        pOutput.accept(ModItems.FREEZING_GROUP.get());

                        //product----------------------------------------------------------------------------------------------->
                        pOutput.accept(ModItems.HEART_OF_THE_COAL.get());
                        pOutput.accept(ModItems.LOST_ENERGY_CORE.get());
                        pOutput.accept(ModItems.LOW_ENERGY_CORE.get());
                        pOutput.accept(ModItems.HIGH_ENERGY_CORE.get());

                        //block---------------------------------------------------------------------------------------------->
                        pOutput.accept(Items.HAY_BLOCK);
                        pOutput.accept(ModBlocks.CARBOHYDRATE_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
