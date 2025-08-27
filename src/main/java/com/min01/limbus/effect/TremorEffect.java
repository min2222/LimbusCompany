package com.min01.limbus.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;

public class TremorEffect extends MobEffect
{
	public TremorEffect()
	{
		super(MobEffectCategory.HARMFUL, 16756224);
	}
	
	@Override
	public void applyEffectTick(LivingEntity p_19467_, int p_19468_) 
	{
		if(p_19467_ instanceof PathfinderMob mob)
		{
			mob.getNavigation().stop();
			mob.setTarget(null);
		}
		p_19467_.xxa = 0.0F;
		p_19467_.yya = 0.0F;
		p_19467_.zza = 0.0F;
	}
	
	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) 
	{
		return duration > 0;
	}
}
