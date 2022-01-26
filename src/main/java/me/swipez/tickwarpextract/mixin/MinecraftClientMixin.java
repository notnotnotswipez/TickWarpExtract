package me.swipez.tickwarpextract.mixin;

import me.swipez.tickwarpextract.helpers.TickSpeed;
import me.swipez.tickwarpextract.network.CarpetClient;
import me.swipez.tickwarpextract.helpers.TickSpeed;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin
{
    @Shadow public ClientWorld world;
    
    @Inject(method = "disconnect(Lnet/minecraft/client/gui/screen/Screen;)V", at = @At("HEAD"))
    private void onCloseGame(Screen screen, CallbackInfo ci)
    {
        CarpetClient.disconnect();
    }
    
    @Inject(at = @At("HEAD"), method = "tick")
    private void onClientTick(CallbackInfo info) {
        if (this.world != null) {
            TickSpeed.tick();
        }
    }
}
