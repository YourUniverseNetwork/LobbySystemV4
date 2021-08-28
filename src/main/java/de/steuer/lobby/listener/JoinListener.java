package de.steuer.lobby.listener;

import de.steuer.lobby.commands.setlocCMD;
import de.steuer.lobby.inventories.JoinInv;
import de.steuer.lobby.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(Main.build.contains(p)) {
            Main.build.remove(p);
        }

        String msg = Main.getPlugin().getConfig().getString("Lobby.JoinMessage");
        msg = msg.replaceAll("&", "§");
        msg = msg.replace("%player%", p.getName());
        e.setJoinMessage(msg);

        p.setGameMode(GameMode.SURVIVAL);
        p.getInventory().clear();
        p.teleport((Location) Objects.requireNonNull(setlocCMD.cfg.get("Location.Spawn")));
        p.sendTitle("§eWillkommen §b" + p.getName(), "§7auf dem §aEntwicklungsserver§7!");
        JoinInv.GetJoinItems(p);

        p.setMaxHealth(10.0);
        p.setHealth(10);
        p.setFoodLevel(20);
        p.sendMessage("§eWillkommen auf §bUniverseNetwork§7, §ewir wünschen dir viel Spaß und eine schöne Zeit §l:^)");
        p.setLevel(2021);
        p.setExp(0.0f);

        Main.getVisibleManager().getHider().forEach(hider -> {
            hider.hidePlayer(p);
        });

    //TODO: Connect MSQL Webserver (PHPMyAdmin)
}}
