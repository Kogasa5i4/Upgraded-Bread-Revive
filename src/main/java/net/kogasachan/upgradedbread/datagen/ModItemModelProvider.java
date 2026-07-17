package net.kogasachan.upgradedbread.datagen;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, UpgradedBread.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //essence----------------------------------------------------------------------------------------------->
        simpleItem(ModItems.HARD_BREAD);
        simpleItem(ModItems.HARDER_BREAD);
        essenceItem(ModItems.CARBOHYDRATE_ESSENCE);
        essenceItem(ModItems.SPEED_ESSENCE);
        essenceItem(ModItems.STRENGTH_ESSENCE);
        essenceItem(ModItems.REGENERATION_ESSENCE);
        essenceItem(ModItems.JUMP_BOOST_ESSENCE);
        essenceItem(ModItems.HEALTH_ESSENCE);
        essenceItem(ModItems.NIGHT_VISION_ESSENCE);
        essenceItem(ModItems.FIRE_RESISTANCE_ESSENCE);
        essenceItem(ModItems.BREATHE_ESSENCE);
        essenceItem(ModItems.INVISIBILITY_ESSENCE);
        essenceItem(ModItems.SLOW_FALLING_ESSENCE);
        essenceItem(ModItems.GREED_ESSENCE);
        essenceItem(ModItems.INFLUENCE_ESSENCE);
        essenceItem(ModItems.FISHING_ESSENCE);
        essenceItem(ModItems.FREEZING_ESSENCE);
        simpleItem(ModItems.CARBOHYDRATE_INGOT);

        //food-------------------------------------------------------------------------------------------------->
        simpleItem(ModItems.FRESH_LONG_BREAD);
        simpleItem(ModItems.DRY_LONG_BREAD);
        simpleItem(ModItems.STRENGTH_LONG_BREAD);
        simpleItem(ModItems.NIGHT_VISION_LONG_BREAD);
        simpleItem(ModItems.BREATHE_LONG_BREAD);
        simpleItem(ModItems.FIRE_RESISTANCE_LONG_BREAD);
        simpleItem(ModItems.HEALTH_LONG_BREAD);
        simpleItem(ModItems.INVISIBILITY_LONG_BREAD);
        simpleItem(ModItems.JUMP_BOOST_LONG_BREAD);
        simpleItem(ModItems.REGENERATION_LONG_BREAD);
        simpleItem(ModItems.SLOW_FALLING_LONG_BREAD);
        simpleItem(ModItems.SPEED_LONG_BREAD);
        simpleItem(ModItems.GREED_LONG_BREAD);
        simpleItem(ModItems.INFLUENCE_LONG_BREAD);
        simpleItem(ModItems.FISHING_LONG_BREAD);
        simpleItem(ModItems.FREEZING_LONG_BREAD);

        //material---------------------------------------------------------------------------------------------->
        simpleItem(ModItems.SUGAR_GROUP);
        simpleItem(ModItems.BLAZE_GROUP);
        simpleItem(ModItems.FOOT_GROUP);
        simpleItem(ModItems.MELON_GROUP);
        simpleItem(ModItems.PUFF_GROUP);
        simpleItem(ModItems.MAGMA_GROUP);
        simpleItem(ModItems.CARROT_GROUP);
        simpleItem(ModItems.DECAYED_GROUP);
        simpleItem(ModItems.TEAR_GROUP);
        simpleItem(ModItems.MEMBRANE_GROUP);
        simpleItem(ModItems.GREED_GROUP);
        simpleItem(ModItems.EMERALD_GROUP);
        simpleItem(ModItems.INFLUENCE_GROUP);
        simpleItem(ModItems.FISHING_GROUP);
        simpleItem(ModItems.FREEZING_GROUP);

        //product----------------------------------------------------------------------------------------------->
        simpleItem(ModItems.HEART_OF_THE_COAL);
        simpleItem(ModItems.LOST_ENERGY_CORE);
        simpleItem(ModItems.LOW_ENERGY_CORE);
        simpleItem(ModItems.HIGH_ENERGY_CORE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        if (item.getId() != null) {
            return withExistingParent(item.getId().getPath(),
                    ResourceLocation.parse("item/generated")).texture("layer0",
                    ResourceLocation.fromNamespaceAndPath(UpgradedBread.MODID, "item/" + item.getId().getPath()));
        }
        return null;
    }

    private ItemModelBuilder essenceItem(RegistryObject<Item> item) {
        if (item.getId() != null) {
            if (ModItems.CARBOHYDRATE_ESSENCE.getId() != null) {
                return withExistingParent(item.getId().getPath(),
                        ResourceLocation.parse("item/generated")).texture("layer0",
                        ResourceLocation.fromNamespaceAndPath(UpgradedBread.MODID, "item/" + ModItems.CARBOHYDRATE_ESSENCE.getId().getPath()));
            }
        }
        return null;
    }
}
