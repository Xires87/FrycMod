package net.fryc.frycmod.enchantments;

import net.fryc.frycmod.FrycMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    private static final EquipmentSlot[] ALL_ARMOR = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};

    public static Enchantment ABSORPTION = register("absorption_enchantment",
            new AbsorptionEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.CHEST));

    public static Enchantment ENDER_CURSE = register("ender_curse_enchantment",
            new EnderCurseEnchantment(Enchantment.Rarity.VERY_RARE, ALL_ARMOR));

    public static Enchantment FLAMES_CURSE = register("flames_curse_enchantment",
            new FlamesCurseEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.MAINHAND));


    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(FrycMod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        System.out.println("Registering Enchantments for " + FrycMod.MOD_ID);
    }
}
