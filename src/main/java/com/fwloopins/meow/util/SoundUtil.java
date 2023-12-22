package com.fwloopins.meow.util;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.Random;

public class SoundUtil {

    public static void playBegAtPlayer(Player player) {
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_CAT_BEG_FOR_FOOD, 0.7F, 1.0F);
    }

    public static void playHissAtPlayer(Player player) {
        Random random = new Random();
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_CAT_HISS, 0.4F, random.nextFloat(0.8F, 1.2F));
    }

    public static void playHurtAtPlayer(Player player) {
        Random random = new Random();
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_CAT_HURT, 0.65F, random.nextFloat(0.8F, 1.2F));
    }

    public static void playMeowAtPlayer(Player player) {
        Random random = new Random();

        Sound sound;
        if (random.nextBoolean()) {
            sound = Sound.ENTITY_CAT_AMBIENT;
        } else {
            sound = Sound.ENTITY_CAT_STRAY_AMBIENT;
        }

        player.getWorld().playSound(player.getLocation(), sound, 0.5F, random.nextFloat(0.8F, 1.2F));
    }

    public static void playPurrAtPlayer(Player player) {
        Random random = new Random();
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_CAT_PURR, 0.4F, random.nextFloat(0.8F, 1.2F));
    }

    public static void playPurreowAtPlayer(Player player) {
        Random random = new Random();
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_CAT_PURREOW, 0.5F, random.nextFloat(0.8F, 1.2F));
    }
}
