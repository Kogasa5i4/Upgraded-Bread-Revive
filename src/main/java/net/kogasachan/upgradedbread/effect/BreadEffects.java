package net.kogasachan.upgradedbread.effect;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BreadEffects {
    //DeferredRegister: 延迟注册器, 正式注册物品, 创造模式标签页, 方块, 药水效果等的必须前置
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, UpgradedBread.MODID);

    //药水效果注册
    public static final RegistryObject<MobEffect> PERFECT_FREEZE =
            MOB_EFFECTS.register("perfect_freeze",
                    () -> new PerfectFreezeEffect(MobEffectCategory.HARMFUL, 16316671));
    public static final RegistryObject<MobEffect> FREEZING_BODY =
            MOB_EFFECTS.register("freezing_body",
                    () -> new FreezingBodyEffect(MobEffectCategory.BENEFICIAL, 5636095));
    public static final RegistryObject<MobEffect> KE_LA_BODY =
            MOB_EFFECTS.register("ke_la_body",
                    () -> new KeLaBodyEffect(MobEffectCategory.BENEFICIAL, 15975181));
    public static final RegistryObject<MobEffect> UNOVERTAKABLE =
            MOB_EFFECTS.register("unovertakable",
                    () -> new UnovertakableEffect(MobEffectCategory.BENEFICIAL, 11221387));
    public static final RegistryObject<MobEffect> MINOR_HEALTH_BOOST =
            MOB_EFFECTS.register("minor_health_boost",
                    () -> new MinorHealthBoostEffect(MobEffectCategory.BENEFICIAL, 0xFFAA00));
    //滋养: 削弱版
    public static final RegistryObject<MobEffect> GUARANTEED_FULLNESS =
            MOB_EFFECTS.register("guaranteed_fullness",
                    () -> new GuaranteedFullnessEffect(MobEffectCategory.BENEFICIAL, 0xFFD700));

    //以下为测试用
    //生命回溯: 削弱版
    public static final RegistryObject<MobEffect> TIME_REVERSE =
            MOB_EFFECTS.register("time_reverse",
                    () -> new MobEffect(MobEffectCategory.BENEFICIAL, 0x00FFCC) {
                        @Override
                        public boolean isDurationEffectTick(int duration, int amplifier) {
                            return true;
                        }
                    });
    //饱腹代偿: 削弱版
    public static final RegistryObject<MobEffect> FOOD_SHIELD =
            MOB_EFFECTS.register("food_shield",
                    () -> new MobEffect(MobEffectCategory.BENEFICIAL, 0xFFAA00) {
                        @Override
                        public boolean isDurationEffectTick(int duration, int amplifier) {
                            return true;
                        }
                    });
    //!?经验汲取?!
    public static final RegistryObject<MobEffect> EXPERIENCE_BOOST =
            MOB_EFFECTS.register("experience_boost",
                    () -> new MobEffect(MobEffectCategory.BENEFICIAL, 0x55FF55) {
                        @Override
                        public boolean isDurationEffectTick(int duration, int amplifier) {
                            return false;
                        }
                    });
    //自动修补
    public static final RegistryObject<MobEffect> AUTO_REPAIR =
            MOB_EFFECTS.register("auto_repair",
                    () -> new MobEffect(MobEffectCategory.BENEFICIAL, 0xFFAA00) {
                        @Override
                        public boolean isDurationEffectTick(int duration, int amplifier) {
                            return true;
                        }
                    });
    //经验护盾
    public static final RegistryObject<MobEffect> EXPERIENCE_SHIELD =
            MOB_EFFECTS.register("experience_shield",
                    () -> new MobEffect(MobEffectCategory.BENEFICIAL, 0x00AAFF) {
                        @Override
                        public boolean isDurationEffectTick(int duration, int amplifier) {
                            return false;
                        }
                    });

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
