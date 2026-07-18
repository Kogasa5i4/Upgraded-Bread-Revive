package net.kogasachan.upgradedbread.effect;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BreadEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, UpgradedBread.MODID);

    public static final RegistryObject<MobEffect> PERFECT_FREEZE =
            MOB_EFFECTS.register("perfect_freeze",
            ()-> new PerfectFreeze(MobEffectCategory.HARMFUL,16316671));
    public static final RegistryObject<MobEffect> FREEZING_BODY =
            MOB_EFFECTS.register("freezing_body",
            ()-> new FreezingBody(MobEffectCategory.BENEFICIAL,5636095));
    public static final RegistryObject<MobEffect> KE_LA_BODY =
            MOB_EFFECTS.register("ke_la_body",
            () -> new KeLaBody(MobEffectCategory.BENEFICIAL, 15975181));
    public static final RegistryObject<MobEffect> UNOVERTAKABLE =
            MOB_EFFECTS.register("unovertakable",
                    () -> new Unovertakable(MobEffectCategory.BENEFICIAL, 11221387));
    public static final RegistryObject<MobEffect> MINOR_HEALTH_BOOST =
            MOB_EFFECTS.register("minor_health_boost",
                    () -> new MinorHealthBoost(MobEffectCategory.BENEFICIAL, 0xFFAA00));

    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}
