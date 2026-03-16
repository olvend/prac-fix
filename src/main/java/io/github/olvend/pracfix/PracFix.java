package io.github.olvend.pracfix;

import io.github.olvend.pracfix.command.PracFixCommand;
import io.github.olvend.pracfix.config.PracFixConfig;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = PracFix.MOD_ID,
        name = PracFix.MOD_NAME,
        version = PracFix.MOD_VERSION,
        acceptedMinecraftVersions = "@ACCEPTED_MINECRAFT_VERSIONS@",
        clientSideOnly = true
)
public class PracFix {
    public static final String MOD_ID = "@MOD_ID@";
    public static final String MOD_NAME = "@MOD_NAME@";
    public static final String MOD_VERSION = "@MOD_VERSION@";

    public static PracFixConfig config;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        config = new PracFixConfig(event.getSuggestedConfigurationFile());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new PracFixCommand());
    }
}