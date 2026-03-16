package io.github.olvend.pracfix.config;

import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class PracFixConfig {

    private final Configuration config;

    public boolean fixPrac;
    public boolean debug;

    public PracFixConfig(File configFile) {
        config = new Configuration(configFile);
        loadConfig();
    }

    private void loadConfig() {
        fixPrac = config.getBoolean("fixPrac", Configuration.CATEGORY_GENERAL, true,
                "Fix prac");
        debug = config.getBoolean("debug", Configuration.CATEGORY_GENERAL, false,
                "Sends a message every time the server position is updated by the mod");
        if (config.hasChanged()) {
            config.save();
        }
    }

    public void saveConfig() {
        config.get(Configuration.CATEGORY_GENERAL, "fixPrac", fixPrac).set(fixPrac);
        config.get(Configuration.CATEGORY_GENERAL, "debug", debug).set(debug);
        if (config.hasChanged()) {
            config.save();
        }
    }
}
