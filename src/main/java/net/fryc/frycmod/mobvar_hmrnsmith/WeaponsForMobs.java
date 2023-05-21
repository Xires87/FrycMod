package net.fryc.frycmod.mobvar_hmrnsmith;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class WeaponsForMobs {

    public static ItemStack getSwordForCorsair(){
        return new ItemStack(net.fryc.hammersandtables.items.ModItems.COPPER_SWORD);
    }

    public static ItemStack getSwordForUndeadWarrior(){
        return new ItemStack(Items.IRON_SWORD);
    }

    public static ItemStack getAxeForExecutioner(){
        return new ItemStack(Items.IRON_AXE);
    }
}
