package com.min01.limbus.sound;

import com.min01.limbus.LimbusCompany;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LimbusSounds 
{
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, LimbusCompany.MODID);
	
	public static final RegistryObject<SoundEvent> RELOAD = registerSound("reload");
	public static final RegistryObject<SoundEvent> SHIFT_ACTIVE = registerSound("shift_active");
	
	public static RegistryObject<SoundEvent> registerSound(String name) 
	{
		return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(LimbusCompany.MODID, name)));
    }
}
