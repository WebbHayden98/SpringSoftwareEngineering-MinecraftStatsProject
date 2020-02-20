package us.swosuteam404.statistics;

import org.bukkit.ChatColor;
import org.bukkit.block.data.type.TNT;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;

import static org.bukkit.Bukkit.*;

public class DeathCounter implements Listener {

    //total deaths should NOT be higher than mob and non-mob related deaths when added together.
    //total deaths might be less than deaths from mob and non-mob related deaths due to shared damagers
    public static int totalPlayerDeaths = 0;
    //mob related death data recorded below
    public static int deathToRangedPVP = 0;
    public static int deathToPVP = 0;
    public static int deathToCreeper = 0;
    public static int deathToZombie = 0;
    public static int deathToSkeleton = 0;
    public static int deathToWitherSkeleton = 0;
    public static int deathToSpider = 0;
    public static int deathToCaveSpider = 0;
    public static int deathToWitch = 0;
    public static int deathToEnderman = 0;
    public static int deathToZombieVillager = 0;
    public static int deathToZombiePigman = 0;
    public static int deathToWolf;
    public static int deathToDolphin;
    public static int deathToHusk;
    public static int deathToSilverFish;
    public static int deathToSlime;
    public static int deathToMagmaCube;
    public static int deathToRavager;
    public static int deathToVindicator;
    public static int deathToPillagerMelee;
    public static int deathToPhantom;
    public static int deathToIronGolem;
    public static int deathToPolarBear;
    public static int deathToPanda;
    public static int deathToBee;
    public static int deathToPufferFish;
    public static int deathToEndermite;
    public static int deathToVex;
    public static int deathToWitherExplosion;
    public static int deathToEnderDragonMelee;
    public static int deathToGuardianMelee;
    public static int deathToElderGuardianMelee;
    public static int deathToDrownedMelee;
    public static int deathToPillagerRanged;
    public static int deathToRangedWither;
    public static int deathToRangedEnderDragon;
    public static int deathToRangedGuardian;
    public static int deathToRangedElderGuardian;
    public static int deathToLlama;
    public static int deathToShulker;
    public static int deathToEvoker;
    public static int deathToEvokerFangs;
    public static int deathToGhast;
    public static int deathToBlaze;
    public static int deathToDrownedRanged;
    public static int deathToStray;
    //ints for mostly non-mob related deaths
    public static int deathToDrowning;
    public static int deathToCramming;
    public static int deathToTNT;
    public static int deathToCactus;
    public static int deathToFalling;
    public static int deathToLava;
    public static int deathToFallingBlock;
    public static int deathToFireContact;
    public static int deathToBurns;
    public static int deathToMagmaBlock;
    public static int deathToHittingWall;
    public static int deathToLightning;
    public static int deathToMagic;
    public static int deathToPoison;
    public static int deathToProjectile;
    public static int deathToStarvation;
    public static int deathToSuffocation;
    public static int deathToSuicide;
    public static int deathToThorns;
    public static int deathToVoid;
    public static int deathToWithering;
    //the array all int data will be packed into for export
    public static int[] arrayOfPlayerDeathCounts;

    public static String[] arrayOfPlayerDeathLabels = {"Total Deaths", "PVP", "Ranged PVP", "Creeper",
            "Zombie", "Skeleton", "Wither Skeleton", "Spider", "Cave Spider", "Witch",
            "Enderman", "Zombie Villager", "Zombie Pigman", "Wolf", "Dolphin", "Husk", "Silverfish", "Slime", "Magma Cube", "Ravager", "Vindicator",
            "Pillager Melee", "Phantom", "Iron Golem", "Polar Bear", "Panda", "Bee", "PufferFish", "Endermite", "Vex", "Wither Explosion", "Ender Dragon Melee",
            "Guardian Melee", "Elder Guardian Melee", "Drowned Melee", "Pillager", "Ranged Wither", "Ranged Ender Dragon", "Ranged Guardian", "Ranged Elder Guardian",
            "Llama", "Shulker", "Evoker", "Evoker Fangs", "Ghast", "Blaze", "Ranged Drowned", "Stray", "Drowning", "Cramming", "TNT", "Cactus", "Falling",
            "Lava", "Falling Blocks", "Fire Contact", "Burns", "Magma Block", "Flying into walls", "Lightning", "Magic", "Poison", "Trap Projectile", "Starvation",
            "Suffocation", "Suicide", "Thorns", "Void", "Withering"
    };

