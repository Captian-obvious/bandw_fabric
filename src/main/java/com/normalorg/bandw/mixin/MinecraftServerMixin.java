package com.normalorg.bandw.mixin;

import com.normalorg.bandw.Defiance;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin{
    @Inject(at=@At("HEAD"),method="loadWorld")
    private void init(CallbackInfo info){
        Defiance.LOGGER.info("Loading dependancies...");
        // some world initialization tasks
        if (Defiance.isCharterLoaded && Defiance.LESSER_DIVINITY!=null){
            Defiance.LOGGER.info("Initializing Lesser Divinity effects");
            if (Defiance.LESSER_DIVINITY instanceof Item){
                Defiance.LOGGER.info("Enabling Lesser Divinity cleansing effect");
                // some basic initialization tasks as well as cleasning functionality
            };
        };
        // Log completion, start loading
        Defiance.LOGGER.info("Loading world...");
    };
};