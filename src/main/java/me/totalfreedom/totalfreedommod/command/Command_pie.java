package me.totalfreedom.totalfreedommod.command;

import java.util.Random;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.Achievement;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "For the people that are still alive.", usage = "/<command>")
public class Command_pie extends FreedomCommand {

    public static final String PIE_LYRICS = "PIES FOR ALL!";

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {

        StringBuilder output = new StringBuilder();
        Random randomGenerator = new Random();

        String[] words = PIE_LYRICS.split(" ");
        for (String word : words) {
            String color_code = Integer.toHexString(1 + randomGenerator.nextInt(14));
            output.append(ChatColor.COLOR_CHAR).append(color_code).append(word).append(" ");
        }

        ItemStack heldItem = new ItemStack(Material.PUMPKIN_PIE);

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.getInventory().setItem(player.getInventory().firstEmpty(), heldItem);
            player.awardAchievement(Achievement.MINE_WOOD);
            player.awardAchievement(Achievement.BUILD_WORKBENCH);
            player.awardAchievement(Achievement.BUILD_HOE);
            player.awardAchievement(Achievement.BAKE_CAKE);
        }

        FUtil.bcastMsg(output.toString());
        return true;
    }
}