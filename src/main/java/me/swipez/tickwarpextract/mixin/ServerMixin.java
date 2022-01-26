package me.swipez.tickwarpextract.mixin;

import me.swipez.tickwarpextract.helpers.TickSpeed;
import me.swipez.tickwarpextract.utils.TickCheck;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BooleanSupplier;

@Mixin(ServerWorld.class)
public class ServerMixin {


	@Final
	@Shadow
	private MinecraftServer server;

	@Inject(method = "tick", at = @At("HEAD"))
	public void tick(BooleanSupplier shouldKeepTicking, CallbackInfo ci) {
		TickCheck.addTick();
		TickCheck.setPlayercount(this.server.getCurrentPlayerCount());
		TickSpeed.tickrate(TickCheck.getTickMultiplier(), true);
	}
}
