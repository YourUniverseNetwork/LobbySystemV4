package de.universenetwork.lobby.listener;

import de.universenetwork.lobby.commands.setlocCMD;
import de.universenetwork.lobby.main.Main;
import de.universenetwork.lobby.utils.ItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.event.*;
import org.bukkit.event.inventory.*;
import org.bukkit.*;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

import static de.universenetwork.lobby.main.Main.prefix;
import static org.bukkit.Material.*;

public class InteractListener implements Listener {

    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {

        final Player p = e.getPlayer();
        if (e.getItem() != null || e.getItem().getType() != AIR) {
            if ((e.getItem()).getItemMeta().getDisplayName().equalsIgnoreCase("§d§lNavigator")) {
                if (e.getItem().getType() == NETHER_STAR) {
                    final Inventory inv = Bukkit.createInventory(null, 54, Component.text("§d§lNavigator"));

                    Bukkit.getScheduler().runTaskLaterAsynchronously((Plugin) Main.instance, () -> {
                        inv.setItem(0, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(1, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(2, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(3, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(4, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(5, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10.0f, 10.0f);
                        return;
                    }, 1L);

                    Bukkit.getScheduler().runTaskLaterAsynchronously((Plugin) Main.instance, () -> {
                        inv.setItem(6, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(7, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(8, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(9, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(18, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10.0f, 10.0f);
                        return;
                    }, 2L);

                    Bukkit.getScheduler().runTaskLaterAsynchronously((Plugin) Main.instance, () -> {
                        inv.setItem(27, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(36, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(17, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(26, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(35, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(44, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(45, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10.0f, 10.0f);
                        return;
                    }, 3L);

                    Bukkit.getScheduler().runTaskLaterAsynchronously((Plugin) Main.instance, () -> {
                        inv.setItem(27, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(36, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(17, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(26, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(35, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(44, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(45, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10.0f, 10.0f);
                        return;
                    }, 4L);

                    Bukkit.getScheduler().runTaskLaterAsynchronously((Plugin) Main.instance, () -> {
                        inv.setItem(46, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(47, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(48, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(49, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(50, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(51, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(52, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(53, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10.0f, 10.0f);
                        return;
                    }, 5L);

                    Bukkit.getScheduler().runTaskLaterAsynchronously((Plugin) Main.instance, () -> {
                        inv.setItem(46, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(47, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(48, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(49, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(50, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(51, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(52, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        inv.setItem(53, new ItemBuilder(WHITE_STAINED_GLASS_PANE).setName("§a").toItemStack());
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10.0f, 10.0f);
                        return;
                    }, 6L);


                    Bukkit.getScheduler().runTaskLaterAsynchronously((Plugin) Main.instance, () -> {
                        inv.setItem(22, new ItemBuilder(Material.BEACON).setName("§e§lNPCs").toItemStack());
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10.0f, 10.0f);
                        return;
                    }, 8L);

                    p.openInventory(inv);
                }
            } else if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSchwert von den §bGeistlichen")) {
                if (e.getItem().getType() == WOODEN_SWORD) {
                    p.sendTitle(prefix + "", "§7Dieses Schwert wurde hergestellt in §ageheimen Bergruinen§7!");
                }
            }
        }
    }

    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        try {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lNPCs")) {
                if (e.getCurrentItem().getType() == BEACON) {
                    if (setlocCMD.cfg.contains("Location.NPCs")) {
                        p.closeInventory();
                        p.teleport((Location) Objects.requireNonNull(setlocCMD.cfg.get("Location.NPCs")));
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 10.0f, 10.0f);
                    } else {
                        p.closeInventory();
                        p.sendTitle(prefix + "", "§c§lERROR, §7Warp: §cNPCs §7nicht gefunden!");
                        p.sendMessage(prefix + "§cEs wurde die Location NPCs nicht gesetzt!");
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10.0f, 10.0f);
                    }
                }
            }
        } catch (Exception ignored) {
        }
    }
}
