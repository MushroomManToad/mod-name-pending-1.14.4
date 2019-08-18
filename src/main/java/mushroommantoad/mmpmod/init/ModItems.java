package mushroommantoad.mmpmod.init;

import org.apache.logging.log4j.Logger;

import mushroommantoad.mmpmod.Main;
import mushroommantoad.mmpmod.items.ItemVimioniteTome;
import mushroommantoad.mmpmod.items.ItemVimionDagger;
import mushroommantoad.mmpmod.lists.ItemTierList;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;

public class ModItems 
{
	public static Item vimion_shard;
	public static Item vimion_gemstone;
	public static Item vimionite_tome;
	
	public static Item vimionite_dagger;
	
	public static Item vimion_block;
	public static Item concealed_vimionite_ore;
	public static Item vimionite_ore;
	
	public static void registerAll(RegistryEvent.Register<Item> event, Logger logger)
	{
		event.getRegistry().registerAll
		(
				vimion_shard = new Item(new Item.Properties().group(Main.vimion)).setRegistryName(location("vimion_shard")),
				vimion_gemstone = new Item(new Item.Properties().group(Main.vimion)).setRegistryName(location("vimion_gemstone")),
				vimionite_tome = new ItemVimioniteTome(new Item.Properties().group(Main.vimion)).setRegistryName(location("vimionite_tome")),
				
				vimionite_dagger = new ItemVimionDagger(ItemTierList.vimionite, 0, 10.0f, new Item.Properties().group(Main.vimion)).setRegistryName(location("vimionite_dagger")),
				
				vimion_block = new BlockItem(ModBlocks.vimion_block, new Item.Properties().group(Main.vimion)).setRegistryName(location("vimion_block")),
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
