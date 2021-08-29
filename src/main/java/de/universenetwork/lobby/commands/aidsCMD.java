package de.universenetwork.lobby.commands;

import de.universenetwork.lobby.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class aidsCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        sender.sendMessage(Main.prefix + "§aJetzt hast du leider Aids :c");

        return false;
    }
}
