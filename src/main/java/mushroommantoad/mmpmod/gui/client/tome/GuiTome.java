package mushroommantoad.mmpmod.gui.client.tome;

import java.util.ArrayList;

import mushroommantoad.mmpmod.Main;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@SuppressWarnings("unused")
public class GuiTome extends Screen 
{
	public static final ResourceLocation VIMION_TOME = new ResourceLocation(Main.modid + ":textures/gui/vimionite_tome.png");
    public int xSize = 256;
    public int ySize = 166;
    public int guiLeft;
    public int guiTop;
    protected PlayerEntity player;
    protected GuiTomeChapter chapter;
    
    public ItemRenderer iR = itemRenderer;
    
    public ArrayList<GuiTomeChapter> chapters = new ArrayList<>();
	   
	public GuiTome(PlayerEntity player) 
	{
		// Set GUI Title
		super(new StringTextComponent(" "));
		
		this.player = player;
	}

	// Set any variables immediately upon opening the GUI
	// In this case, I've set a couple of variables used by `render` to re-scale and center the GUI at any window size
	@Override
	protected void init() 
	{
	    this.guiLeft = (this.width - this.xSize) / 2;
	    this.guiTop = (this.height - this.ySize) / 2;
	    chapter = new GuiTomeChapter(this, "vimion");
	    chapter.setPage();
		super.init();
	}
	
	// Replaces the old draw() function
	// Taken from CraftingScreen.java -- Draws a background from the specified texture.
	@Override
	public void render(int mouseX, int mouseY, float partialTicks) 
	{
		this.renderBackground();
		chapter.drawBackground();
		chapter.drawHoverObjects(mouseX, mouseY);
		super.render(mouseX, mouseY, partialTicks);
	}
	
	public PlayerEntity getPlayer()
	{
		return player;
	}
	
	public FontRenderer getFontRenderer()
	{
		return font;
	}
}
