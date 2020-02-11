package us.swosuteam404.statistics;

import org.bukkit.ChatColor;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.projectiles.ProjectileSource;

import static org.bukkit.Bukkit.*;

public class DeathCounter implements Listener{
    public static int playerDeaths = 0;
    public static int playerPVPDeath = 0;
    public static int creeperKill = 0;
    public static int zombieKill = 0;
    public static int skeletonKill = 0;
    public static int spiderKill = 0;
    public static int caveSpiderKill = 0;
    public static int witherSkeletonKill = 0;
    public static int witchKill = 0;

    public static int getPlayerDeaths() { return playerDeaths; }


    public static int getPlayerPVPDeath() { return playerPVPDeath; }
    public static int getCreeperKill() { return creeperKill; }
    public static int getZombieKill() { return zombieKill; }
    public static int getSkeletonKill() { return skeletonKill; }
    public static int getSpiderKill() { return spiderKill; }
    public static int getCaveSpiderKill() { return caveSpiderKill; }
    public static int getWitherSkeletonKill() {return witherSkeletonKill;}
    public static int getWitchKill() {return witchKill;}

    @EventHandler
    public static void deathCounter(PlayerDeathEvent event) {
        //code will launch on player death
        Player player = event.getEntity();
        Player killer = player.getKiller();

        //Message will post in in-game chat
        getServer().broadcastMessage(ChatColor.YELLOW + "There has been a death.");
        playerDeaths += 1;
        getServer().broadcastMessage(ChatColor.YELLOW + "The number of total player deaths is now: " + playerDeaths);


        if(killer instanceof Player) {
            playerPVPDeath += 1;
        } else if (player.getLastDamageCause() instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent entityThatDamaged = (EntityDamageByEntityEvent) player.getLastDamageCause();

            getServer().broadcastMessage("The Entity was: " + entityThatDamaged.getDamager());
            //Checks to see if kill comes from a Projectile first
            if (entityThatDamaged.getDamager() instanceof Projectile) {
                Projectile projectile = (Projectile) entityThatDamaged.getDamager();
                if(projectile.getShooter() instanceof Player) {
                    playerPVPDeath += 1;
                } else if (projectile.getShooter() instanceof Skeleton) {
                    getServer().broadcastMessage("A Skeleton has killed you");
                    skeletonKill += 1;
                } else if (projectile.getShooter() instanceof WitherSkeleton) {
                    getServer().broadcastMessage("A Wither Skeleton has killed you");
                    witherSkeletonKill += 1;
                } else if (projectile.getShooter() instanceof Witch) {
                    getServer().broadcastMessage("A Witch has killed you");
                    witchKill += 1;
                } else {
                    getServer().broadcastMessage("The Ranged Entity was: " + projectile.getShooter());
                }
            } else if(entityThatDamaged.getDamager() instanceof Creeper) {
                getServer().broadcastMessage("A Creeper has killed you");
                creeperKill += 1;
            } else if (entityThatDamaged.getDamager() instanceof Zombie) {
                getServer().broadcastMessage("A Zombie has killed you");
                zombieKill += 1;
            } else if (entityThatDamaged.getDamager() instanceof Spider) {
                getServer().broadcastMessage("A Spider has killed you");
                spiderKill += 1;
            } else if (entityThatDamaged.getDamager() instanceof CaveSpider) {
                getServer().broadcastMessage("A Cave Spider has killed you");
                caveSpiderKill += 1;
            } else {
                getServer().broadcastMessage("An entity has killed you");
                getServer().broadcastMessage("The Entity Was: " + entityThatDamaged.getDamager());
            }

        }
    }

}
