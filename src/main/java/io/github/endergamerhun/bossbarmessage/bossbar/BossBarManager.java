package io.github.endergamerhun.bossbarmessage.bossbar;

import io.github.endergamerhun.bossbarmessage.BossBarMessage;
import io.github.endergamerhun.bossbarmessage.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.entity.Player;

public class BossBarManager {

    public static void message(String message, int ticks) {
        message(message, ticks, null);
    }
    public static void message(String message, int ticks, Iterable<? extends Player> recipients) {
        message(message, ticks, recipients, BarColor.RED, BarStyle.SOLID);
    }
    public static void message(String message, int ticks, BarColor color, BarStyle style) {
        message(message, ticks, null, color, style);
    }
    public static void message(String message, int ticks, Iterable<? extends Player> recipients, BarColor color, BarStyle style) {
        KeyedBossBar bar = createBossBar(message, color, style);
        new TimedBossBar(bar, ticks*50L, recipients);
    }

    public static KeyedBossBar createBossBar(String title, BarColor color, BarStyle style) {
        BossBarMessage plugin = Util.getInstance();
        NamespacedKey key;
        KeyedBossBar bar;
        int i = 0;
        do {
            i++;
            key = new NamespacedKey(plugin, "message" + i);
            bar = Bukkit.getBossBar(key);
        } while (bar != null);
        bar = Bukkit.createBossBar(key, title, color, style);
        bar.setVisible(false);
        return bar;
    }
}
