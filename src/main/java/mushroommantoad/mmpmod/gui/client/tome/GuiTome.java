package mushroommantoad.mmpmod.gui.client.tome;

import java.util.ArrayList;

import com.mojang.blaze3d.platform.GlStateManager;

import mushroommantoad.mmpmod.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.Button.IPressable;
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
    protected GuiTomeTabManager tabManager;
    
    int mousePosX = 0;
    int mousePosY = 0;
    
    public ItemRenderer iR = itemRenderer;
    
    public TabHandlingButton tabHandler;
	   
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
	    tabManager = new GuiTomeTabManager(this);
	    
		this.buttons.clear();
		this.tabHandler = this.addButton(new TabHandlingButton(this.guiLeft - 32, this.guiTop, 32, this.ySize, " ", (p_213029_1_) -> { tabManager.handleClickEvent(mousePosX, mousePosY); }));
	    
		super.init();
	}
	
	// Replaces the old draw() function
	// Taken from CraftingScreen.java -- Draws a background from the specified texture.
	@Override
	public void render(int mouseX, int mouseY, float partialTicks) 
	{
		this.mousePosX = mouseX;
		this.mousePosY = mouseY;
		
		this.renderBackground();
		chapter.drawBackground();
		chapter.drawHoverObjects(mouseX, mouseY);
		tabManager.tabTick(mouseX, mouseY);
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
	
	@OnlyIn(Dist.CLIENT)
    static class TabHandlingButton extends Button
    {
		private boolean locked = false;
		
		public TabHandlingButton(int xPos, int yPos, int width, int height, String text, IPressable onPress) 
		{
			super(xPos, yPos, width, height, text, onPress);
		}
		
		@Override
		public void renderButton(int p_renderButton_1_, int p_renderButton_2_, float p_renderButton_3_) 
		{
			
		}
		
		@Override
		public boolean mouseClicked(double p_mouseClicked_1_, double p_mouseClicked_3_, int p_mouseClicked_5_) 
		{
			if (this.active && this.visible) 
			{
				if (this.isValidClickButton(p_mouseClicked_5_)) 
				{
		            boolean flag = this.clicked(p_mouseClicked_1_, p_mouseClicked_3_);
		            if (flag) 
		            {
		            	this.onClick(p_mouseClicked_1_, p_mouseClicked_3_);
		            	return true;
		            }
				}

				return false;
			} 
			else 
			{
				return false;
			}
		}
    }
}
