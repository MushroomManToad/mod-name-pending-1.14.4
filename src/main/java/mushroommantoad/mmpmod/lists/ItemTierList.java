package mushroommantoad.mmpmod.lists;

import mushroommantoad.mmpmod.init.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ItemTierList implements IItemTier
{
	vimionite(5.0f, 9.0f, 250, 3, 1, ModItems.vimion_shard);
	
	private float attackDamage, effiency;
	private int durability, harvestLevel, enchantability;
	private Item repairMaterial;
	
	private ItemTierList(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial)
	{
		this.attackDamage = attackDamage;
		this.effiency = efficiency;
		this.durability = durability;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public int getMaxUses()
	{
		return this.durability;
	}

	@Override
	public float getEfficiency() 
	{
		return this.effiency;
	}

	@Override
	public float getAttackDamage() 
	{
		return this.attackDamage;
	}

	@Override
	public int getHarvestLevel() 
	{
		return this.harvestLevel;
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return Ingredient.fromItems(this.repairMaterial);
	}
}
