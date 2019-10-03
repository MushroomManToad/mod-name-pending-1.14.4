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
public class PagesNihilion 
{
	private static ResourceLocation NIHILION_GEMSTONE = new ResourceLocation(Main.modid + ":textures/gui/icon/nihilion_gemstone.png");
	
	// TODO
	public static GuiTomePage getPage(GuiTome tome, int id)
	{
		return get0(tome);
	}
	
	public static GuiTomePage get0(GuiTome tome)
	{
		PlayerEntity player = tome.getPlayer();
		ArrayList<GuiTomeHoverObject> ho = new ArrayList<>();
		
		ho.add(new GuiTomeHoverObject(tome, 10, tome.ySize / 2 - 14, NIHILION_GEMSTONE, "Nihilion!", "Obtain a Nihilion Gemstone"));
		
		return new GuiTomePage(tome, ho);
	}
}
