package com.min01.limbus.util;

public class LimbusUtil 
{
	public static float getPercentage(float baseValue, float value)
	{
		return value / baseValue * 100.0F;
	}
	
	public static float percent(float baseValue, float percent)
	{
		return baseValue * percent / 100.0F;
	}
}
