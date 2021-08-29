package de.universenetwork.lobby.commands;

import de.universenetwork.lobby.listener.CoinManager;
import de.universenetwork.lobby.main.Main;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class coinCMD implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        final Player player = (Player)sender;
        if (command.getName().equalsIgnoreCase("coins")) {
            if (!player.hasPermission("lobby.coins.edit")) {
                    player.sendMessage(String.valueOf(Main.prefix) + "§cDazu hast du keine Rechte.");
                return true;
            }
            if (args.length == 4) {
                if (args[0].equalsIgnoreCase("set")) {
                    final Player target = Bukkit.getPlayer(args[1]);
                    if (target != null) {
                        CoinManager.setBalance(target, Integer.valueOf(args[2]));
                        player.sendMessage(String.valueOf(Main.prefix) + "§7Du hast die M\u00fcnzen von §b" + target.getName() + " §7bearbeitet.");
                    }
                    player.sendMessage(String.valueOf(Main.prefix) + "§7Dieser Spieler ist leider offline.");

                }
                else if (args[0].equalsIgnoreCase("add")) {
                    final Player target = Bukkit.getPlayer(args[1]);
                    if (target != null) {
                        CoinManager.addBalance(target, Integer.valueOf(args[2]));
                        player.sendMessage(String.valueOf(Main.prefix) + "§7Du hast die M\u00fcnzen von §b" + target.getName() + " §7bearbeitet.");
                    }
                    player.sendMessage(String.valueOf(Main.prefix) + "§7Dieser Spieler ist leider offline.");
                }
                else if (args[0].equalsIgnoreCase("remove")) {
                    final Player target = Bukkit.getPlayer(args[1]);
                    if (target != null) {
                        CoinManager.removeBalance(target, Integer.valueOf(args[2]));
                        player.sendMessage(String.valueOf(Main.prefix) + "§7Du hast die M\u00fcnzen von §b" + target.getName() + " §7bearbeitet.");
                    }
                    player.sendMessage(String.valueOf(Main.prefix) + "§7Dieser Spieler ist leider offline.");
                }
                    player.sendMessage(String.valueOf(Main.prefix) + "§cFehler, dieser Command geht so nicht.");
            }
            player.sendMessage(String.valueOf(Main.prefix) + "§cFehler, dieser Command geht so nicht.");
        }
        return true;
    }
}
