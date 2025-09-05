package com.min01.limbus;

import com.min01.limbus.effect.LimbusEffects;
import com.min01.limbus.item.LimbusItems;
import com.min01.limbus.misc.LimbusCreativeTabs;
import com.min01.limbus.sound.LimbusSounds;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LimbusCompany.MODID)
public class LimbusCompany
{
	public static final String MODID = "limbuscompany";
	
	public LimbusCompany() 
	{
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		LimbusItems.ITEMS.register(bus);
		LimbusCreativeTabs.CREATIVE_MODE_TAB.register(bus);
		LimbusEffects.EFFECTS.register(bus);
		LimbusSounds.SOUNDS.register(bus);
	}
}