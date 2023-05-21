package net.fryc.frycmod.unused;


//@Mixin(ArmorItem.class)
public class ArmorsMixin {
    /*
    @Shadow
    private static @Final UUID[] MODIFIERS;

    //adds movement speed attribute for armors and max health for undead armor
    @ModifyVariable(method = "<init>", at = @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableMultimap$Builder;build()Lcom/google/common/collect/ImmutableMultimap;"))
    private ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> heavy(ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder, ArmorMaterial material, EquipmentSlot slot) {
        if(material == ArmorMaterials.NETHERITE ||
                material == ArmorMaterials.DIAMOND ||
                material == ArmorMaterials.GOLD ||
                material == ArmorMaterials.IRON ||
                material == ModArmorMaterials.COPPER ||
                material == ModArmorMaterials.NUGGET_COPPER ||
                material == ModArmorMaterials.INGOT_COPPER ||
                material == ModArmorMaterials.NUGGET_IRON ||
                material == ModArmorMaterials.INGOT_IRON ||
                material == ModArmorMaterials.GOLD ||
                material == ModArmorMaterials.DIAMOND_GOLD){
            builder.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(
                    MODIFIERS[slot.getEntitySlotId()], "Armor movement speed penalty",
                    -0.03, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        if(material == ModArmorMaterials.ECHO_WARDEN_BONE){
            builder.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(
                    MODIFIERS[slot.getEntitySlotId()], "Armor max health",
                    1, EntityAttributeModifier.Operation.ADDITION));
        }


        return builder;
    }

    //prevents player from right-click armor wearing when holding magic scroll for armor
    @Inject(method = "use(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/TypedActionResult;", at = @At("HEAD"), cancellable = true)
    private void dontWearArmor(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> ret) {
        ItemStack itemStack = user.getStackInHand(hand);
        if(user.getOffHandStack().isOf(ModItems.MAGIC_SCROLL_ARMOR)) ret.setReturnValue(TypedActionResult.fail(itemStack));
    }

     */
}
