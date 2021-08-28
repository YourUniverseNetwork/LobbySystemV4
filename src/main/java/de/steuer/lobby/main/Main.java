package de.steuer.lobby.main;

import de.steuer.lobby.commands.*;
import de.steuer.lobby.listener.*;
import de.steuer.lobby.playerhider.PlayerHiderListener;
import de.steuer.lobby.playerhider.VisibleManager;
import de.steuer.lobby.utils.MySQL;
import de.steuer.lobby.utils.SettingsSystem;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main extends JavaPlugin {

    public static Main plugin;
    public static Main instance;
    public static List<Player> build = new ArrayList<>();
    public static String prefix = "§8| §b§lUniverse§f§lNetwork §r§8| §r";
    public static String noperms = prefix + "§cDazu hast du keine Rechte.";
    public static String notfound = prefix + "§cDieser Spieler wurde nicht gefunden.";
    private static VisibleManager visibleManager;


    public static String noCS;
    public static File file;
    public static FileConfiguration cfg;
    private static char[] pr;
    private static  ArrayList<UUID> noplayersvisible;





    @Override
    public void onEnable() {
        (Main.instance = this).createFile();
        if (!MySQL.isConnected()) {
            MySQL.connect();
        }
        SettingsSystem.createTable();


        plugin = this;
        visibleManager = new VisibleManager();
        Bukkit.getConsoleSender().sendMessage(prefix + "§7Das LobbySystem v4 wurde erfolgreich gestartet!");
        noplayersvisible = new ArrayList<>();

        //LISTENER
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new QuitListener(), this);
        Bukkit.getPluginManager().registerEvents(new SneakListener(), this);
        Bukkit.getPluginManager().registerEvents(new ProtectionListener(), this);
        Bukkit.getPluginManager().registerEvents(new InteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new Lag(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerHiderListener(), this);

        //COMMANDS
        getCommand("build").setExecutor(new buildCMD());
        getCommand("reloadlobby").setExecutor(new reloadCMD());
        getCommand("gmc").setExecutor(new gmcCMD());
        getCommand("gms").setExecutor(new gmsCMD());
        getCommand("gmsp").setExecutor(new gmspCMD());
        getCommand("cloudtps").setExecutor(new tpsCMD());
        getCommand("setloc").setExecutor(new setlocCMD());
        getCommand("setheight").setExecutor(new heightCMD());
        getCommand("chatclear").setExecutor(new chatclearCMD());
        getCommand("aids").setExecutor(new aidsCMD());


        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Lag(), 100L, 1L);
        loadconfig();
    }

    private void loadconfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }


    public static Main getInstance() {
        return Main.instance;
    }

    public void createFile() {
        try {
            if (!Main.file.exists()) {
                Main.cfg.set("MySQL.username", (Object) "root");
                Main.cfg.set("MySQL.password", (Object) "password");
                Main.cfg.set("MySQL.database", (Object) "database");
                Main.cfg.set("MySQL.port", (Object) "3306");
                Main.cfg.set("MySQL.host", (Object) "localhost");
                Main.cfg.save(Main.file);
            }
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(Main.prefix + "§cDatei konnte nicht erstellt werden!");
        }
    }

    public static Main getPlugin() {
        return plugin;
    }

    public static ArrayList<UUID> getNoplayersvisible() {
        return noplayersvisible;
    }



    static {
        Main.file = new File("plugins/LobbySystemV4/mysql.yml");
        Main.cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(Main.file);
    }

    public static VisibleManager getVisibleManager() {
        return visibleManager;
    }
}
