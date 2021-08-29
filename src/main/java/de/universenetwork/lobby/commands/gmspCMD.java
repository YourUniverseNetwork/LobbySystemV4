package de.universenetwork.lobby.commands;

import de.universenetwork.lobby.main.Main;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gmspCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        sender.sendMessage(Main.prefix + "§7Du bist jetzt im GameMode: §b3§7!");
        player.sendTitle(Main.prefix + "", "§7Du bist jetzt im GameMode: §b3");
        player.setGameMode(GameMode.SPECTATOR);
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10.0f, 10.0f);

        return false;
    }
}
