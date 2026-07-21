package net.kogasachan.upgradedbread.sound;

import net.kogasachan.upgradedbread.UpgradedBread;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BreadSounds {
    // 创建音效的延迟注册器
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, UpgradedBread.MODID);

    // 注册灼热音效
    public static final RegistryObject<SoundEvent> BURNING_ATTACK =
            registerSoundEvent("burning_attack");

    // 注册经验汲取音效
    public static final RegistryObject<SoundEvent> EXPERIENCE_BOOST =
            registerSoundEvent("experience_boost");

    // 注册抢救音效
    public static final RegistryObject<SoundEvent> AUTO_REPAIR =
            registerSoundEvent("auto_repair");

    // 辅助方法, 简化注册过程
    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name,
                () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(UpgradedBread.MODID, name)));
    }

    // 在模组主类中调用此方法, 将注册器添加到模组事件总线
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}