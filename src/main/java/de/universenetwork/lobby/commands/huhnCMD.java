package de.universenetwork.lobby.commands;

import de.universenetwork.lobby.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class huhnCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) sender;
        if(player.hasPermission("lobby.huhn")) {
            player.sendTitle(Main.prefix + "§eHuhn oder nicht?", "§aJa, du bist eins.");
        }
        else {
            player.sendTitle(Main.prefix + "§eHuhn oder nicht?", "§cNein, du bist keins.");
        }



        return false;
    }
}
