package de.steuer.lobby.inventories;

import de.steuer.lobby.utils.ItemAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class JoinInv {

    public static void GetJoinItems(final Player player) {

        player.getInventory().setItem(0, new ItemAPI(Material.NETHER_STAR).setName("§d§lNavigator").build());
        player.getInventory().setItem(8, new ItemAPI(Material.WITHER_SKELETON_SKULL).setName("§a§lProfil").build());
        player.getInventory().setItem(4, new ItemAPI(Material.GRAY_DYE).setName("§cPlayerHider [aus]").setLore("§aAktiviere den PlayerHider und sehe keine Spieler mehr!").build());
    }
}
