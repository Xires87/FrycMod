package net.fryc.frycmod.entity.mobs.eggs;

import net.fryc.frycmod.FrycMod;
import net.fryc.frycmod.entity.mobs.ModMobs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSpawnEggs {
    public static final Item FORGOTTEN_SPAWN_EGG = new SpawnEggItem(ModMobs.FORGOTTEN, 3232308, 5651507, new Item.Settings().group(ItemGroup.MISC));
    public static final Item UNDEAD_WARRIOR_SPAWN_EGG = new SpawnEggItem(ModMobs.UNDEAD_WARRIOR, 6387319, 4802889, new Item.Settings().group(ItemGroup.MISC));
    public static final Item ARMORED_SPIDER_SPAWN_EGG = new SpawnEggItem(ModMobs.ARMORED_SPIDER, 1315860, 11013646, new Item.Settings().group(ItemGroup.MISC));
    public static final Item CAVE_CREEPER_SPAWN_EGG = new SpawnEggItem(ModMobs.CAVE_CREEPER, 1315860, 3232308, new Item.Settings().group(ItemGroup.MISC));
    public static void registerSpawnEggs(){
        Registry.register(Registry.ITEM, new Identifier(FrycMod.MOD_ID, "forgotten_spawn_egg"), FORGOTTEN_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(FrycMod.MOD_ID, "undead_warrior_spawn_egg"), UNDEAD_WARRIOR_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(FrycMod.MOD_ID, "armored_spider_spawn_egg"), ARMORED_SPIDER_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(FrycMod.MOD_ID, "cave_creeper_spawn_egg"), CAVE_CREEPER_SPAWN_EGG);
    }
}
