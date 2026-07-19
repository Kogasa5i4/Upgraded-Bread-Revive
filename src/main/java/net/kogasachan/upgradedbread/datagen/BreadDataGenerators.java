package net.kogasachan.upgradedbread.datagen;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = UpgradedBread.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BreadDataGenerators {
    //数据包生成
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new BreadRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), BreadLootTableProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new BreadBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new BreadItemModelProvider(packOutput, existingFileHelper));

        BreadBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new BreadBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new BreadItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
    }
}
