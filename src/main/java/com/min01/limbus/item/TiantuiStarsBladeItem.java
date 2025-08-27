package com.min01.limbus.item;

import java.util.function.Consumer;

import com.min01.limbus.item.renderer.LimbusItemRenderer;
import com.min01.limbus.util.LimbusClientUtil;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class TiantuiStarsBladeItem extends SwordItem
{
	public TiantuiStarsBladeItem() 
	{
		super(Tiers.NETHERITE, 8, -2, new Item.Properties().stacksTo(1));
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment)
	{
		if(enchantment == Enchantments.MENDING || enchantment == Enchantments.UNBREAKING)
		{
			return false;
		}
		return super.canApplyAtEnchantingTable(stack, enchantment);
	}
	
	@Override
	public boolean hurtEnemy(ItemStack p_43278_, LivingEntity p_43279_, LivingEntity p_43280_)
	{
		p_43279_.invulnerableTime = 0;
		return super.hurtEnemy(p_43278_, p_43279_, p_43280_);
	}
	
	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) 
	{
		consumer.accept(new IClientItemExtensions()
		{
			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() 
			{
				return new LimbusItemRenderer(LimbusClientUtil.MC.getEntityModels());
			}
		});
	}
}
