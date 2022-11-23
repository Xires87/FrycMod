package net.fryc.frycmod.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "frycmod")
public class FrycmodConfig implements ConfigData {

    //recipes
    @ConfigEntry.Category("recipes")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.RequiresRestart
    public boolean isTooltipsEnabled = true;
    @ConfigEntry.Category("recipes")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.RequiresRestart
    public boolean isCopperRecipeBlocked = true;
    @ConfigEntry.Category("recipes")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.RequiresRestart
    public boolean isIronRecipeBlocked = true;
    @ConfigEntry.Category("recipes")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.RequiresRestart
    public boolean isGoldRecipeBlocked = true;
    @ConfigEntry.Category("recipes")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.RequiresRestart
    public boolean isDiamondRecipeBlocked = true;
    @ConfigEntry.Category("recipes")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.RequiresRestart
    public boolean isMiscRecipeBlocked = true;


    //trades
    @ConfigEntry.Category("trades")
    @ConfigEntry.Gui.RequiresRestart
    public boolean modifyTradeOffersForArmorer = true;

    @ConfigEntry.Category("trades")
    @ConfigEntry.Gui.RequiresRestart
    public boolean modifyTradeOffersForToolsmith = true;

    @ConfigEntry.Category("trades")
    @ConfigEntry.Gui.RequiresRestart
    public boolean modifyTradeOffersForWeaponsmith = true;

    @ConfigEntry.Category("trades")
    @ConfigEntry.Gui.RequiresRestart
    public boolean modifyTradeOffersForLibrarian = true;
    @ConfigEntry.Category("trades")
    @ConfigEntry.Gui.Tooltip
    public boolean forceModifiedTradeOffers = false;

    //bleeding
    @ConfigEntry.Category("bleeding")
    public boolean bleedoutKills = true;

    @ConfigEntry.Category("bleeding")
    public boolean bleedingStopsFoodHealing = true;

    @ConfigEntry.Category("bleeding")
    public boolean fireDamageLowersBleedingDuration = true;

    @ConfigEntry.Category("bleeding")
    @ConfigEntry.Gui.Tooltip
    public boolean enableMeleeEffectUpgrading = true;

    @ConfigEntry.Category("bleeding")
    @ConfigEntry.BoundedDiscrete(max = 200)
    public int meleeBleedLength = 11;

    @ConfigEntry.Category("bleeding")
    @ConfigEntry.BoundedDiscrete(max = 4000)
    public int healthLossLength = 280;

    @ConfigEntry.Category("bleeding")
    @ConfigEntry.Gui.Tooltip
    public boolean enableArrowEffectUpgrading = false;

    @ConfigEntry.Category("bleeding")
    @ConfigEntry.BoundedDiscrete(max = 200)
    public int arrowBleedLength = 7;

    //mobs
    @ConfigEntry.Category("mobs")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(max = 300, min = -64)
    public int zombieToForgottenConvertLevelY = 26;

    @ConfigEntry.Category("mobs")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(max = 300, min = -64)
    public int skeletonToUndeadWarriorConvertLevelY = 26;

    @ConfigEntry.Category("mobs")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(max = 300, min = -64)
    public int spiderToBlackSpiderConvertLevelY = 26;

    @ConfigEntry.Category("mobs")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(max = 300, min = -64)
    public int creeperToCaveCreeperConvertLevelY = 26;


    //other
    @ConfigEntry.Category("other")
    @ConfigEntry.Gui.Tooltip
    public boolean enableDarknessAtLowHp = true;
    @ConfigEntry.Category("other")
    @ConfigEntry.Gui.Tooltip
    public boolean enableBlindnessAtLowHp = true;

    @ConfigEntry.Category("other")
    @ConfigEntry.Gui.RequiresRestart
    public boolean playToolsAndArmorOnCraftSounds = true;

    @ConfigEntry.Category("other")
    @ConfigEntry.Gui.RequiresRestart
    public boolean playIngotsFromFurnaceOnCraftSounds = true;

    @ConfigEntry.Category("other")
    @ConfigEntry.Gui.RequiresRestart
    public boolean playBlocksOnCraftSounds = false;
}
