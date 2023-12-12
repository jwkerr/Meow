package com.fwloopins.meow.util;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

import java.util.Random;

public class ParticleUtil {
    private static final Random random = new Random();

    public static void createParticlesAroundPlayer(Player player, Particle particle, int numParticles) {
        Location location = player.getLocation();
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();

        for (int i = 0; i < numParticles; i++) {
            player.getWorld().spawnParticle(particle, random.nextDouble(x, x + 1.0), random.nextDouble(y + 0.2, y + 2), random.nextDouble(z, z + 1.0), 1);
        }
    }

    public static void createParticlesAroundPlayerHead(Player player, Particle particle, int numParticles) {
        Location location = player.getLocation();
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();

        for (int i = 0; i < numParticles; i++) {
            player.getWorld().spawnParticle(particle, random.nextDouble(x, x + 1.0), random.nextDouble(y + 1.5, y + 2.2), random.nextDouble(z, z + 1.0), 1);
        }
    }
}
