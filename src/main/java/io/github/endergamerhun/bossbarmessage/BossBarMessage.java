package io.github.endergamerhun.bossbarmessage;

import io.github.endergamerhun.bossbarmessage.commands.CommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class BossBarMessage extends JavaPlugin {

    private static BossBarMessage INSTANCE;
    public static BossBarMessage getInstance() {
        return INSTANCE;
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
