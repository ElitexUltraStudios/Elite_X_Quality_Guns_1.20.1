package com.elitexstudios.registeration_center;

import com.elitexstudios.elitex.EliteXQualityGuns;
import com.tacz.guns.init.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

//Author Elite X

public class EliteXCreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB , EliteXQualityGuns.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ELITE_X_CREATIVE_TAB = CREATIVE_MODE_TABS.register("elitex",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ElitexItemRegistry.CREATIVE_ICON.get()))// Your custom icon
                    .title(Component.translatable("creative_tab.elitex")) // Custom tab title
                    .displayItems((parameters, output) -> {

                        // First you Get base item 'modern_kinetic_gun' from the main mod
                        Item GunItem = ModItems.MODERN_KINETIC_GUN.get();

                        // Add items with proper NBT data , Fire Modes are  "SEMI , AUTO , BURST"

                        // if i wanna Keep things organized and clean code then imma be dividing them into different categories to make sure they fit the same
                        //Pistols
                        output.accept(createCustomNBTItem(GunItem, "elitex:colt_m1911x1", 7, "SEMI", true, "elitex.gun.colt_m1911x1.name"));
                        output.accept(createCustomNBTItem(GunItem, "elitex:jrx", 20, "SEMI", true, "elitex.gun.jrx.name"));
                        output.accept(createCustomNBTItem(GunItem, "elitex:five_seven", 20, "SEMI", true, "elitex.gun.five_seven.name"));
                        output.accept(createCustomNBTItem(GunItem, "elitex:srz_2011", 16, "SEMI", true, "elitex.gun.srz_2011.name"));

                        //Assault Rifles
                        output.accept(createCustomNBTItem(GunItem, "elitex:ak47x", 30, "AUTO", true, "elitex.gun.ak47x.name"));
                        output.accept(createCustomNBTItem(GunItem, "elitex:m4_sopmod", 35, "AUTO", true, "elitex.gun.m4_sopmod.name"));
                        output.accept(createCustomNBTItem(GunItem, "elitex:mcs_spear", 20, "AUTO", true, "elitex.gun.mcs_spear.name"));
                        output.accept(createCustomNBTItem(GunItem, "elitex:famas_f1", 25, "AUTO", true, "elitex.gun.famas_f1.name"));
                        output.accept(createCustomNBTItem(GunItem, "elitex:akx105", 30, "AUTO", true, "elitex.gun.akx105.name"));


                        //Wonder Weapons
                        output.accept(createCustomNBTItem(GunItem, "elitex:ray_gun_mk2", 21, "BURST", true, "elitex.gun.ray_gun_mk2.name"));
                        output.accept(createCustomNBTItem(GunItem, "elitex:wonder_waffle", 3, "SEMI", true, "elitex.gun.wonder_waffle.name"));
                        output.accept(createCustomNBTItem(GunItem, "elitex:mustang_and_sally", 12, "SEMI", true, "elitex.gun.mustang_and_sally.name"));
                        output.accept(createCustomNBTItem(GunItem, "elitex:origin_electric_staff", 9, "SEMI", false, "elitex.gun.origin_electric_staff.name"));
                        output.accept(createCustomNBTItem(GunItem, "elitex:origin_fire_staff", 10, "SEMI", false, "elitex.gun.origin_fire_staff.name"));
                        output.accept(createCustomNBTItem(GunItem, "elitex:origin_ice_staff", 10, "SEMI", false, "elitex.gun.origin_ice_staff.name"));
                        output.accept(createCustomNBTItem(GunItem, "elitex:origin_wind_staff", 10, "SEMI", false, "elitex.gun.origin_wind_staff.name"));

                        //Shotguns
                        output.accept(createCustomNBTItem(GunItem, "elitex:benelli_super", 8, "SEMI", true, "elitex.gun.benelli_super.name"));

                        //Bolt Action Rifles
                        output.accept(createCustomNBTItem(GunItem, "elitex:kar98k", 5, "SEMI", false, "elitex.gun.kar98k.name"));

                        // Later add normal items like this if I wanna add custom items for crafting purposes
                        // output.accept(ElitexItemRegistry.Custom_ITEM.get());

                    })
                    .build());



    private static ItemStack createCustomNBTItem(Item baseItem, String gunId, int ammoCount, String fireMode, boolean hasBulletInBarrel, String displayName) {
        ItemStack stack = new ItemStack(baseItem);
        CompoundTag tag = new CompoundTag();

        // Add all required NBT data
        tag.putString("GunId", gunId); // Unique gun identifier
        tag.putInt("GunCurrentAmmoCount", ammoCount); // Current ammo count
        tag.putString("GunFireMode", fireMode); // Fire mode (e.g., SEMI, AUTO , Burst)
        tag.putByte("HasBulletInBarrel", (byte) (hasBulletInBarrel ? 1 : 0)); // 1 for true, 0 for true

        stack.setTag(tag); // Attach the tag to the item stack

        // Set the custom display name and disable italics
        stack.setHoverName(Component.translatable(displayName).withStyle(style -> style.withItalic(false)));

        return stack;
    }


}
