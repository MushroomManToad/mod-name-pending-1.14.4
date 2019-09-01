package mushroommantoad.mmpmod.init;

import org.apache.logging.log4j.Logger;

import mushroommantoad.mmpmod.Main;
import mushroommantoad.mmpmod.items.ItemEnergizedGemstone;
import mushroommantoad.mmpmod.items.ItemGeologicPhaser;
import mushroommantoad.mmpmod.items.ItemSpirit;
import mushroommantoad.mmpmod.items.ItemVimionDagger;
import mushroommantoad.mmpmod.items.ItemVimioniteTome;
import mushroommantoad.mmpmod.lists.ItemTierList;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;

public class ModItems 
{
	public static Item vimion_shard;
	public static Item vimion_gemstone;
	public static Item energized_vimion;
	public static Item vimionic_tome;
	public static Item geologic_phaser;
	
	public static Item vimionite_dagger;
	
	public static Item vimion_block;
	//public static Item vimion_cluster;
	public static Item concealed_vimionite_ore;
	public static Item vimionite_ore;
	
	public static Item sheep_spirit;
	public static Item cow_spirit;
	public static Item pig_spirit;
	public static Item rabbit_spirit;
	public static Item chicken_spirit;
	
	public static void registerAll(RegistryEvent.Register<Item> event, Logger logger)
	{
		event.getRegistry().registerAll
		(
				vimion_shard = new Item(new Item.Properties().group(Main.vimion)).setRegistryName(location("vimion_shard")),
				vimion_gemstone = new Item(new Item.Properties().group(Main.vimion)).setRegistryName(location("vimion_gemstone")),
				energized_vimion = new ItemEnergizedGemstone(new Item.Properties().group(Main.vimion)).setRegistryName(location("energized_vimion")),
				vimionic_tome = new ItemVimioniteTome(new Item.Properties().group(Main.vimion)).setRegistryName(location("vimionic_tome")),
				geologic_phaser = new ItemGeologicPhaser(new Item.Properties().group(Main.vimion).maxDamage(250)).setRegistryName(location("geologic_phaser")),
				
				sheep_spirit = new ItemSpirit(new Item.Properties().group(Main.vimion)).setRegistryName(location("sheep_spirit")),
				cow_spirit = new ItemSpirit(new Item.Properties().group(Main.vimion)).setRegistryName(location("cow_spirit")),
				pig_spirit = new ItemSpirit(new Item.Properties().group(Main.vimion)).setRegistryName(location("pig_spirit")),
				rabbit_spirit = new ItemSpirit(new Item.Properties().group(Main.vimion)).setRegistryName(location("rabbit_spirit")),
				chicken_spirit = new ItemSpirit(new Item.Properties().group(Main.vimion)).setRegistryName(location("chicken_spirit")),
				
				vimionite_dagger = new ItemVimionDagger(ItemTierList.vimionite, 0, -0.6f, new Item.Properties().group(Main.vimion)).setRegistryName(location("vimionite_dagger")),
				
				vimion_block = new BlockItem(ModBlocks.vimion_block, new Item.Properties().group(Main.vimion)).setRegistryName(location("vimion_block")),
				//vimion_cluster = new BlockItem(ModBlocks.vimion_cluster, new Item.Properties().group(Main.vimion)).setRegistryName(location("vimion_cluster")),
				concealed_vimionite_ore = new BlockItem(ModBlocks.concealed_vimionite_ore, new Item.Properties().group(Main.vimion)).setRegistryName(location("concealed_vimionite_ore")),
				vimionite_ore = new BlockItem(ModBlocks.vimionite_ore, new Item.Properties().group(Main.vimion)).setRegistryName(location("vimionite_ore"))
		);
		
		logger.info("Items Registered");
	}
	
	private static ResourceLocation location(String name)
	{
		return new ResourceLocation(Main.modid, name);
	}
}
