package net.kogasachan.upgradedbread.item;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.effect.ModEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UpgradedBread.MODID);

    //essence----------------------------------------------------------------------------------------------->
    public static final RegistryObject<Item> HARD_BREAD = ITEMS.register("hard_bread",
            () -> new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.hard_bread.tooltip"));
                }
            });
    public static final RegistryObject<Item> HARDER_BREAD = ITEMS.register("harder_bread",
            () -> new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.harder_bread.tooltip"));
                }
            });
    public static final RegistryObject<Item> CARBOHYDRATE_ESSENCE = ITEMS.register("carbohydrate_essence",
            () -> new SimpleFoiledItem(new Item.Properties().rarity(Rarity.RARE)) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.carbohydrate_essence.tooltip"));
                }
            });
    public static final RegistryObject<Item> SPEED_ESSENCE = ITEMS.register("speed_essence",
            () -> new SimpleFoiledItem(new Item.Properties().rarity(Rarity.UNCOMMON)) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.uncommon_essence.tooltip"));
                }
            });
    public static final RegistryObject<Item> STRENGTH_ESSENCE = ITEMS.register("strength_essence",
            () -> new SimpleFoiledItem(new Item.Properties().rarity(Rarity.UNCOMMON)) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.uncommon_essence.tooltip"));
                }
            });
    public static final RegistryObject<Item> REGENERATION_ESSENCE = ITEMS.register("regeneration_essence",
            () -> new SimpleFoiledItem(new Item.Properties().rarity(Rarity.UNCOMMON)) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.uncommon_essence.tooltip"));
                }
            });
    public static final RegistryObject<Item> JUMP_BOOST_ESSENCE = ITEMS.register("jump_boost_essence",
            () -> new SimpleFoiledItem(new Item.Properties().rarity(Rarity.UNCOMMON)) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.uncommon_essence.tooltip"));
                }
            });
    public static final RegistryObject<Item> HEALTH_ESSENCE = ITEMS.register("health_essence",
            () -> new SimpleFoiledItem(new Item.Properties().rarity(Rarity.UNCOMMON)) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.uncommon_essence.tooltip"));
                }
            });
    public static final RegistryObject<Item> NIGHT_VISION_ESSENCE = ITEMS.register("night_vision_essence",
            () -> new SimpleFoiledItem(new Item.Properties().rarity(Rarity.UNCOMMON)) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.uncommon_essence.tooltip"));
                }
            });
    public static final RegistryObject<Item> FIRE_RESISTANCE_ESSENCE = ITEMS.register("fire_resistance_essence",
            () -> new SimpleFoiledItem(new Item.Properties().rarity(Rarity.UNCOMMON)) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.uncommon_essence.tooltip"));
                }
            });
    public static final RegistryObject<Item> BREATHE_ESSENCE = ITEMS.register("breathe_essence",
            () -> new SimpleFoiledItem(new Item.Properties().rarity(Rarity.UNCOMMON)) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.uncommon_essence.tooltip"));
                }
            });
    public static final RegistryObject<Item> INVISIBILITY_ESSENCE = ITEMS.register("invisibility_essence",
            () -> new SimpleFoiledItem(new Item.Properties().rarity(Rarity.UNCOMMON)) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.uncommon_essence.tooltip"));
                }
            });
    public static final RegistryObject<Item> SLOW_FALLING_ESSENCE = ITEMS.register("slow_falling_essence",
            () -> new SimpleFoiledItem(new Item.Properties().rarity(Rarity.UNCOMMON)) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.uncommon_essence.tooltip"));
                }
            });
    public static final RegistryObject<Item> GREED_ESSENCE = ITEMS.register("greed_essence",
            () -> new SimpleFoiledItem(new Item.Properties().rarity(Rarity.EPIC)) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.epic_essence.tooltip"));
                }
            });
    public static final RegistryObject<Item> INFLUENCE_ESSENCE = ITEMS.register("influence_essence",
            () -> new SimpleFoiledItem(new Item.Properties().rarity(Rarity.EPIC)) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.epic_essence.tooltip"));
                }
            });
    public static final RegistryObject<Item> FISHING_ESSENCE = ITEMS.register("fishing_essence",
            () -> new SimpleFoiledItem(new Item.Properties().rarity(Rarity.EPIC)) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.epic_essence.tooltip"));
                }
            });
    public static final RegistryObject<Item> FREEZING_ESSENCE = ITEMS.register("freezing_essence",
            ()-> new SimpleFoiledItem(new Item.Properties().rarity(Rarity.RARE)){
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.epic_essence.tooltip"));
                }
            });
    public static final RegistryObject<Item> CARBOHYDRATE_INGOT = ITEMS.register("carbohydrate_ingot",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.carbohydrate_ingot.tooltip"));
                }
            });

    //food-------------------------------------------------------------------------------------------------->
    public static final RegistryObject<Item> FRESH_LONG_BREAD = ITEMS.register("fresh_long_bread",
            () -> new Item(new Item.Properties().stacksTo(16).
                    food((new FoodProperties.Builder()).nutrition(15).saturationMod(0.4F).build())) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.fresh_long_bread.tooltip"));
                }
            });
    public static final RegistryObject<Item> DRY_LONG_BREAD = ITEMS.register("dry_long_bread",
            () -> new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.dry_long_bread.tooltip"));
                }
            });
    public static final RegistryObject<Item> STRENGTH_LONG_BREAD = ITEMS.register("strength_long_bread",
            () -> new Item(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).
                    effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1800, 2), 1.0F).build())) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.uncommon_long_bread.tooltip"));
                }
            });
    public static final RegistryObject<Item> NIGHT_VISION_LONG_BREAD = ITEMS.register("night_vision_long_bread",
            () -> new Item(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).
                    effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 9600, 0), 1.0F).build())) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.uncommon_long_bread.tooltip"));
                }
            });
    public static final RegistryObject<Item> BREATHE_LONG_BREAD = ITEMS.register("breathe_long_bread",
            () -> new Item(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).
                    effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 9600, 0), 1.0F).build())) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.uncommon_long_bread.tooltip"));
                }
            });
    public static final RegistryObject<Item> FIRE_RESISTANCE_LONG_BREAD = ITEMS.register("fire_resistance_long_bread",
            () -> new Item(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).
                    effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 9600, 0), 1.0F).build())) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.uncommon_long_bread.tooltip"));
                }
            });
    public static final RegistryObject<Item> HEALTH_LONG_BREAD = ITEMS.register("health_long_bread",
            () -> new Item(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).
                    effect(() -> new MobEffectInstance(MobEffects.HEAL, 3, 0), 1.0F).build())) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.uncommon_long_bread.tooltip"));
                }
            });
    public static final RegistryObject<Item> INVISIBILITY_LONG_BREAD = ITEMS.register("invisibility_long_bread",
            () -> new Item(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).
                    effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 9600, 0), 1.0F).build())) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.uncommon_long_bread.tooltip"));
                }
            });
    public static final RegistryObject<Item> JUMP_BOOST_LONG_BREAD = ITEMS.register("jump_boost_long_bread",
            () -> new Item(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).
                    effect(() -> new MobEffectInstance(MobEffects.JUMP, 1800, 2), 1.0F).build())) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.uncommon_long_bread.tooltip"));
                }
            });
    public static final RegistryObject<Item> REGENERATION_LONG_BREAD = ITEMS.register("regeneration_long_bread",
            () -> new Item(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).
                    effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 440, 2), 1.0F).build())) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.uncommon_long_bread.tooltip"));
                }
            });
    public static final RegistryObject<Item> SLOW_FALLING_LONG_BREAD = ITEMS.register("slow_falling_long_bread",
            () -> new Item(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).
                    effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 4800, 0), 1.0F).build())) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.uncommon_long_bread.tooltip"));
                }
            });
    public static final RegistryObject<Item> SPEED_LONG_BREAD = ITEMS.register("speed_long_bread",
            () -> new Item(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).
                    effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1800, 2), 1.0F).build())) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.uncommon_long_bread.tooltip"));
                }
            });
    public static final RegistryObject<Item> GREED_LONG_BREAD = ITEMS.register("greed_long_bread",
            () -> new SimpleFoiledItem(new Item.Properties().stacksTo(16).rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).
                    effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1800, 2), 1.0F).
                    effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1800, 2), 1.0F).
                    effect(() -> new MobEffectInstance(MobEffects.HUNGER, 1800, 9), 1.0F).build())) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.greed_long_bread.tooltip"));
                    tooltip.add(Component.translatable("tooltip.upgradedbread.greed_long_bread.tale"));
                }
            });
    public static final RegistryObject<Item> INFLUENCE_LONG_BREAD = ITEMS.register("influence_long_bread",
            () -> new SimpleFoiledItem(new Item.Properties().stacksTo(16).rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).
                    effect(() -> new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 1800, 4), 1.0F).
                    effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 1800, 4), 1.0F).
                    effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1800, 3), 1.0F).
                    effect(() -> new MobEffectInstance(MobEffects.GLOWING, 1800, 0), 1.0F).build())) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.influence_long_bread.tooltip"));
                    tooltip.add(Component.translatable("tooltip.upgradedbread.influence_long_bread.tale"));
                }
            });
    public static final RegistryObject<Item> FISHING_LONG_BREAD = ITEMS.register("fishing_long_bread",
            () -> new SimpleFoiledItem(new Item.Properties().stacksTo(16).rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).
                    effect(() -> new MobEffectInstance(MobEffects.LUCK, 9600, 4), 1.0F).
                    effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 9600, 0), 1.0F).build())) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.fishing_long_bread.tooltip"));
                    tooltip.add(Component.translatable("tooltip.upgradedbread.fishing_long_bread.tale1"));
                    tooltip.add(Component.translatable("tooltip.upgradedbread.fishing_long_bread.tale2"));
                    tooltip.add(Component.translatable("tooltip.upgradedbread.support.marshall"));
                }
            });
    public static final RegistryObject<Item> FREEZING_LONG_BREAD = ITEMS.register("freezing_long_bread",
            () -> new SimpleFoiledItem(new Item.Properties().stacksTo(16).rarity(Rarity.RARE).food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).
                    effect(()-> new MobEffectInstance(ModEffects.FREEZING_BODY.get(),1800,0),1.0F).build())){
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.freezing_long_bread.tooltip"));
                    tooltip.add(Component.translatable("tooltip.upgradedbread.freezing_long_bread.tale1"));
                    tooltip.add(Component.translatable("tooltip.upgradedbread.freezing_long_bread.tale2"));
                    tooltip.add(Component.translatable("tooltip.upgradedbread.freezing_long_bread.tale3"));
                    tooltip.add(Component.translatable("tooltip.upgradedbread.support.marshall"));
                }
            });

