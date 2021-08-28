package de.steuer.lobby.commands;

import de.steuer.lobby.main.Main;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import java.io.*;
import org.bukkit.configuration.file.*;

public class heightCMD implements CommandExecutor
{
    public static File file;
    public static FileConfiguration cfg;

    public boolean onCommand(final CommandSender cs, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("setheight")) {
            if (!(cs instanceof Player)) {
                cs.sendMessage(Main.noCS);
            }
            else {
                final Player p = (Player)cs;
                if (p.hasPermission("Lobby.setheight")) {
                    if (args.length != 0) {
                        p.sendMessage(Main.prefix + "§cNutze: /setheight");
                    }
                    else {
                        this.setCfg("Height", p.getLocation().getY());
                        p.sendMessage(Main.prefix + "§7Du hast die §aH\u00f6he §7gesetzt");
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
            heightCMD.cfg.save(heightCMD.file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCfg(final String path, final Object value) {
        heightCMD.cfg.set(path, value);
        this.saveCfg();
    }

    static {
        heightCMD.file = new File("plugins/LobbySystemV4/Height.yml");
        heightCMD.cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(heightCMD.file);
    }
}
