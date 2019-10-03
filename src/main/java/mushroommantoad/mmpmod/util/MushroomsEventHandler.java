package mushroommantoad.mmpmod.util;

import mushroommantoad.mmpmod.init.ModItems;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@SuppressWarnings("unused")
public class MushroomsEventHandler 
{
	@SubscribeEvent
    public void tickEvent(TickEvent.PlayerTickEvent event) 
    {
		//if(event.player.getPersistentData().getIntArray("VimionAdvancements").length > 0)
		//System.out.println(event.player.getPersistentData().getIntArray("VimionAdvancements")[0]);
    }
}
