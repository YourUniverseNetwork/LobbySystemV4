package de.steuer.lobby.listener;

import de.steuer.lobby.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
public class Lag
        implements Runnable, Listener {
    public static int TICK_COUNT= 0;
    public static long[] TICKS= new long[600];
    public static long LAST_TICK= 0L;

    public static double getTPS()
    {
        return getTPS(100);
    }

    public static double getTPS(int ticks)
    {
        if (TICK_COUNT< ticks) {
            return 20.0D;
        }
        int target = (TICK_COUNT- 1 - ticks) % TICKS.length;
        long elapsed = System.currentTimeMillis() - TICKS[target];

        return ticks / (elapsed / 1000.0D);
    }

    public static long getElapsed(int tickID)
    {
        if (TICK_COUNT- tickID >= TICKS.length)
        {
        }

        long time = TICKS[(tickID % TICKS.length)];
        return System.currentTimeMillis() - time;
    }

    public void run()
    {
        TICKS[(TICK_COUNT% TICKS.length)] = System.currentTimeMillis();

        TICK_COUNT+= 1;
    }
}