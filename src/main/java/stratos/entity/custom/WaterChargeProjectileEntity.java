package stratos.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import stratos.entity.ModEntities;

public class WaterChargeProjectileEntity extends ThrownItemEntity {
    public WaterChargeProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public WaterChargeProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.WATER_CHARGE, livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return stratos.Items.ModItems.WATER_CHARGE;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if(!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.getWorld().setBlockState(getBlockPos(), Fluids.WATER.getDefaultState().getBlockState());


            this.discard();
        super.onBlockHit(blockHitResult);
    }
}
}
