package com.pahimar.ee3.client.audio;

import com.pahimar.ee3.helper.LogHelper;
import com.pahimar.ee3.lib.Sounds;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.sound.SoundLoadEvent;

/**
 * Equivalent-Exchange-3
 * <p/>
 * SoundHandler
 *
 * @author pahimar
 */
public class SoundHandler
{
    @SubscribeEvent
    public void onSoundLoad(SoundLoadEvent event)
    {
        // FIXME Load custom sounds into Minecraft
        // For each custom sound file we have defined in Sounds
//        for (String soundFile : Sounds.soundFiles)
//        {
//            // Try to add the custom sound file to the pool of sounds
//            try
//            {
//                event.manager.addSound(soundFile);
//            }
//            // If we cannot add the custom sound file to the pool, log the exception
//            catch (Exception e)
//            {
//                LogHelper.warn("Failed loading sound file: " + soundFile);
//            }
//        }
    }
}
