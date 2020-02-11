package us.swosuteam404.statistics;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Statistics extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Statistics Plugin Loaded");
        getServer().getPluginManager().registerEvents(this, this);
        //Custom command to allow exportation of collected data
        this.getCommand("exportData").setExecutor(new CommandExportData());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Statistics Plugin Disengaged");
    }

    //this will trigger when a player dies and call .deathCounter() from DeathCounter.jar
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        DeathCounter.deathCounter(event);
    }


}
