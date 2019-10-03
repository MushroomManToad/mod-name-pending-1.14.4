package mushroommantoad.mmpmod.items;

import mushroommantoad.mmpmod.network.SendBookOpenPacket;
import mushroommantoad.mmpmod.network.VimionPacketHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkDirection;

public class ItemVimioniteTome extends Item
{

	public ItemVimioniteTome(Properties properties) 
	{
		super(properties);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) 
	{
		if(!worldIn.isRemote)
		{
			int[] values = new int[500];
			ServerPlayerEntity playerMP = (ServerPlayerEntity) playerIn;
			if(playerIn.getPersistentData().contains("VimionAdvancements")) values = playerIn.getPersistentData().getIntArray("VimionAdvancements");
			VimionPacketHandler.CHANNEL.sendTo(new SendBookOpenPacket(values), playerMP.connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
