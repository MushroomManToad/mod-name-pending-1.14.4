package mushroommantoad.mmpmod.items;

import java.util.Random;

import mushroommantoad.mmpmod.init.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;

public class ItemGeologicPhaser extends Item
{
	public ItemGeologicPhaser(Properties properties) 
	{
		super(properties);
	}
	
	public ActionResultType onItemUse(ItemUseContext context)
	   {
		   if(!context.getWorld().isRemote)
		   {
			   if(context.getWorld().getBlockState(context.getPos()).getBlock() == ModBlocks.concealed_vimionite_ore)
			   {
				   context.getWorld().setBlockState(context.getPos(), ModBlocks.vimionite_ore.getDefaultState());
				   context.getItem().attemptDamageItem(1, new Random(), null);
				   return ActionResultType.SUCCESS;
			   }
			   else 
			   {
				   if(new Random().nextInt(10) < 1) context.getItem().attemptDamageItem(1, new Random(), null);
				   return ActionResultType.SUCCESS;
			   }
		   }
		   else
		   {
			   return ActionResultType.PASS;
		   }
	   }
	
	@Override
	public boolean isDamageable() 
	{
		return true;
	}
}
