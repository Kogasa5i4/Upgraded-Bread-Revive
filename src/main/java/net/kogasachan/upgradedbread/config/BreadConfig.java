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
        public final ForgeConfigSpec.ConfigValue<Boolean> consumeAllWater;

        public ServerConfig(ForgeConfigSpec.Builder builder) {
            builder.comment("面包蘸炼药锅水的设置")
                    .push("bread_dipping");

            consumeAllWater = builder
                    .comment("是否消耗炼药锅所有水：true=清空，false=不消耗（默认）")
                    .define("consumeAllWater", false);

            builder.pop();
        }
    }
}