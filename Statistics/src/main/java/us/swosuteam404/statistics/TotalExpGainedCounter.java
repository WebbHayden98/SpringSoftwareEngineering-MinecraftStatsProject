package us.swosuteam404.statistics;

import org.bukkit.event.player.PlayerExpChangeEvent;

public class TotalExpGainedCounter {
    private static int totalExp = 0;

    public static int getTotalExp() {
      return totalExp;
    }

    public static int incrementTotalExp(int intake) {
        int newAmount = intake;
        totalExp = totalExp + newAmount;

        System.out.println("New EXP total is: " + totalExp);
        return totalExp;
    }

    public static void ExpGained(PlayerExpChangeEvent event) {
        int newAmount = event.getAmount();
        TotalExpGainedCounter.incrementTotalExp(newAmount);

        System.out.println("ExpChangeEvent triggered");
    }
}
