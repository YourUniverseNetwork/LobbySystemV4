package de.universenetwork.lobby.playerhider;

import de.universenetwork.lobby.main.Main;
import de.universenetwork.lobby.utils.ItemAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;

public class PlayerHiderListener implements Listener {

    public HashMap<String, Long> cooldowns = new HashMap<String, Long>();

    @EventHandler
    public void handlePlayerInteractEvent(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        int cooldownTime = 5; // Get number of seconds from wherever you want
        if (cooldowns.containsKey(player.getName())) {
            long secondsLeft = ((cooldowns.get(player.getName()) / 1000) + cooldownTime) - (System.currentTimeMillis() / 1000);
            if (secondsLeft > 0) {
                // Still cooling down
                player.sendMessage(Main.prefix + "§7Du kannst dies nur alle §a" + secondsLeft + " Sekunden §7tun!");
                cooldowns.put(player.getName(), System.currentTimeMillis());
            }
        } else {
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (event.getItem().getType() == Material.GRAY_DYE) {
                    player.getInventory().setItem(4, new ItemAPI(Material.LIME_DYE).setName("§aPlayerHider [an]").setLore("§cDeaktiviere den PlayerHider und sehe alle Spieler wieder!").build());

                    Bukkit.getOnlinePlayers().forEach(player::showPlayer);
                    player.sendMessage(Main.prefix + "§cDu kannst nun keine Spieler mehr sehen§7.");
                    Main.getVisibleManager().getHider().remove(player);
                } else if (event.getItem().getType() == Material.LIME_DYE) {

                    player.getInventory().setItem(4, new ItemAPI(Material.GRAY_DYE).setName("§cPlayerHider [aus]").setLore("§aAktiviere den PlayerHider und sehe keine Spieler mehr!").build());
                    Bukkit.getOnlinePlayers().forEach(player::showPlayer);
                    Main.getVisibleManager().getHider().add(player);
                    player.sendMessage(Main.prefix + "§aDu siehst nun alle Spieler§7.");
                }
            }
        }
    }
}