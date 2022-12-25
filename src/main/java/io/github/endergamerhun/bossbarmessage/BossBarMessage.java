package io.github.endergamerhun.bossbarmessage;

import io.github.endergamerhun.bossbarmessage.bossbar.BossBarManager;
import io.github.endergamerhun.bossbarmessage.commands.CommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class BossBarMessage extends JavaPlugin {

    public static BossBarMessage INSTANCE;
    private final BossBarManager manager = new BossBarManager();
    public BossBarManager getMessageSender() {
        return manager;
    }
    public BossBarMessage() {
        INSTANCE = this;
    }

    @Override
    public void onEnable() {
        INSTANCE = this;
        getCommand("bbbroadcast").setExecutor(new CommandHandler());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
