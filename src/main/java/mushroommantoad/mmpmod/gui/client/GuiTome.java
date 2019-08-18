package mushroommantoad.mmpmod.gui.client;

import com.mojang.blaze3d.platform.GlStateManager;

import mushroommantoad.mmpmod.Main;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;

public class GuiTome extends Screen 
{
	public static final ResourceLocation ARGONITE_TOME = new ResourceLocation(Main.modid + ":textures/gui/vimionite_tome.png");
    protected int xSize = 256;
    protected int ySize = 166;
    protected int guiLeft;
    protected int guiTop;
	   
	public GuiTome() 
	{
		
		// Set GUI Title
		super(new StringTextComponent(" "));
	}

	// Set any variables immediately upon opening the GUI
	// In this case, I've set a couple of variables used by `render` to re-scale and center the GUI at any window size
	@Override
	protected void init() 
	{
	    this.guiLeft = (this.width - this.xSize) / 2;
	    this.guiTop = (this.height - this.ySize) / 2;
		super.init();
	}
	
	// Replaces the old draw() function
	// Taken from CraftingScreen.java -- Draws a background from the specified texture.
	@Override
	public void render(int mouseX, int mouseY, float partialTicks) 
	{
		this.renderBackground();
	    GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
	    this.minecraft.getTextureManager().bindTexture(ARGONITE_TOME);
	    int i = this.guiLeft;
	    int j = (this.height - this.ySize) / 2;
	    this.blit(i, j, 0, 0, this.xSize, this.ySize);
		super.render(mouseY, mouseY, partialTicks);
	}
}
