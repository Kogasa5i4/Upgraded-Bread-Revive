package net.kogasachan.upgradedbread.datagen;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.item.BreadItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class BreadItemModelProvider extends ItemModelProvider {
    // 物品模型
    public BreadItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, UpgradedBread.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // essence
        simpleItem(BreadItems.HARD_BREAD);
        simpleItem(BreadItems.HARDER_BREAD);
        essenceItem(BreadItems.CARBOHYDRATE_ESSENCE);
        essenceItem(BreadItems.SPEED_ESSENCE);
        essenceItem(BreadItems.STRENGTH_ESSENCE);
        essenceItem(BreadItems.REGENERATION_ESSENCE);
        essenceItem(BreadItems.JUMP_BOOST_ESSENCE);
        essenceItem(BreadItems.HEALTH_ESSENCE);
        essenceItem(BreadItems.NIGHT_VISION_ESSENCE);
        essenceItem(BreadItems.FIRE_RESISTANCE_ESSENCE);
        essenceItem(BreadItems.BREATHE_ESSENCE);
        essenceItem(BreadItems.INVISIBILITY_ESSENCE);
        essenceItem(BreadItems.SLOW_FALLING_ESSENCE);
        essenceItem(BreadItems.GREED_ESSENCE);
        essenceItem(BreadItems.INFLUENCE_ESSENCE);
        essenceItem(BreadItems.FISHING_ESSENCE);
        essenceItem(BreadItems.FREEZING_ESSENCE);
        simpleItem(BreadItems.CARBOHYDRATE_INGOT);

        // essence (new)
        essenceItem(BreadItems.GROWTH_ESSENCE);
        essenceItem(BreadItems.LIFE_ESSENCE);
        essenceItem(BreadItems.CHOCLIZ_ESSENCE);

        // food
        simpleItem(BreadItems.FRESH_LONG_BREAD);
        simpleItem(BreadItems.DRY_LONG_BREAD);
        simpleItem(BreadItems.STRENGTH_LONG_BREAD);
        simpleItem(BreadItems.NIGHT_VISION_LONG_BREAD);
        simpleItem(BreadItems.BREATHE_LONG_BREAD);
        simpleItem(BreadItems.FIRE_RESISTANCE_LONG_BREAD);
        simpleItem(BreadItems.HEALTH_LONG_BREAD);
        simpleItem(BreadItems.INVISIBILITY_LONG_BREAD);
        simpleItem(BreadItems.JUMP_BOOST_LONG_BREAD);
        simpleItem(BreadItems.REGENERATION_LONG_BREAD);
        simpleItem(BreadItems.SLOW_FALLING_LONG_BREAD);
        simpleItem(BreadItems.SPEED_LONG_BREAD);
        simpleItem(BreadItems.GREED_LONG_BREAD);
        simpleItem(BreadItems.INFLUENCE_LONG_BREAD);
        simpleItem(BreadItems.FISHING_LONG_BREAD);
        simpleItem(BreadItems.FREEZING_LONG_BREAD);

        // food (new)
        simpleItem(BreadItems.KE_LA_LONG_BREAD);
        simpleItem(BreadItems.LEES_WAFFLE);
        simpleItem(BreadItems.CHOCLIZ_LONG_BREAD);
        simpleItem(BreadItems.BAGUETTE_BAGUETTE);
        simpleItem(BreadItems.MICRO_SOFT_BREAD);
        simpleItem(BreadItems.MACRO_HARD_BREAD);
        simpleItem(BreadItems.FOX_GIFT_LONG_BREAD);

        // material
        simpleItem(BreadItems.SUGAR_GROUP);
        simpleItem(BreadItems.BLAZE_GROUP);
        simpleItem(BreadItems.FOOT_GROUP);
        simpleItem(BreadItems.MELON_GROUP);
        simpleItem(BreadItems.PUFF_GROUP);
        simpleItem(BreadItems.MAGMA_GROUP);
        simpleItem(BreadItems.CARROT_GROUP);
        simpleItem(BreadItems.DECAYED_GROUP);
        simpleItem(BreadItems.TEAR_GROUP);
        simpleItem(BreadItems.MEMBRANE_GROUP);
        simpleItem(BreadItems.GREED_GROUP);
        simpleItem(BreadItems.EMERALD_GROUP);
        simpleItem(BreadItems.INFLUENCE_GROUP);
        simpleItem(BreadItems.FISHING_GROUP);
        simpleItem(BreadItems.FREEZING_GROUP);

        // material (new)
        simpleItem(BreadItems.BONE_MEAL_GROUP);
        simpleItem(BreadItems.TOTEM_GROUP);
        simpleItem(BreadItems.COCOA_GROUP);

        // product
        simpleItem(BreadItems.HEART_OF_THE_COAL);
        simpleItem(BreadItems.LOST_ENERGY_CORE);
        simpleItem(BreadItems.LOW_ENERGY_CORE);
        simpleItem(BreadItems.HIGH_ENERGY_CORE);
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
            if (BreadItems.CARBOHYDRATE_ESSENCE.getId() != null) {
                return withExistingParent(item.getId().getPath(),
                        ResourceLocation.parse("item/generated")).texture("layer0",
                        ResourceLocation.fromNamespaceAndPath(UpgradedBread.MODID, "item/" + BreadItems.CARBOHYDRATE_ESSENCE.getId().getPath()));
            }
        }
        return null;
    }
}
