package us.swosuteam404.statistics;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.ArrayList;

public class BlockBreakCounter {
    private static int tally;
    private static Material blockName;

    static ArrayList<Material> blockBreakNameArray = new ArrayList<>();
    static ArrayList<Integer> blockBreakTallyArray = new ArrayList<>();

    public static void incrementBreakTally(ArrayList name, int indexOfArray) {
        System.out.println(ChatColor.YELLOW + "Updating Array index");
        int oldTally = (int) name.get(indexOfArray);
        int newTally = oldTally + 1;

        blockBreakTallyArray.set(indexOfArray, newTally);
        System.out.println(ChatColor.YELLOW + "Array index updated");
    }

    public static void breakDetector(BlockBreakEvent event) {
        Block block = event.getBlock();
        Material blockType = block.getType();

        System.out.println(ChatColor.YELLOW + "Block Broken: " + blockType);

        if (blockBreakNameArray.contains(blockType)) {
            System.out.println(ChatColor.YELLOW + "Found in Array");

            int index = blockBreakNameArray.indexOf(blockType);

            BlockBreakCounter.incrementBreakTally(blockBreakTallyArray, index);
        } else {
            System.out.println("Not found in Array");
            blockBreakNameArray.add(blockType);

            int index = blockBreakNameArray.indexOf(blockType);
            blockBreakTallyArray.add(index, 1);
            System.out.println(ChatColor.YELLOW + "Added to the Array");
        }
    }
}
