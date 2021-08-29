package de.universenetwork.lobby.utils;

import de.universenetwork.lobby.commands.heightCMD;
import de.universenetwork.lobby.main.Main;
import org.bukkit.event.*;
import org.bukkit.event.weather.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.*;

import java.util.Objects;

public class GameSettings implements Listener
{
    @EventHandler
    public void onFood(final FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onWeather(final WeatherChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onSpawn(final CreatureSpawnEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onMove(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (!Main.build.contains(p) && p.getLocation().getY() < heightCMD.cfg.getInt("Height")) {
            p.teleport((Location) Objects.requireNonNull(heightCMD.cfg.get("Location.Spawn")));
            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 10.0f, 10.0f);
        }
    }


    @EventHandler
    public void onItemHeld(final PlayerItemHeldEvent e) {
        final Player p = e.getPlayer();
        if (SettingsSystem.haveSetting(p.getUniqueId().toString(), "Hotbar")) {
            p.playSound(p.getLocation(), Sound.BLOCK_LAVA_POP, 10.0f, 10.0f);
        }
    }

    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getAction().equals((Object)Action.PHYSICAL) && e.getClickedBlock().getType().equals((Object)Material.FARMLAND) && p != null) {
            e.setCancelled(true);
        }
    }
}
