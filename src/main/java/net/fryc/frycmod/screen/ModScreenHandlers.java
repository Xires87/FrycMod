package net.fryc.frycmod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.fryc.frycmod.FrycMod;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {

    public static ScreenHandlerType<ModSmithingScreenHandler> MOD_SMITHING_SCREEN_HANDLER;


    public static void registerAllScreenHandlers() {

        MOD_SMITHING_SCREEN_HANDLER =
        ScreenHandlerRegistry.registerSimple(new Identifier(FrycMod.MOD_ID, "copper_table"),
                ModSmithingScreenHandler::new);



    }

}
