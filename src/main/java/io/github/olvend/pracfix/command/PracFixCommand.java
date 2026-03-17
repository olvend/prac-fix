package io.github.olvend.pracfix.command;

import io.github.olvend.pracfix.PracFix;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PracFixCommand extends CommandBase {

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        return args.length == 1 ? Arrays.asList("toggle", "debug") : Collections.emptyList();
    }

    @Override
    public String getCommandName() {
        return "pracfix";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/pracfix <toggle|debug>";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 0) {
            sender.addChatMessage(new ChatComponentText("§7Usage: " + getCommandUsage(sender)));
            sender.addChatMessage(new ChatComponentText("§7 - Prac fix is currently: " + (PracFix.config.fixPrac ? "§aEnabled" : "§cDisabled")));
            sender.addChatMessage(new ChatComponentText("§7 - Debug is currently: " + (PracFix.config.debugPositionUpdates ? "§aEnabled" : "§cDisabled")));
            return;
        }

        String sub = args[0].toLowerCase();

        switch (sub) {
            case "toggle":
                PracFix.config.fixPrac = !PracFix.config.fixPrac;
                PracFix.config.saveConfig();
                sender.addChatMessage(new ChatComponentText("§7Prac fix is now " +
                        (PracFix.config.fixPrac ? "§aEnabled" : "§cDisabled")));
                break;
            case "debug":
                PracFix.config.debugPositionUpdates = !PracFix.config.debugPositionUpdates;
                PracFix.config.saveConfig();
                sender.addChatMessage(new ChatComponentText("§7Debug is now " +
                        (PracFix.config.debugPositionUpdates ? "§aEnabled" : "§cDisabled")));
                break;
            default:
                sender.addChatMessage(new ChatComponentText("§cUnknown subcommand. \n§cUsage: " + getCommandUsage(sender)));
        }
    }
}
