package net.fryc.frycmod;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fryc.frycmod.config.FrycmodConfig;
import net.fryc.frycmod.mobvar_hmrnsmith.WeaponsForMobs;
import net.fryc.frycmod.painting.ModPaintings;
import net.fryc.frycmod.spagyria_haemorrhage.SpagyriaPotions;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrycMod implements ModInitializer {
	public static final String MOD_ID = "frycmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static FrycmodConfig config;

	private static boolean mobvar_hmrnsmith_compat = false;



	@Override
	public void onInitialize() {
		//config
		AutoConfig.register(FrycmodConfig.class, GsonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(FrycmodConfig.class).getConfig();

		//loader
		FabricLoader fabric = FabricLoader.getInstance();

		ModPaintings.registerPaintings();

		if(fabric.isModLoaded("threepotions") && fabric.isModLoaded("imbleeding") && config.enableSpagyriaAndHaemorrhageCompatibility){
			SpagyriaPotions.registerSpagyriaPotions();
		}

		if(fabric.isModLoaded("hammersandtables") && config.enableHmrsNSmithingAndMobVariantsCompatibility){
			mobvar_hmrnsmith_compat = true;
		}


	}

	public static ItemStack corsairSword(){
		if(mobvar_hmrnsmith_compat){
			return WeaponsForMobs.getSwordForCorsair();
		}
		return new ItemStack(Items.WOODEN_SWORD);
	}

	public static ItemStack undeadWarriorSword(){
		if(mobvar_hmrnsmith_compat){
			return WeaponsForMobs.getSwordForUndeadWarrior();
		}
		return new ItemStack(Items.STONE_SWORD);
	}
	public static ItemStack executionerAxe(){
		if(mobvar_hmrnsmith_compat){
			return WeaponsForMobs.getAxeForExecutioner();
		}
		return new ItemStack(Items.STONE_AXE);
	}
}
