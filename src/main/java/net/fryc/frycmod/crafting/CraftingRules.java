package net.fryc.frycmod.crafting;

import net.fryc.craftingmanipulator.conditions.PressedKey;
import net.fryc.craftingmanipulator.rules.StandNearBlockRBR;
import net.fryc.craftingmanipulator.rules.oncraft.PlaySoundOCR;
import net.fryc.craftingmanipulator.rules.tooltips.TooltipRules;
import net.fryc.frycmod.FrycMod;
import net.fryc.frycmod.tag.ModBlockTags;
import net.fryc.frycmod.tag.ModItemTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.BlastFurnaceScreenHandler;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Formatting;

public class CraftingRules {

    private static final Formatting[] requirementsTooltip = new Formatting[]{Formatting.YELLOW};
    private static final Formatting[] tooltip = new Formatting[]{Formatting.RED};

    public static void createCraftingRules(){

        //tooltip for golden items
        if(FrycMod.config.isTooltipsForGoldenItemsEnabled){
            TooltipRules LOVED_BY_PIGLINS = new TooltipRules(ItemTags.PIGLIN_LOVED, "Loved by Piglins");
            LOVED_BY_PIGLINS.tooltipFormatting = new Formatting[]{Formatting.BLUE};
        }

        //blocking recipes with Crafting Manipulator
        if(FrycMod.config.isCopperRecipeBlocked){
            StandNearBlockRBR COPPER = new StandNearBlockRBR(ModItemTags.NEEDS_COPPER_TABLE, ModBlockTags.TABLES);
            if(FrycMod.config.isTooltipsEnabled){
                TooltipRules COPPER_TOOLTIP = new TooltipRules(ModItemTags.NEEDS_COPPER_TABLE, "Crafting Requirements (SHIFT)", PressedKey.SHIFT, "Workshop: Copper Smithing Table");
                COPPER_TOOLTIP.tooltipWhenKeyPressedFormatting = tooltip;
                COPPER_TOOLTIP.tooltipFormatting = requirementsTooltip;
            }
        }
        if(FrycMod.config.isIronRecipeBlocked){
            StandNearBlockRBR IRON = new StandNearBlockRBR(ModItemTags.NEEDS_IRON_TABLE, ModBlockTags.IRON_TABLES);
            if(FrycMod.config.isTooltipsEnabled){
                TooltipRules IRON_TOOLTIP = new TooltipRules(ModItemTags.NEEDS_IRON_TABLE, "Crafting Requirements (SHIFT)", PressedKey.SHIFT, "Workshop: Iron Smithing Table");
                IRON_TOOLTIP.tooltipWhenKeyPressedFormatting = tooltip;
                IRON_TOOLTIP.tooltipFormatting = requirementsTooltip;
            }
        }
        if(FrycMod.config.isGoldRecipeBlocked){
            StandNearBlockRBR GOLD = new StandNearBlockRBR(ModItemTags.NEEDS_GOLDEN_TABLE, ModBlockTags.GOLDEN_TABLES);
            if(FrycMod.config.isTooltipsEnabled){
                TooltipRules GOLD_TOOLTIP = new TooltipRules(ModItemTags.NEEDS_GOLDEN_TABLE, "Crafting Requirements (SHIFT)", PressedKey.SHIFT, "Workshop: Golden Smithing Table");
                GOLD_TOOLTIP.tooltipWhenKeyPressedFormatting = tooltip;
                GOLD_TOOLTIP.tooltipFormatting = requirementsTooltip;
            }
        }
        if(FrycMod.config.isDiamondRecipeBlocked){
            StandNearBlockRBR DIAMOND = new StandNearBlockRBR(ModItemTags.NEEDS_DIAMOND_TABLE, ModBlockTags.DIAMOND_TABLES);
            if(FrycMod.config.isTooltipsEnabled){
                TooltipRules DIAMOND_TOOLTIP = new TooltipRules(ModItemTags.NEEDS_DIAMOND_TABLE, "Crafting Requirements (SHIFT)", PressedKey.SHIFT, "Workshop: Diamond Smithing Table");
                DIAMOND_TOOLTIP.tooltipWhenKeyPressedFormatting = tooltip;
                DIAMOND_TOOLTIP.tooltipFormatting = requirementsTooltip;
            }
        }
        if(FrycMod.config.isVanillaGoldenRecipeBlocked){
            StandNearBlockRBR VANILLA_GOLDEN = new StandNearBlockRBR(ModItemTags.VANILLA_GOLDEN_TOOLS, ModBlockTags.PIGLINS_FORGE);
            if(FrycMod.config.isTooltipsEnabled){
                TooltipRules VANILLA_GOLDEN_TOOLTIP = new TooltipRules(ModItemTags.VANILLA_GOLDEN_TOOLS, "Crafting Requirements (SHIFT)", PressedKey.SHIFT, "Workshop: Piglins Forge");
                VANILLA_GOLDEN_TOOLTIP.tooltipWhenKeyPressedFormatting = tooltip;
                VANILLA_GOLDEN_TOOLTIP.tooltipFormatting = requirementsTooltip;
            }
        }

        //playing sounds
        if(FrycMod.config.playToolsAndArmorOnCraftSounds) {
            PlaySoundOCR TOOLS_AND_ARMOR = new PlaySoundOCR(ModItemTags.SOUND_TOOLS_AND_ARMOR, SoundEvents.BLOCK_SMITHING_TABLE_USE, 0.6f, 1.0f);
            PlaySoundOCR BONE_ARMORS = new PlaySoundOCR(ModItemTags.SOUND_BONE_ARMORS, SoundEvents.ENTITY_SKELETON_STEP, 0.6f, 0.4f);
            PlaySoundOCR CHAIN_ARMORS = new PlaySoundOCR(ModItemTags.SOUND_CHAIN_ARMORS, SoundEvents.BLOCK_CHAIN_PLACE, 0.6f, 0.7f);

            TOOLS_AND_ARMOR.getSelectedScreenHandlers().add(CraftingScreenHandler.class);
            BONE_ARMORS.getSelectedScreenHandlers().add(CraftingScreenHandler.class);
            CHAIN_ARMORS.getSelectedScreenHandlers().add(CraftingScreenHandler.class);
        }
        if(FrycMod.config.playIngotsFromFurnaceOnCraftSounds){
            PlaySoundOCR INGOTS_FROM_FURNACE = new PlaySoundOCR(ModItemTags.SOUND_INGOTS_FROM_FURNACE, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE,0.6f, 1.0f);

            INGOTS_FROM_FURNACE.getSelectedScreenHandlers().add(FurnaceScreenHandler.class);
            INGOTS_FROM_FURNACE.getSelectedScreenHandlers().add(BlastFurnaceScreenHandler.class);
        }
        if(FrycMod.config.playBlocksOnCraftSounds){
            PlaySoundOCR WOOD = new PlaySoundOCR(ModItemTags.SOUND_WOOD, SoundEvents.BLOCK_WOOD_BREAK,0.65f, 0.75f);
            PlaySoundOCR STONE = new PlaySoundOCR(ModItemTags.SOUND_STONE, SoundEvents.BLOCK_STONE_BREAK,0.65f, 0.75f);
            PlaySoundOCR DEEPSLATE = new PlaySoundOCR(ModItemTags.SOUND_DEEPSLATE, SoundEvents.BLOCK_DEEPSLATE_BREAK,0.65f, 0.75f);

            WOOD.getSelectedScreenHandlers().add(CraftingScreenHandler.class);
            STONE.getSelectedScreenHandlers().add(CraftingScreenHandler.class);
            DEEPSLATE.getSelectedScreenHandlers().add(CraftingScreenHandler.class);

            WOOD.getSelectedScreenHandlers().add(PlayerScreenHandler.class);
            STONE.getSelectedScreenHandlers().add(PlayerScreenHandler.class);
            DEEPSLATE.getSelectedScreenHandlers().add(PlayerScreenHandler.class);
        }

    }
}
