package net.kogasachan.upgradedbread.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.item.BreadItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

@JeiPlugin
public class JEIBreadPlugin implements IModPlugin {
    // JEI 插件的注册
    private static final ResourceLocation PLUGIN_UID = ResourceLocation.fromNamespaceAndPath(UpgradedBread.MODID, "jei_plugin");

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return PLUGIN_UID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new BreadRefreshCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(Items.WATER_BUCKET),
                BreadRefreshCategory.RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(Items.CAULDRON),
                BreadRefreshCategory.RECIPE_TYPE);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        // 配方类型注册
        List<BreadRefreshRecipe> recipes = List.of(new BreadRefreshRecipe());
        registration.addRecipes(BreadRefreshCategory.RECIPE_TYPE, recipes);
        // 获取需要隐藏的物品
        ItemStack itemToHide = new ItemStack(BreadItems.FOX_GIFT_LONG_BREAD.get());
        // 将其从 JEI 的运行时 ingredient 管理中移除
        registration.getIngredientManager().removeIngredientsAtRuntime(
                VanillaTypes.ITEM_STACK,
                Collections.singletonList(itemToHide)
        );
    }
}