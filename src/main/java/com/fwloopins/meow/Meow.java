package com.fwloopins.meow;

import com.fwloopins.meow.command.MeowCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Meow extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("meow").setExecutor(new MeowCommand());
    }
}
