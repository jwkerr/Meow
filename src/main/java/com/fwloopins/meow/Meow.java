package com.fwloopins.meow;

import com.fwloopins.meow.command.MeowCommand;
import com.fwloopins.meow.config.Config;
import com.fwloopins.meow.manager.CooldownManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Meow extends JavaPlugin {
    public static Meow INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;

        Config.init(getConfig());
        saveConfig();

        if (getConfig().getBoolean("cooldowns.enabled"))
            CooldownManager.initCooldownTask();

        getCommand("meow").setExecutor(new MeowCommand());
    }
}
