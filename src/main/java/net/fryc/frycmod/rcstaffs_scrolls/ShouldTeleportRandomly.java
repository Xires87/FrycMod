package net.fryc.frycmod.rcstaffs_scrolls;

import net.minecraft.server.network.ServerPlayerEntity;

public class ShouldTeleportRandomly {

    public static boolean hasChaoticTeleportationEffect(ServerPlayerEntity player){
        return player.hasStatusEffect(net.fryc.frycscrolls.effects.ModEffects.CHAOTIC_TELEPORTATION);
    }
}
