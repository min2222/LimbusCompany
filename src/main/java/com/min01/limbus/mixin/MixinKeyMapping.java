package com.min01.limbus.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.min01.limbus.effect.LimbusEffects;
import com.min01.limbus.util.LimbusClientUtil;

import net.minecraft.client.KeyMapping;

@Mixin(KeyMapping.class)
public class MixinKeyMapping
{
	@Inject(at = @At("TAIL"), method = "isDown", cancellable = true)
	private void isDown(CallbackInfoReturnable<Boolean> cir)
	{
		if(LimbusClientUtil.MC.player != null)
		{
			KeyMapping mapping = KeyMapping.class.cast(this);
			if(mapping == LimbusClientUtil.MC.options.keyJump || mapping == LimbusClientUtil.MC.options.keyRight || mapping == LimbusClientUtil.MC.options.keyLeft || mapping == LimbusClientUtil.MC.options.keyUp || mapping == LimbusClientUtil.MC.options.keyDown)
			{
				if(LimbusClientUtil.MC.player.hasEffect(LimbusEffects.TREMOR.get()) || LimbusClientUtil.MC.player.hasEffect(LimbusEffects.TREMOR_SCORCH.get()))
				{
					cir.setReturnValue(false);
				}
			}
		}
	}
}
