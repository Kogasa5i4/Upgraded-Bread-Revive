package net.kogasachan.upgradedbread.datagen.loot;

import net.kogasachan.upgradedbread.block.BreadBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class BreadBlockLootTables extends BlockLootSubProvider {
    //提供战利品表
    public BreadBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(BreadBlocks.CARBOHYDRATE_BLOCK.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return BreadBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
