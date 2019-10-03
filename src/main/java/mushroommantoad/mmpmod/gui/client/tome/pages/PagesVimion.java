package mushroommantoad.mmpmod.gui.client.tome.pages;

import java.util.ArrayList;

import mushroommantoad.mmpmod.Main;
import mushroommantoad.mmpmod.gui.client.tome.GuiTome;
import mushroommantoad.mmpmod.gui.client.tome.GuiTomeHoverObject;
import mushroommantoad.mmpmod.gui.client.tome.GuiTomePage;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@SuppressWarnings("unused")
@OnlyIn(Dist.CLIENT)
public class PagesVimion 
{
	private static ResourceLocation VIMIONIC_TOME = new ResourceLocation(Main.modid + ":textures/item/vimionic_tome.png");
	private static ResourceLocation VIMION_GEMSTONE = new ResourceLocation(Main.modid + ":textures/gui/icon/vimion_gemstone.png");
	private static ResourceLocation VIMIONITE_DAGGER = new ResourceLocation(Main.modid + ":textures/item/vimionite_dagger.png");
	private static ResourceLocation ADVANCED_PHASER = new ResourceLocation(Main.modid + ":textures/gui/icon/advanced_geologic_phaser.png");
	
	// TODO
	public static GuiTomePage getPage(GuiTome tome, int id)
	{
		return get0(tome);
	}
	
	public static GuiTomePage get0(GuiTome tome)
	{
		PlayerEntity player = tome.getPlayer();
		
		ArrayList<GuiTomeHoverObject> ho = new ArrayList<>();
		
		ho.add(new GuiTomeHoverObject(tome, 10, tome.ySize / 2 - 14, VIMION_GEMSTONE, "Vimion!", "Obtain a Vimion Gemstone"));
		ho.add(new GuiTomeHoverObject(tome, 40, tome.ySize / 2 - 42, VIMIONITE_DAGGER, "Spirits...", "Craft a Vimionite Dagger to harvest the Spirits of animals."));
		ho.add(new GuiTomeHoverObject(tome, 40, tome.ySize / 2 + 14, ADVANCED_PHASER, "Advanced Phasing", "Surround a Geologic Phaser with Vimion Gemstones in the Crafting Table to craft an Advanced Geologic Phaser."));
		
		ho.add(new GuiTomeHoverObject(tome, 150, tome.ySize / 2 + 14, ADVANCED_PHASER, "Advanced Phasing", "Surround a Geologic Phaser with Vimion Gemstones in the Crafting Table to craft an Advanced Geologic Phaser."));
		
		return new GuiTomePage(tome, ho);
	}
}
