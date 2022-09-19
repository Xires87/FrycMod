package net.fryc.frycmod.items.custom;

import net.fryc.frycmod.effects.ModEffects;
import net.fryc.frycmod.tag.ModItemTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ModArmorItems extends ArmorItem {

    public ModArmorItems(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                if(hasFullSuitOfArmorOn(player)) {
                    if(hasCorrectArmor(player)){
                        if(!player.hasStatusEffect(ModEffects.IMMUNITY)){
                            addArmorEffects(player);
                        }
                    }
                    else if(player.getActiveStatusEffects().containsKey(ModEffects.IMMUNITY)) removeArmorEffects(player);
                }
                else if(player.getActiveStatusEffects().containsKey(ModEffects.IMMUNITY)) removeArmorEffects(player);
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void addArmorEffects(PlayerEntity player) {
        player.addStatusEffect(new StatusEffectInstance(ModEffects.IMMUNITY, 100000, 0));
    }

    private void removeArmorEffects(PlayerEntity player) {
        if(player.getActiveStatusEffects().get(ModEffects.IMMUNITY).getDuration() > 10000) player.removeStatusEffect(ModEffects.IMMUNITY);
    }
    private boolean hasCorrectArmor(PlayerEntity player){
        return player.getInventory().getArmorStack(0).isIn(ModItemTags.WITHER_ARMORS) && player.getInventory().getArmorStack(1).isIn(ModItemTags.WITHER_ARMORS)
                && player.getInventory().getArmorStack(2).isIn(ModItemTags.WITHER_ARMORS) && player.getInventory().getArmorStack(3).isIn(ModItemTags.WITHER_ARMORS);
    }
    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !chestplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

}
