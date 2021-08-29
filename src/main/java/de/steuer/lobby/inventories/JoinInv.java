package de.steuer.lobby.inventories;

import de.steuer.lobby.utils.ItemAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class JoinInv {

    public static void GetJoinItems(final Player player) {

        player.getInventory().setItem(0, new ItemAPI(Material.NETHER_STAR).setName("§d§lNavigator").build());
        player.getInventory().setItem(8, new ItemAPI(Material.WOODEN_SWORD).setName("§aSchwert von den §bGeistlichen").setLore("").setLore("§7>> Schwert von den §aGeistlichen!").setLore("§7>> Wie wurde es gemacht?").setLore("§7>> ").setLore("§7>> §aEs wurde von den Geistlichen aus Freiburn gemacht.").setLore("§7>> ").setLore("§7>> §6§lLEGENDÄRES ITEM").setLore("§7>> ").build());
        player.getInventory().setItem(4, new ItemAPI(Material.GRAY_DYE).setName("§cPlayerHider [aus]").setLore("§aAktiviere den PlayerHider und sehe keine Spieler mehr!").build());
    }
}
