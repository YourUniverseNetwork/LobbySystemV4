package de.universenetwork.lobby.vanish;

import de.universenetwork.lobby.main.Main;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.entity.*;

public class vanishCMD implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        final VanishManager vanishManager = Main.getInstance().getVanishManager();
        if (args.length == 1) {
            final Player player = Bukkit.getPlayer(args[0]);
            if (player == null) {
                sender.sendMessage(Main.prefix + ChatColor.RED + "Der Spieler ist nicht online!");
                return true;
            }
            if (vanishManager.isVanished(player)) {
                vanishManager.setVanished(player, false);
                sender.sendMessage(Main.prefix + ChatColor.RED + "Der Spieler ist jetzt nicht mehr im Vanish!");
            }
            else {
                vanishManager.setVanished(player, true);
                sender.sendMessage(Main.prefix + "§aDer Spieler ist jetzt im Vanish");
            }
            return true;
        }
        else {
            if (sender instanceof Player) {
                final Player player = (Player)sender;
                if (vanishManager.isVanished(player)) {
                    vanishManager.setVanished(player, false);
                    sender.sendMessage(Main.prefix + ChatColor.RED + "Du bist jetzt nicht mehr im Vanish!");
                }
                else {
                    vanishManager.setVanished(player, true);
                    sender.sendMessage(Main.prefix + ChatColor.GREEN + "Du bist jetzt im Vanish!");
                }
                return true;
            }
            return false;
        }
    }
}
