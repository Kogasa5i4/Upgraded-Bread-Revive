package net.kogasachan.upgradedbread.datagen;

import net.kogasachan.upgradedbread.datagen.loot.BreadBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class BreadLootTableProvider {
    //战利品表
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(BreadBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}