    public static int[] buildDeathCounterArray() {
        arrayOfPlayerDeathCounts = new int[]{totalPlayerDeaths, deathToPVP, deathToRangedPVP, deathToCreeper,
                deathToZombie, deathToSkeleton, deathToWitherSkeleton, deathToSpider, deathToCaveSpider, deathToWitch,
                deathToEnderman, deathToZombieVillager, deathToZombiePigman, deathToWolf, deathToDolphin, deathToHusk,
                deathToSilverFish, deathToSlime, deathToMagmaCube, deathToRavager, deathToVindicator, deathToPillagerMelee,
                deathToPhantom, deathToIronGolem, deathToPolarBear, deathToPanda, deathToBee, deathToPufferFish,
                deathToEndermite, deathToVex, deathToWitherExplosion, deathToEnderDragonMelee, deathToGuardianMelee,
                deathToEnderDragonMelee, deathToDrownedMelee, deathToPillagerRanged, deathToRangedWither, deathToRangedEnderDragon,
                deathToRangedEnderDragon, deathToRangedElderGuardian, deathToLlama, deathToShulker, deathToEvoker, deathToEvokerFangs,
                deathToGhast, deathToBlaze, deathToDrownedRanged, deathToStray, deathToDrowning, deathToCramming, deathToTNT,
                deathToCactus, deathToFalling, deathToLava, deathToFallingBlock, deathToFireContact, deathToBurns, deathToMagmaBlock,
                deathToHittingWall, deathToLightning, deathToMagic, deathToPoison, deathToProjectile, deathToStarvation,
                deathToSuffocation, deathToSuicide, deathToThorns, deathToVoid, deathToWithering
        };
        return arrayOfPlayerDeathCounts;
    }

