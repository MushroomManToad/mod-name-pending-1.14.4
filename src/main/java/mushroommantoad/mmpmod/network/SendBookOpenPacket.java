package mushroommantoad.mmpmod.network;

import java.util.function.Supplier;

import mushroommantoad.mmpmod.gui.client.tome.GuiTome;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

public class SendBookOpenPacket 
{
	private int[] bookData;

	public SendBookOpenPacket(int[] data) 
	{
		this.bookData = data;
	}
	
	public void serialize(PacketBuffer buf) 
	{
		buf.writeVarIntArray(this.bookData);
	}
	
	public static SendBookOpenPacket deserialize(PacketBuffer buf) {
		int[] data = buf.readVarIntArray();
		return new SendBookOpenPacket(data);
	}
	
	public static void handle(SendBookOpenPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		ServerPlayerEntity sender = contextSupplier.get().getSender();
		if (context.getDirection().getReceptionSide() == LogicalSide.CLIENT) {
			context.enqueueWork(() -> {
				Minecraft.getInstance().displayGuiScreen(new GuiTome(sender, message.bookData));
			});
			context.setPacketHandled(true);
		}
	}
}
