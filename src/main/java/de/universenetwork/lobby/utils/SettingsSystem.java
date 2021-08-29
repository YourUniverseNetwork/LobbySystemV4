package de.universenetwork.lobby.utils;

import java.sql.*;

public class SettingsSystem
{
    public static void createTable() {
        try {
            final PreparedStatement ps = MySQL.getStatement("CREATE TABLE IF NOT EXISTS Settings (UUID VARCHAR(100), SETTING VARCHAR(100))");
            ps.executeUpdate();
            ps.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addSetting(final String uuid, final String setting) {
        try {
            final PreparedStatement ps = MySQL.getStatement("INSERT INTO Settings (UUID, SETTING) VALUES ('" + uuid + "', '" + setting + "')");
            ps.executeUpdate();
            ps.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void removeSetting(final String uuid) {
        try {
            final PreparedStatement ps = MySQL.getStatement("DELETE FROM Settings WHERE UUID='" + uuid + "'");
            ps.executeUpdate();
            ps.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean haveSetting(final String uuid, final String setting) {
        final ResultSet rs = MySQL.getResult("SELECT * FROM Settings WHERE UUID='" + uuid + "' AND SETTING='" + setting + "'");
        try {
            final boolean next = rs.next();
            rs.close();
            return next;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
