package mushroommantoad.mmpmod.gui.client.tome.pages;

import java.util.ArrayList;

import mushroommantoad.mmpmod.Main;
import mushroommantoad.mmpmod.gui.client.tome.GuiTome;
import mushroommantoad.mmpmod.gui.client.tome.GuiTomeHoverObject;
import mushroommantoad.mmpmod.gui.client.tome.GuiTomePage;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;

@SuppressWarnings("unused")
public class PagesVimion 
{
	private static ResourceLocation VIMIONIC_TOME = new ResourceLocation(Main.modid + ":textures/item/vimionic_tome.png");
	private static ResourceLocation VIMION_GEMSTONE = new ResourceLocation(Main.modid + ":textures/gui/icon/vimion_gemstone.png");
	private static ResourceLocation VIMIONITE_DAGGER = new ResourceLocation(Main.modid + ":textures/item/vimionite_dagger.png");
	
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
		ho.add(new GuiTomeHoverObject(tome, 40, tome.ySize / 2 - 50, VIMIONITE_DAGGER, "Spirits...", "Craft a Vimionite Dagger to harvest the Spirits of animals"));
		
		return new GuiTomePage(tome, ho);
	}
}
