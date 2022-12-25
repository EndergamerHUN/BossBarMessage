package io.github.endergamerhun.bossbarmessage.commands;

import io.github.endergamerhun.bossbarmessage.bossbar.BossBarManager;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandHandler implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 4) {
            sender.sendMessage("§cYou need to provide more arguments!");
            return true;
        }
        int length;
        BarColor color;
        BarStyle style;
        try {
            length = Integer.parseInt(args[0]);
        } catch (NumberFormatException ignored) {
            sender.sendMessage("§cThat is not a valid number!");
            return true;
        }
        try {
            color = BarColor.valueOf(args[1]);
        } catch (IllegalArgumentException ignored) {
            sender.sendMessage("§cThat is not a valid color!");
            return true;
        }
        try {
            style = BarStyle.valueOf(args[2]);
        } catch (IllegalArgumentException ignored) {
            sender.sendMessage("§cThat is not a valid style!");
            return true;
        }
        String message = String.join(" ", Arrays.copyOfRange(args, 3, args.length));
        BossBarManager.message(message, length*20, color, style);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> completions = new ArrayList<>();
        int arg = args.length;
        switch (arg) {
            case 1 -> completions.addAll(List.of("10","20","30","60"));
            case 2 -> completions.addAll(List.of("PINK","BLUE","RED","GREEN","YELLOW","PURPLE","WHITE"));
            case 3 -> completions.addAll(List.of("SOLID","SEGMENTED_6","SEGMENTED_10","SEGMENTED_12","SEGMENTED_20"));
            case 4 -> completions.add("Message");
        }
        return StringUtil.copyPartialMatches(args[arg-1], completions, new ArrayList<>());
    }
}
