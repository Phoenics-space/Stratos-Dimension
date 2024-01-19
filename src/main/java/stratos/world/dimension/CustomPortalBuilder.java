package stratos.world.dimension;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class CustomPortalBuilder {
    private Block frameBlock;
    private boolean activated;

    public static CustomPortalBuilder beginPortal() {
        return new CustomPortalBuilder();
    }

    public CustomPortalBuilder frameBlock(Block frameBlock) {
        this.frameBlock = frameBlock;
        return this;
    }

    public CustomPortalBuilder activateWithLightning() {
        this.activated = true;
        return this;
    }

    public CustomPortalBuilder destDimID(Identifier dimID) {
        // Implement your logic for destination dimension ID
        return this;
    }

    public CustomPortalBuilder tintColor(int red, int green, int blue) {
        // Implement your logic for portal tint color
        return this;
    }

    public void registerPortal(ServerWorld world, BlockPos portalPos) {
        if (activated && frameBlock == Blocks.REINFORCED_DEEPSLATE) {
            // Example: Create portal at the block position
            // Adjust this logic based on your actual portal creation requirements
            LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            lightning.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(portalPos));
            world.spawnEntity(lightning);
        }
    }

    // Other methods...
}