package net.kogasachan.upgradedbread.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.kogasachan.upgradedbread.UpgradedBread;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@JeiPlugin
public class JEIBreadPlugin implements IModPlugin {
    //jei插件的注册
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
    public void registerRecipes(IRecipeRegistration registration) {
        List<BreadRefreshRecipe> recipes = List.of(new BreadRefreshRecipe());
        registration.addRecipes(BreadRefreshCategory.RECIPE_TYPE, recipes);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(Items.WATER_BUCKET),
                BreadRefreshCategory.RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(Items.CAULDRON),
                BreadRefreshCategory.RECIPE_TYPE);
    }
}