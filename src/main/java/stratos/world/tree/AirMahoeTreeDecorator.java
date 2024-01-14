package stratos.world.tree;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import stratos.block.ModBlocks;
import stratos.mod.ExampleMod;

public class AirMahoeTreeDecorator extends TreeDecorator {
    public static final AirMahoeTreeDecorator INSTANCE = new AirMahoeTreeDecorator();
    // Our constructor doesn't have any arguments, so we create a unit codec that returns the singleton instance
    public static final Codec<AirMahoeTreeDecorator> CODEC = Codec.unit(() -> INSTANCE);

    private AirMahoeTreeDecorator() {}

    @Override
    protected TreeDecoratorType<?> getType() {
        return ExampleMod.AIR_MAHOE_TREE_DECORATOR;
    }

    @Override
    public void generate(TreeDecorator.Generator generator) {
        // Iterate through block positions
        generator.getLogPositions().forEach(pos -> {
            Random random = generator.getRandom();
            // Pick a value from 0 (inclusive) to 4 (exclusive) and if it's 0, continue
            // This is the chance for spawning the gold block
            if (random.nextInt(4) == 0) {
                // Pick a random value from 0 to 4 and determine the side where the gold block will be placed using it
                int sideRaw = random.nextInt(4);
                Direction side = switch (sideRaw) {
                    case 0 -> Direction.NORTH;
                    case 1 -> Direction.SOUTH;
                    case 2 -> Direction.EAST;
                    case 3 -> Direction.WEST;
                    default -> throw new ArithmeticException("The picked side value doesn't fit in the 0 to 4 bounds");
                };

                // Offset the log position by the resulting side
                BlockPos targetPosition = logPosition.offset(side, 1);

                // Place the Lichen block using the replacer BiConsumer
                // This is the standard way of placing blocks in TrunkPlacers, FoliagePlacers and TreeDecorators
                replacer.accept(targetPosition, ModBlocks.AIR_MAHOE_LICHEN .getDefaultState());


            }
        });

    }
}

