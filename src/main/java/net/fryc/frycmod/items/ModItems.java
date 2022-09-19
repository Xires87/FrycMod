package net.fryc.frycmod.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fryc.frycmod.FrycMod;
import net.fryc.frycmod.items.custom.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    //hammers----------------------------------------------------------------------------------
    public static final Item COPPER_HAMMER = registerItem("copper_hammer" ,
            new ModSlownessSwordItem(ModToolMaterials.COPPER , 4 , -3.3f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item NUGGET_COPPER_HAMMER = registerItem("nugget_copper_hammer" ,
            new ModSlownessSwordItem(ModToolMaterials.NUGGET_COPPER , 4 , -3.3f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item INGOT_COPPER_HAMMER = registerItem("ingot_copper_hammer" ,
            new ModSlownessSwordItem(ModToolMaterials.INGOT_COPPER , 4 , -3.3f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item IRON_HAMMER = registerItem("iron_hammer" ,
            new ModSlownessSwordItem(ToolMaterials.IRON , 5 , -3.3f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item NUGGET_IRON_HAMMER = registerItem("nugget_iron_hammer" ,
            new ModSlownessSwordItem(ModToolMaterials.NUGGET_IRON , 4 , -3.3f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item INGOT_IRON_HAMMER = registerItem("ingot_iron_hammer" ,
            new ModSlownessSwordItem(ModToolMaterials.INGOT_IRON , 4 , -3.3f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item GOLDEN_HAMMER = registerItem("golden_hammer" ,
            new ModSlownessSwordItem(ModToolMaterials.GOLD , 4 , -3.3f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item DIAMOND_GOLDEN_HAMMER = registerItem("diamond_golden_hammer" ,
            new ModSlownessSwordItem(ModToolMaterials.DIAMOND_GOLD , 4 , -3.3f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer" ,
            new ModSlownessSwordItem(ToolMaterials.DIAMOND , 5 , -3.3f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer" ,
            new ModSlownessSwordItem(ToolMaterials.NETHERITE , 4 , -3.2f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));
    //copper ----------------------------------------------------------------------------------
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe" ,
            new ModPickaxeItem(ModToolMaterials.COPPER , 0 , -2.8f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item COPPER_AXE = registerItem("copper_axe" ,
            new ModAxeItem(ModToolMaterials.COPPER , 6 , -3.2f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item COPPER_SHOVEL = registerItem("copper_shovel" ,
            new ModShovelItem(ModToolMaterials.COPPER , 0.5f , -3f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item COPPER_HOE = registerItem("copper_hoe" ,
            new ModHoeItem(ModToolMaterials.COPPER , -1 , -2f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item COPPER_SWORD = registerItem("copper_sword" ,
            new SwordItem(ModToolMaterials.COPPER , 2 , -2.4f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item COPPER_HELMET = registerItem("copper_helmet" ,
            new ArmorItem(ModArmorMaterials.COPPER , EquipmentSlot.HEAD ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate" ,
            new ArmorItem(ModArmorMaterials.COPPER , EquipmentSlot.CHEST ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings" ,
            new ArmorItem(ModArmorMaterials.COPPER , EquipmentSlot.LEGS ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item COPPER_BOOTS = registerItem("copper_boots" ,
            new ArmorItem(ModArmorMaterials.COPPER , EquipmentSlot.FEET ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    //nugget copper---------------------------------------------------------------------------------------

    public static final Item NUGGET_COPPER_PICKAXE = registerItem("nugget_copper_pickaxe" ,
            new ModPickaxeItem(ModToolMaterials.NUGGET_COPPER , 0 , -2.8f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item NUGGET_COPPER_AXE = registerItem("nugget_copper_axe" ,
            new ModAxeItem(ModToolMaterials.NUGGET_COPPER , 5.5f , -3.15f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item NUGGET_COPPER_SHOVEL = registerItem("nugget_copper_shovel" ,
            new ModShovelItem(ModToolMaterials.NUGGET_COPPER , 0.5f , -3f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item NUGGET_COPPER_HOE = registerItem("nugget_copper_hoe" ,
            new ModHoeItem(ModToolMaterials.NUGGET_COPPER , -1 , -2f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item NUGGET_COPPER_SWORD = registerItem("nugget_copper_sword" ,
            new SwordItem(ModToolMaterials.NUGGET_COPPER , 2 , -2.4f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item NUGGET_COPPER_HELMET = registerItem("nugget_copper_helmet" ,
            new ArmorItem(ModArmorMaterials.NUGGET_COPPER , EquipmentSlot.HEAD ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item NUGGET_COPPER_CHESTPLATE = registerItem("nugget_copper_chestplate" ,
            new ArmorItem(ModArmorMaterials.NUGGET_COPPER , EquipmentSlot.CHEST ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item NUGGET_COPPER_LEGGINGS = registerItem("nugget_copper_leggings" ,
            new ArmorItem(ModArmorMaterials.NUGGET_COPPER , EquipmentSlot.LEGS ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item NUGGET_COPPER_BOOTS = registerItem("nugget_copper_boots" ,
            new ArmorItem(ModArmorMaterials.NUGGET_COPPER , EquipmentSlot.FEET ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    //ingot copper-----------------------------------------------------------------------------------------
    public static final Item INGOT_COPPER_PICKAXE = registerItem("ingot_copper_pickaxe" ,
            new ModPickaxeItem(ModToolMaterials.INGOT_COPPER , 0 , -2.8f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item INGOT_COPPER_AXE = registerItem("ingot_copper_axe" ,
            new ModAxeItem(ModToolMaterials.INGOT_COPPER , 5 , -3.1f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item INGOT_COPPER_SHOVEL = registerItem("ingot_copper_shovel" ,
            new ModShovelItem(ModToolMaterials.INGOT_COPPER , 0.5f , -3f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item INGOT_COPPER_HOE = registerItem("ingot_copper_hoe" ,
            new ModHoeItem(ModToolMaterials.INGOT_COPPER , -2 , -1f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item INGOT_COPPER_SWORD = registerItem("ingot_copper_sword" ,
            new SwordItem(ModToolMaterials.INGOT_COPPER , 2 , -2.4f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item INGOT_COPPER_HELMET = registerItem("ingot_copper_helmet" ,
            new ArmorItem(ModArmorMaterials.INGOT_COPPER , EquipmentSlot.HEAD ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item INGOT_COPPER_CHESTPLATE = registerItem("ingot_copper_chestplate" ,
            new ArmorItem(ModArmorMaterials.INGOT_COPPER , EquipmentSlot.CHEST ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item INGOT_COPPER_LEGGINGS = registerItem("ingot_copper_leggings" ,
            new ArmorItem(ModArmorMaterials.INGOT_COPPER , EquipmentSlot.LEGS ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item INGOT_COPPER_BOOTS = registerItem("ingot_copper_boots" ,
            new ArmorItem(ModArmorMaterials.INGOT_COPPER , EquipmentSlot.FEET ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    //nugget iron---------------------------------------------------------------------------------------------
    public static final Item NUGGET_IRON_PICKAXE = registerItem("nugget_iron_pickaxe" ,
            new ModPickaxeItem(ModToolMaterials.NUGGET_IRON , 0 , -2.8f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item NUGGET_IRON_AXE = registerItem("nugget_iron_axe" ,
            new ModAxeItem(ModToolMaterials.NUGGET_IRON , 5 , -3.1f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item NUGGET_IRON_SHOVEL = registerItem("nugget_iron_shovel" ,
            new ModShovelItem(ModToolMaterials.NUGGET_IRON , 0.5f , -3f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item NUGGET_IRON_HOE = registerItem("nugget_iron_hoe" ,
            new ModHoeItem(ModToolMaterials.NUGGET_IRON , -2 , -1.5f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item NUGGET_IRON_SWORD = registerItem("nugget_iron_sword" ,
            new SwordItem(ModToolMaterials.NUGGET_IRON , 2 , -2.4f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item NUGGET_IRON_HELMET = registerItem("nugget_iron_helmet" ,
            new ArmorItem(ModArmorMaterials.NUGGET_IRON , EquipmentSlot.HEAD ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item NUGGET_IRON_CHESTPLATE = registerItem("nugget_iron_chestplate" ,
            new ArmorItem(ModArmorMaterials.NUGGET_IRON , EquipmentSlot.CHEST ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item NUGGET_IRON_LEGGINGS = registerItem("nugget_iron_leggings" ,
            new ArmorItem(ModArmorMaterials.NUGGET_IRON , EquipmentSlot.LEGS ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item NUGGET_IRON_BOOTS = registerItem("nugget_iron_boots" ,
            new ArmorItem(ModArmorMaterials.NUGGET_IRON , EquipmentSlot.FEET ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    //ingot iron------------------------------------------------------------------------------
    public static final Item INGOT_IRON_PICKAXE = registerItem("ingot_iron_pickaxe" ,
            new ModPickaxeItem(ModToolMaterials.INGOT_IRON , 0 , -2.8f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item INGOT_IRON_AXE = registerItem("ingot_iron_axe" ,
            new ModAxeItem(ModToolMaterials.INGOT_IRON , 5 , -3.1f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item INGOT_IRON_SHOVEL = registerItem("ingot_iron_shovel" ,
            new ModShovelItem(ModToolMaterials.INGOT_IRON , 0.5f , -3f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item INGOT_IRON_HOE = registerItem("ingot_iron_hoe" ,
            new ModHoeItem(ModToolMaterials.INGOT_IRON , -3 , -0.5f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item INGOT_IRON_SWORD = registerItem("ingot_iron_sword" ,
            new SwordItem(ModToolMaterials.INGOT_IRON , 2 , -2.4f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item INGOT_IRON_HELMET = registerItem("ingot_iron_helmet" ,
            new ArmorItem(ModArmorMaterials.INGOT_IRON , EquipmentSlot.HEAD ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item INGOT_IRON_CHESTPLATE = registerItem("ingot_iron_chestplate" ,
            new ArmorItem(ModArmorMaterials.INGOT_IRON , EquipmentSlot.CHEST ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item INGOT_IRON_LEGGINGS = registerItem("ingot_iron_leggings" ,
            new ArmorItem(ModArmorMaterials.INGOT_IRON , EquipmentSlot.LEGS ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item INGOT_IRON_BOOTS = registerItem("ingot_iron_boots" ,
            new ArmorItem(ModArmorMaterials.INGOT_IRON , EquipmentSlot.FEET ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    //first textures of reinforced iron armor
    public static final Item OBSZCZANY_HELM = registerItem("obszczany_helm" ,
            new ArmorItem(ModArmorMaterials.SZCZYNY , EquipmentSlot.HEAD ,
                    new FabricItemSettings()));

    public static final Item OBSZCZANA_KLATA = registerItem("obszczana_klata" ,
            new ArmorItem(ModArmorMaterials.SZCZYNY , EquipmentSlot.CHEST ,
                    new FabricItemSettings()));

    public static final Item OBSZCZANE_SPODNIE = registerItem("obszczane_spodnie" ,
            new ArmorItem(ModArmorMaterials.SZCZYNY , EquipmentSlot.LEGS ,
                    new FabricItemSettings()));

    public static final Item OBSZCZANE_BUTY = registerItem("obszczane_buty" ,
            new ArmorItem(ModArmorMaterials.SZCZYNY , EquipmentSlot.FEET ,
                    new FabricItemSettings()));

    //gold---------------------------------------------------------------------------------
    public static final Item GOLDEN_PICKAXE = registerItem("golden_pickaxe" ,
            new ModPickaxeItem(ModToolMaterials.GOLD , 0 , -2.8f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item GOLDEN_AXE = registerItem("golden_axe" ,
            new ModAxeItem(ModToolMaterials.GOLD, 5 , -3.1f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item GOLDEN_SHOVEL = registerItem("golden_shovel" ,
            new ModShovelItem(ModToolMaterials.GOLD , 0.5f , -3f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item GOLDEN_HOE = registerItem("golden_hoe" ,
            new ModHoeItem(ModToolMaterials.GOLD , -3 , -1f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item GOLDEN_SWORD = registerItem("golden_sword" ,
            new SwordItem(ModToolMaterials.GOLD , 2 , -2.4f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item GOLDEN_HELMET = registerItem("golden_helmet" ,
            new ArmorItem(ModArmorMaterials.GOLD , EquipmentSlot.HEAD ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item GOLDEN_CHESTPLATE = registerItem("golden_chestplate" ,
            new ArmorItem(ModArmorMaterials.GOLD , EquipmentSlot.CHEST ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item GOLDEN_LEGGINGS = registerItem("golden_leggings" ,
            new ArmorItem(ModArmorMaterials.GOLD , EquipmentSlot.LEGS ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item GOLDEN_BOOTS = registerItem("golden_boots" ,
            new ArmorItem(ModArmorMaterials.GOLD , EquipmentSlot.FEET ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    //diamond gold--------------------------------------------------------------------------
    public static final Item DIAMOND_GOLDEN_PICKAXE = registerItem("diamond_golden_pickaxe" ,
            new ModPickaxeItem(ModToolMaterials.DIAMOND_GOLD , 0 , -2.8f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item DIAMOND_GOLDEN_AXE = registerItem("diamond_golden_axe" ,
            new ModAxeItem(ModToolMaterials.DIAMOND_GOLD, 4.5f , -3.05f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item DIAMOND_GOLDEN_SHOVEL = registerItem("diamond_golden_shovel" ,
            new ModShovelItem(ModToolMaterials.DIAMOND_GOLD , 0.5f , -3f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item DIAMOND_GOLDEN_HOE = registerItem("diamond_golden_hoe" ,
            new ModHoeItem(ModToolMaterials.DIAMOND_GOLD , -3 , -1f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)));

    public static final Item DIAMOND_GOLDEN_SWORD = registerItem("diamond_golden_sword" ,
            new SwordItem(ModToolMaterials.DIAMOND_GOLD , 2 , -2.4f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item DIAMOND_GOLDEN_HELMET = registerItem("diamond_golden_helmet" ,
            new ArmorItem(ModArmorMaterials.DIAMOND_GOLD , EquipmentSlot.HEAD ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item DIAMOND_GOLDEN_CHESTPLATE = registerItem("diamond_golden_chestplate" ,
            new ArmorItem(ModArmorMaterials.DIAMOND_GOLD , EquipmentSlot.CHEST ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item DIAMOND_GOLDEN_LEGGINGS = registerItem("diamond_golden_leggings" ,
            new ArmorItem(ModArmorMaterials.DIAMOND_GOLD , EquipmentSlot.LEGS ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item DIAMOND_GOLDEN_BOOTS = registerItem("diamond_golden_boots" ,
            new ArmorItem(ModArmorMaterials.DIAMOND_GOLD , EquipmentSlot.FEET ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    //bone----------------------------------------------------------------------------------
    public static final Item BONE_HELMET = registerItem("bone_helmet" ,
            new ArmorItem(ModArmorMaterials.BONE , EquipmentSlot.HEAD ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item BONE_CHESTPLATE = registerItem("bone_chestplate" ,
            new ArmorItem(ModArmorMaterials.BONE , EquipmentSlot.CHEST ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item BONE_LEGGINGS = registerItem("bone_leggings" ,
            new ArmorItem(ModArmorMaterials.BONE , EquipmentSlot.LEGS ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item BONE_BOOTS = registerItem("bone_boots" ,
            new ArmorItem(ModArmorMaterials.BONE , EquipmentSlot.FEET ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item WITHER_HELMET = registerItem("wither_helmet" ,
            new ModArmorItems(ModArmorMaterials.WITHER_BONE , EquipmentSlot.HEAD ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item WITHER_CHESTPLATE = registerItem("wither_chestplate" ,
            new ModArmorItems(ModArmorMaterials.WITHER_BONE , EquipmentSlot.CHEST ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item WITHER_LEGGINGS = registerItem("wither_leggings" ,
            new ModArmorItems(ModArmorMaterials.WITHER_BONE , EquipmentSlot.LEGS ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item WITHER_BOOTS = registerItem("wither_boots" ,
            new ModArmorItems(ModArmorMaterials.WITHER_BONE , EquipmentSlot.FEET ,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item WARDEN_HELMET = registerItem("warden_helmet" ,
            new ModArmorItems(ModArmorMaterials.WARDEN_BONE , EquipmentSlot.HEAD ,
                    new FabricItemSettings().group(ItemGroup.COMBAT).fireproof()));

    public static final Item WARDEN_CHESTPLATE = registerItem("warden_chestplate" ,
            new ModArmorItems(ModArmorMaterials.WARDEN_BONE , EquipmentSlot.CHEST ,
                    new FabricItemSettings().group(ItemGroup.COMBAT).fireproof()));

    public static final Item WARDEN_LEGGINGS = registerItem("warden_leggings" ,
            new ModArmorItems(ModArmorMaterials.WARDEN_BONE , EquipmentSlot.LEGS ,
                    new FabricItemSettings().group(ItemGroup.COMBAT).fireproof()));

    public static final Item WARDEN_BOOTS = registerItem("warden_boots" ,
            new ModArmorItems(ModArmorMaterials.WARDEN_BONE , EquipmentSlot.FEET ,
                    new FabricItemSettings().group(ItemGroup.COMBAT).fireproof()));


    //scrolls--------------------------------------------------------------------------------------------
    public static final Item MAGIC_SCROLL_ARMOR = registerItem("magic_scroll_armor" ,
            new ScrollItem(new FabricItemSettings().maxCount(4).group(ItemGroup.MISC)));

    public static final Item MAGIC_SCROLL_TOOL = registerItem("magic_scroll_tool" ,
            new ScrollItem(new FabricItemSettings().maxCount(4).group(ItemGroup.MISC)));

    public static final Item MAGIC_SCROLL_WEAPON = registerItem("magic_scroll_weapon" ,
            new ScrollItem(new FabricItemSettings().maxCount(4).group(ItemGroup.MISC)));

    //bandages-------------------------------------------------------------------------------------------
    public static final Item BANDAGE = registerItem("bandage" ,
            new BandageItem(new FabricItemSettings().maxCount(16).group(ItemGroup.MISC)));
    public static final Item HONEY_BANDAGE = registerItem("honey_bandage" ,
            new BandageItem(new FabricItemSettings().maxCount(16).group(ItemGroup.MISC)));
    public static final Item STICKY_BANDAGE = registerItem("sticky_bandage" ,
            new StickyBandageItem(new FabricItemSettings().maxCount(16).group(ItemGroup.MISC)));

    //other----------------------------------------------------------------------------------------------
    public static final Item WITHER_BONE = registerItem("wither_bone" ,
            new Item(new FabricItemSettings().maxCount(64).group(ItemGroup.BREWING)));

    public static final Item RED_CRYSTALS = registerItem("red_crystals" ,
            new Item(new FabricItemSettings().maxCount(64).group(ItemGroup.BREWING)));

    public static final Item CLOVER = registerItem("clover" ,
            new Item(new FabricItemSettings().maxCount(64).group(ItemGroup.BREWING)));

    public static final Item ANCIENT_REMAINS = registerItem("ancient_remains" ,
            new Item(new FabricItemSettings().maxCount(64).group(ItemGroup.MISC).fireproof()));




    //registers------------------------------------------------------------------------------------------
    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(FrycMod.MOD_ID, name), item);
    }
    public static void registerModItems(){
        FrycMod.LOGGER.info("Registering Mod Items for " + FrycMod.MOD_ID);
    }

}
