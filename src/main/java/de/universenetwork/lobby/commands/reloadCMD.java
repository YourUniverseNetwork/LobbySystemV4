package de.universenetwork.lobby.commands;

import de.universenetwork.lobby.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class reloadCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        sender.sendMessage(Main.prefix + "§cPlugin lädt neu...");
        Bukkit.getServer().getPluginManager().disablePlugin(Main.plugin);
        Bukkit.getServer().getPluginManager().enablePlugin(Main.plugin);
        sender.sendMessage(Main.prefix + "§aPlugin erfolgreich reloaded!");

        return false;
    }
}
