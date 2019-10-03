package mushroommantoad.mmpmod.entities.boss.vimionic_abomination;

import mushroommantoad.mmpmod.init.ModEntities;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.ServerBossInfo;
import net.minecraft.world.World;

public class VimionicAbominationEntity extends CreatureEntity 
{
	private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(new TranslationTextComponent("bossbar.vimion.vimionic_abomination.name").applyTextStyle(TextFormatting.GREEN), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS)).setCreateFog(true);
	
	@SuppressWarnings("unchecked")
	public VimionicAbominationEntity(EntityType<? extends CreatureEntity> type, World worldIn) 
	{
		super((EntityType<? extends CreatureEntity>) ModEntities.VIMIONIC_ABOMINATION, worldIn);
	}
	
	@Override
	public void registerGoals() 
	{
		this.goalSelector.addGoal(0, new SwimGoal(this));
	    this.goalSelector.addGoal(1, new LookAtGoal(this, PlayerEntity.class, 64.0F));
	    //this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
	}
	
	@Override
	protected void registerAttributes() 
	{
		super.registerAttributes();
	    this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(120.0D);
	    this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
	}
	
	@Override
	public boolean canDespawn(double distanceToClosestPlayer) 
	{
		return false;
	}
	
	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) 
	{
		return 0.9F * sizeIn.height;
	}
	
	@Override
	public void addTrackingPlayer(ServerPlayerEntity player)
	{
		super.addTrackingPlayer(player);
		this.bossInfo.addPlayer(player);
	}
	
	@Override
	protected void updateAITasks() 
	{
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		super.updateAITasks();
	}

	@Override
	public void removeTrackingPlayer(ServerPlayerEntity player) 
	{
		super.removeTrackingPlayer(player);
		this.bossInfo.removePlayer(player);
	}
	
	@Override
	public boolean isNonBoss() 
	{
		return false;
	}
}
