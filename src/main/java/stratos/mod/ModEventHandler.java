package stratos.mod;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.event.server.ServerTickCallback;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModEventHandler {
    public static void initialize() {
        // Register a server tick event callback
        ServerTickCallback.EVENT.register(server -> {
            // Check for lightning strikes and handle portal creation
            handleLightningStrikes(server);
        });
    }

    private static void handleLightningStrikes(MinecraftServer server) {
        // Iterate over all worlds in the server
        server.getWorlds().forEach(world -> {
            // Iterate over all entities in the world
            for (LightningEntity lightning : world.getEntitiesByType(EntityType.LIGHTNING_BOLT, lightning -> true)) {
                BlockPos lightningPos = lightning.getBlockPos();

                // Check if the lightning strike hits a REINFORCED_DEEPSLATE block
                if (world.getBlockState(lightningPos).isOf(Blocks.REINFORCED_DEEPSLATE)) {
                    // Activate your portal or perform any desired action
                    activatePortal((ServerWorld) world, lightningPos);
                }
            }
        });
    }

    private static void activatePortal(ServerWorld serverWorld, BlockPos portalPos) {
        // Implement your logic to activate the portal
        // This might include creating particles, changing block states, or triggering a portal activation event

        // For example, register the portal
        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.REINFORCED_DEEPSLATE)
                .lightWithItem(stratos.Items.ModItems.ANCIENT_PORTAL_IGNITER)
                .destDimID(new Identifier(ExampleMod.MOD_ID, "stratosdim"))
                .tintColor(0xbe, 0x01, 0x3c)
                .registerPortal();
    }
}