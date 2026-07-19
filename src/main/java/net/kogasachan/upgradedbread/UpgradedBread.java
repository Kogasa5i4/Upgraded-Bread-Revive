package net.kogasachan.upgradedbread;

import net.kogasachan.upgradedbread.block.BreadBlocks;
import net.kogasachan.upgradedbread.config.BreadConfigs;
import net.kogasachan.upgradedbread.effect.BreadEffects;
import net.kogasachan.upgradedbread.event.BreadRefreshEvent;
import net.kogasachan.upgradedbread.event.UnovertakableEvent;
import net.kogasachan.upgradedbread.item.BreadCreativeModeTabs;
import net.kogasachan.upgradedbread.item.BreadItems;
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

@Mod(UpgradedBread.MODID)
public class UpgradedBread
{
    public static final String MODID = "upgradedbread";

    public UpgradedBread(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        BreadCreativeModeTabs.register(modEventBus);

        BreadItems.register(modEventBus);
        BreadBlocks.register(modEventBus);
        BreadEffects.MOB_EFFECTS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(new BreadRefreshEvent());
        MinecraftForge.EVENT_BUS.register(new UnovertakableEvent());

        context.registerConfig(ModConfig.Type.SERVER, BreadConfigs.SERVER_SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
