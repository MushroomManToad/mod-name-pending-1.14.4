package mushroommantoad.mmpmod.init;

import org.apache.logging.log4j.Logger;

import mushroommantoad.mmpmod.Main;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;

public class ModBlocks 
{
	public static Block vimion_block;
	public static Block concealed_vimionite_ore;
	public static Block vimionite_ore;
	
	public static void registerAll(RegistryEvent.Register<Block> event, Logger logger)
	{
		event.getRegistry().registerAll
		(
				vimion_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 15f).lightValue(15).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)).setRegistryName(location("vimion_block")),
				concealed_vimionite_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 15f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName(location("concealed_vimionite_ore")),
				vimionite_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 15f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName(location("vimionite_ore"))
		);
		
		logger.info("Blocks Registered");
	}
	
	private static ResourceLocation location(String name)
	{
		return new ResourceLocation(Main.modid, name);
	}
}
