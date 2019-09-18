package mushroommantoad.mmpmod.init;

import org.apache.logging.log4j.Logger;

import mushroommantoad.mmpmod.Main;
import mushroommantoad.mmpmod.entities.spectral.sheep.SpectralSheepEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;

@SuppressWarnings("unused")
public class ModEntities 
{
	public static EntityType<?> SPECTRAL_SHEEP = EntityType.Builder.create(SpectralSheepEntity::new, EntityClassification.CREATURE).build(Main.modid + ":spectral_sheep").setRegistryName(location("spectral_sheep"));
	
	public static Item spectral_sheep_egg;
	
	public static void registerAll(Register<EntityType<?>> event, Logger logger) 
	{
		event.getRegistry().registerAll
		(
			SPECTRAL_SHEEP
		);
		
		registerEntityWorldSpawns();
	}
	
	
	public static void registerEntityWorldSpawns()
	{
		//registerEntityWorldSpawn(SPECTRAL_SHEEP, Biomes.PLAINS, Biomes.BAMBOO_JUNGLE);
	}
	
	public static void registerEntityWorldSpawn(EntityType<?> entity, Biome...biomes)
	{
		for(Biome biome : biomes)
		{
			if(biome != null)
			{
				biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(entity, 1, 1, 1));
			}
		}
	}
	
	public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll
		(
				spectral_sheep_egg = registerEntitySpawnEgg(SPECTRAL_SHEEP, 0x94ffd8, 0x94ffef, "spectral_sheep_spawn_egg")
		);
	}
	
	public static Item registerEntitySpawnEgg(EntityType<?> type, int primaryColor, int secondaryColor, String name)
	{
		SpawnEggItem item = new SpawnEggItem(type, primaryColor, secondaryColor, new Item.Properties().group(ItemGroup.MISC));
		item.setRegistryName(ModItems.location(name));
		return item;
	}
	
	public static ResourceLocation location(String name)
	{
		return new ResourceLocation(Main.modid, name);
	}
}
