package us.swosuteam404.statistics;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;


import static org.bukkit.Bukkit.getServer;

public class DeathCounter implements Listener{
    public static int playerDeaths = 0;

    public static int getPlayerDeaths() {
        return playerDeaths;
    }

    @EventHandler
    public static void deathCounter() {
        //code will launch on player death
        //Message will post in ingame chat
        getServer().broadcastMessage(ChatColor.YELLOW + "There has been a death.");
        playerDeaths += 1;
        getServer().broadcastMessage(ChatColor.YELLOW + "The number of total player deaths is now: " + playerDeaths);
    }
}
