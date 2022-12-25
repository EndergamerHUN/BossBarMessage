package io.github.endergamerhun.bossbarmessage.utils;

import io.github.endergamerhun.bossbarmessage.BossBarMessage;
import org.bukkit.Bukkit;

public class Util {

    public static BossBarMessage getInstance() {
        return BossBarMessage.getInstance();
    }
    public static void log(String format, Object... objects) {
        String log = String.format(format, objects);
        Bukkit.getConsoleSender().sendMessage(log);
    }
}
