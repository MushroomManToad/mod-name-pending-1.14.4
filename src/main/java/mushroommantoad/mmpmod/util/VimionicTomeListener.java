package mushroommantoad.mmpmod.util;

import mushroommantoad.mmpmod.init.ModItems;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class VimionicTomeListener 
{
	@SubscribeEvent
	public void pickupItemAddToBookEvent(EntityItemPickupEvent event)
	{
		//
		// CHAPTER: VIMION HANDLER
		//
		
		if(event.getItem().getItem().getItem() == ModItems.vimion_gemstone)
		{
			CompoundNBT nbt = event.getPlayer().getPersistentData();
			if(nbt.contains("VimionAdvancements"))
			{
				if(nbt.getIntArray("VimionAdvancements")[0] == 0)
				{
					int[] value = nbt.getIntArray("VimionAdvancements");
					nbt.putIntArray("VimionAdvancements", value);
				}
			}
			else
			{
				int[] value = new int[100];
				value[0] = 1;
				nbt.putIntArray("VimionAdvancements", value);
			}
		}
		
		//
		// CHAPTER: VIMION HANDLER
		//
	}
}
