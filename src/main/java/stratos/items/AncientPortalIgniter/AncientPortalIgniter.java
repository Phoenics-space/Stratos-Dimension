package stratos.items.AncientPortalIgniter;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class AncientPortalIgniter extends Item {
    public AncientPortalIgniter(Item.Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (stack.getItem() == stratos.Items.ModItems.ANCIENT_PORTAL_IGNITER && hand == Hand.MAIN_HAND) {
            BlockHitResult hitResult = Item.raycast(world, player, RaycastContext.FluidHandling.ANY);

            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockPos pos = hitResult.getBlockPos();
                BlockState blockState = world.getBlockState(pos);

                if (blockState.isOf(Blocks.REINFORCED_DEEPSLATE) && world instanceof ServerWorld) {
                    // Summon lightning at the block position
                    summonLightning(world, player, pos);

                    return TypedActionResult.success(stack);
                }
            }
        }

        return TypedActionResult.pass(stack);
    }

    private void summonLightning(World world, PlayerEntity player, BlockPos pos) {
        LightningEntity lightningEntity = (LightningEntity) EntityType.LIGHTNING_BOLT.create(world);
        lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(pos));
        world.spawnEntity(lightningEntity);

        if (player instanceof ServerPlayerEntity serverPlayer) {
            lightningEntity.setChanneler(serverPlayer);
        }

        world.spawnEntity(lightningEntity);


        }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.getItemCooldownManager().set(this,20);

        return TypedActionResult.success(itemStack, world.isClient());
    }
    }
