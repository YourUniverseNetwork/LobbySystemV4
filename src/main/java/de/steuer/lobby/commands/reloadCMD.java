package de.steuer.lobby.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static de.steuer.lobby.main.Main.plugin;
import static de.steuer.lobby.main.Main.prefix;

public class reloadCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        sender.sendMessage(prefix + "§cPlugin lädt neu...");
        Bukkit.getServer().getPluginManager().disablePlugin(plugin);
        Bukkit.getServer().getPluginManager().enablePlugin(plugin);
        sender.sendMessage(prefix + "§aPlugin erfolgreich reloaded!");

        return false;
    }
}
