package de.steuer.lobby.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static de.steuer.lobby.main.Main.prefix;

public class chatclearCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        for (int i = 0; i < 1000; ++i) {
            Bukkit.broadcastMessage("§7» ");
        }
        Bukkit.broadcastMessage(prefix + "§aDer Chat wurde geleert von §b" + sender.getName() + "§7.");
        return false;
    }
}
