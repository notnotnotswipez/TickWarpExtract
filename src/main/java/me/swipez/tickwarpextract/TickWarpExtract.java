package me.swipez.tickwarpextract;

import me.swipez.tickwarpextract.helpers.TickSpeed;
import me.swipez.tickwarpextract.utils.TickCheck;
import net.fabricmc.api.ModInitializer;

public class TickWarpExtract implements ModInitializer {
    @Override
    public void onInitialize() {
        TickCheck.Init();
    }
}
