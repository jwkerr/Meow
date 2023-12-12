package com.fwloopins.meow.command;

import com.fwloopins.meow.util.CommandUtil;
import com.fwloopins.meow.util.ParticleUtil;
import com.fwloopins.meow.util.SoundUtil;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Collectors;

public class MeowCommand implements TabExecutor {
    private final List<String> availableSounds = List.of("beg", "hiss", "hurt", "meow", "purr", "purreow");

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(Component.text("Only players can use this command", NamedTextColor.RED));
            return true;
        }

        if (args.length == 0) {
            if (!CommandUtil.hasPermissionOrError(player, "meow.command.meow.meow")) return true;
            SoundUtil.playMeowAtPlayer(player);
            return true;
        }

        String chosenSound = args[0];
        switch (chosenSound) {
            case "beg":
                if (!CommandUtil.hasPermissionOrError(player, "meow.command.meow.beg")) return true;
                SoundUtil.playBegAtPlayer(player);
                break;
            case "hiss":
                if (!CommandUtil.hasPermissionOrError(player, "meow.command.meow.hiss")) return true;
                SoundUtil.playHissAtPlayer(player);

                if (player.hasPermission("meow.particles"))
                    ParticleUtil.createParticlesAroundPlayerHead(player, Particle.VILLAGER_ANGRY, 6);
                break;
            case "hurt":
                if (!CommandUtil.hasPermissionOrError(player, "meow.command.meow.hurt")) return true;
                SoundUtil.playHurtAtPlayer(player);
                break;
            case "meow":
                if (!CommandUtil.hasPermissionOrError(player, "meow.command.meow.meow")) return true;
                SoundUtil.playMeowAtPlayer(player);
                break;
            case "purr":
                if (!CommandUtil.hasPermissionOrError(player, "meow.command.meow.purr")) return true;
                SoundUtil.playPurrAtPlayer(player);

                if (player.hasPermission("meow.particles"))
                    ParticleUtil.createParticlesAroundPlayer(player, Particle.HEART, 6);
                break;
            case "purreow":
                if (!CommandUtil.hasPermissionOrError(player, "meow.command.meow.purreow")) return true;
                SoundUtil.playPurreowAtPlayer(player);
                break;
            default:
                player.sendMessage(Component.text("Invalid argument", NamedTextColor.RED));
                return true;
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            if (args[0].isEmpty()) {
                return availableSounds;
            } else {
                return availableSounds.stream()
                        .filter(string -> string.startsWith(args[0]))
                        .collect(Collectors.toList());
            }
        }

        return null;
    }
}
