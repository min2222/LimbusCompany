package com.min01.limbus.event;

import com.min01.limbus.LimbusCompany;
import com.min01.limbus.effect.LimbusEffects;
import com.min01.limbus.util.LimbusClientUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.Camera;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LimbusCompany.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEventHandlerForge
{
	@SubscribeEvent
	public static void onRenderPlayerPost(RenderPlayerEvent.Post event)
	{
		PoseStack stack = event.getPoseStack();
		Player player = event.getEntity();
		Camera camera = LimbusClientUtil.MC.gameRenderer.getMainCamera();
		MultiBufferSource bufferSource =  event.getMultiBufferSource();
		if(player.hasEffect(LimbusEffects.UNRELENTING_SPIRIT.get()))
		{
			stack.pushPose();
			float f = player.getBbWidth() * 1.8F;
			stack.scale(f, f, f);
			stack.mulPose(Axis.YP.rotationDegrees(-camera.getYRot()));
			stack.translate(0.0F, 1.4F, 0.0F);
			LimbusClientUtil.drawQuad(stack, bufferSource.getBuffer(RenderType.entityTranslucent(new ResourceLocation(String.format("%s:textures/entity/unrelenting_spirit_aura%d.png", LimbusCompany.MODID, player.tickCount % 15)))), f, f + 0.5F, 0.5F, LightTexture.FULL_BRIGHT);
			stack.popPose();
		}
		else if(player.hasEffect(LimbusEffects.UNRELENTING_SPIRIT_SHIN.get()))
		{
			stack.pushPose();
			float f = player.getBbWidth() * 1.8F;
			stack.scale(f, f, f);
			stack.mulPose(Axis.YP.rotationDegrees(-camera.getYRot()));
			stack.translate(0.0F, 1.4F, 0.0F);
			LimbusClientUtil.drawQuad(stack, bufferSource.getBuffer(RenderType.entityTranslucent(new ResourceLocation(String.format("%s:textures/entity/unrelenting_spirit_shin_aura%d.png", LimbusCompany.MODID, player.tickCount % 15)))), f, f + 0.5F, 0.5F, LightTexture.FULL_BRIGHT);
			stack.popPose();
		}
	}
}
