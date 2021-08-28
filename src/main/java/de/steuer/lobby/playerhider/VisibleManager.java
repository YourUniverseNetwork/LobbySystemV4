package de.steuer.lobby.playerhider;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class VisibleManager {

    private ArrayList<Player> hider = new ArrayList<Player>();

    public ArrayList<Player> getHider() {
        return hider;
    }
}
