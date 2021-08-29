package de.universenetwork.lobby.commands;

import de.universenetwork.lobby.main.Main;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import java.io.*;
import org.bukkit.configuration.file.*;

public class setlocCMD implements CommandExecutor
{
    public static File file;
    public static FileConfiguration cfg;

    public boolean onCommand(final CommandSender cs, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("setloc")) {
            if (!(cs instanceof Player)) {
                cs.sendMessage(Main.noCS);
            }
            else {
                final Player p = (Player)cs;
                if (p.hasPermission("Lobby.setloc")) {
                    if (args.length != 1) {
                        p.sendMessage(Main.prefix + "§cNutze: /setloc <Spawn, Kit-PVP, Spezialmode, Bedwars>");
                    }
                    else if (args[0].equalsIgnoreCase("Spawn")) {
                        this.setCfg("Location.Spawn", p.getLocation());
                        this.setCfg("World.Spawn", p.getWorld().getName());
                        p.sendMessage(Main.prefix + "§7Du hast den §aSpawn §7gesetzt");
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10.0f, 10.0f);
                    }
                    else if (args[0].equalsIgnoreCase("NPCs")) {
                        this.setCfg("Location.NPCs", p.getLocation());
                        this.setCfg("World.NPCs", p.getWorld().getName());
                        p.sendMessage(Main.prefix + "§7Du hast den Standort: §aNPCs §7gesetzt");
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10.0f, 10.0f);
                    }
                    else {
                        p.sendMessage(Main.prefix + "§cDad Warp existiert nicht!");
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10.0f, 10.0f);
                    }
                }
                else {
                    p.sendMessage(Main.prefix + "§cDazu hast du keine Rechte!");
                }
            }
        }
        return false;
    }

    public void saveCfg() {
        try {
            setlocCMD.cfg.save(setlocCMD.file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCfg(final String path, final Object value) {
        setlocCMD.cfg.set(path, value);
        this.saveCfg();
    }

    static {
        setlocCMD.file = new File("plugins/LobbySystemV4/Locations.yml");
        setlocCMD.cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(setlocCMD.file);
    }
}