    /*
        public static int[] getArrayOfPlayerDeaths() {
            return arrayOfPlayerDeathCounts.clone();
        }
    */
    @EventHandler
    public static void deathDetector(PlayerDeathEvent event) {
        //code will launch on player death
        Player player = event.getEntity();
        Player killer = player.getKiller();
        EntityDamageEvent.DamageCause causeOfDeath = event.getEntity().getLastDamageCause().getCause();

        //Message will post in in-game chat
        getServer().broadcastMessage(ChatColor.YELLOW + "There has been a death.");
        totalPlayerDeaths += 1;
        getServer().broadcastMessage(ChatColor.YELLOW + "The number of total player deaths is now: " + totalPlayerDeaths);
        //will check if death was caused by a player. If not, checks if death was caused by ranged PVP or mob.
        if (killer instanceof Player) {
            getServer().broadcastMessage("There has been a PVP murder!");
            deathToPVP += 1;
        } else if (player.getLastDamageCause() instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent entityThatDamaged = (EntityDamageByEntityEvent) player.getLastDamageCause();

            //Checks to see if kill comes from a Projectile first
            if (entityThatDamaged.getDamager() instanceof Projectile) {
                Projectile projectile = (Projectile) entityThatDamaged.getDamager();
                if (projectile.getShooter() instanceof Player) {
                    deathToRangedPVP += 1;
                    getServer().broadcastMessage("A Player Projectile has killed you");
                    deathToPVP += 1;
                } else if (projectile.getShooter() instanceof Skeleton) {
                    getServer().broadcastMessage("A Skeleton has killed you");
                    deathToSkeleton += 1;
                    if (projectile.getShooter() instanceof Stray) {
                        getServer().broadcastMessage("Wait, that was a Stray");
                        deathToSkeleton -= 1;
                        deathToStray += 1;
                    }
                } else if (projectile.getShooter() instanceof WitherSkeleton) {
                    getServer().broadcastMessage("A Wither Skeleton has killed you");
                    deathToWitherSkeleton += 1;
                } else if (projectile.getShooter() instanceof Witch) {
                    getServer().broadcastMessage("A Witch has killed you");
                    deathToWitch += 1;
                } else if (projectile.getShooter() instanceof Pillager) {
                    getServer().broadcastMessage("Ranged Pillager");
                    deathToPillagerRanged += 1;
                } else if (projectile.getShooter() instanceof Wither) {
                    getServer().broadcastMessage("Ranged Wither");
                    deathToRangedWither += 1;
                } else if (projectile.getShooter() instanceof EnderDragon) {
                    getServer().broadcastMessage("Ranged EnderDragon");
                    deathToRangedEnderDragon += 1;
                }  else if (projectile.getShooter() instanceof Guardian) {
                    getServer().broadcastMessage("Ranged Guardian");
                    deathToRangedGuardian += 1;
                    if (projectile.getShooter() instanceof ElderGuardian) {
                        getServer().broadcastMessage("Ranged Elder Guardian");
                        deathToRangedGuardian -= 1;
                        deathToRangedElderGuardian += 1;
                    }
                } else if (projectile.getShooter() instanceof LlamaSpit) {
                    getServer().broadcastMessage("Spat to death");
                    deathToLlama += 1;
                } else if (projectile.getShooter() instanceof Shulker) {
                    getServer().broadcastMessage("Death by Shulker");
                    deathToShulker += 1;
                } else if (projectile.getShooter() instanceof Evoker) {
                    getServer().broadcastMessage("Death by Evoker");
                    deathToEvoker += 1;
                } else if (projectile.getShooter() instanceof EvokerFangs) {
                    getServer().broadcastMessage("Death by Evoker Fangs");
                    deathToEvokerFangs += 1;
                } else if (projectile.getShooter() instanceof Ghast) {
                    getServer().broadcastMessage("Death by Ghast");
                    deathToGhast += 1;
                } else if (projectile.getShooter() instanceof Blaze) {
                    getServer().broadcastMessage("Death to Blaze");
                    deathToBlaze += 1;
                } else if (projectile.getShooter() instanceof Drowned) {
                    getServer().broadcastMessage("Death to Drowned Trident");
                    deathToDrownedRanged += 1;
                } else if (projectile.getShooter() instanceof Stray) {
                    getServer().broadcastMessage("Death to Stray");
                    deathToStray += 1;
                } else {
                    getServer().broadcastMessage(ChatColor.RED + "ALERT!! Something failed");
                    getServer().broadcastMessage(ChatColor.RED + "The Ranged Entity was: " + projectile.getShooter());
                }
            } else if (entityThatDamaged.getDamager() instanceof Creeper) {
                getServer().broadcastMessage("A Creeper has killed you");
                deathToCreeper += 1;
            } else if (entityThatDamaged.getDamager() instanceof Zombie) {
                getServer().broadcastMessage("A Zombie has killed you");
                deathToZombie += 1;
                if (entityThatDamaged.getDamager() instanceof Drowned) {
                    getServer().broadcastMessage("Death to Drowned Melee");
                    deathToZombie -= 1;
                    deathToDrownedMelee += 1;
                } else if (entityThatDamaged.getDamager() instanceof Husk) {
                    getServer().broadcastMessage("Death to Husk");
                    deathToZombie -=1;
                    deathToHusk += 1;
                } else if (entityThatDamaged.getDamager() instanceof ZombieVillager) {
                    getServer().broadcastMessage("Death To Zombie Villager 2");
                    deathToZombie -= 1;
                    deathToZombieVillager += 1;
                } else if (entityThatDamaged.getDamager() instanceof PigZombie) {
                    deathToZombie -= 1;
                    deathToZombiePigman += 1;
                }
            } else if (entityThatDamaged.getDamager() instanceof Spider) {
                getServer().broadcastMessage("A Spider has killed you");
                deathToSpider += 1;
            } else if (entityThatDamaged.getDamager() instanceof CaveSpider) {
                getServer().broadcastMessage("A Cave Spider has killed you");
                deathToCaveSpider += 1;
            } else if (entityThatDamaged.getDamager() instanceof Enderman) {
                getServer().broadcastMessage("An Enderman has killed you");
                deathToEnderman += 1;
            } else if (entityThatDamaged.getDamager() instanceof ZombieVillager) {
                getServer().broadcastMessage("A Zombie Villager has killed you");
                deathToZombieVillager += 1;
            } else if (entityThatDamaged.getDamager() instanceof PigZombie) {
                getServer().broadcastMessage("A Zombie Pigman has killed you");
                deathToZombiePigman += 1;
            } else if (entityThatDamaged.getDamager() instanceof Wolf) {
                getServer().broadcastMessage("Animal Abuse Karma");
                deathToWolf += 1;
            } else if (entityThatDamaged.getDamager() instanceof Dolphin) {
                getServer().broadcastMessage("A Dolphin has killed you");
                deathToDolphin += 1;
            } else if (entityThatDamaged.getDamager() instanceof Husk) {
                getServer().broadcastMessage("A Husk has killed you");
                deathToHusk += 1;
            } else if (entityThatDamaged.getDamager() instanceof Silverfish) {
                getServer().broadcastMessage("Silverfishy");
                deathToSilverFish += 1;
            } else if (entityThatDamaged.getDamager() instanceof Slime) {
                getServer().broadcastMessage("Slimey Demise");
                deathToSlime += 1;
            } else if (entityThatDamaged.getDamager() instanceof MagmaCube) {
                getServer().broadcastMessage("Death by Magma Cube");
                deathToMagmaCube += 1;
            } else if (entityThatDamaged.getDamager() instanceof Ravager) {
                getServer().broadcastMessage("You have been Ravaged");
                deathToRavager += 1;
            } else if (entityThatDamaged.getDamager() instanceof Vindicator) {
                getServer().broadcastMessage("Death by Vindicator");
                deathToVindicator += 1;
            } else if (entityThatDamaged.getDamager() instanceof Pillager) {
                getServer().broadcastMessage("You got Pillaged");
                deathToPillagerMelee += 1;
            } else if (entityThatDamaged.getDamager() instanceof Phantom) {
                getServer().broadcastMessage("Danny Phantom anyone?");
                deathToPhantom += 1;
            } else if (entityThatDamaged.getDamager() instanceof IronGolem) {
                getServer().broadcastMessage("Iron Golem Smash!");
                deathToIronGolem += 1;
            } else if (entityThatDamaged.getDamager() instanceof PolarBear) {
                getServer().broadcastMessage("Global Warming Karma");
                deathToPolarBear += 1;
            } else if (entityThatDamaged.getDamager() instanceof Panda) {
                getServer().broadcastMessage("Panda Expressed to the Nether");
                deathToPanda += 1;
            } else if (entityThatDamaged.getDamager() instanceof Bee) {
                getServer().broadcastMessage("NOT THE BEE'S!");
                deathToBee += 1;
            } else if (entityThatDamaged.getDamager() instanceof PufferFish) {
                getServer().broadcastMessage("Death by PufferFish");
                deathToPufferFish += 1;
            } else if (entityThatDamaged.getDamager() instanceof Endermite) {
                getServer().broadcastMessage("Death by Endermite");
                deathToEndermite += 1;
            } else if (entityThatDamaged.getDamager() instanceof Vex) {
                getServer().broadcastMessage("Death by Vex");
                deathToVex += 1;
            } else if (entityThatDamaged.getDamager() instanceof Wither) {
                getServer().broadcastMessage("Death to Wither Explosion?");
                deathToWitherExplosion += 1;
            } else if (entityThatDamaged.getDamager() instanceof EnderDragon) {
                getServer().broadcastMessage("Fistfought a Dragon");
                deathToEnderDragonMelee += 1;
            } else if (entityThatDamaged.getDamager() instanceof Guardian) {
                getServer().broadcastMessage("Death by Guardian");
                deathToGuardianMelee += 1;
                if (entityThatDamaged.getDamager() instanceof ElderGuardian) {
                    getServer().broadcastMessage("Death by Elder Guardian");
                    deathToElderGuardianMelee += 1;
                }
            } else if (entityThatDamaged.getDamager() instanceof WitherSkeleton) {
                getServer().broadcastMessage("Death to Wither Skeleton");
                deathToWitherSkeleton += 1;
            } else if (entityThatDamaged.getDamager() instanceof Blaze) {
                getServer().broadcastMessage("Death to Blaze");
                deathToBlaze += 1;
            } else if (entityThatDamaged.getDamager() instanceof Ghast) {
                deathToGhast += 1;
            } else if (entityThatDamaged.getDamager() instanceof Evoker) {
                deathToEvoker += 1;
            } else if (entityThatDamaged.getDamager() instanceof EvokerFangs) {
                deathToEvokerFangs += 1;
            } else  if (entityThatDamaged.getDamager() instanceof TNT || entityThatDamaged.getDamager() instanceof TNTPrimed) {
                deathToTNT += 1;
            } else {
                    getServer().broadcastMessage(ChatColor.RED + "ALERT!! Something failed");
                    getServer().broadcastMessage(ChatColor.RED + "The Entity Was: " + entityThatDamaged.getDamager());

            }
        } else if (player.getLastDamageCause() instanceof EntityDamageEvent) {

            if (causeOfDeath == DamageCause.DROWNING) {
                getServer().broadcastMessage("Drowned to death");
                deathToDrowning += 1;
            } else if (causeOfDeath == DamageCause.CRAMMING) {
                getServer().broadcastMessage("Cramming");
                deathToCramming += 1;
            } else if (causeOfDeath == DamageCause.BLOCK_EXPLOSION) {
                getServer().broadcastMessage("Death to TNT");
                deathToTNT += 1;
            } else if (causeOfDeath == DamageCause.CONTACT) {
                getServer().broadcastMessage("Death by Cactus");
                deathToCactus += 1;
            } else if (causeOfDeath == DamageCause.FALL) {
                getServer().broadcastMessage("Death by falling");
                deathToFalling += 1;
            } else if (causeOfDeath == DamageCause.LAVA) {
                getServer().broadcastMessage("Death by Lava");
                deathToLava += 1;
            } else if (causeOfDeath == DamageCause.FALLING_BLOCK) {
                getServer().broadcastMessage("Died to falling block");
                deathToFallingBlock += 1;
            } else if (causeOfDeath == DamageCause.FIRE) {
                getServer().broadcastMessage("Death to fire contact");
                deathToFireContact += 1;
            } else if (causeOfDeath == DamageCause.FIRE_TICK) {
                getServer().broadcastMessage("Death due to burns");
                deathToBurns += 1;
            } else if (causeOfDeath == DamageCause.HOT_FLOOR) {
                getServer().broadcastMessage("Death to Magma Block");
                deathToMagmaBlock += 1;
            } else if (causeOfDeath == DamageCause.FLY_INTO_WALL) {
                getServer().broadcastMessage("Death to Wall Impact");
                deathToHittingWall += 1;
            } else if (causeOfDeath == DamageCause.LIGHTNING) {
                getServer().broadcastMessage("Death by Zues");
                deathToLightning += 1;
            } else if (causeOfDeath == DamageCause.MAGIC) {
                getServer().broadcastMessage("Death to Magic! (Potion or Spell");
                deathToMagic += 1;
            } else if (causeOfDeath == DamageCause.POISON) {
                getServer().broadcastMessage("Death to Poison (lasting effect)");
                deathToPoison += 1;
            } else if (causeOfDeath == DamageCause.PROJECTILE) {
                getServer().broadcastMessage("Death to Projectile (Trap?)");
                deathToProjectile += 1;
            } else if (causeOfDeath == DamageCause.STARVATION) {
                getServer().broadcastMessage("Death to Starvation");
                deathToStarvation += 1;
            } else if (causeOfDeath == DamageCause.SUFFOCATION) {
                getServer().broadcastMessage("Died of Suffocation (in a block)");
                deathToSuffocation += 1;
            } else if (causeOfDeath == DamageCause.SUICIDE) {
                getServer().broadcastMessage("Used /kill");
                deathToSuicide += 1;
            } else if (causeOfDeath == DamageCause.THORNS) {
                getServer().broadcastMessage("Death to 'Thorn' enchantment");
                deathToThorns += 1;
            } else if (causeOfDeath == DamageCause.VOID) {
                getServer().broadcastMessage("Died to the Void");
                deathToVoid += 1;
            } else if (causeOfDeath == DamageCause.WITHER) {
                getServer().broadcastMessage("Death to Withering");
                deathToWithering += 1;
            } else {
                getServer().broadcastMessage(ChatColor.RED + "How did you die?");
                getServer().broadcastMessage(ChatColor.RED + " " + causeOfDeath);
            }
        }
    }
}
