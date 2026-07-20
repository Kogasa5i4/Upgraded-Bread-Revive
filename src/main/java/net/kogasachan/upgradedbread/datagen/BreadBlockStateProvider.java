package net.kogasachan.upgradedbread.datagen;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.kogasachan.upgradedbread.block.BreadBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class BreadBlockStateProvider extends BlockStateProvider {
    // 方块状态
    public BreadBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, UpgradedBread.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BreadBlocks.CARBOHYDRATE_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
