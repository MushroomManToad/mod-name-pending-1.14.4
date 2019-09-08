package mushroommantoad.mmpmod.gui.client.tome;

import java.util.ArrayList;

public class GuiTomePage 
{
	public ArrayList<GuiTomeHoverObject> ho;
	public GuiTome tome;
	
	public GuiTomePage(GuiTome tome, ArrayList<GuiTomeHoverObject> ho)
	{
		this.tome = tome;
		this.ho = ho;
	}
	
	public void drawAllHoverObjects(int mouseX, int mouseY)
	{
		for(GuiTomeHoverObject h : ho)
		{
			h.drawIcon();
		}
		for(GuiTomeHoverObject h : ho)
		{
			h.checkForHover(mouseX, mouseY);
		}
	}
}
