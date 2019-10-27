package mushroommantoad.mmpmod.util;

import mushroommantoad.mmpmod.entities.boss.vimionic_abomination.VimionicAbominationEntity;
import mushroommantoad.mmpmod.entities.spectral.ISpectralEntity;
import mushroommantoad.mmpmod.init.ModEntities;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MushroomsEventHandler 
{
	@SubscribeEvent
    public void tickEvent(TickEvent.PlayerTickEvent event) 
    {
		//if(event.player.getPersistentData().getIntArray("VimionAdvancements").length > 0)
		//System.out.println(event.player.getPersistentData().getIntArray("VimionAdvancements")[0]);
    }
	
	@SubscribeEvent
	public void abominationSpawnEvent(LivingDeathEvent event)
	{
		World worldIn = event.getEntity().world;
		if(!worldIn.isRemote && event.getEntityLiving() instanceof ISpectralEntity)
		{
			Entity entity = event.getSource().getTrueSource();
			if(entity != null)
			{
				if(entity instanceof MobEntity)
				{
					MobEntity mobIn = (MobEntity) entity;
					if(mobIn.isEntityUndead())
					{
						CompoundNBT nbt = entity.getPersistentData();
						if(nbt.contains("VimionAscension"))
						{
							nbt.putInt("VimionAscension", nbt.getInt("VimionAscension") + 1);
							if(nbt.getInt("VimionAscension") >= 5)
							{
								@SuppressWarnings("unchecked")
								VimionicAbominationEntity vim = new VimionicAbominationEntity((EntityType<? extends CreatureEntity>) ModEntities.VIMIONIC_ABOMINATION, worldIn);
								vim.setPosition(entity.posX, entity.posY, entity.posZ);
								worldIn.addEntity(vim);
								entity.remove();
							}
						}
						else
						{
							nbt.putInt("VimionAscension", 1);
						}
					}
				}
			}
		}
	}
}
