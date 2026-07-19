package net.kogasachan.upgradedbread.compat.jei;

import net.kogasachan.upgradedbread.item.BreadItems;
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

/**
 * jei兼容配方(仅用于jei显示, 不参与实际合成逻辑)
 */
public class BreadRefreshRecipe implements Recipe<Container> {
    //自定义配方类型(用于jei分类)
    public static final RecipeType<BreadRefreshRecipe> TYPE = new RecipeType<>() { };

    //输入输出设定
    private final Ingredient input = Ingredient.of(BreadItems.DRY_LONG_BREAD.get());
    private final ItemStack output = new ItemStack(BreadItems.FRESH_LONG_BREAD.get());

    //下列方法仅为满足接口，实际不会被调用
    @Override
    public boolean matches(@NotNull Container pContainer, @NotNull Level pLevel) {
        return false; //不用于实际合成匹配
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull Container pContainer, @NotNull RegistryAccess pRegistryAccess) {
        return ItemStack.EMPTY; //无实际合成行为
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return false; //不限制合成格数
    }

    @Override
    public @NotNull ItemStack getResultItem(@NotNull RegistryAccess pRegistryAccess) {
        return output.copy(); //jei显示输出结果
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return ResourceLocation.fromNamespaceAndPath("upgradedbread", "bread_refresh");
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return null; //无需序列化，仅jei使用
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return TYPE; //返回自定义配方类型
    }

    //供jei类别读取输入输出
    public Ingredient getInput() {
        return input;
    }
    public ItemStack getOutput() {
        return output;
    }
}