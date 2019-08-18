package mushroommantoad.mmpmod.items;

import java.util.Random;

import mushroommantoad.mmpmod.init.ModBlocks;
import mushroommantoad.mmpmod.init.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.SwordItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;

public class ItemVimionDagger extends SwordItem
{

	public ItemVimionDagger(IItemTier tier, int attackDamage, float attackSpeed, Properties builder) 
	{
		super(tier, attackDamage, attackSpeed, builder);
	}
	
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) 
	{
		/*
		if(!attacker.getEntityWorld().isRemote)
		if(!target.isAlive())
		{
			if(Math.random() < 0.05)
			{
				ItemEntity argonite = new ItemEntity(attacker.getEntityWorld(), target.posX, target.posY, target.posZ, new ItemStack(ModItems.vimion_shard, 1));
				attacker.getEntityWorld().addEntity(argonite);
				
				CompoundNBT nbt = stack.getTag();
				if(nbt == null) nbt = new CompoundNBT();
				nbt.putBoolean("active", true);
				stack.setTag(nbt);
			}
		}
		*/
		return super.hitEntity(stack, target, attacker);
	}
	
	/*
	   public ActionResultType onItemUse(ItemUseContext context)
	   {
		   if(!context.getWorld().isRemote)
		   {
			   if(context.getWorld().getBlockState(context.getPos()).getBlock() == ModBlocks.argonite_ore)
			   {
				   context.getWorld().setBlockState(context.getPos(), ModBlocks.argonite_block.getDefaultState());
				   context.getItem().attemptDamageItem(1, new Random(), null);
				   return ActionResultType.SUCCESS;
			   }
			   else return ActionResultType.FAIL;
		   }
		   else
		   {
			   return ActionResultType.FAIL;
		   }
	   }
	*/
}
