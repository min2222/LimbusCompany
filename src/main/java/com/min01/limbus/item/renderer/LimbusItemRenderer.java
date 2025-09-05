package com.min01.limbus.item.renderer;

import com.min01.limbus.LimbusCompany;
import com.min01.limbus.item.TiantuiStarsBladeItem;
import com.min01.limbus.item.model.ModelTiantuiStarsBlade;
import com.min01.limbus.util.LimbusClientUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class LimbusItemRenderer extends BlockEntityWithoutLevelRenderer
{
	public final ModelTiantuiStarsBlade bladeModel;
	
	public LimbusItemRenderer(EntityModelSet modelSet)
	{
		super(LimbusClientUtil.MC.getBlockEntityRenderDispatcher(), modelSet);
		this.bladeModel = new ModelTiantuiStarsBlade(modelSet.bakeLayer(ModelTiantuiStarsBlade.LAYER_LOCATION));
	}
	
	@Override
	public void renderByItem(ItemStack p_108830_, ItemDisplayContext p_108831_, PoseStack p_108832_, MultiBufferSource p_108833_, int p_108834_, int p_108835_) 
	{
		if(p_108830_.getItem() instanceof TiantuiStarsBladeItem)
		{
			p_108832_.pushPose();
			VertexConsumer consumer = p_108833_.getBuffer(RenderType.entityCutoutNoCull(this.getTexture(p_108830_)));
			p_108832_.scale(-1.0F, -1.0F, 1.0F);
			p_108832_.translate(0.0F, -1.5F, 0.0F);
			this.setupDisplay(p_108831_, p_108832_);
			this.bladeModel.setupAnim(p_108830_);
			this.bladeModel.renderToBuffer(p_108832_, consumer, p_108834_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
			p_108832_.popPose();
		}
	}
	
	public void setupDisplay(ItemDisplayContext ctx, PoseStack stack)
	{
		if(ctx == ItemDisplayContext.GUI)
		{
			stack.translate(0.0, 0.5, -0.5);
			stack.mulPose(Axis.YP.rotationDegrees(90.0F));
			stack.mulPose(Axis.XP.rotationDegrees(-45.0F));
			stack.scale(0.5F, 0.5F, 0.5F);
		}
		if(ctx == ItemDisplayContext.FIXED || ctx == ItemDisplayContext.GROUND)
		{
			stack.translate(-1.0, 0.5, 0.5);
			stack.mulPose(Axis.YP.rotationDegrees(-90.0F));
			stack.mulPose(Axis.XP.rotationDegrees(-45.0F));
			stack.scale(0.5F, 0.5F, 0.5F);
		}
		if(ctx == ItemDisplayContext.HEAD)
		{
			stack.translate(-0.5, -0.5, -1.0);
		}
		if(ctx == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND || ctx == ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
		{
			stack.translate(-0.5, 0.5, 2.0);
			stack.mulPose(Axis.XP.rotationDegrees(-95.0F));
		}
		if(ctx == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND || ctx == ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
		{
			stack.translate(-0.5, 1.0, 2.0);
			stack.mulPose(Axis.XP.rotationDegrees(-105.0F));
		}
	}
	
	public ResourceLocation getTexture(ItemStack stack)
	{
		return new ResourceLocation(String.format("%s:textures/item/tiantui_stars_blade%d.png", LimbusCompany.MODID, LimbusClientUtil.MC.player.tickCount % 4));
	}
}
