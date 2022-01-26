package me.swipez.tickwarpextract.network;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CarpetClient
{
    public static final Object sync = new Object();
    public static final int HI = 69;
    public static final int HELLO = 420;
    public static final int DATA = 1;

    private static ClientPlayerEntity clientPlayer = null;
    private static boolean isServerCarpet = false;
    public static String serverCarpetVersion;
    public static final Identifier CARPET_CHANNEL = new Identifier("carpet:hello");

    public static void gameJoined(ClientPlayerEntity player)
    {
        synchronized (sync)
        {
            clientPlayer = player;
            // client didn't say hi back yet

        }
    }

    public static void disconnect()
    {
        isServerCarpet = false;
        clientPlayer = null;
    }

    public static void setCarpet()
    {
        isServerCarpet = true;
    }

    public static ClientPlayerEntity getPlayer()
    {
        return clientPlayer;
    }

    public static boolean isCarpet()
    {
        return isServerCarpet;
    }


}
