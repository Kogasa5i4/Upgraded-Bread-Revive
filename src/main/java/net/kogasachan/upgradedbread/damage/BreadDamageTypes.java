package net.kogasachan.upgradedbread.damage;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class BreadDamageTypes {
    public static final ResourceKey<DamageType> UNOVERTAKABLE =
            ResourceKey.create(Registries.DAMAGE_TYPE,
                    ResourceLocation.fromNamespaceAndPath(UpgradedBread.MODID, "unovertakable"));
}