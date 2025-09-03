package com.min01.limbus.effect;

import com.min01.limbus.LimbusCompany;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LimbusEffects 
{
	public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, LimbusCompany.MODID);
	
	public static final RegistryObject<MobEffect> TREMOR = EFFECTS.register("tremor", () -> new TremorEffect());
	public static final RegistryObject<MobEffect> TREMOR_SCORCH = EFFECTS.register("tremor_scorch", () -> new TremorScorchEffect());
	
	public static final RegistryObject<MobEffect> UNRELENTING_SPIRIT = EFFECTS.register("unrelenting_spirit", () -> new UnrelentingSpiritEffect());
	public static final RegistryObject<MobEffect> UNRELENTING_SPIRIT_SHIN = EFFECTS.register("unrelenting_spirit_shin", () -> new UnrelentingSpiritShinEffect());
	
	public static final RegistryObject<MobEffect> OVERHEAT = EFFECTS.register("overheat", () -> new OverheatEffect());
}
