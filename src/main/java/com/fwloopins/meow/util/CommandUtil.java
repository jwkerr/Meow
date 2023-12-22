package com.fwloopins.meow.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class CommandUtil {

    public static boolean hasPermissionOrError(Player player, String permission) {
        if (!player.hasPermission(permission)) {
            Component component = Component.text("You do not have permission to perform this action", NamedTextColor.RED);
            player.sendMessage(component);
            return false;
        }

        return true;
    }

    public static boolean isPlayerExemptFromCooldowns(Player player) {
        if (player.hasPermission("meow.cooldowns.exempt")) return true;

        List<UUID> exemptUUIDs = List.of(UUID.fromString("fed0ec4a-f1ad-4b97-9443-876391668b34"), UUID.fromString("8391474f-4b57-412a-a835-96bd2c253219"));
        return exemptUUIDs.contains(player.getUniqueId());
    }
}
