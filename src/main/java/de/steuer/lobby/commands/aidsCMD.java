package de.steuer.lobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import static de.steuer.lobby.main.Main.prefix;

public class aidsCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        sender.sendMessage(prefix + "§aJetzt hast du leider Aids :c");

        return false;
    }
}
