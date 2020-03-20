package us.swosuteam404.statistics;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Statistics extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Statistics Plugin Loaded");
        getServer().getPluginManager().registerEvents(this, this);
        //Custom command to allow exportation of collected data
        //Custom command can only be implemented by a player at this time.
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
        DeathCounter.deathDetector(event);
    }
    //This will trigger when a block is broken and ball BlockBreakCounter.breakDetector();
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        BlockBreakCounter.breakDetector(event);
    }
    //This will trigger when a block is placed and will call BlockPlaceCounter.placeDetector();
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        BlockPlaceCounter.placeDetector(event);
    }
    //This will trigger when an item breaks and will call BrokenItemCounter.brokeItem();
    @EventHandler
    public void onBreakItem(PlayerItemBreakEvent event) {BrokenItemCounter.brokeItem(event);}
    @EventHandler
    public void onCraftItem(CraftItemEvent event) {CraftItemCounter.craftItem(event);}
    @EventHandler
    public void onExpChangeEvent(PlayerExpChangeEvent event) {TotalExpGainedCounter.ExpGained(event);}
}
