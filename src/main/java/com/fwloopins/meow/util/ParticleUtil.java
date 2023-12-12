package com.fwloopins.meow.util;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

import java.util.Random;

public class MeowUtil {

    public static void createParticlesAroundPlayer(Player player, Particle particle, int numParticles) {
        Random random = new Random();
        Location location = player.getLocation();
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();

        for (int i = 0; i < numParticles; i++) {
            player.getWorld().spawnParticle(particle, random.nextDouble(x, x + 0.5), random.nextDouble(y, y + 2), random.nextDouble(z, z + 0.5), 1);
        }
    }
}
