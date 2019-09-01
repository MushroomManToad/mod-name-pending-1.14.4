package mushroommantoad.mmpmod.items;

import mushroommantoad.mmpmod.gui.client.tome.GuiTome;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemVimioniteTome extends Item
{

	public ItemVimioniteTome(Properties properties) 
	{
		super(properties);
	}
	
	// Function to open a Client-side-only GUI.
	// There is no need for a GUI handler for these, only for containers
	@Override
	@OnlyIn(Dist.CLIENT)
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) 
	{
		if(worldIn.isRemote) Minecraft.getInstance().displayGuiScreen(new GuiTome(playerIn));
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
