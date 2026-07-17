package net.kogasachan.upgradedbread.item;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.block.BreadBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class BreadCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UpgradedBread.MODID);

    public static final RegistryObject<CreativeModeTab> BREAD_TAB = CREATIVE_MODE_TABS.register("bread_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BreadItems.FRESH_LONG_BREAD.get()))
                    .title(Component.translatable("itemGroup.upgradedbreadtab"))
                    .displayItems((pParameters, pOutput) -> {
                        //essence----------------------------------------------------------------------------------------------->
                        pOutput.accept(BreadItems.HARD_BREAD.get());
                        pOutput.accept(BreadItems.HARDER_BREAD.get());
                        pOutput.accept(BreadItems.CARBOHYDRATE_ESSENCE.get());
                        pOutput.accept(BreadItems.SPEED_ESSENCE.get());
                        pOutput.accept(BreadItems.STRENGTH_ESSENCE.get());
                        pOutput.accept(BreadItems.REGENERATION_ESSENCE.get());
                        pOutput.accept(BreadItems.JUMP_BOOST_ESSENCE.get());
                        pOutput.accept(BreadItems.HEALTH_ESSENCE.get());
                        pOutput.accept(BreadItems.NIGHT_VISION_ESSENCE.get());
                        pOutput.accept(BreadItems.FIRE_RESISTANCE_ESSENCE.get());
                        pOutput.accept(BreadItems.BREATHE_ESSENCE.get());
                        pOutput.accept(BreadItems.INVISIBILITY_ESSENCE.get());
                        pOutput.accept(BreadItems.SLOW_FALLING_ESSENCE.get());
                        pOutput.accept(BreadItems.GREED_ESSENCE.get());
                        pOutput.accept(BreadItems.INFLUENCE_ESSENCE.get());
                        pOutput.accept(BreadItems.FISHING_ESSENCE.get());
                        pOutput.accept(BreadItems.FREEZING_ESSENCE.get());
                        pOutput.accept(BreadItems.CARBOHYDRATE_INGOT.get());

                        //food-------------------------------------------------------------------------------------------------->
                        pOutput.accept(Items.BREAD);
                        pOutput.accept(BreadItems.FRESH_LONG_BREAD.get());
                        pOutput.accept(BreadItems.DRY_LONG_BREAD.get());
                        pOutput.accept(BreadItems.STRENGTH_LONG_BREAD.get());
                        pOutput.accept(BreadItems.NIGHT_VISION_LONG_BREAD.get());
                        pOutput.accept(BreadItems.BREATHE_LONG_BREAD.get());
                        pOutput.accept(BreadItems.FIRE_RESISTANCE_LONG_BREAD.get());
                        pOutput.accept(BreadItems.HEALTH_LONG_BREAD.get());
                        pOutput.accept(BreadItems.INVISIBILITY_LONG_BREAD.get());
                        pOutput.accept(BreadItems.JUMP_BOOST_LONG_BREAD.get());
                        pOutput.accept(BreadItems.REGENERATION_LONG_BREAD.get());
                        pOutput.accept(BreadItems.SLOW_FALLING_LONG_BREAD.get());
                        pOutput.accept(BreadItems.SPEED_LONG_BREAD.get());
                        pOutput.accept(BreadItems.GREED_LONG_BREAD.get());
                        pOutput.accept(BreadItems.INFLUENCE_LONG_BREAD.get());
                        pOutput.accept(BreadItems.FISHING_LONG_BREAD.get());
                        pOutput.accept(BreadItems.FREEZING_LONG_BREAD.get());

                        //material(vanilla)---------------------------------------------------------------------------------------------->
                        pOutput.accept(Items.WHEAT);
                        pOutput.accept(Items.WHEAT_SEEDS);

                        //material(mod)---------------------------------------------------------------------------------------------->
                        pOutput.accept(BreadItems.SUGAR_GROUP.get());
                        pOutput.accept(BreadItems.BLAZE_GROUP.get());
                        pOutput.accept(BreadItems.FOOT_GROUP.get());
                        pOutput.accept(BreadItems.MELON_GROUP.get());
                        pOutput.accept(BreadItems.PUFF_GROUP.get());
                        pOutput.accept(BreadItems.MAGMA_GROUP.get());
                        pOutput.accept(BreadItems.CARROT_GROUP.get());
                        pOutput.accept(BreadItems.DECAYED_GROUP.get());
                        pOutput.accept(BreadItems.TEAR_GROUP.get());
                        pOutput.accept(BreadItems.MEMBRANE_GROUP.get());
                        pOutput.accept(BreadItems.GREED_GROUP.get());
                        pOutput.accept(BreadItems.EMERALD_GROUP.get());
                        pOutput.accept(BreadItems.INFLUENCE_GROUP.get());
                        pOutput.accept(BreadItems.FISHING_GROUP.get());
                        pOutput.accept(BreadItems.FREEZING_GROUP.get());

                        //product----------------------------------------------------------------------------------------------->
                        pOutput.accept(BreadItems.HEART_OF_THE_COAL.get());
                        pOutput.accept(BreadItems.LOST_ENERGY_CORE.get());
                        pOutput.accept(BreadItems.LOW_ENERGY_CORE.get());
                        pOutput.accept(BreadItems.HIGH_ENERGY_CORE.get());

                        //block---------------------------------------------------------------------------------------------->
                        pOutput.accept(Items.HAY_BLOCK);
                        pOutput.accept(BreadBlocks.CARBOHYDRATE_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
