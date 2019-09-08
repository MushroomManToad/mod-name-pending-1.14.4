package mushroommantoad.mmpmod.gui.client.tome.pages;

import java.util.ArrayList;

import mushroommantoad.mmpmod.Main;
import mushroommantoad.mmpmod.gui.client.tome.GuiTome;
import mushroommantoad.mmpmod.gui.client.tome.GuiTomeHoverObject;
import mushroommantoad.mmpmod.gui.client.tome.GuiTomePage;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;

@SuppressWarnings("unused")
public class PagesExpion 
{
	private static ResourceLocation EXPION_GEMSTONE = new ResourceLocation(Main.modid + ":textures/gui/icon/expion_gemstone.png");
	
	// TODO
	public static GuiTomePage getPage(GuiTome tome, int id)
	{
		return get0(tome);
	}
	
	public static GuiTomePage get0(GuiTome tome)
	{
		PlayerEntity player = tome.getPlayer();
		ArrayList<GuiTomeHoverObject> ho = new ArrayList<>();
		
		ho.add(new GuiTomeHoverObject(tome, 10, tome.ySize / 2 - 14, EXPION_GEMSTONE, "Expion!", "Obtain an Expion Gemstone"));
		
		return new GuiTomePage(tome, ho);
	}
}
