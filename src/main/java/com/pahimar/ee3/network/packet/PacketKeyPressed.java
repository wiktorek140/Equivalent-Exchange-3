package com.pahimar.ee3.network.packet;

import com.pahimar.ee3.item.IKeyBound;
import com.pahimar.ee3.network.PacketTypeHandler;
import net.minecraft.entity.player.EntityPlayer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Equivalent-Exchange-3
 * <p/>
 * PacketKeyPressed
 *
 * @author pahimar
 */
public class PacketKeyPressed extends PacketEE
{

    public String key;

    public PacketKeyPressed()
    {

        super(PacketTypeHandler.KEY, false);
    }

    public PacketKeyPressed(String key)
    {

        super(PacketTypeHandler.KEY, false);
        this.key = key;
    }

    @Override
    public void writeData(DataOutputStream data) throws IOException
    {

        data.writeUTF(key);
    }

    @Override
    public void readData(DataInputStream data) throws IOException
    {

        key = data.readUTF();
    }

    @Override
    public void execute(INetworkManager manager, Player player)
    {

        EntityPlayer thePlayer = (EntityPlayer) player;

        if (thePlayer.getCurrentEquippedItem() != null && thePlayer.getCurrentEquippedItem().getItem() instanceof IKeyBound)
        {
            ((IKeyBound) thePlayer.getCurrentEquippedItem().getItem()).doKeyBindingAction(thePlayer, thePlayer.getCurrentEquippedItem(), key);
        }
    }
}
