package net.kogasachan.kogasas_thinking;

import com.mojang.logging.LogUtils;
import net.kogasachan.kogasas_thinking.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(KogasasThinking.MODID)
public class KogasasThinking
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "kogasas_thinking";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public KogasasThinking(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ModItems.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.RAW_DEBRIS);
//            event.accept(ModItems.RAW_MITHRIL);
            event.accept(ModItems.NETHERITE_SHARD);
            event.accept(ModItems.MITHRIL_SHARD);
            event.accept(ModItems.DIAMOND_SHARD);
            event.accept(ModItems.EMERALD_SHARD);
            event.accept(ModItems.REDSTONE_SHARD);
            event.accept(ModItems.LAPIS_SHARD);
            event.accept(ModItems.NETHERITE_NUGGET);
            event.accept(ModItems.MITHRIL_NUGGET);
            event.accept(ModItems.COPPER_NUGGET);
            event.accept(ModItems.CRUSHED_DEBRIS);
            event.accept(ModItems.CRUSHED_MITHRIL);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