//material---------------------------------------------------------------------------------------------->
    public static final RegistryObject<Item> SUGAR_GROUP = ITEMS.register("sugar_group",
        () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLAZE_GROUP = ITEMS.register("blaze_group",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FOOT_GROUP = ITEMS.register("foot_group",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MELON_GROUP = ITEMS.register("melon_group",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PUFF_GROUP = ITEMS.register("puff_group",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAGMA_GROUP = ITEMS.register("magma_group",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CARROT_GROUP = ITEMS.register("carrot_group",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DECAYED_GROUP = ITEMS.register("decayed_group",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEAR_GROUP = ITEMS.register("tear_group",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MEMBRANE_GROUP = ITEMS.register("membrane_group",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GREED_GROUP = ITEMS.register("greed_group",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> EMERALD_GROUP = ITEMS.register("emerald_group",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> INFLUENCE_GROUP = ITEMS.register("influence_group",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> FISHING_GROUP = ITEMS.register("fishing_group",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> FREEZING_GROUP = ITEMS.register("freezing_group",
            ()-> new Item(new Item.Properties().rarity(Rarity.RARE)));
    
    //product----------------------------------------------------------------------------------------------->
    public static final RegistryObject<Item> HEART_OF_THE_COAL = ITEMS.register("heart_of_the_coal",
            () -> new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.heart_of_the_coal.tooltip"));
                }
            });
    public static final RegistryObject<Item> LOST_ENERGY_CORE = ITEMS.register("lost_energy_core",
            () -> new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.lost_energy_core.tooltip"));
                }
            });
    public static final RegistryObject<Item> LOW_ENERGY_CORE = ITEMS.register("low_energy_core",
            () -> new SimpleFoiledItem(new Item.Properties().rarity(Rarity.RARE)) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.low_energy_core.tooltip"));
                }
            });
    public static final RegistryObject<Item> HIGH_ENERGY_CORE = ITEMS.register("high_energy_core",
            () -> new SimpleFoiledItem(new Item.Properties().craftRemainder(ModItems.LOST_ENERGY_CORE.get()).rarity(Rarity.UNCOMMON)) {
                @Override
                public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    super.appendHoverText(itemStack, level, tooltip, flag);
                    tooltip.add(Component.translatable("tooltip.upgradedbread.high_energy_core.tooltip"));
                }
            });

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
