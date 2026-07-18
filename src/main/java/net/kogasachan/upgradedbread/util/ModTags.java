package net.kogasachan.upgradedbread.util;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> DROPS_LOST_ENERGY_CORE = tag(UpgradedBread.MODID, "drops_lost_energy_core");

        private static TagKey<Block> tag(String namespace, String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(namespace, name));
        }
    }

    public static class Items {
        private static TagKey<Item> tag(String namespace, String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(namespace, name));
        }
    }
}
