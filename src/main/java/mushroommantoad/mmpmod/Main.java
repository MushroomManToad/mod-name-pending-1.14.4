package mushroommantoad.mmpmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mushroommantoad.mmpmod.init.ModBlocks;
import mushroommantoad.mmpmod.init.ModItems;
import mushroommantoad.mmpmod.init.ModTileEntities;
import mushroommantoad.mmpmod.itemgroups.ItemGroupVimion;
import mushroommantoad.mmpmod.world.OreGeneration;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("vimion")
public class Main {
	public static Main instance;
	public static final String modid = "vimion";
	private static final Logger logger = LogManager.getLogger(modid);

	public static final ItemGroup vimion = new ItemGroupVimion();

	public Main() {
		instance = this;

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

		MinecraftForge.EVENT_BUS.register(this);
	}

	// PreInit
	private void setup(final FMLCommonSetupEvent event) {
		OreGeneration.setupOreGeneration();
		logger.info("Setup Server PreInit");
	}

	// PreInit
	private void clientRegistries(final FMLClientSetupEvent event) {
		logger.info("Client Registries Added");
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			ModItems.registerAll(event, logger);
		}

		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			ModBlocks.registerAll(event, logger);
		}
		
		@SubscribeEvent
		public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> event)	{
			ModTileEntities.registerAll(event, logger);
		}
	}
}
