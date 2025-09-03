package com.min01.limbus.effect;

import java.util.UUID;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class OverheatEffect extends MobEffect
{
	public OverheatEffect()
	{
		super(MobEffectCategory.BENEFICIAL, 13045277);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, UUID.randomUUID().toString(), -4.0F, Operation.ADDITION);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, UUID.randomUUID().toString(), 0.8F, Operation.ADDITION);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, UUID.randomUUID().toString(), 20.0F / 100.0F, Operation.MULTIPLY_BASE);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, UUID.randomUUID().toString(), 10.0F / 100.0F, Operation.MULTIPLY_BASE);
	}
	
	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) 
	{
		return duration > 0;
	}
}
