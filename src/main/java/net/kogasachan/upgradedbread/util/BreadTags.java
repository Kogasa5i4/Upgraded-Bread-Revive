package net.kogasachan.upgradedbread.util;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class BreadTags {
    // 模组标签注册
    public static class Blocks {
        // 方块标签注册
        public static final TagKey<Block> DROPS_LOST_ENERGY_CORE = tag("drops_lost_energy_core");

        // 方块标签添加
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(UpgradedBread.MODID, name));
        }
    }

    public static class Items {
        // 物品标签注册
        public static final TagKey<Item> GROUPS = tag("groups");
        public static final TagKey<Item> POTION_GROUPS = tag("potion_groups");
        public static final TagKey<Item> SPECIAL_GROUPS = tag("special_groups");
        public static final TagKey<Item> ESSENCES = tag("essences");
        public static final TagKey<Item> POTION_ESSENCES = tag("potion_essences");
        public static final TagKey<Item> SPECIAL_ESSENCES = tag("special_essences");
        public static final TagKey<Item> FOODS = tag("foods");
        public static final TagKey<Item> BASIC_BREADS = tag("basic_breads");
        public static final TagKey<Item> POTION_FOODS = tag("potion_foods");
        public static final TagKey<Item> SPECIAL_FOODS = tag("special_foods");
        public static final TagKey<Item> ENERGY_CORES = tag("energy_cores");

        // 物品标签添加
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(UpgradedBread.MODID, name));
        }
    }
}
