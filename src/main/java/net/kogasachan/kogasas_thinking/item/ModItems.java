package net.kogasachan.kogasas_thinking.item;

import net.kogasachan.kogasas_thinking.KogasasThinking;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, KogasasThinking.MODID);

    public static final RegistryObject<Item> RAW_DEBRIS =
            ITEMS.register("raw_debris", () -> (new Item(new Item.Properties())));

//    public static final RegistryObject<Item> RAW_MITHRIL =
//            ITEMS.register("raw_mithril", () -> (new Item(new Item.Properties())));

    public static final RegistryObject<Item> NETHERITE_SHARD =
            ITEMS.register("netherite_shard", () -> (new Item(new Item.Properties())));

    public static final RegistryObject<Item> MITHRIL_SHARD =
            ITEMS.register("mithril_shard", () -> (new Item(new Item.Properties())));

    public static final RegistryObject<Item> DIAMOND_SHARD =
            ITEMS.register("diamond_shard", () -> (new Item(new Item.Properties())));

    public static final RegistryObject<Item> EMERALD_SHARD =
            ITEMS.register("emerald_shard", () -> (new Item(new Item.Properties())));

    public static final RegistryObject<Item> REDSTONE_POWDER =
            ITEMS.register("redstone_powder", () -> (new Item(new Item.Properties())));

    public static final RegistryObject<Item> LAPIS_SHARD =
            ITEMS.register("lapis_shard", () -> (new Item(new Item.Properties())));

    public static final RegistryObject<Item> NETHERITE_NUGGET =
            ITEMS.register("netherite_nugget", () -> (new Item(new Item.Properties())));

    public static final RegistryObject<Item> MITHRIL_NUGGET =
            ITEMS.register("mithril_nugget", () -> (new Item(new Item.Properties())));

    public static final RegistryObject<Item> COPPER_NUGGET =
            ITEMS.register("copper_nugget", () -> (new Item(new Item.Properties())));

    public static final RegistryObject<Item> CRUSHED_DEBRIS =
            ITEMS.register("crushed_debris", () -> (new Item(new Item.Properties())));

    public static final RegistryObject<Item> CRUSHED_MITHRIL =
            ITEMS.register("crushed_mithril", () -> (new Item(new Item.Properties())));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
