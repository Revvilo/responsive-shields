package revvilo.responsiveshields.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class Config {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.DoubleValue SHIELD_DELAY;
    public static final ModConfigSpec.BooleanValue IS_ENABLED;

    static {
        SHIELD_DELAY = BUILDER.comment(
            "The amount of time, in ticks, before a shield will block",
            "Setting to 5 is the same as vanilla.",
            "Setting to 0 makes shields capable of blocking instantly.",
            "The shield's 'Block' animation takes roughly 1 tick to complete, so setting to 1 is a good balance to prevent block-hitting."
            ).defineInRange("raiseTime", 0, 0, Double.MAX_VALUE);

        IS_ENABLED = BUILDER.comment("Whether or not the mods effect is enabled.").define("enabled", true);
        
        SPEC = BUILDER.build();
    }
}
