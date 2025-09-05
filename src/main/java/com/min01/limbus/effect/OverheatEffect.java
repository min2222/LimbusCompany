package com.min01.limbus.effect;

import java.util.UUID;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class OverheatEffect extends MobEffect
{
	public OverheatEffect()
	{
		super(MobEffectCategory.BENEFICIAL, 13045277);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, UUID.randomUUID().toString(), -6.0F, Operation.ADDITION);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, UUID.randomUUID().toString(), 0.8F, Operation.ADDITION);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, UUID.randomUUID().toString(), 20.0F / 100.0F, Operation.MULTIPLY_BASE);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, UUID.randomUUID().toString(), 10.0F / 100.0F, Operation.MULTIPLY_BASE);
	}
	
	@Override
	public void applyEffectTick(LivingEntity p_19467_, int p_19468_)
	{
		p_19467_.level.addAlwaysVisibleParticle(ParticleTypes.SMOKE, p_19467_.getX(), p_19467_.getEyeY() + 0.5D, p_19467_.getZ(), 0.0D, 0.0D, 0.0D);
	}
	
	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) 
	{
		return duration > 0;
	}
}
