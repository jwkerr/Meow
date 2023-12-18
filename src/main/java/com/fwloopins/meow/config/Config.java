package com.fwloopins.meow.config;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.Collections;

public class Config {

    public static void init(FileConfiguration config) {
        config.options().setHeader(Collections.singletonList("Meow"));

        config.addDefault("cooldowns.enabled", true);
        config.addDefault("cooldowns.cooldown_seconds", 180);

        config.options().copyDefaults(true);
    }
}
