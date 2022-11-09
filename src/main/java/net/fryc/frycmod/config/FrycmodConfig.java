package net.fryc.frycmod.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "frycmod")
public class FrycmodConfig implements ConfigData {
    @ConfigEntry.Category("recipes")
    @ConfigEntry.Gui.Tooltip
    public boolean isTooltipsEnabled = true;
    @ConfigEntry.Category("recipes")
    @ConfigEntry.Gui.Tooltip
    public boolean isCopperRecipeBlocked = true;
    @ConfigEntry.Category("recipes")
    @ConfigEntry.Gui.Tooltip
    public boolean isIronRecipeBlocked = true;
    @ConfigEntry.Category("recipes")
    @ConfigEntry.Gui.Tooltip
    public boolean isGoldRecipeBlocked = true;
    @ConfigEntry.Category("recipes")
    @ConfigEntry.Gui.Tooltip
    public boolean isDiamondRecipeBlocked = true;
    @ConfigEntry.Category("trades")
    @ConfigEntry.Gui.Tooltip
    public boolean isTradeOffersModified = true;
    @ConfigEntry.Category("trades")
    @ConfigEntry.Gui.Tooltip
    public boolean forceModifiedTradeOffers = false;

    @ConfigEntry.Category("other")
    @ConfigEntry.Gui.Tooltip
    public boolean enableBlindnessAtLowHp = true;

}
