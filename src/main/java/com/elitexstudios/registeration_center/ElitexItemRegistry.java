package com.elitexstudios.registeration_center;

import com.elitexstudios.elitex.EliteXQualityGuns;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ElitexItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS , EliteXQualityGuns.MOD_ID);

    // Register the Creative Tab Icon Item
    public static final RegistryObject<Item> CREATIVE_ICON = ITEMS.register("creative_icon",
            () -> new Item(new Item.Properties()) {
                @Override
                public boolean isFoil(ItemStack stack) {
                    return false; // No glowing effect
                }

                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return false; // Cannot be enchanted
                }

                @Override
                public boolean canBeDepleted() {
                    return false; // Indestructible
                }
            });

    //Add More items here

}
