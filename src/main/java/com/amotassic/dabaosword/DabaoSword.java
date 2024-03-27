package com.amotassic.dabaosword;

import com.amotassic.dabaosword.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DabaoSword implements ModInitializer {
    public static final String MOD_ID = "dabaosword";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        LOGGER.info("Hello Fabric world!");
        ModItems.register();
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.NETHERITE_SWORD,ModItems.GUDINGDAO);
            content.addAfter(Items.LEATHER_BOOTS,ModItems.RATTAN_CHESTPLATE);
            content.addAfter(ModItems.RATTAN_CHESTPLATE,ModItems.RATTAN_LEGGINGS);
            content.addAfter(Items.EGG,ModItems.ARROW_RAIN);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.ENCHANTED_GOLDEN_APPLE,ModItems.PEACH);
        });
    }
}
