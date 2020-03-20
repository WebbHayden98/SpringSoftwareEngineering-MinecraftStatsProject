package us.swosuteam404.statistics;

import org.bukkit.ChatColor;
import org.bukkit.event.inventory.CraftItemEvent;

import java.util.ArrayList;

public class CraftItemCounter {
    private String itemName;
    private int itemTally;

    static ArrayList<String> itemCraftNameArray = new ArrayList<String>();
    static ArrayList<Integer> itemCraftTallyArray = new ArrayList<>();

    public static void incrementCraftTally(ArrayList name, int indexOfArray) {
        System.out.println(ChatColor.YELLOW + "Updating Item Array index");
        int oldTally = (int) name.get(indexOfArray);
        int newTally = oldTally + 1;

        itemCraftTallyArray.set(indexOfArray, newTally);
        System.out.println(ChatColor.YELLOW + "Array index updated");
    }

    public static void craftItem(CraftItemEvent event) {
         String craftItem = event.getCurrentItem().getType().toString();

        System.out.println(ChatColor.YELLOW + "Item Crafted: " + craftItem);

        if (itemCraftNameArray.contains(craftItem)) {
            System.out.println(ChatColor.YELLOW + "Found in Array");

            int index = itemCraftNameArray.indexOf(craftItem);

            CraftItemCounter.incrementCraftTally(itemCraftTallyArray, index);
        } else {
            System.out.println("Not found in Array");
            itemCraftNameArray.add(craftItem);

            int index = itemCraftNameArray.indexOf(craftItem);
            itemCraftTallyArray.add(index, 1);
            System.out.println(ChatColor.YELLOW + "Added to the Array");
        }
    }
}
