package de.steuer.lobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static de.steuer.lobby.main.Main.prefix;

public class huhnCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) sender;
        if(player.hasPermission("lobby.huhn")) {
            player.sendTitle(prefix + "§eHuhn oder nicht?", "§aJa, du bist eins.");
        }
        else {
            player.sendTitle(prefix + "§eHuhn oder nicht?", "§cNein, du bist keins.");
        }



        return false;
    }
}
