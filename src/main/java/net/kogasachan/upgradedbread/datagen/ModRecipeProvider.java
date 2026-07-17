package net.kogasachan.upgradedbread.datagen;

import net.kogasachan.upgradedbread.block.ModBlocks;
import net.kogasachan.upgradedbread.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pWriter) {
        final String SMELT_TAIL = "_from_smelting";
        final String SMOKE_TAIL = "_from_smoking";
        final String CAMP_TAIL = "_from_campfire_cooking";
        final String ESSENCE_TAIL = "_from_essence";

        //Shaped------------------------------------------------------------------------------------>
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLAZE_GROUP.get(), 3)
                .define('M', Items.BLAZE_POWDER)
                .define('N', Items.NETHER_WART)
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EME")
                .pattern("NEN")
                .pattern("EME")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BREATHE_ESSENCE.get(), 8)
                .define('P', ModItems.PUFF_GROUP.get())
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EEE")
                .pattern("EPE")
                .pattern("EEE")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BREATHE_LONG_BREAD.get(), 1)
                .define('B', ModItems.FRESH_LONG_BREAD.get())
                .define('E', ModItems.BREATHE_ESSENCE.get())
                .pattern("EEE")
                .pattern("EBE")
                .pattern("EEE")
                .unlockedBy("has_breathe", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.BREATHE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARBOHYDRATE_INGOT.get(), 1)
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EEE")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter, getItemName(ModItems.CARBOHYDRATE_INGOT.get()) + ESSENCE_TAIL);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARROT_GROUP.get(), 3)
                .define('M', Items.GOLDEN_CARROT)
                .define('N', Items.NETHER_WART)
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EME")
                .pattern("NEN")
                .pattern("EME")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DECAYED_GROUP.get(), 3)
                .define('M', Items.FERMENTED_SPIDER_EYE)
                .define('N', Items.NETHER_WART)
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EME")
                .pattern("NEN")
                .pattern("EME")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_GROUP.get(), 1)
                .define('M', Items.EMERALD_BLOCK)
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EME")
                .pattern("MEM")
                .pattern("EME")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FIRE_RESISTANCE_ESSENCE.get(), 8)
                .define('P', ModItems.MAGMA_GROUP.get())
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EEE")
                .pattern("EPE")
                .pattern("EEE")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FIRE_RESISTANCE_LONG_BREAD.get(), 1)
                .define('B', ModItems.FRESH_LONG_BREAD.get())
                .define('E', ModItems.FIRE_RESISTANCE_ESSENCE.get())
                .pattern("EEE")
                .pattern("EBE")
                .pattern("EEE")
                .unlockedBy("has_fire_resistance", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.FIRE_RESISTANCE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FISHING_GROUP.get(), 1)
                .define('A', Items.COD)
                .define('B', Items.SALMON)
                .define('N', Items.NETHER_WART_BLOCK)
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EAE")
                .pattern("BNB")
                .pattern("EAE")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FISHING_ESSENCE.get(), 8)
                .define('P', ModItems.FISHING_GROUP.get())
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EEE")
                .pattern("EPE")
                .pattern("EEE")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FISHING_LONG_BREAD.get(), 1)
                .define('B', ModItems.FRESH_LONG_BREAD.get())
                .define('E', ModItems.FISHING_ESSENCE.get())
                .pattern("EEE")
                .pattern("EBE")
                .pattern("EEE")
                .unlockedBy("has_fishing", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.FISHING_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FOOT_GROUP.get(), 3)
                .define('M', Items.RABBIT_FOOT)
                .define('N', Items.NETHER_WART)
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EME")
                .pattern("NEN")
                .pattern("EME")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FRESH_LONG_BREAD.get(), 1)
                .define('#', Items.BREAD)
                .pattern("  #")
                .pattern(" # ")
                .pattern("#  ")
                .unlockedBy("has_bread", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.BREAD).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GREED_ESSENCE.get(), 8)
                .define('P', ModItems.GREED_GROUP.get())
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EEE")
                .pattern("EPE")
                .pattern("EEE")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GREED_GROUP.get(), 1)
                .define('A', ModItems.BLAZE_GROUP.get())
                .define('B', ModItems.CARROT_GROUP.get())
                .define('N', Items.NETHER_WART_BLOCK)
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EAE")
                .pattern("BNB")
                .pattern("EAE")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GREED_LONG_BREAD.get(), 1)
                .define('B', ModItems.FRESH_LONG_BREAD.get())
                .define('E', ModItems.GREED_ESSENCE.get())
                .pattern("EEE")
                .pattern("EBE")
                .pattern("EEE")
                .unlockedBy("has_greed", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.GREED_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HARD_BREAD.get(), 1)
                .define('#', Items.BREAD)
                .pattern("#")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_bread", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.BREAD).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HARDER_BREAD.get(), 1)
                .define('#', ModItems.HARD_BREAD.get())
                .pattern("#")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_hard_bread", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.BREAD).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HEALTH_ESSENCE.get(), 8)
                .define('P', ModItems.MELON_GROUP.get())
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EEE")
                .pattern("EPE")
                .pattern("EEE")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HEALTH_LONG_BREAD.get(), 1)
                .define('B', ModItems.FRESH_LONG_BREAD.get())
                .define('E', ModItems.HEALTH_ESSENCE.get())
                .pattern("EEE")
                .pattern("EBE")
                .pattern("EEE")
                .unlockedBy("has_health", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.HEALTH_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HEART_OF_THE_COAL.get(), 1)
                .define('C', Ingredient.of(Items.COAL, Items.CHARCOAL))
                .define('B', Items.BONE_MEAL)
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("CBC")
                .pattern("BEB")
                .pattern("CBC")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HIGH_ENERGY_CORE.get(), 1)
                .define('C', Ingredient.of(Items.COAL, Items.CHARCOAL))
                .define('L', ModItems.LOST_ENERGY_CORE.get())
                .pattern("CCC")
                .pattern("CLC")
                .pattern("CCC")
                .unlockedBy("has_lost_core", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.LOST_ENERGY_CORE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.INFLUENCE_ESSENCE.get(), 8)
                .define('P', ModItems.INFLUENCE_GROUP.get())
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EEE")
                .pattern("EPE")
                .pattern("EEE")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.INFLUENCE_GROUP.get(), 1)
                .define('A', ModItems.EMERALD_GROUP.get())
                .define('B', Items.TOTEM_OF_UNDYING)
                .define('N', Items.NETHER_WART_BLOCK)
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("ENE")
                .pattern("ABA")
                .pattern("ENE")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.INFLUENCE_LONG_BREAD.get(), 1)
                .define('B', ModItems.FRESH_LONG_BREAD.get())
                .define('E', ModItems.INFLUENCE_ESSENCE.get())
                .pattern("EEE")
                .pattern("EBE")
                .pattern("EEE")
                .unlockedBy("has_influence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.INFLUENCE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.INVISIBILITY_ESSENCE.get(), 8)
                .define('P', ModItems.DECAYED_GROUP.get())
                .define('E', ModItems.NIGHT_VISION_ESSENCE.get())
                .pattern("EEE")
                .pattern("EPE")
                .pattern("EEE")
                .unlockedBy("has_night_vision", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.NIGHT_VISION_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.INVISIBILITY_LONG_BREAD.get(), 1)
                .define('B', ModItems.FRESH_LONG_BREAD.get())
                .define('E', ModItems.INVISIBILITY_ESSENCE.get())
                .pattern("EEE")
                .pattern("EBE")
                .pattern("EEE")
                .unlockedBy("has_invisibility", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.INVISIBILITY_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JUMP_BOOST_ESSENCE.get(), 8)
                .define('P', ModItems.FOOT_GROUP.get())
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EEE")
                .pattern("EPE")
                .pattern("EEE")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JUMP_BOOST_LONG_BREAD.get(), 1)
                .define('B', ModItems.FRESH_LONG_BREAD.get())
                .define('E', ModItems.JUMP_BOOST_ESSENCE.get())
                .pattern("EEE")
                .pattern("EBE")
                .pattern("EEE")
                .unlockedBy("has_jump_boost", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.JUMP_BOOST_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MAGMA_GROUP.get(), 3)
                .define('M', Items.MAGMA_CREAM)
                .define('N', Items.NETHER_WART)
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EME")
                .pattern("NEN")
                .pattern("EME")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MELON_GROUP.get(), 3)
                .define('M', Items.GLISTERING_MELON_SLICE)
                .define('N', Items.NETHER_WART)
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EME")
                .pattern("NEN")
                .pattern("EME")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MEMBRANE_GROUP.get(), 3)
                .define('M', Items.PHANTOM_MEMBRANE)
                .define('N', Items.NETHER_WART)
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EME")
                .pattern("NEN")
                .pattern("EME")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHT_VISION_ESSENCE.get(), 8)
                .define('P', ModItems.CARROT_GROUP.get())
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EEE")
                .pattern("EPE")
                .pattern("EEE")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NIGHT_VISION_LONG_BREAD.get(), 1)
                .define('B', ModItems.FRESH_LONG_BREAD.get())
                .define('E', ModItems.NIGHT_VISION_ESSENCE.get())
                .pattern("EEE")
                .pattern("EBE")
                .pattern("EEE")
                .unlockedBy("has_night_vision", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.NIGHT_VISION_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PUFF_GROUP.get(), 3)
                .define('M', Items.PUFFERFISH)
                .define('N', Items.NETHER_WART)
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EME")
                .pattern("NEN")
                .pattern("EME")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.REGENERATION_ESSENCE.get(), 8)
                .define('P', ModItems.TEAR_GROUP.get())
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EEE")
                .pattern("EPE")
                .pattern("EEE")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.REGENERATION_LONG_BREAD.get(), 1)
                .define('B', ModItems.FRESH_LONG_BREAD.get())
                .define('E', ModItems.REGENERATION_ESSENCE.get())
                .pattern("EEE")
                .pattern("EBE")
                .pattern("EEE")
                .unlockedBy("has_regeneration", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.REGENERATION_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SLOW_FALLING_ESSENCE.get(), 8)
                .define('P', ModItems.MEMBRANE_GROUP.get())
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EEE")
                .pattern("EPE")
                .pattern("EEE")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SLOW_FALLING_LONG_BREAD.get(), 1)
                .define('B', ModItems.FRESH_LONG_BREAD.get())
                .define('E', ModItems.SLOW_FALLING_ESSENCE.get())
                .pattern("EEE")
                .pattern("EBE")
                .pattern("EEE")
                .unlockedBy("has_slow_falling", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.SLOW_FALLING_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SPEED_ESSENCE.get(), 8)
                .define('P', ModItems.SUGAR_GROUP.get())
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EEE")
                .pattern("EPE")
                .pattern("EEE")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SPEED_LONG_BREAD.get(), 1)
                .define('B', ModItems.FRESH_LONG_BREAD.get())
                .define('E', ModItems.SPEED_ESSENCE.get())
                .pattern("EEE")
                .pattern("EBE")
                .pattern("EEE")
                .unlockedBy("has_speed", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.SPEED_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STRENGTH_ESSENCE.get(), 8)
                .define('P', ModItems.BLAZE_GROUP.get())
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EEE")
                .pattern("EPE")
                .pattern("EEE")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STRENGTH_LONG_BREAD.get(), 1)
                .define('B', ModItems.FRESH_LONG_BREAD.get())
                .define('E', ModItems.STRENGTH_ESSENCE.get())
                .pattern("EEE")
                .pattern("EBE")
                .pattern("EEE")
                .unlockedBy("has_strength", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.STRENGTH_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SUGAR_GROUP.get(), 3)
                .define('M', Items.SUGAR)
                .define('N', Items.NETHER_WART)
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EME")
                .pattern("NEN")
                .pattern("EME")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TEAR_GROUP.get(), 3)
                .define('M', Items.GHAST_TEAR)
                .define('N', Items.NETHER_WART)
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EME")
                .pattern("NEN")
                .pattern("EME")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WHEAT, 8)
                .define('S', Items.WHEAT_SEEDS)
                .define('C', Ingredient.of(ModItems.HIGH_ENERGY_CORE.get(), ModItems.LOW_ENERGY_CORE.get()))
                .pattern("SSS")
                .pattern("SCS")
                .pattern("SSS")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FREEZING_GROUP.get(), 1)
                .define('A', Items.BLUE_ICE)
                .define('B', Items.PACKED_ICE)
                .define('N', Items.NETHER_WART_BLOCK)
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EAE")
                .pattern("BNB")
                .pattern("EAE")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FREEZING_ESSENCE.get(), 8)
                .define('P', ModItems.FREEZING_GROUP.get())
                .define('E', ModItems.CARBOHYDRATE_ESSENCE.get())
                .pattern("EEE")
                .pattern("EPE")
                .pattern("EEE")
                .unlockedBy("has_essence", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARBOHYDRATE_ESSENCE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FREEZING_LONG_BREAD.get(),1)
                .define('B',ModItems.FRESH_LONG_BREAD.get())
                .define('E',ModItems.FREEZING_ESSENCE.get())
                .pattern("EEE")
                .pattern("EBE")
                .pattern("EEE")
                .unlockedBy("has_freezing",inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.FREEZING_ESSENCE.get()).build()))
                .save(pWriter);

        //Shapeless--------------------------------------------------------------------------------->
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BREAD, 3)
                .requires(ModItems.FRESH_LONG_BREAD.get())
                .unlockedBy("has_long_bread", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.FRESH_LONG_BREAD.get()).build()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LOW_ENERGY_CORE.get(), 1)
                .requires(ModItems.LOST_ENERGY_CORE.get(), 8)
                .unlockedBy("has_lost_core", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.LOST_ENERGY_CORE.get()).build()))
                .save(pWriter);

        //nineBlockStorage-------------------------------------------------------------------------->
        nineBlockStorageRecipes(pWriter,
                RecipeCategory.MISC,
                ModItems.CARBOHYDRATE_INGOT.get(),
                RecipeCategory.MISC,
                ModBlocks.CARBOHYDRATE_BLOCK.get().asItem());

        //SimpleCook-------------------------------------------------------------------------------->
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.HARDER_BREAD.get()),
                        RecipeCategory.MISC,
                        ModItems.CARBOHYDRATE_ESSENCE.get(), 1.0F, 200)
                .unlockedBy("has_harder_bread", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.HARDER_BREAD.get()).build()))
                .save(pWriter);
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ModItems.HARDER_BREAD.get()),
                        RecipeCategory.MISC,
                        ModItems.CARBOHYDRATE_ESSENCE.get(), 1.0F, 100)
                .unlockedBy("has_harder_bread", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.HARDER_BREAD.get()).build()))
                .save(pWriter, getItemName(ModItems.CARBOHYDRATE_ESSENCE.get()) + SMOKE_TAIL);
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ModItems.HARDER_BREAD.get()),
                        RecipeCategory.MISC,
                        ModItems.CARBOHYDRATE_ESSENCE.get(), 1.0F, 600)
                .unlockedBy("has_harder_bread", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.HARDER_BREAD.get()).build()))
                .save(pWriter, getItemName(ModItems.CARBOHYDRATE_ESSENCE.get()) + CAMP_TAIL);
        //********************************************************************************************
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.FRESH_LONG_BREAD.get()),
                        RecipeCategory.MISC,
                        ModItems.DRY_LONG_BREAD.get(), 1.05F, 200)
                .unlockedBy("has_fresh_long_bread", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.FRESH_LONG_BREAD.get()).build()))
                .save(pWriter);
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ModItems.FRESH_LONG_BREAD.get()),
                        RecipeCategory.MISC,
                        ModItems.DRY_LONG_BREAD.get(), 1.05F, 100)
                .unlockedBy("has_fresh_long_bread", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.FRESH_LONG_BREAD.get()).build()))
                .save(pWriter, getItemName(ModItems.DRY_LONG_BREAD.get()) + SMOKE_TAIL);
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ModItems.FRESH_LONG_BREAD.get()),
                        RecipeCategory.MISC,
                        ModItems.DRY_LONG_BREAD.get(), 1.05F, 600)
                .unlockedBy("has_fresh_long_bread", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.FRESH_LONG_BREAD.get()).build()))
                .save(pWriter, getItemName(ModItems.DRY_LONG_BREAD.get()) + CAMP_TAIL);
        //********************************************************************************************
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.HEART_OF_THE_COAL.get()),
                        RecipeCategory.MISC,
                        ModItems.LOW_ENERGY_CORE.get(), 0.5F, 200)
                .unlockedBy("has_heart_of_the_coal", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.HEART_OF_THE_COAL.get()).build()))
                .save(pWriter, getItemName(ModItems.LOW_ENERGY_CORE.get()) + SMELT_TAIL);
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ModItems.HEART_OF_THE_COAL.get()),
                        RecipeCategory.MISC,
                        ModItems.LOW_ENERGY_CORE.get(), 0.5F, 100)
                .unlockedBy("has_heart_of_the_coal", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.HEART_OF_THE_COAL.get()).build()))
                .save(pWriter, getItemName(ModItems.LOW_ENERGY_CORE.get()) + SMOKE_TAIL);
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ModItems.HEART_OF_THE_COAL.get()),
                        RecipeCategory.MISC,
                        ModItems.LOW_ENERGY_CORE.get(), 0.5F, 600)
                .unlockedBy("has_heart_of_the_coal", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.HEART_OF_THE_COAL.get()).build()))
                .save(pWriter, getItemName(ModItems.LOW_ENERGY_CORE.get()) + CAMP_TAIL);
    }
}
