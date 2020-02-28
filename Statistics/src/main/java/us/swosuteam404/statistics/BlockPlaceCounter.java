package us.swosuteam404.statistics;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;

public class BlockPlaceCounter {
    private static int tally;
    private static Material blockName;

    static ArrayList<Material> blockPlaceNameArray = new ArrayList<>();
    static ArrayList<Integer> blockPlaceTallyArray = new ArrayList<>();

    public static void incrementPlaceTally(ArrayList name, int indexOfArray) {
        System.out.println(ChatColor.YELLOW + "Updating Array index");
        int oldTally = (int) name.get(indexOfArray);
        int newTally = oldTally + 1;

        blockPlaceTallyArray.set(indexOfArray, newTally);
        System.out.println(ChatColor.YELLOW + "Array index updated");
    }

    public static void placeDetector(BlockPlaceEvent event) {
        Block block = event.getBlock();
        Material blockType = block.getType();

        System.out.println(ChatColor.YELLOW + "Block Placed: " + blockType);
        //checks if block placed is in the ArrayList
        //Will either update the Arraylist if blocktype is located in it
        //Or will add a new material and tally to their respective ArrayLists.
        if (blockPlaceNameArray.contains(blockType)) {
            System.out.println(ChatColor.YELLOW + "Found in Array");
            //SysOut is for Debug
            int index = blockPlaceNameArray.indexOf(blockType);
            BlockPlaceCounter.incrementPlaceTally(blockPlaceTallyArray, index);
        } else {
            System.out.println("Not found in Array");
            blockPlaceNameArray.add(blockType);

            int index = blockPlaceNameArray.indexOf(blockType);
            blockPlaceTallyArray.add(index, 1);
            System.out.println(ChatColor.YELLOW + "Added to the Array");
        }
    }
}