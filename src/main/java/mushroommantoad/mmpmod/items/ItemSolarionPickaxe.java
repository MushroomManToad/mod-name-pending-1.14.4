package mushroommantoad.mmpmod.items;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.ShulkerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemSolarionPickaxe extends PickaxeItem
{
	public ItemSolarionPickaxe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) 
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) 
	{
		ItemStack stack = playerIn.getHeldItem(handIn);
		CompoundNBT nbt = stack.getTag(); 
		if(nbt == null) nbt = new CompoundNBT();
		if(nbt.contains("active"))
		{
			if(!nbt.getBoolean("active")) nbt.putBoolean("active", true);
			else
			{
				nbt.putBoolean("active", false);
				AxisAlignedBB checkBox = new AxisAlignedBB(playerIn.getPosition().add(-100, -100, -100), playerIn.getPosition().add(100, 100, 100));
				List<ShulkerEntity> shulkers = worldIn.getEntitiesWithinAABB(ShulkerEntity.class, checkBox);
				for(ShulkerEntity s : shulkers)
				{
					if(s.getTags().contains("Solarion"))
					{
						s.setPosition(s.getPosition().getX(), -60, s.getPosition().getY());
					}
				}
			}
		}
		else
		{
			nbt.putBoolean("active", false);
		}
		if(nbt.contains("charge"))
		{
			if(nbt.getInt("charge") <= 0)
			{
				nbt.putBoolean("active", false);
				AxisAlignedBB checkBox = new AxisAlignedBB(playerIn.getPosition().add(-100, -100, -100), playerIn.getPosition().add(100, 100, 100));
				List<ShulkerEntity> shulkers = worldIn.getEntitiesWithinAABB(ShulkerEntity.class, checkBox);
				for(ShulkerEntity s : shulkers)
				{
					if(s.getTags().contains("Solarion"))
					{
						s.setPosition(s.getPosition().getX(), -60, s.getPosition().getY());
					}
				}
			}
		}
		else
		{
			nbt.putBoolean("active", false);
			nbt.putInt("charge", 0);
		}
		stack.setTag(nbt);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) 
	{
		return slotChanged;
	}
	
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) 
	{
		CompoundNBT nbt = stack.getTag();
		if(nbt == null) nbt = new CompoundNBT();
		
		if(!worldIn.isRemote)
		{
			if(!nbt.contains("active")) nbt.putBoolean("active", false);
			if(!nbt.contains("charge")) nbt.putInt("charge", 0);
			if(!nbt.contains("tick")) nbt.putInt("tick", 0);

			boolean active = nbt.getBoolean("active");
			int charge = nbt.getInt("charge");
			if(nbt.getBoolean("active"))
			{
				if(charge > 0)
				{
					charge--;
				}
				else
				{
					active = false;
				}
			}
			else
			{
				if(charge < 2500)
				{
					if(canSeeSky(worldIn, entityIn)) charge++;
				}
			}
			nbt.putBoolean("active", active);
			nbt.putInt("charge", charge);
			
			if(nbt.getInt("tick") == 19)
			{
				if(nbt.contains("active"))
				{
					if(nbt.getBoolean("active"))
					{
						AxisAlignedBB checkBox = new AxisAlignedBB(entityIn.getPosition().add(-100, -100, -100), entityIn.getPosition().add(18, 18, 18));
						List<ShulkerEntity> shulkers = worldIn.getEntitiesWithinAABB(ShulkerEntity.class, checkBox);
						for(ShulkerEntity s : shulkers)
						{
							if(s.getTags().contains("Solarion"))
							{
								s.setPosition(s.getPosition().getX(), -80, s.getPosition().getY());
							}
						}
						int r = 0;
						if(nbt.getInt("charge") >= 1599) r = 8;
						else r = 1 + (int) (nbt.getInt("charge") / 200);
						for(BlockPos pos : getOreBlocks(worldIn, entityIn.getPosition(), r))
						{
							ShulkerEntity shulker = new ShulkerEntity(EntityType.SHULKER, worldIn);
							shulker.setNoAI(true);
							shulker.addPotionEffect(new EffectInstance(Effects.GLOWING, 100000, 0, true, false));
							shulker.setInvisible(true);
							shulker.setPosition(pos.getX(), pos.getY(), pos.getZ());
							shulker.addTag("Solarion");
							shulker.setInvulnerable(true);
							worldIn.addEntity(shulker);
						}
					}
				}
			}
			
			if(nbt.getInt("tick") >= 20)
			{
				nbt.putInt("tick", 0);
			}
			nbt.putInt("tick", nbt.getInt("tick") + 1);
		}
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
	}
	
	public boolean canSeeSky(World worldIn, Entity entityIn)
	{
		BlockPos.MutableBlockPos pos1 = new BlockPos.MutableBlockPos((int) entityIn.posX, (int) entityIn.posY, (int) entityIn.posZ);
		if(!worldIn.isRemote && !worldIn.isDaytime()) return false;
		for(int i = (int) entityIn.posY; i <= 256; i++)
		{
			if(!(worldIn.getBlockState(pos1).getBlock() instanceof AirBlock)) return false;
			pos1.setPos(pos1.getX(), pos1.getY() + 1, pos1.getZ());
		}
		return true;
	}
	
	public ArrayList<BlockPos> getOreBlocks(World worldIn, BlockPos pos, int r)
	{
		ArrayList<BlockPos> localOres = new ArrayList<>();
	    int startX = pos.getX();
	    int startY = pos.getY();
	    int startZ = pos.getZ();
	    Block b;
        BlockPos.MutableBlockPos pooledMutableBlockPos = new BlockPos.MutableBlockPos();
	    for(int X = -r; X <= r; X++ )
	    {
	        for(int Y = -r; Y <= r; Y++ )
	        {
	            for(int Z = -r; Z <= r; Z++ )
	            {
	                if(Math.sqrt((X * X) + (Y * Y) + (Z * Z)) <= r)
	                {
	                	pooledMutableBlockPos.setPos(startX + X, startY + Y, startZ + Z);
	                	b = worldIn.getBlockState(pooledMutableBlockPos).getBlock();
	                	if(
	                		b instanceof AirBlock || 
	                		b == Blocks.STONE || 
	                		b == Blocks.GRANITE || 
	                		b == Blocks.DIORITE || 
	                		b == Blocks.ANDESITE || 
	                		b == Blocks.DIRT ||
	                		b == Blocks.GRAVEL ||
	                		b == Blocks.SAND ||
	                		b instanceof FlowingFluidBlock) {} 
	                	else localOres.add(pooledMutableBlockPos.toImmutable());
	                }
	            }
	        }
	    }
	    return localOres;
	}
	
   @OnlyIn(Dist.CLIENT)
   public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) 
   {
	   CompoundNBT nbt = stack.getTag();
	   if(nbt == null) nbt = new CompoundNBT();
	   if(nbt.contains("charge"))
	   {
		   tooltip.add(new StringTextComponent("Charge: " + nbt.getInt("charge") + "/2500").applyTextStyle(TextFormatting.YELLOW));
	   }
   }
	
	@Override
	public boolean hasEffect(ItemStack stack) 
	{
		CompoundNBT nbt = stack.getTag();
		if(nbt == null) nbt = new CompoundNBT();
		if(nbt.contains("active")) return nbt.getBoolean("active");
		else return false;
	}
}
