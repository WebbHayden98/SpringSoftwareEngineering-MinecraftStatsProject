package us.swosuteam404.statistics;

import jdk.nashorn.internal.ir.Block;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import us.swosuteam404.statistics.DeathCounter;

public class CommandExportData implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            player.sendMessage(ChatColor.YELLOW + "Exporting the Data now");


            //FileWriter allows us to export data to a new file
            //Originally made by Nam Ha Minh @ www.codejava.net
            try {
                FileWriter writer = new FileWriter("StatisticsData.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                //TotalExpGainedCounter exporter
                bufferedWriter.write("Total Experience gained: " + TotalExpGainedCounter.getTotalExp() + "\n");
                //CraftItemCounter exporter
                bufferedWriter.write("Crafted Item Counts: \n");
                for (String index : CraftItemCounter.itemCraftNameArray) {
                    int arrayIndex = CraftItemCounter.itemCraftNameArray.indexOf(index);
                    bufferedWriter.write("The Number of " + index + " crafted " + CraftItemCounter.itemCraftTallyArray.get(arrayIndex) + "\n");
                }
                //BrokenItemCounter exporter
                bufferedWriter.write("Broken Item Counts: \n");
                for (String index : BrokenItemCounter.itemBreakNameArray) {
                    int arrayIndex = BrokenItemCounter.itemBreakNameArray.indexOf(index);
                    bufferedWriter.write("The number of " + index + " broken: " + BrokenItemCounter.itemBreakTallyArray.get(arrayIndex) + "\n");
                }
                //BlockBreakCounter exporter
                bufferedWriter.write("Broken Block Counts: \n");
                for (Material index : BlockBreakCounter.blockBreakNameArray) {
                    int arrayIndex = BlockBreakCounter.blockBreakNameArray.indexOf(index);
                    bufferedWriter.write("The number of " + index.toString() + " broken: " + BlockBreakCounter.blockBreakTallyArray.get(arrayIndex) + "\n");
                }
                //BlockPlaceCounter exporter
                bufferedWriter.write("Placed Block Counts: \n");
                for(Material index : BlockPlaceCounter.blockPlaceNameArray) {
                    int arrayIndex = BlockPlaceCounter.blockPlaceNameArray.indexOf(index);
                    bufferedWriter.write("The number of " + index.toString() + " placed: " + BlockPlaceCounter.blockPlaceTallyArray.get(arrayIndex) + "\n");
                }
                //DeathCounter exporter
                bufferedWriter.write("Player Death Counts: \n");
                //building an instance of DeathCounterArray to pull to here
                int[] deathArray = DeathCounter.buildDeathCounterArray();;
                //Begin writing top line of total number of deaths.
                bufferedWriter.write("The number of totals deaths: " + DeathCounter.totalPlayerDeaths + "\n");
                //writing all other deaths.
                int arrayOfPlayerDeathsLength = deathArray.length;
                for (int index = 1; index < arrayOfPlayerDeathsLength; index++) {
                    bufferedWriter.write("The number of totals deaths by " + DeathCounter.arrayOfPlayerDeathLabels[index] +
                            ": " + deathArray[index] + "\n");
                }
                //end writing
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
                player.sendMessage(ChatColor.RED + "Data Export Failure");
            }

            player.sendMessage(ChatColor.YELLOW + "Data Export complete");
        }

        return true;
    }
}
