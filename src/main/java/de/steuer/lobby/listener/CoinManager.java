package de.steuer.lobby.listener;

import org.bukkit.entity.*;
import java.io.*;
import org.bukkit.configuration.file.*;

public class CoinManager
{
    public static void setBalance(final Player player, final int coins) {
        final File file = new File("plugins//LobbySystemV4//PlayerStats.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        cfg.set("Stats." + player.getUniqueId() + ".Coins", (Object)coins);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeBalance(final Player player, final int coins) {
        final File file = new File("plugins//LobbySystemV4//PlayerStats.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        cfg.set("Stats." + player.getUniqueId() + ".Coins", (Object)(cfg.getInt("Stats." + player.getUniqueId() + ".Coins") - coins));
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addBalance(final Player player, final int coins) {
        final File file = new File("plugins//LobbySystemV4//PlayerStats.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        cfg.set("Stats." + player.getUniqueId() + ".Coins", (Object)(cfg.getInt("Stats." + player.getUniqueId() + ".Coins") + coins));
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean hasEnoughCoins(final Player player, final int price) {
        final File file = new File("plugins//LobbySystemV4//PlayerStats.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        boolean hasEnough = false;
        final int coins = cfg.getInt("Stats." + player.getUniqueId() + ".Coins");
        hasEnough = (coins > price);
        return hasEnough;
    }

    public static int getBalance(final Player player) {
        final File file = new File("plugins//LobbySystemV4//PlayerStats.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        final int coins = cfg.getInt("Stats." + player.getUniqueId() + ".Coins");
        return coins;
    }
}
