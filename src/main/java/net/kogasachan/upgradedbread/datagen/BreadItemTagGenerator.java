package net.kogasachan.upgradedbread.datagen;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.item.BreadItems;
import net.kogasachan.upgradedbread.util.BreadTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class BreadItemTagGenerator extends ItemTagsProvider {
    // 物品标签
    public BreadItemTagGenerator(@NotNull PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> pBlockTags, @Nullable net.minecraftforge.common.data.ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, UpgradedBread.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        this.tag(BreadTags.Items.GROUPS)
                .add(BreadItems.SUGAR_GROUP.get())
                .add(BreadItems.BLAZE_GROUP.get())
                .add(BreadItems.FOOT_GROUP.get())
                .add(BreadItems.MELON_GROUP.get())
                .add(BreadItems.PUFF_GROUP.get())
                .add(BreadItems.MAGMA_GROUP.get())
                .add(BreadItems.CARROT_GROUP.get())
                .add(BreadItems.DECAYED_GROUP.get())
                .add(BreadItems.TEAR_GROUP.get())
                .add(BreadItems.MEMBRANE_GROUP.get())
                .add(BreadItems.GREED_GROUP.get())
                .add(BreadItems.EMERALD_GROUP.get())
                .add(BreadItems.INFLUENCE_GROUP.get())
                .add(BreadItems.FISHING_GROUP.get())
                .add(BreadItems.FREEZING_GROUP.get())
                .add(BreadItems.BONE_MEAL_GROUP.get())
                .add(BreadItems.TOTEM_GROUP.get())
                .add(BreadItems.COCOA_GROUP.get());
        this.tag(BreadTags.Items.POTION_GROUPS)
                .add(BreadItems.SUGAR_GROUP.get())
                .add(BreadItems.BLAZE_GROUP.get())
                .add(BreadItems.FOOT_GROUP.get())
                .add(BreadItems.MELON_GROUP.get())
                .add(BreadItems.PUFF_GROUP.get())
                .add(BreadItems.MAGMA_GROUP.get())
                .add(BreadItems.CARROT_GROUP.get())
                .add(BreadItems.DECAYED_GROUP.get())
                .add(BreadItems.TEAR_GROUP.get())
                .add(BreadItems.MEMBRANE_GROUP.get());
        this.tag(BreadTags.Items.SPECIAL_GROUPS)
                .add(BreadItems.GREED_GROUP.get())
                .add(BreadItems.EMERALD_GROUP.get())
                .add(BreadItems.INFLUENCE_GROUP.get())
                .add(BreadItems.FISHING_GROUP.get())
                .add(BreadItems.FREEZING_GROUP.get())
                .add(BreadItems.BONE_MEAL_GROUP.get())
                .add(BreadItems.TOTEM_GROUP.get())
                .add(BreadItems.COCOA_GROUP.get());
        this.tag(BreadTags.Items.ESSENCES)
                .add(BreadItems.CARBOHYDRATE_ESSENCE.get())
                .add(BreadItems.SPEED_ESSENCE.get())
                .add(BreadItems.STRENGTH_ESSENCE.get())
                .add(BreadItems.REGENERATION_ESSENCE.get())
                .add(BreadItems.JUMP_BOOST_ESSENCE.get())
                .add(BreadItems.HEALTH_ESSENCE.get())
                .add(BreadItems.NIGHT_VISION_ESSENCE.get())
                .add(BreadItems.FIRE_RESISTANCE_ESSENCE.get())
                .add(BreadItems.BREATHE_ESSENCE.get())
                .add(BreadItems.INVISIBILITY_ESSENCE.get())
                .add(BreadItems.SLOW_FALLING_ESSENCE.get())
                .add(BreadItems.GREED_ESSENCE.get())
                .add(BreadItems.INFLUENCE_ESSENCE.get())
                .add(BreadItems.FISHING_ESSENCE.get())
                .add(BreadItems.FREEZING_ESSENCE.get())
                .add(BreadItems.GROWTH_ESSENCE.get())
                .add(BreadItems.LIFE_ESSENCE.get())
                .add(BreadItems.CHOCLIZ_ESSENCE.get());
        this.tag(BreadTags.Items.POTION_ESSENCES)
                .add(BreadItems.SPEED_ESSENCE.get())
                .add(BreadItems.STRENGTH_ESSENCE.get())
                .add(BreadItems.REGENERATION_ESSENCE.get())
                .add(BreadItems.JUMP_BOOST_ESSENCE.get())
                .add(BreadItems.HEALTH_ESSENCE.get())
                .add(BreadItems.NIGHT_VISION_ESSENCE.get())
                .add(BreadItems.FIRE_RESISTANCE_ESSENCE.get())
                .add(BreadItems.BREATHE_ESSENCE.get())
                .add(BreadItems.INVISIBILITY_ESSENCE.get())
                .add(BreadItems.SLOW_FALLING_ESSENCE.get());
        this.tag(BreadTags.Items.SPECIAL_ESSENCES)
                .add(BreadItems.GREED_ESSENCE.get())
                .add(BreadItems.INFLUENCE_ESSENCE.get())
                .add(BreadItems.FISHING_ESSENCE.get())
                .add(BreadItems.FREEZING_ESSENCE.get())
                .add(BreadItems.GROWTH_ESSENCE.get())
                .add(BreadItems.LIFE_ESSENCE.get())
                .add(BreadItems.CHOCLIZ_ESSENCE.get());
        this.tag(BreadTags.Items.FOODS)
                .add(BreadItems.HARD_BREAD.get())
                .add(BreadItems.HARDER_BREAD.get())
                .add(BreadItems.FRESH_LONG_BREAD.get())
                .add(BreadItems.DRY_LONG_BREAD.get())
                .add(BreadItems.BAGUETTE_BAGUETTE.get())
                .add(BreadItems.MICRO_SOFT_BREAD.get())
                .add(BreadItems.MACRO_HARD_BREAD.get())
                .add(BreadItems.STRENGTH_LONG_BREAD.get())
                .add(BreadItems.NIGHT_VISION_LONG_BREAD.get())
                .add(BreadItems.BREATHE_LONG_BREAD.get())
                .add(BreadItems.FIRE_RESISTANCE_LONG_BREAD.get())
                .add(BreadItems.HEALTH_LONG_BREAD.get())
                .add(BreadItems.INVISIBILITY_LONG_BREAD.get())
                .add(BreadItems.JUMP_BOOST_LONG_BREAD.get())
                .add(BreadItems.REGENERATION_LONG_BREAD.get())
                .add(BreadItems.SLOW_FALLING_LONG_BREAD.get())
                .add(BreadItems.SPEED_LONG_BREAD.get())
                .add(BreadItems.GREED_LONG_BREAD.get())
                .add(BreadItems.INFLUENCE_LONG_BREAD.get())
                .add(BreadItems.FISHING_LONG_BREAD.get())
                .add(BreadItems.FREEZING_LONG_BREAD.get())
                .add(BreadItems.KE_LA_LONG_BREAD.get())
                .add(BreadItems.LEES_WAFFLE.get())
                .add(BreadItems.CHOCLIZ_LONG_BREAD.get());
        this.tag(BreadTags.Items.BASIC_BREADS)
                .add(BreadItems.HARD_BREAD.get())
                .add(BreadItems.HARDER_BREAD.get())
                .add(BreadItems.FRESH_LONG_BREAD.get())
                .add(BreadItems.DRY_LONG_BREAD.get())
                .add(BreadItems.BAGUETTE_BAGUETTE.get())
                .add(BreadItems.MICRO_SOFT_BREAD.get())
                .add(BreadItems.MACRO_HARD_BREAD.get());
        this.tag(BreadTags.Items.POTION_FOODS)
                .add(BreadItems.STRENGTH_LONG_BREAD.get())
                .add(BreadItems.NIGHT_VISION_LONG_BREAD.get())
                .add(BreadItems.BREATHE_LONG_BREAD.get())
                .add(BreadItems.FIRE_RESISTANCE_LONG_BREAD.get())
                .add(BreadItems.HEALTH_LONG_BREAD.get())
                .add(BreadItems.INVISIBILITY_LONG_BREAD.get())
                .add(BreadItems.JUMP_BOOST_LONG_BREAD.get())
                .add(BreadItems.REGENERATION_LONG_BREAD.get())
                .add(BreadItems.SLOW_FALLING_LONG_BREAD.get())
                .add(BreadItems.SPEED_LONG_BREAD.get());
        this.tag(BreadTags.Items.SPECIAL_FOODS)
                .add(BreadItems.GREED_LONG_BREAD.get())
                .add(BreadItems.INFLUENCE_LONG_BREAD.get())
                .add(BreadItems.FISHING_LONG_BREAD.get())
                .add(BreadItems.FREEZING_LONG_BREAD.get())
                .add(BreadItems.KE_LA_LONG_BREAD.get())
                .add(BreadItems.LEES_WAFFLE.get())
                .add(BreadItems.CHOCLIZ_LONG_BREAD.get());
        this.tag(BreadTags.Items.ENERGY_CORES)
                .add(BreadItems.HEART_OF_THE_COAL.get())
                .add(BreadItems.LOST_ENERGY_CORE.get())
                .add(BreadItems.LOW_ENERGY_CORE.get())
                .add(BreadItems.HIGH_ENERGY_CORE.get());
    }
}
