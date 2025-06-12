package com.normalorg.bandw.command;

import com.normalorg.bandw.Defiance;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;

public class ModCommands {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        Defiance.LOGGER.info("WIP: ModCommands.register()");
    };
};