package de.steuer.lobby.commands;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.steuer.lobby.main.Main.prefix;

public class gmcCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        player.getInventory().clear();
        sender.sendMessage(prefix + "§7Du bist jetzt im GameMode: §b1§7!");
        player.sendTitle(prefix + "", "§7Du bist jetzt im GameMode: §b1");
        player.setGameMode(GameMode.CREATIVE);
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10.0f, 10.0f);
        player.performCommand("build");

        return false;
    }
}
