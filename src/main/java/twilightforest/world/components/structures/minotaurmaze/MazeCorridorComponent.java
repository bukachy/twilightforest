package twilightforest.world.components.structures.minotaurmaze;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import twilightforest.world.components.structures.TFStructureComponentOld;
import twilightforest.init.TFLandmark;
import twilightforest.init.TFStructurePieceTypes;


public class MazeCorridorComponent extends TFStructureComponentOld {

	public MazeCorridorComponent(StructurePieceSerializationContext ctx, CompoundTag nbt) {
		this(TFStructurePieceTypes.TFMMC.get(), nbt);
	}

	public MazeCorridorComponent(StructurePieceType piece, CompoundTag nbt) {
		super(piece, nbt);
	}

	public MazeCorridorComponent(StructurePieceType type, TFLandmark feature, int i, int x, int y, int z, Direction rotation) {
		super(type, feature, i, x, y, z);
		this.setOrientation(rotation);
		this.boundingBox = new BoundingBox(x, y, z, x + 5, y + 5, z + 5);
	}

	@Override
	public void postProcess(WorldGenLevel world, StructureManager manager, ChunkGenerator generator, RandomSource rand, BoundingBox sbb, ChunkPos chunkPosIn, BlockPos blockPos) {
		//arch
		this.generateBox(world, sbb, 1, 1, 2, 4, 4, 3, Blocks.OAK_FENCE.defaultBlockState(), AIR, false);
		this.generateAirBox(world, sbb, 2, 1, 2, 3, 3, 3);
	}
}
