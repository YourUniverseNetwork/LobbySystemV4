package de.universenetwork.lobby.inventories;

import de.universenetwork.lobby.utils.ItemAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class JoinInv {

    public static void GetJoinItems(final Player player) {

        player.getInventory().setItem(0, new ItemAPI(Material.NETHER_STAR).setName("§d§lNavigator").build());
        player.getInventory().setItem(8, new ItemAPI(Material.WOODEN_SWORD).setName("§aSchwert von den §bGeistlichen").build());
        player.getInventory().setItem(4, new ItemAPI(Material.GRAY_DYE).setName("§cPlayerHider [aus]").setLore("§aAktiviere den PlayerHider und sehe keine Spieler mehr!").build());
    }
}
