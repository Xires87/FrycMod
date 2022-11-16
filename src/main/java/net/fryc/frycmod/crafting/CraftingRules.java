package net.fryc.frycmod.crafting;

import net.fryc.craftingmanipulator.rules.ItemInInventoryRBR;
import net.fryc.craftingmanipulator.rules.RecipeBlockingRules;
import net.fryc.craftingmanipulator.rules.StandNearBlockRBR;
import net.fryc.craftingmanipulator.rules.oncraft.PlaySoundOCR;
import net.fryc.frycmod.FrycMod;
import net.fryc.frycmod.tag.ModBlockTags;
import net.fryc.frycmod.tag.ModItemTags;
import net.minecraft.sound.SoundEvents;

public class CraftingRules {

    public static void createCraftingRules(){
        //blocking recipes
        String[] tooltips;
        if(FrycMod.config.isTooltipsEnabled){
            tooltips = new String[]{"Workshop: Copper Smithing Table", "Workshop: Iron Smithing Table", "Workshop: Golden Smithing Table", "Workshop: Diamond Smithing Table", "Furnace", "Item: Diamond Hammer"};
        }
        else{
            tooltips = new String[]{"", "", "", "", "", ""};
        }

        RecipeBlockingRules VANILLA_GOLDEN_ITEMS = new RecipeBlockingRules("Recipe disabled by: Frycmod", ModItemTags.VANILLA_GOLDEN_TOOLS);

        if(FrycMod.config.isCopperRecipeBlocked){
            StandNearBlockRBR COPPER = new StandNearBlockRBR(tooltips[0], ModItemTags.NEEDS_COPPER_TABLE, ModBlockTags.TABLES);
        }
        if(FrycMod.config.isIronRecipeBlocked){
            StandNearBlockRBR IRON = new StandNearBlockRBR(tooltips[1], ModItemTags.NEEDS_IRON_TABLE, ModBlockTags.IRON_TABLES);
        }
        if(FrycMod.config.isGoldRecipeBlocked){
            StandNearBlockRBR GOLDEN = new StandNearBlockRBR(tooltips[2], ModItemTags.NEEDS_GOLDEN_TABLE, ModBlockTags.GOLDEN_TABLES);
        }
        if(FrycMod.config.isDiamondRecipeBlocked){
            StandNearBlockRBR DIAMOND = new StandNearBlockRBR(tooltips[3], ModItemTags.NEEDS_DIAMOND_TABLE, ModBlockTags.DIAMOND_TABLES);
        }
        if(FrycMod.config.isMiscRecipeBlocked){
            StandNearBlockRBR INGOTS = new StandNearBlockRBR(tooltips[4], ModItemTags.SOUND_INGOTS_FROM_FURNACE, ModBlockTags.FURNACES_FOR_INGOTS);
            ItemInInventoryRBR NETHERITE_INGOT = new ItemInInventoryRBR(tooltips[5], ModItemTags.NETHERITE_INGOT, ModItemTags.DIAMOND_HAMMERS);
        }

        //playing sounds
        if(FrycMod.config.playToolsAndArmorOnCraftSounds) {
            PlaySoundOCR TOOLS_AND_ARMOR = new PlaySoundOCR(ModItemTags.SOUND_TOOLS_AND_ARMOR, SoundEvents.BLOCK_SMITHING_TABLE_USE, 0.2f, 1.0f);
            PlaySoundOCR BONE_ARMORS = new PlaySoundOCR(ModItemTags.SOUND_BONE_ARMORS, SoundEvents.ENTITY_SKELETON_STEP, 0.6f, 0.4f);
            PlaySoundOCR CHAIN_ARMORS = new PlaySoundOCR(ModItemTags.SOUND_CHAIN_ARMORS, SoundEvents.BLOCK_CHAIN_PLACE, 0.6f, 0.7f);
        }
        if(FrycMod.config.playIngotsFromFurnaceOnCraftSounds){
            PlaySoundOCR INGOTS_FROM_FURNACE = new PlaySoundOCR(ModItemTags.SOUND_INGOTS_FROM_FURNACE, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE,0.6f, 1.0f);
        }
        if(FrycMod.config.playBlocksOnCraftSounds){
            PlaySoundOCR WOOD = new PlaySoundOCR(ModItemTags.SOUND_WOOD, SoundEvents.BLOCK_WOOD_BREAK,0.65f, 0.75f);
            PlaySoundOCR STONE = new PlaySoundOCR(ModItemTags.SOUND_STONE, SoundEvents.BLOCK_STONE_BREAK,0.65f, 0.75f);
            PlaySoundOCR DEEPSLATE = new PlaySoundOCR(ModItemTags.SOUND_DEEPSLATE, SoundEvents.BLOCK_DEEPSLATE_BREAK,0.65f, 0.75f);
        }

    }
}
