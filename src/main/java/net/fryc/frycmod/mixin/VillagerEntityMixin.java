package net.fryc.frycmod.mixin;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.fryc.frycmod.gamerules.ModGameRules;
import net.fryc.frycmod.mixhelpers.ModTradeOffers;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.InteractionObserver;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.village.*;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(VillagerEntity.class)
abstract class VillagerEntityMixin extends MerchantEntity implements InteractionObserver, VillagerDataContainer {


    public VillagerEntityMixin(EntityType<? extends VillagerEntity> entityType, World world) {
        super(entityType, world);
    }

    //Overwrites vanilla trade offers for Armorer, Toolsmith, Cleric, Weaponsmith and Librarian
    @ModifyVariable(method = "fillRecipes()V", at = @At("STORE"))
    private Int2ObjectMap<TradeOffers.Factory[]> injected(Int2ObjectMap<TradeOffers.Factory[]> int2ObjectMap) {
        if(int2ObjectMap != null){
            VillagerData villagerData = ((VillagerEntity)(Object)this).getVillagerData();
            if((world.getGameRules().getBoolean(ModGameRules.OVERWRITE_TOOL_TRADE_OFFERS) && (villagerData.getProfession() == VillagerProfession.ARMORER || villagerData.getProfession() == VillagerProfession.TOOLSMITH ||
                    villagerData.getProfession() == VillagerProfession.CLERIC || villagerData.getProfession() == VillagerProfession.WEAPONSMITH)) ||
                    (villagerData.getProfession() == VillagerProfession.LIBRARIAN && world.getGameRules().getBoolean(ModGameRules.OVERWRITE_LIBRARIAN_TRADE_OFFERS))){
                int2ObjectMap = ModTradeOffers.PROFESSION_TO_LEVELED_TRADE.get(villagerData.getProfession());
            }
        }
        return int2ObjectMap;
    }

}
