package de.steuer.lobby.vanish;

import org.bukkit.event.Listener;
import org.bukkit.plugin.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class VanishManager {
    private Plugin plugin;
    private final List<Player> vanished;

    public VanishManager(Plugin plugin) {
        this.plugin = this.plugin;
        this.vanished = new ArrayList<Player>();
    }

    public List<Player> getVanished() {
        return this.vanished;
    }

    public boolean isVanished(final Player player) {
        return this.vanished.contains(player);
    }

    public void setVanished(final Player player, final boolean bool) {
        if (bool) {
            this.vanished.add(player);
        }
        else {
            this.vanished.remove(player);
        }
        for (final Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (player.equals(onlinePlayer)) {
                continue;
            }
            if (bool) {
                onlinePlayer.hidePlayer(this.plugin, player);
            }
            else {
                onlinePlayer.showPlayer(this.plugin, player);
            }
        }
    }

    public void hideAll(final Player player) {
        this.vanished.forEach(player1 -> player.hidePlayer(this.plugin, player1));
    }
}
