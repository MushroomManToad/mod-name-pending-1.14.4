package mushroommantoad.mmpmod.entities;

import mushroommantoad.mmpmod.entities.spectral.sheep.SpectralSheepEntity;
import mushroommantoad.mmpmod.entities.spectral.sheep.SpectralSheepRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class VimionRenderRegistry 
{
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(SpectralSheepEntity.class, new SpectralSheepRenderer.RenderFactory());
	}
}
