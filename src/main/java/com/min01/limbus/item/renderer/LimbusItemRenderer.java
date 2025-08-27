package com.min01.limbus.item.renderer;

import java.util.HashMap;
import java.util.Map;

import com.min01.limbus.LimbusCompany;
import com.min01.limbus.item.TiantuiStarsBladeItem;
import com.min01.limbus.item.model.ModelTiantuiStarsBlade;
import com.min01.limbus.util.LimbusClientUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

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
	
	public final Map<ItemStack, Integer> frameMap = new HashMap<>();
	
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
			if(!this.frameMap.containsKey(p_108830_))
			{
				this.frameMap.put(p_108830_, 0);
			}
			else
			{
				int frame = this.frameMap.get(p_108830_);
				if(frame >= 5)
				{
					this.frameMap.put(p_108830_, 0);
				}
				else
				{
					this.frameMap.put(p_108830_, frame + 1);
				}
			}
			p_108832_.pushPose();
			VertexConsumer consumer = p_108833_.getBuffer(RenderType.entityCutoutNoCull(this.getTexture(p_108830_)));
			p_108832_.scale(-1.0F, -1.0F, 1.0F);
			p_108832_.translate(0.0F, -1.5F, 0.0F);
			this.bladeModel.renderToBuffer(p_108832_, consumer, p_108834_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
			p_108832_.popPose();
		}
	}
	
	public ResourceLocation getTexture(ItemStack stack)
	{
		return new ResourceLocation(String.format("%s:textures/item/tiantui_stars_blade%d.png", LimbusCompany.MODID, this.frameMap.getOrDefault(stack, 0)));
	}
}
