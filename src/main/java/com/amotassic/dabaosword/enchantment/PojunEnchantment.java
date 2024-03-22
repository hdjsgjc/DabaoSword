package com.amotassic.dabaosword.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

public class PojunEnchantment extends Enchantment {
    public PojunEnchantment(Rarity weight, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(weight, target, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 1;
    }

    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        if (stack.getItem() instanceof AxeItem) {
            return true;
        }
        return super.isAcceptableItem(stack);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        ItemStack head = ((LivingEntity) target).getEquippedStack(EquipmentSlot.HEAD);
        ItemStack chest = ((LivingEntity) target).getEquippedStack(EquipmentSlot.CHEST);
        ItemStack legs = ((LivingEntity) target).getEquippedStack(EquipmentSlot.LEGS);
        ItemStack feet = ((LivingEntity) target).getEquippedStack(EquipmentSlot.FEET);
        if (target instanceof LivingEntity && !user.getWorld().isClient()) {
            if (!head.isEmpty()) {target.dropItem(head.getItem());head.setCount(0);}
            if (!chest.isEmpty()) {target.dropItem(chest.getItem());chest.setCount(0);}
            if (!legs.isEmpty()) {target.dropItem(legs.getItem());legs.setCount(0);}
            if (!feet.isEmpty()) {target.dropItem(feet.getItem());feet.setCount(0);}
        }
        super.onTargetDamaged(user, target, level);
    }
}