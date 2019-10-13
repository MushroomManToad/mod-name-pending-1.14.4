package mushroommantoad.mmpmod.entities.boss.vimionic_abomination.absorption_spire;

import javax.annotation.Nullable;

import mushroommantoad.mmpmod.init.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityAbsorptionSpire extends Entity
{
	public EntityAbsorptionSpire(EntityType<? extends Entity> entityTypeIn, World worldIn) 
	{
		super((EntityType<? extends Entity>) ModEntities.ABSORPTION_SPIRE, worldIn);
	}

	@Override
	protected void registerData() {}

	@Override
	protected void readAdditional(CompoundNBT compound) {}

	@Override
	protected void writeAdditional(CompoundNBT compound) {}
	
	@Nullable
	public AxisAlignedBB getCollisionBox(Entity entityIn) { return entityIn.canBePushed() ? entityIn.getBoundingBox() : null; }

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox() { return this.getBoundingBox(); }

	@Override
	public boolean canBePushed() { return true; }
	
	@Override
	public void tick() 
	{
		System.out.println(this);
		super.tick();
	}

	@Override
	public IPacket<?> createSpawnPacket() 
	{
		return new SSpawnObjectPacket(this);
	}
}
