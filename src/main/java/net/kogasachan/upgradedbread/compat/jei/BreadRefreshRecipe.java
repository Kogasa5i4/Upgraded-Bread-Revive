package net.kogasachan.upgradedbread.compat.jei;

import net.kogasachan.upgradedbread.item.ModItems;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class BreadRefreshRecipe implements Recipe<Container> {
    public static final ResourceLocation TYPE_ID = ResourceLocation.fromNamespaceAndPath("upgradedbread", "bread_refresh");
    public static final RecipeType<BreadRefreshRecipe> TYPE = new RecipeType<>() {};

    private final Ingredient input = Ingredient.of(ModItems.DRY_LONG_BREAD.get());
    private final ItemStack output = new ItemStack(ModItems.FRESH_LONG_BREAD.get());

    @Override
    public boolean matches(@NotNull Container pContainer, @NotNull Level pLevel) {
        return false;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull Container pContainer, @NotNull RegistryAccess pRegistryAccess) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return false;
    }

    @Override
    public @NotNull ItemStack getResultItem(@NotNull RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return ResourceLocation.fromNamespaceAndPath("upgradedbread", "bread_refresh");
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return null;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return TYPE;
    }

    public Ingredient getInput() {
        return input;
    }

    public ItemStack getOutput() {
        return output;
    }
}