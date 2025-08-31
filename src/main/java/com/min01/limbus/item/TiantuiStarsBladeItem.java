package com.min01.limbus.item;

import java.util.List;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.min01.limbus.effect.LimbusEffects;
import com.min01.limbus.item.renderer.LimbusItemRenderer;
import com.min01.limbus.util.LimbusClientUtil;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class TiantuiStarsBladeItem extends SwordItem
{
    public static final Predicate<ItemStack> AMMO = (stack) ->
    {
        return stack.getItem() == LimbusItems.TIGERMARK_ROUND.get().asItem();
    };
    
    public static final Predicate<ItemStack> AMMO2 = (stack) ->
    {
        return stack.getItem() == LimbusItems.SAVAGE_TIGERMARK_ROUND.get().asItem();
    };
    
	public TiantuiStarsBladeItem() 
	{
		super(Tiers.NETHERITE, 7, -2, new Item.Properties().stacksTo(1));
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_)
	{
		ItemStack stack = p_41433_.getItemInHand(p_41434_);
        ItemStack ammo = this.findAmmo(p_41433_);
        if(!ammo.isEmpty() && !isActive(stack) && !isShiftActive(stack))
        {
        	if(!p_41433_.isShiftKeyDown())
        	{
            	if(!p_41433_.getAbilities().instabuild)
            	{
                	ammo.shrink(1);
            	}
            	p_41433_.playSound(SoundEvents.FIRECHARGE_USE);
            	p_41433_.getCooldowns().addCooldown(this, 20);
            	setActive(stack, true);
            	setSavage(stack, ammo.is(LimbusItems.SAVAGE_TIGERMARK_ROUND.get()));
    			return InteractionResultHolder.consume(stack);
        	}
        	else if(ammo.getCount() >= 6)
        	{
            	if(!p_41433_.getAbilities().instabuild)
            	{
                	ammo.shrink(6);
            	}
            	p_41433_.playSound(SoundEvents.FIRECHARGE_USE);
            	p_41433_.getCooldowns().addCooldown(this, 200);
            	setShiftActive(stack, true);
            	setSavage(stack, ammo.is(LimbusItems.SAVAGE_TIGERMARK_ROUND.get()));
    			return InteractionResultHolder.consume(stack);
        	}
		}
		return super.use(p_41432_, p_41433_, p_41434_);
	}
	
	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack)
	{
	    ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
	    Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(slot, stack);
		if(slot == EquipmentSlot.MAINHAND)
		{
		    for(Entry<Attribute, AttributeModifier> entry : map.entries())
		    {
		    	if(entry.getKey() != Attributes.ATTACK_DAMAGE && entry.getKey() != Attributes.ATTACK_SPEED)
		    	{
				    builder.put(entry.getKey(), entry.getValue());
		    	}
		    	else if(entry.getKey() == Attributes.ATTACK_DAMAGE)
		    	{
		    		double amount = entry.getValue().getAmount();
		    		if(isActive(stack))
		    		{
		    			if(isSavage(stack))
		    			{
		    				amount += 5.0F;
		    			}
		    			else
		    			{
			    			amount += 3.0F;
		    			}
		    		}
		    		else if(isShiftActive(stack))
		    		{
		    			if(isSavage(stack))
		    			{
		    				amount += 12.0F;
		    			}
		    			else
		    			{
			    			amount += 7.0F;
		    			}
		    		}
		    		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", amount, AttributeModifier.Operation.ADDITION));
		    	}
		    	else if(entry.getKey() == Attributes.ATTACK_SPEED)
		    	{
		    		double amount = entry.getValue().getAmount();
		    		if(isActive(stack))
		    		{
		    			if(isSavage(stack))
		    			{
		    				amount += 0.5F;
		    			}
		    			else
		    			{
			    			amount += 0.2F;
		    			}
		    		}
		    		else if(isShiftActive(stack))
		    		{
		    			if(isSavage(stack))
		    			{
		    				amount += 1.0F;
		    			}
		    			else
		    			{
			    			amount += 0.5F;
		    			}
		    		}
		    		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", amount, AttributeModifier.Operation.ADDITION));
		    	}
		    }
		}
		return builder.build();
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
		if(isActive(p_43278_))
		{
			int fireSecond = isSavage(p_43278_) ? 4 : 3;
			p_43279_.setSecondsOnFire(fireSecond);
			setActive(p_43278_, false);
			setSavage(p_43278_, false);
		}
		else if(isShiftActive(p_43278_))
		{
			if(isSavage(p_43278_))
			{
				List<LivingEntity> list = p_43279_.level.getEntitiesOfClass(LivingEntity.class, p_43280_.getBoundingBox().inflate(4), t -> t != p_43280_ && !t.isAlliedTo(p_43280_));
				list.forEach(t -> 
				{
					t.setSecondsOnFire(8);
					t.addEffect(new MobEffectInstance(LimbusEffects.TREMOR_SCORCH.get(), 60));
					p_43280_.doHurtTarget(t);
				});
			}
			else
			{
				List<LivingEntity> list = p_43279_.level.getEntitiesOfClass(LivingEntity.class, p_43280_.getBoundingBox().inflate(2.5F), t -> t != p_43280_ && !t.isAlliedTo(p_43280_));
				list.forEach(t -> 
				{
					t.setSecondsOnFire(6);
					t.addEffect(new MobEffectInstance(LimbusEffects.TREMOR.get(), 40));
					p_43280_.doHurtTarget(t);
				});
			}
			setShiftActive(p_43278_, false);
			setSavage(p_43278_, false);
		}
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
	
	@Override
	public boolean canBeDepleted() 
	{
		return false;
	}
	
	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) 
	{
		return newStack.getItem() != this;
	}
	
    public static int getFrame(ItemStack stack)
    {
        CompoundTag tag = stack.getTag();
        return tag != null ? tag.getInt("Frame") : 0;
    }

    public static void setFrame(ItemStack stack, int frame)
    {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putInt("Frame", frame);
    }
	
    public static boolean isSavage(ItemStack stack)
    {
        CompoundTag tag = stack.getTag();
        return tag != null ? tag.getBoolean("isSavage") : false;
    }

    public static void setSavage(ItemStack stack, boolean savage)
    {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putBoolean("isSavage", savage);
    }
    
    public static boolean isShiftActive(ItemStack stack)
    {
        CompoundTag tag = stack.getTag();
        return tag != null ? tag.getBoolean("isShiftActive") : false;
    }

    public static void setShiftActive(ItemStack stack, boolean active)
    {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putBoolean("isShiftActive", active);
    }
	
    public static boolean isActive(ItemStack stack)
    {
        CompoundTag tag = stack.getTag();
        return tag != null ? tag.getBoolean("isActive") : false;
    }

    public static void setActive(ItemStack stack, boolean active)
    {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putBoolean("isActive", active);
    }
	
    public ItemStack findAmmo(Player entity) 
    {
        for(int i = 0; i < entity.getInventory().getContainerSize(); ++i)
        {
            ItemStack stack = entity.getInventory().getItem(i);
            if(AMMO.test(stack))
            {
                return stack;
            }
            else if(AMMO2.test(stack))
            {
                return stack;
            }
        }
        return ItemStack.EMPTY;
    }
}
