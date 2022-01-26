package me.swipez.tickwarpextract.mixin;

import me.swipez.tickwarpextract.helpers.TickSpeed;
import me.swipez.tickwarpextract.utils.TickCheck;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin
{
	@Inject(at = @At("HEAD"), method = "tick", cancellable = true)
	public void tick(CallbackInfo ci){
		PlayerEntity playerEntity = (PlayerEntity) (Object) this;
		EntityAttributeInstance att = playerEntity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
		att.setBaseValue(TickCheck.getMovementModifier());
		playerEntity.setMovementSpeed(TickCheck.getMovementModifier());
		int potency = 0;
		if (TickCheck.getMovementModifier() > 0.12){
			potency = 1;
		}
		else if (TickCheck.getMovementModifier() > 0.15){
			potency = 2;
		}
		else if (TickCheck.getMovementModifier() > 0.17){
			potency = 3;
		}
		else if (TickCheck.getMovementModifier() > 0.18){
			potency = 4;
		}
		else if (TickCheck.getMovementModifier() > 0.2){
			potency = 5;
		}
		if (potency > 0){
			playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(3), 6, potency, true, false));
		}
		playerEntity.updateNeeded = true;
		int seconds = 60;
		int ticks = (seconds*60);
		if (TickCheck.getTicks() >= ticks) {
			TickCheck.addMultiplier();
			playerEntity.sendMessage(Text.of("§c[!] The world is now §d"+TickCheck.getMultiplier()+"x §cfaster"), false);
			TickCheck.inches = 0;
			TickCheck.setTicks(0F);
		}
	}
}
