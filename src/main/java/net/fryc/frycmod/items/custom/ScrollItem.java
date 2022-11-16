package net.fryc.frycmod.items.custom;

import net.fryc.frycmod.items.ModItems;
import net.fryc.frycmod.tag.ModItemTags;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;


public class ScrollItem extends Item {
    public ScrollItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        ItemStack main = user.getMainHandStack();
        ItemStack off = user.getOffHandStack();
        if(!off.isIn(ModItemTags.SCROLLS)){
            return TypedActionResult.fail(stack);
        }
        else if(main.isIn(ModItemTags.SCROLLS)){
            return TypedActionResult.fail(stack);
        }
        else if(main.isEnchantable()){
            if(off.isOf(ModItems.MAGIC_SCROLL_ARMOR) && main.getItem() instanceof ArmorItem){
                main.addEnchantment(scrollArmor(), 1);
                off.setCount(off.getCount() - 1);
                user.getWorld().playSound(user, user.getBlockPos(), SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.PLAYERS, 0.7f, 1.0f);
                return TypedActionResult.consume(stack);
            }
            else if(off.isOf(ModItems.MAGIC_SCROLL_WEAPON) && (main.getItem() instanceof SwordItem || main.getItem() instanceof AxeItem)){
                main.addEnchantment(scrollWeapon(), 1);
                off.setCount(off.getCount() - 1);
                user.getWorld().playSound(user, user.getBlockPos(), SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.PLAYERS, 0.7f, 1.0f);
                return TypedActionResult.consume(stack);
            }
            else if(off.isOf(ModItems.MAGIC_SCROLL_TOOL) && main.getItem() instanceof MiningToolItem){
                main.addEnchantment(scrollTool(), 1);
                off.setCount(off.getCount() - 1);
                user.getWorld().playSound(user, user.getBlockPos(), SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.PLAYERS, 0.7f, 1.0f);
                return TypedActionResult.consume(stack);
            }

            return TypedActionResult.fail(stack);
        }
        else return TypedActionResult.fail(stack);
    }

    public static net.minecraft.enchantment.Enchantment scrollArmor(){
        int i = (int) ((Math.random()*4)+1);
        return switch (i) {
            case 1 -> Enchantments.PROTECTION;
            case 2 -> Enchantments.FIRE_PROTECTION;
            case 3-> Enchantments.BLAST_PROTECTION;
            case 4-> Enchantments.PROJECTILE_PROTECTION;

            default -> null;
        };
    }

    public static net.minecraft.enchantment.Enchantment scrollTool(){
        int i = (int) ((Math.random()*2)+1);
        return switch (i) {
            case 1 -> Enchantments.EFFICIENCY;
            case 2 -> Enchantments.UNBREAKING;

            default -> null;
        };
    }

    public static net.minecraft.enchantment.Enchantment scrollWeapon(){
        int i = (int) ((Math.random()*4)+1);
        return switch (i) {
            case 1 -> Enchantments.SHARPNESS;
            case 2 -> Enchantments.SMITE;
            case 3 -> Enchantments.BANE_OF_ARTHROPODS;
            case 4 -> Enchantments.KNOCKBACK;

            default -> null;
        };
    }

}
