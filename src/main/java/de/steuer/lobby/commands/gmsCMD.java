package de.steuer.lobby.commands;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.steuer.lobby.main.Main.prefix;

public class gmsCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        sender.sendMessage(prefix + "§7Du bist jetzt im GameMode: §b0§7!");
        player.sendTitle(prefix + "", "§7Du bist jetzt im GameMode: §b0");
        player.setGameMode(GameMode.SURVIVAL);
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10.0f, 10.0f);

        return false;
    }
}
