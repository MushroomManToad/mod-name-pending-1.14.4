package mushroommantoad.mmpmod.proxy;

import mushroommantoad.mmpmod.gui.client.tome.GuiTome;
import mushroommantoad.mmpmod.network.SendBookOpenPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ServerPlayerEntity;

public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit() 
	{
		
	}
	
	@Override
	public void openVimionTomeGUI(ServerPlayerEntity sender, SendBookOpenPacket message) 
	{
		Minecraft.getInstance().displayGuiScreen(new GuiTome(sender, message.getBookData()));
	}
}
