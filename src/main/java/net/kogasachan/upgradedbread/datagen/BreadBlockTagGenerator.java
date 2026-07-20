package net.kogasachan.upgradedbread.datagen;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.block.BreadBlocks;
import net.kogasachan.upgradedbread.util.BreadTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BreadBlockTagGenerator extends BlockTagsProvider {
    // 方块标签
    public BreadBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, UpgradedBread.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        this.tag(BreadTags.Blocks.DROPS_LOST_ENERGY_CORE)
                .add(BreadBlocks.CARBOHYDRATE_BLOCK.get());
        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(BreadBlocks.CARBOHYDRATE_BLOCK.get());
    }
}
