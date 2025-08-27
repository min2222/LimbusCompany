package com.min01.limbus.misc;

import com.min01.limbus.LimbusCompany;
import com.min01.limbus.item.LimbusItems;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class LimbusCreativeTabs 
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LimbusCompany.MODID);

    public static final RegistryObject<CreativeModeTab> LIMBUS_COMPANY = CREATIVE_MODE_TAB.register("limbuscompany", () -> CreativeModeTab.builder()
    		.title(Component.translatable("itemGroup.limbuscompany"))
    		.icon(() -> new ItemStack(LimbusItems.TIGERMARK_ROUND.get()))
    		.displayItems((enabledFeatures, output) -> 
    		{
    			output.accept(LimbusItems.TIGERMARK_ROUND.get());
    			output.accept(LimbusItems.SAVAGE_TIGERMARK_ROUND.get());
    			output.accept(LimbusItems.TIANTUI_STARS_BLADE.get());
    		}).build());
}
