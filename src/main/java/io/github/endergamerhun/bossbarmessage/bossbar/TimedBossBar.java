package io.github.endergamerhun.bossbarmessage.bossbar;

import io.github.endergamerhun.bossbarmessage.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;

public class TimedBossBar extends BukkitRunnable {

    final long end;
    final long length;
    final KeyedBossBar bar;

    public TimedBossBar(KeyedBossBar bar, long length) {
        this(bar, length, null);
    }
    public TimedBossBar(KeyedBossBar bar, long length, Iterable<? extends Player> recipients) {
        bar.setVisible(true);
        if (recipients == null) recipients = Bukkit.getOnlinePlayers();
        recipients.forEach(bar::addPlayer);

        this.end = System.currentTimeMillis()+length;
        this.length = length;
        this.bar = bar;

        this.runTaskTimer(Util.getInstance(), 0, 1);
    }

    @Override
    public void run() {
        long now = System.currentTimeMillis();
        if (now > end) {
            bar.setVisible(false);
            Bukkit.removeBossBar(bar.getKey());
            this.cancel();
            return;
        }
        bar.setProgress((double) (end - now)/length);
    }
}
