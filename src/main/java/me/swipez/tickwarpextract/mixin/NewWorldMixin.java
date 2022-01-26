package me.swipez.tickwarpextract.mixin;

import me.swipez.tickwarpextract.utils.TickCheck;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class NewWorldMixin {
	@Inject(method = "tick", at = @At("HEAD"))
	public void tick(CallbackInfo ci){
		TickCheck.Init();
	}
}
