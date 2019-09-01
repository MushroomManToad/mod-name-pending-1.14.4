package mushroommantoad.mmpmod.gui.client.tome;

import com.mojang.blaze3d.platform.GlStateManager;

import mushroommantoad.mmpmod.Main;
import mushroommantoad.mmpmod.gui.client.tome.pages.PagesVimion;
import net.minecraft.util.ResourceLocation;

public class GuiTomeChapter 
{
	public static final ResourceLocation VIMION_TOME = new ResourceLocation(Main.modid + ":textures/gui/vimionite_tome.png");
	public static final ResourceLocation NECRION_TOME = new ResourceLocation(Main.modid + ":textures/gui/necrionite_tome.png");
	public static final ResourceLocation SOLARION_TOME = new ResourceLocation(Main.modid + ":textures/gui/solarionite_tome.png");
	public static final ResourceLocation NIHILION_TOME = new ResourceLocation(Main.modid + ":textures/gui/nihilionite_tome.png");
	public static final ResourceLocation EXPION_TOME = new ResourceLocation(Main.modid + ":textures/gui/expionite_tome.png");
	
	public String name;
	private GuiTome tome;
	public GuiTomePage page;
	public int page_number = 0;
	
	public GuiTomeChapter(GuiTome tome, String name)
	{
		this.name = name;
		this.tome = tome;
	}
	
	public void setPage()
	{
		if(name == "vimion") page = PagesVimion.getPage(tome, page_number);
		//if(name == "necrion") pages = MasterPages.addNecrionPages();
		//if(name == "solarion") pages = MasterPages.addSolarionPages();
		//if(name == "nihilion") pages = MasterPages.addNihilionPages();
		//if(name == "expion") pages = MasterPages.addExpionPages();
	}
	
	public void drawBackground()
	{
	    GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
	    tome.getMinecraft().getTextureManager().bindTexture(VIMION_TOME);
	    if(name == "vimion") tome.getMinecraft().getTextureManager().bindTexture(VIMION_TOME);
	    if(name == "necrion") tome.getMinecraft().getTextureManager().bindTexture(NECRION_TOME);
	    if(name == "solarion") tome.getMinecraft().getTextureManager().bindTexture(SOLARION_TOME);
	    if(name == "nihilion") tome.getMinecraft().getTextureManager().bindTexture(NIHILION_TOME);
	    if(name == "expion") tome.getMinecraft().getTextureManager().bindTexture(EXPION_TOME);
	    int i = tome.guiLeft;
	    int j = (tome.height - tome.ySize) / 2;
	    tome.blit(i, j, 0, 0, tome.xSize, tome.ySize);
	}
	
	public void drawHoverObjects(int mouseX, int mouseY)
	{
		page.drawAllHoverObjects(mouseX, mouseY);
	}
}
