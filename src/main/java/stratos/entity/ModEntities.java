package stratos.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import stratos.entity.custom.WaterChargeProjectileEntity;
import stratos.mod.ExampleMod;

public class ModEntities {

    public static final EntityType<WaterChargeProjectileEntity> WATER_CHARGE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(ExampleMod.MOD_ID, "water_charge"),
            FabricEntityTypeBuilder.<WaterChargeProjectileEntity>create(SpawnGroup.MISC, WaterChargeProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());
}
