package net.fryc.frycmod.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "frycmod")
public class FrycmodConfig implements ConfigData {


    @ConfigEntry.Gui.RequiresRestart
    public boolean enableSpagyriaAndHaemorrhageCompatibility = true;

    @ConfigEntry.Gui.RequiresRestart
    public boolean enableSpagyriaAndScrollsAndCursesCompatibility = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableHmrsNSmithingAndMobVariantsCompatibility = true;

    @ConfigEntry.Gui.RequiresRestart
    public boolean enableRecallStaffsAndScrollsAndCursesCompatibility = true;

    //@ConfigEntry.Gui.RequiresRestart
    //public boolean enableHmrsNSmithingAndRecallStaffsCompatibility = true;
}
