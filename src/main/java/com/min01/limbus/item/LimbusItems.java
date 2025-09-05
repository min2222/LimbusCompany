package com.min01.limbus.item;

import java.util.function.Supplier;

import com.min01.limbus.LimbusCompany;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LimbusItems
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LimbusCompany.MODID);

	public static final RegistryObject<Item> LOGO = ITEMS.register("logo", () -> new Item(new Item.Properties()));
	
	public static final RegistryObject<Item> TIGERMARK_ROUND = ITEMS.register("tigermark_round", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SAVAGE_TIGERMARK_ROUND = ITEMS.register("savage_tigermark_round", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> TIANTUI_STARS_BLADE = ITEMS.register("tiantui_stars_blade", () -> new TiantuiStarsBladeItem());
	
	public static RegistryObject<Item> registerBlockItem(String name, Supplier<Block> block, Item.Properties properties)
	{
		return ITEMS.register(name, () -> new BlockItem(block.get(), properties));
	}
	
	public static RegistryObject<Item> registerSpawnEgg(String name, Supplier<EntityType<? extends Mob>> type, int color1, int color2)
	{
		return ITEMS.register(name, () -> new ForgeSpawnEggItem(type, color1, color2, new Item.Properties()));
	}
}
