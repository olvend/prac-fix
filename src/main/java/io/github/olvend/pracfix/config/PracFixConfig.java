package io.github.olvend.pracfix.config;

import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class PracFixConfig {

    private final Configuration config;

    public boolean fixPrac;
    public boolean debugPositionUpdates;

    public PracFixConfig(File configFile) {
        config = new Configuration(configFile);
        loadConfig();
    }

    private void loadConfig() {
        fixPrac = config.getBoolean("fixPrac", Configuration.CATEGORY_GENERAL, true,
                "Fix inaccurate prac positions");
        debugPositionUpdates = config.getBoolean("debugPositionUpdates", Configuration.CATEGORY_GENERAL, false,
                "Sends a debug message when the mod updates your position");
        if (config.hasChanged()) {
            config.save();
        }
    }

    public void saveConfig() {
        config.get(Configuration.CATEGORY_GENERAL, "fixPrac", fixPrac).set(fixPrac);
        config.get(Configuration.CATEGORY_GENERAL, "debugPositionUpdates", debugPositionUpdates).set(debugPositionUpdates);
        if (config.hasChanged()) {
            config.save();
        }
    }
}
