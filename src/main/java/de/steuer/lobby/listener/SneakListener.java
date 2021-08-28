package de.steuer.lobby.listener;

import de.steuer.lobby.inventories.JoinInv;
import de.steuer.lobby.main.Main;
import de.steuer.lobby.utils.ItemAPI;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class SneakListener implements Listener {

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e) {
        if(!Main.build.contains(e.getPlayer())) {
            if (e.getPlayer().isSneaking()) {
                e.getPlayer().getInventory().clear();
                JoinInv.GetJoinItems(e.getPlayer());
            } else {
                e.getPlayer().getInventory().clear();
                e.getPlayer().getInventory().setItem(4, new ItemAPI(Material.BARRIER).setName("§a§lDu Sneaker!, §b§lUnKuHl (:").build());
                e.getPlayer().getInventory().setItem(0, new ItemAPI(Material.BARRIER).setName("§a§lDu Sneaker!, §b§lUnKuHl (:").build());
                e.getPlayer().getInventory().setItem(1, new ItemAPI(Material.BARRIER).setName("§a§lDu Sneaker!, §b§lUnKuHl (:").build());
                e.getPlayer().getInventory().setItem(2, new ItemAPI(Material.BARRIER).setName("§a§lDu Sneaker!, §b§lUnKuHl (:").build());
                e.getPlayer().getInventory().setItem(3, new ItemAPI(Material.BARRIER).setName("§a§lDu Sneaker!, §b§lUnKuHl (:").build());
                e.getPlayer().getInventory().setItem(4, new ItemAPI(Material.BARRIER).setName("§a§lDu Sneaker!, §b§lUnKuHl (:").build());
                e.getPlayer().getInventory().setItem(5, new ItemAPI(Material.BARRIER).setName("§a§lDu Sneaker!, §b§lUnKuHl (:").build());
                e.getPlayer().getInventory().setItem(6, new ItemAPI(Material.BARRIER).setName("§a§lDu Sneaker!, §b§lUnKuHl (:").build());
                e.getPlayer().getInventory().setItem(7, new ItemAPI(Material.BARRIER).setName("§a§lDu Sneaker!, §b§lUnKuHl (:").build());
                e.getPlayer().getInventory().setItem(8, new ItemAPI(Material.BARRIER).setName("§a§lDu Sneaker!, §b§lUnKuHl (:").build());
            }
        }
    }
}
