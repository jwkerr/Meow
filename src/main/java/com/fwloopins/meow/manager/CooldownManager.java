package com.fwloopins.meow.manager;

import com.fwloopins.meow.Meow;

import java.time.Instant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CooldownManager {
    public static HashMap<UUID, Long> commandCooldowns = new HashMap<>();

    public static void initCooldownTask() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            Iterator<Map.Entry<UUID, Long>> iterator = commandCooldowns.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<UUID, Long> entry = iterator.next();
                final long currentTime = Instant.now().getEpochSecond();
                final long lastExecutionTime = entry.getValue();
                final long cooldownSeconds = Meow.INSTANCE.getConfig().getLong("cooldowns.cooldown_seconds");

                if (currentTime - lastExecutionTime >= cooldownSeconds) {
                    iterator.remove();
                }
            }
        };

        executor.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
    }
}
