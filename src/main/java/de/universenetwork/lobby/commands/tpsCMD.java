package de.universenetwork.lobby.commands;

import de.universenetwork.lobby.listener.Lag;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tpsCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        double tps = Lag.getTPS();
        double lag = Math.round((1.0D - tps / 100.0D) * 100.0D);

        player.sendTitle("§a§l" + tps + "", "§aServer TPS");
        player.playSound(player.getLocation(), Sound.BLOCK_WOODEN_BUTTON_CLICK_ON, 10.0f, 10.0f);

        return false;
    }
}
