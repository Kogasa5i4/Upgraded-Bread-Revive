package net.kogasachan.upgradedbread.compat.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.item.BreadItems;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BreadRefreshCategory implements IRecipeCategory<BreadRefreshRecipe> {
    // JEI 兼容配方类型的注册
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(UpgradedBread.MODID, "bread_refresh");
    public static final RecipeType<BreadRefreshRecipe> RECIPE_TYPE = new RecipeType<>(UID, BreadRefreshRecipe.class);

    //private final IDrawable background;
    // 已弃用 (背景绘制)
    // JEI 兼容配方类型的图标
    private final IDrawable icon;

    public BreadRefreshCategory(IGuiHelper guiHelper) {
        //this.background = guiHelper.createBlankDrawable(126, 70);
        // 已弃用
        // 使用软棍面包作为图标
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BreadItems.FRESH_LONG_BREAD.get()));
    }

    // 绘制水桶和炼药锅作为示意
    @Override
    public void draw(@NotNull BreadRefreshRecipe recipe, @NotNull IRecipeSlotsView recipeSlotsView,
                     GuiGraphics guiGraphics, double mouseX, double mouseY) {
        ItemStack waterBucket = new ItemStack(Items.WATER_BUCKET);
        guiGraphics.renderItem(waterBucket, 60, 15);
        ItemStack cauldron = new ItemStack(Items.CAULDRON);
        guiGraphics.renderItem(cauldron, 60, 35);
    }

    // get() 函数的注册, 方便外部类访问
    @Override
    public @NotNull RecipeType<BreadRefreshRecipe> getRecipeType() {
        return RECIPE_TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.translatable("jei.category.upgradedbread.bread_refresh");
    }

    //@Override
    //public IDrawable getBackground() {
    //    return background;
    //}
    // 已弃用

    @Override
    public int getWidth() {
        return 126;
    }

    @Override
    public int getHeight() {
        return 70;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    // 输入输出物品的位置
    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, BreadRefreshRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 32, 26)
                .addIngredients(recipe.getInput());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 26)
                .addItemStack(recipe.getOutput());
    }
}