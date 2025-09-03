package com.min01.limbus.event;

import com.min01.limbus.LimbusCompany;
import com.min01.limbus.effect.LimbusEffects;
import com.min01.limbus.util.LimbusUtil;

import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LimbusCompany.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandlerForge
{
	@SubscribeEvent
	public static void onMobEffectAdded(MobEffectEvent.Added event)
	{
		if(event.getEffectInstance().getEffect() == LimbusEffects.UNRELENTING_SPIRIT_SHIN.get() && event.getEntity().hasEffect(LimbusEffects.UNRELENTING_SPIRIT.get()))
		{
			event.getEntity().removeEffect(LimbusEffects.UNRELENTING_SPIRIT.get());
		}
	}
	
	@SubscribeEvent
	public static void onLivingDamage(LivingDamageEvent event)
	{
		if(event.getEntity().hasEffect(LimbusEffects.UNRELENTING_SPIRIT_SHIN.get()) || event.getEntity().hasEffect(LimbusEffects.OVERHEAT.get()))
		{
			float percent = 0.0F;
			if(event.getEntity().hasEffect(LimbusEffects.UNRELENTING_SPIRIT_SHIN.get()))
			{
				percent += 20.0F;
			}
			if(event.getEntity().hasEffect(LimbusEffects.OVERHEAT.get()))
			{
				percent += 10.0F;
			}
			event.setAmount(event.getAmount() - LimbusUtil.percent(event.getAmount(), percent));
		}
	}
}
