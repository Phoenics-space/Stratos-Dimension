package stratos.Items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import stratos.block.ModBlocks;
import stratos.mod.ExampleMod;

public class ModItemGroups {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ExampleMod.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() -> new ItemStack(stratos.Items.ModItems.RUBY)).entries((displayContext, entries) -> {
                        entries.add(stratos.Items.ModItems.RUBY);

                        entries.add(stratos.Items.ModItems.ANCIENT_PORTAL_IGNITER);

                        entries.add(stratos.Items.ModItems.WATER_CHARGE);

                        entries.add(ModBlocks.RUBY_BLOCK);

                        entries.add(ModBlocks.RUBY_ORE);

                        entries.add(ModBlocks.STRATOS_STONE);

                        entries.add(ModBlocks.SKY_SEDIMENT);

                        entries.add(ModBlocks.SKY_SEDIMENT_BRICKS);

                        entries.add(ModBlocks.COBBLED_STRATOS_STONE);

                        entries.add(ModBlocks.STRATOS_STONE_WALL);

                        entries.add(ModBlocks.FRAME);

                        entries.add(ModBlocks.FRAME_FILLED);

                        entries.add(ModBlocks.FRAME_PORTAL);

                        entries.add(ModBlocks.AIR_MAHOE_LICHEN);

                        entries.add(ModBlocks.AIR_MAHOE_LOG);

                        entries.add(ModBlocks.AIR_MAHOE_WOOD);

                        entries.add(ModBlocks.STRIPPED_AIR_MAHOE_LOG);

                        entries.add(ModBlocks.STRIPPED_AIR_MAHOE_WOOD);

                        entries.add(ModBlocks.AIR_MAHOE_PLANKS);

                        entries.add(ModBlocks.AIR_MAHOE_STAIRS);

                        entries.add(ModBlocks.AIR_MAHOE_SLAB);

                        entries.add(ModBlocks.AIR_MAHOE_FENCE);

                        entries.add(ModBlocks.AIR_MAHOE_FENCE_GATE);

                        entries.add(ModBlocks.AIR_MAHOE_DOOR);

                        entries.add(ModBlocks.AIR_MAHOE_TRAPDOOR);

                        entries.add(ModBlocks.AIR_MAHOE_PRESSURE_PLATE);
                        //shingle
                        entries.add(ModBlocks.SHINGLE_LOG);

                        entries.add(ModBlocks.SHINGLE_WOOD);

                        entries.add(ModBlocks.STRIPPED_SHINGLE_LOG);

                        entries.add(ModBlocks.STRIPPED_SHINGLE_WOOD);

                        entries.add(ModBlocks.SHINGLE_PLANKS);

                        entries.add(ModBlocks.SHINGLE_STAIRS);

                        entries.add(ModBlocks.SHINGLE_SLAB);

                        entries.add(ModBlocks.SHINGLE_FENCE);

                        entries.add(ModBlocks.SHINGLE_FENCE_GATE);

                        entries.add(ModBlocks.SHINGLE_DOOR);

                        entries.add(ModBlocks.SHINGLE_TRAPDOOR);

                        entries.add(ModBlocks.SHINGLE_PRESSURE_PLATE);

                        entries.add(ModBlocks.SHINGLE_BUTTON);

                        entries.add(ModBlocks.SHINGLE_MYOZYT);





                        /* here we call ModFluids.BOILING_MUD_BUCKET because this Item is registered in the ModFluids Class */
                        //entries.add(ModFluids.BOILING_MUD_BUCKET);





                        entries.add(ModBlocks.AIR_MAHOE_SAPLING);

                        entries.add(ModBlocks.LICHEN_GROWTH);

                        entries.add(ModBlocks.LICHEN_GRASS);

                        entries.add(ModBlocks.AIR_SHROOM);

                        entries.add(ModBlocks.AIR_KELP);

                        entries.add(ModBlocks.SHROOM_MYOZYT);



                    }).build());


    public static void registerItemGroups() {
        ExampleMod.LOGGER.info("Registering Item Groups for " + ExampleMod.MOD_ID);
    }
}

