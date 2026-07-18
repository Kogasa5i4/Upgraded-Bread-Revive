package net.kogasachan.upgradedbread.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class BreadConfigs {
    public static final ServerConfig SERVER;
    public static final ForgeConfigSpec SERVER_SPEC;

    static {
        final Pair<ServerConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder()
                .configure(ServerConfig::new);
        SERVER = specPair.getLeft();
        SERVER_SPEC = specPair.getRight();
    }

    public static class ServerConfig {
        public final ForgeConfigSpec.ConfigValue<Integer> waterConsumptionMode;
        public final ForgeConfigSpec.ConfigValue<Double> penaltyDeathChance;
        public final ForgeConfigSpec.ConfigValue<Integer> healthBreadDefaultLevel;
        public final ForgeConfigSpec.ConfigValue<Boolean> healthBreadEnableLevelIncrement;
        public final ForgeConfigSpec.ConfigValue<Integer> healthBreadMaxLevel;
        public final ForgeConfigSpec.ConfigValue<Boolean> healthBreadEnableAbsorption;
        public final ForgeConfigSpec.ConfigValue<Integer> healthBreadAbsorptionLevel;
        public final ForgeConfigSpec.ConfigValue<Integer> healthBreadAbsorptionMaxTime;

        public ServerConfig(ForgeConfigSpec.Builder builder) {
            builder.comment("炼药锅蘸水设置")
                    .push("bread_dipping");
            waterConsumptionMode = builder
                    .comment("炼药锅中水的消耗模式：0=不消耗，1=消耗一份水（水位降1级），2=消耗所有水（清空），默认为0")
                    .defineInRange("waterConsumptionMode", 0, 0, 2);
            builder.pop();

            builder.comment("巧乐兹设置")
                    .push("chocliz_bread");
            penaltyDeathChance = builder
                    .comment("巧乐兹效果结束后杀死玩家的概率（0~1），1.0表示必死，默认为0.05")
                    .comment("*不建议设太高")
                    .defineInRange("deathChance", 0.05, 0.0, 1.0);
            builder.pop();

            builder.comment("李家华夫包设置")
                    .push("lees_waffle");
            healthBreadDefaultLevel = builder
                    .comment("默认生命增加等级（0-255，0表示增加半颗心，增加一级则多半颗心），默认为3")
                    .comment("*可能会导致效果超模")
                    .defineInRange("defaultLevel", 3, 0, 255);
            healthBreadEnableLevelIncrement = builder
                    .comment("是否启用等级递增（每吃一个增加一颗心），默认为false")
                    .comment("*可能会导致效果超模")
                    .define("enableLevelIncrement", false);
            healthBreadMaxLevel = builder
                    .comment("最大等级（0-255），默认为255")
                    .comment("*可能会导致效果超模")
                    .defineInRange("maxLevel", 255, 0, 255);
            healthBreadEnableAbsorption = builder
                    .comment("是否启用满血时赋予伤害吸收，默认为false")
                    .comment("*可能会导致效果超模")
                    .define("enableAbsorption", false);
            healthBreadAbsorptionLevel = builder
                    .comment("伤害吸收等级（0-255），默认为1")
                    .comment("*可能会导致效果超模")
                    .defineInRange("absorptionLevel", 1, 0, 255);
            healthBreadAbsorptionMaxTime = builder
                    .comment("伤害吸收持续时间（单位为tick【1秒=20tick】，-1表示无限），默认为600")
                    .comment("*可能会导致效果超模")
                    .defineInRange("absorptionDuration", 600, -1, Integer.MAX_VALUE);
            builder.pop();
        }
    }
}