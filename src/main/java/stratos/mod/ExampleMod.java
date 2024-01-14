package stratos.mod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stratos.Items.ModItemGroups;
import stratos.Items.ModItems;
import stratos.block.ModBlocks;
import stratos.fluid.BoilingMudFLuid;
import stratos.fluid.ModFluids;
import stratos.particle.ModParticles;
import stratos.util.ModRegistries;
import stratos.world.gen.ModWorldGeneration;
import stratos.world.tree.AirMahoeTreeDecorator;
import stratos.world.tree.ModFoliagePlacerTypes;

public class ExampleMod
        implements ModInitializer {
    public static final String MOD_ID = "stratos";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ModRegistries.registerModRegistries();

        ModParticles.registerParticles();
        ModFluids.register();

        //ModTrunkPlacerTypes.register();
        ModFoliagePlacerTypes.register();

        ModWorldGeneration.generateModWorldGeneration();

        /* The Portal is now under:
        * 
        * stratos/util/ModRegistries/registerPortal()
        * 
        * */

        STILL_BOILING_MUD = Registry.register(Registries.FLUID, new Identifier("stratos", "acid"), new BoilingMudFLuid.Still());
        FLOWING_BOILING_MUD = Registry.register(Registries.FLUID, new Identifier("stratos", "flowing_acid"), new BoilingMudFLuid.Flowing());
        BOILING_MUD_BUCKET = Registry.register(Registries.ITEM, new Identifier("stratos", "acid_bucket"),
                new BucketItem(STILL_BOILING_MUD, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));

        BOILING_MUD = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "acid"), new FluidBlock(STILL_BOILING_MUD, FabricBlockSettings.copy(Blocks.LAVA)){});

    }
    public static FluidBlock BOILING_MUD;
    public static FlowableFluid STILL_BOILING_MUD;
    public static FlowableFluid FLOWING_BOILING_MUD;
    public static Item BOILING_MUD_BUCKET;

    public static TreeDecoratorType AIR_MAHOE_TREE_DECORATOR;

    }

