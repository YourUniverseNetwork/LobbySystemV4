package de.steuer.lobby.utils;

import de.steuer.lobby.main.Main;
import org.bukkit.*;
import java.sql.*;

public class MySQL
{
    public static String username;
    public static String password;
    public static String database;
    public static String port;
    public static String host;
    public static Connection con;

    public static boolean isConnected() {
        return MySQL.con != null;
    }

    public static void connect() {
        if (isConnected()) {
            Bukkit.getConsoleSender().sendMessage("§aVerbinden...");
        }
        try {
            MySQL.con = DriverManager.getConnection("jdbc:mysql://" + MySQL.host + ":" + MySQL.port + "/" + MySQL.database + "?autoReconnect=true", MySQL.username, MySQL.password);
            Bukkit.getConsoleSender().sendMessage(Main.prefix + "§aDu hast die Verbindung zur MySQL Database aufgebaut!");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            MySQL.con.close();
            Bukkit.getConsoleSender().sendMessage(Main.prefix + "§cDu hast die Verbindung zur MySQL Database getrennt!");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static PreparedStatement getStatement(final String sql) {
        if (isConnected()) {
            try {
                final PreparedStatement ps = MySQL.con.prepareStatement(sql);
                return ps;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static ResultSet getResult(final String sql) {
        if (isConnected()) {
            try {
                final PreparedStatement ps = getStatement(sql);
                final ResultSet rs = ps.executeQuery();
                return rs;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    static {
        MySQL.username = Main.cfg.getString("MySQL.username");
        MySQL.password = Main.cfg.getString("MySQL.password");
        MySQL.database = Main.cfg.getString("MySQL.database");
        MySQL.port = Main.cfg.getString("MySQL.port");
        MySQL.host = Main.cfg.getString("MySQL.host");
    }
}
