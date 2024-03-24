package com.fwloopins.meow.manager;

import com.fwloopins.meow.Meow;

import java.time.Instant;
import java.util.HashMap;
import java.util.UUID;

public class CooldownManager {
    public static HashMap<UUID, Long> commandCooldowns = new HashMap<>();

    public static boolean hasCooldown(UUID uuid) {
        long cooldownSeconds = Meow.INSTANCE.getConfig().getLong("cooldowns.cooldown_seconds");
        Long value = commandCooldowns.getOrDefault(uuid, null);

        return value != null && Instant.now().getEpochSecond() - value < cooldownSeconds;
    }

    public static Long getCooldownSeconds(UUID uuid) {
        Long value = commandCooldowns.getOrDefault(uuid, null);
        if (value == null) return null;

        long cooldownSeconds = Meow.INSTANCE.getConfig().getLong("cooldowns.cooldown_seconds");
        long targetTime = value + cooldownSeconds;
        return targetTime - Instant.now().getEpochSecond();
    }
}
