package com.min01.limbus.misc;

import com.min01.limbus.LimbusCompany;

import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.LivingEntity;

public class LimbusDamageSource
{
    public static final ResourceKey<DamageType> TREMOR_SCORCH = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(LimbusCompany.MODID, "tremor_scorch"));
    
    public static DamageSource causeTremorScorchDamage(RegistryAccess registryAccess)
    {
        return new DamageSource(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(TREMOR_SCORCH), (LivingEntity) null);
    }
}
