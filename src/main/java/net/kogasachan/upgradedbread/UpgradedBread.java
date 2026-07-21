package net.kogasachan.upgradedbread;

import net.kogasachan.upgradedbread.block.BreadBlocks;
import net.kogasachan.upgradedbread.config.BreadConfigs;
import net.kogasachan.upgradedbread.effect.BreadEffects;
import net.kogasachan.upgradedbread.event.BreadRefreshEvent;
import net.kogasachan.upgradedbread.event.FoxGivingEvent;
import net.kogasachan.upgradedbread.event.UnovertakableEvent;
import net.kogasachan.upgradedbread.item.BreadItems;
import net.kogasachan.upgradedbread.item.tab.BreadCreativeModeTabs;
import net.kogasachan.upgradedbread.sound.BreadSounds;
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
public class UpgradedBread {
    // 模组主类
    // modid 注册
    public static final String MODID = "upgradedbread";

    // 模组事件总线
    public UpgradedBread(FMLJavaModLoadingContext context) {
        // 获取模组事件总线
        IEventBus modEventBus = context.getModEventBus();

        // 主类的注册
        MinecraftForge.EVENT_BUS.register(this);

        // 物品, 创造模式标签页, 方块, 药水效果, 音效注册(注意药水效果写法不同)
        BreadItems.register(modEventBus);
        BreadCreativeModeTabs.register(modEventBus);
        BreadBlocks.register(modEventBus);
        BreadEffects.MOB_EFFECTS.register(modEventBus);
        BreadSounds.register(modEventBus);

        // 事件监听
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        // 事件处理类注册
        MinecraftForge.EVENT_BUS.register(new BreadRefreshEvent());
        MinecraftForge.EVENT_BUS.register(new UnovertakableEvent());
        MinecraftForge.EVENT_BUS.register(new FoxGivingEvent());

        // 服务端配置文件类注册
        context.registerConfig(ModConfig.Type.SERVER, BreadConfigs.SERVER_SPEC);
    }

    // 位于模组加载的公共初始化阶段, 可用于注册酿造配方, 网络包, 复杂配方序列化器等
    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    // 在创造模式物品栏构建时触发, 可用于将物品添加到已有的创造模式标签页
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    // 在服务器启动时触发, 可用于加载服务器专属数据或执行服务器初始化
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // 客户端专用的事件订阅类
    // 在客户端初始化阶段执行, 常用于注册渲染器 (如物品模型, 特殊方块渲染器) 或加载客户端资源
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
