package us.swosuteam404.statistics;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class BrokenItemCounter {
    private String itemName;
    private int itemTally;

    static ArrayList<String> itemBreakNameArray = new ArrayList<>();
    static ArrayList<Integer> itemBreakTallyArray = new ArrayList<>();

    public static void incrementBreakTally(ArrayList name, int indexOfArray) {
        System.out.println(ChatColor.YELLOW + "Updating Item Array index");
        int oldTally = (int) name.get(indexOfArray);
        int newTally = oldTally + 1;

        itemBreakTallyArray.set(indexOfArray, newTally);
        System.out.println(ChatColor.YELLOW + "Array index updated");
    }

    public static void brokeItem(PlayerItemBreakEvent event) {
        String brokeItem = event.getBrokenItem().getType().toString();

        System.out.println(ChatColor.YELLOW + "Item Broken: " + brokeItem);

        if (itemBreakNameArray.contains(brokeItem)) {
            System.out.println(ChatColor.YELLOW + "Found in Array");

            int index = itemBreakNameArray.indexOf(brokeItem);

            BrokenItemCounter.incrementBreakTally(itemBreakTallyArray, index);
        } else {
            System.out.println("Not found in Array");
            itemBreakNameArray.add(brokeItem);

            int index = itemBreakNameArray.indexOf(brokeItem);
            itemBreakTallyArray.add(index, 1);
            System.out.println(ChatColor.YELLOW + "Added to the Array");
        }
    }
}
