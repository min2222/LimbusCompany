package com.min01.limbus.event;

import com.min01.limbus.LimbusCompany;
import com.min01.limbus.item.model.ModelTiantuiStarsBlade;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LimbusCompany.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler 
{
    @SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
    	event.registerLayerDefinition(ModelTiantuiStarsBlade.LAYER_LOCATION, ModelTiantuiStarsBlade::createBodyLayer);
    }
}
