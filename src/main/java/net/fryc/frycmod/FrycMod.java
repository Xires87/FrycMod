package net.fryc.frycmod;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fryc.frycmod.config.FrycmodConfig;
import net.fryc.frycmod.mobvar_hmrnsmith.WeaponsForMobs;
import net.fryc.frycmod.painting.ModPaintings;
import net.fryc.frycmod.rcstaffs_scrolls.ShouldTeleportRandomly;
import net.fryc.frycmod.spagyria.HaemorrhagePotions;
import net.fryc.frycmod.spagyria.ScrollsAndCursesPotions;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrycMod implements ModInitializer {
	public static final String MOD_ID = "frycmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static FrycmodConfig config;

	private static boolean mobvar_hmrnsmith_compat = false;
	private static boolean rcstaffs_scrollsncurses_compat = false;



	@Override
	public void onInitialize() {
		//config
		AutoConfig.register(FrycmodConfig.class, GsonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(FrycmodConfig.class).getConfig();

		//loader
		FabricLoader fabric = FabricLoader.getInstance();

		ModPaintings.registerPaintings();

		if(fabric.isModLoaded("threepotions")){
			if(fabric.isModLoaded("imbleeding") && config.enableSpagyriaAndHaemorrhageCompatibility){
				HaemorrhagePotions.registerHaemorrhagePotions();
			}
			if(fabric.isModLoaded("frycscrolls") && config.enableSpagyriaAndScrollsAndCursesCompatibility){
				ScrollsAndCursesPotions.registerScrollsAndCursesPotions();
			}
		}

		if(fabric.isModLoaded("hammersandtables") && config.enableHmrsNSmithingAndMobVariantsCompatibility){
			mobvar_hmrnsmith_compat = true;
		}

		if(fabric.isModLoaded("frycscrolls") && config.enableRecallStaffsAndScrollsAndCursesCompatibility){
			rcstaffs_scrollsncurses_compat = true;
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

	public static boolean recallStaffsScrollsAndCursesCompatibility(ServerPlayerEntity player) {
		if(rcstaffs_scrollsncurses_compat){
			return ShouldTeleportRandomly.hasChaoticTeleportationEffect(player);
		}
		return false;
	}
}
