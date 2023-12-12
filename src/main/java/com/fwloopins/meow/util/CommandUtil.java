package com.fwloopins.meow.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;

public class CommandUtil {

    public static boolean hasPermissionOrError(Player player, String permission) {
        if (!player.hasPermission(permission)) {
            Component component = Component.text("You do not have permission to perform this action", NamedTextColor.RED);
            player.sendMessage(component);
            return false;
        }

        return true;
    }
}
