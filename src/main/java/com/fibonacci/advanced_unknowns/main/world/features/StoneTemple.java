

package com.fibonacci.advanced_unknowns.main.world.features;

import com.fibonacci.advanced_unknowns.reference.AU_Items;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;

import java.util.Random;

public class StoneTemple extends MapGenStructure implements IWorldGenerator {
	protected Block[] getValidSpawnBlocks() {
		return new Block[]{
				Blocks.grass,
				Blocks.stone,
				Blocks.dirt
		};
	}

	public boolean locationIsValidSpawn(World world, int i, int j, int k) {
		int distanceToAir = 0;
		Block check = world.getBlock(i, j, k);

		while (check != Blocks.air) {
			if (distanceToAir > 25) {
				return false;
			}

			distanceToAir++;
			check = world.getBlock(i, j + distanceToAir, k);
		}

		j += distanceToAir - 1;

		Block block = world.getBlock(i, j, k);
		Block blockAbove = world.getBlock(i, j + 1, k);
		Block blockBelow = world.getBlock(i, j - 1, k);

		for (Block x : getValidSpawnBlocks()) {
			if (blockAbove != Blocks.air) {
				return false;
			}
			if (block == x) {
				return true;
			} else if (block == Blocks.snow && blockBelow == x) {
				return true;
			}
		}

		return false;
	}

	public StoneTemple() {
	}

	@Override
	public String func_143025_a() {
		return "StoneTemple";
	}

	@Override
	protected boolean canSpawnStructureAtCoords(int x, int z) {

		return true;
	}

	@Override
	protected StructureStart getStructureStart(int p_75049_1_, int p_75049_2_) {
		return null;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	}

	public void setBlock(World world, int x, int y, int z, Block block, int metadata) {
		Block b1 = world.getBlock(x, y, z);

		if (b1.isAir(world, x, y, z) || b1.isLeaves(world, x, y, z)) {
			world.setBlock(x, y, z, block, metadata, 2);
		}
	}

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
		if (!locationIsValidSpawn(world, i, j, k) || !locationIsValidSpawn(world, i + 4, j, k) || !locationIsValidSpawn(world, i + 4, j, k + 4) || !locationIsValidSpawn(world, i, j, k + 4)) {
			return false;
		}



		this.setBlock(world, i + 0, j + 0, k + 0, Blocks.stonebrick, 1);
		this.setBlock(world, i + 0, j + 0, k + 1, Blocks.stonebrick, 1);
		this.setBlock(world, i + 0, j + 0, k + 2, Blocks.stonebrick, 1);
		this.setBlock(world, i + 0, j + 0, k + 3, Blocks.stonebrick, 1);
		this.setBlock(world, i + 0, j + 0, k + 4, Blocks.stonebrick, 1);
		this.setBlock(world, i + 0, j + 1, k + 0, Blocks.stonebrick, 1);
		this.setBlock(world, i + 0, j + 1, k + 1, Blocks.stonebrick, 1);
		this.setBlock(world, i + 0, j + 1, k + 2, Blocks.stonebrick, 1);
		this.setBlock(world, i + 0, j + 1, k + 3, Blocks.stonebrick, 1);
		this.setBlock(world, i + 0, j + 1, k + 4, Blocks.stonebrick, 1);
		this.setBlock(world, i + 0, j + 2, k + 0, Blocks.stonebrick, 2);
		this.setBlock(world, i + 0, j + 2, k + 1, Blocks.stonebrick, 2);
		this.setBlock(world, i + 0, j + 2, k + 2, Blocks.stonebrick, 2);
		this.setBlock(world, i + 0, j + 2, k + 3, Blocks.stonebrick, 2);
		this.setBlock(world, i + 0, j + 2, k + 4, Blocks.stonebrick, 2);
		this.setBlock(world, i + 0, j + 3, k + 0, Blocks.stonebrick, 3);
		this.setBlock(world, i + 0, j + 3, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 3, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 3, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 3, k + 4, Blocks.stonebrick, 3);
		this.setBlock(world, i + 0, j + 4, k + 0, Blocks.stonebrick, 3);
		this.setBlock(world, i + 0, j + 4, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 4, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 4, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 4, k + 4, Blocks.stonebrick, 3);
		this.setBlock(world, i + 0, j + 5, k + 0, Blocks.stonebrick, 3);
		this.setBlock(world, i + 0, j + 5, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 5, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 5, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 5, k + 4, Blocks.stonebrick, 3);
		this.setBlock(world, i + 0, j + 6, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 6, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 6, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 6, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 6, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 0, k + 0, Blocks.stonebrick, 1);
		this.setBlock(world, i + 1, j + 0, k + 1, Blocks.stonebrick, 1);
		this.setBlock(world, i + 1, j + 0, k + 2, Blocks.stonebrick, 1);
		this.setBlock(world, i + 1, j + 0, k + 3, Blocks.stonebrick, 1);
		this.setBlock(world, i + 1, j + 0, k + 4, Blocks.stonebrick, 1);
		this.setBlock(world, i + 1, j + 1, k + 0, Blocks.stonebrick, 1);
		this.setBlock(world, i + 1, j + 1, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 1, k + 2, Blocks.gold_block, 0);
		this.setBlock(world, i + 1, j + 1, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 1, k + 4, Blocks.stonebrick, 1);
		this.setBlock(world, i + 1, j + 2, k + 0, Blocks.stonebrick, 2);
		this.setBlock(world, i + 1, j + 2, k + 1, Blocks.stonebrick, 2);
		this.setBlock(world, i + 1, j + 2, k + 2, Blocks.stone_slab, 13);
		this.setBlock(world, i + 1, j + 2, k + 3, Blocks.stonebrick, 2);
		this.setBlock(world, i + 1, j + 2, k + 4, Blocks.stonebrick, 2);
		this.setBlock(world, i + 1, j + 3, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 3, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 3, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 3, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 3, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 4, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 4, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 4, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 4, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 4, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 5, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 5, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 5, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 5, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 5, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 6, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 6, k + 1, Blocks.stonebrick, 3);
		this.setBlock(world, i + 1, j + 6, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 6, k + 3, Blocks.stonebrick, 3);
		this.setBlock(world, i + 1, j + 6, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 0, k + 0, Blocks.stonebrick, 1);
		this.setBlock(world, i + 2, j + 0, k + 1, Blocks.stonebrick, 1);
		this.setBlock(world, i + 2, j + 0, k + 2, Blocks.stonebrick, 3);
		this.setBlock(world, i + 2, j + 0, k + 3, Blocks.stonebrick, 1);
		this.setBlock(world, i + 2, j + 0, k + 4, Blocks.stonebrick, 1);
		this.setBlock(world, i + 2, j + 1, k + 0, Blocks.stonebrick, 1);
		this.setBlock(world, i + 2, j + 1, k + 1, Blocks.redstone_block, 0);
		this.setBlock(world, i + 2, j + 1, k + 2, Blocks.chest, 3);
		TileEntityChest chest = new TileEntityChest();
		world.setTileEntity(i + 2, j + 1, k + 2, chest);
		Random random = new Random();

		chest.setInventorySlotContents(22, new ItemStack(AU_Items.expstorage, 1));
		chest.setInventorySlotContents(25, new ItemStack(AU_Items.blaster, 1));
		for(int x = 0; x < 10; x++){
			int slot = random.nextInt(20);
			chest.setInventorySlotContents(slot, new ItemStack(Items.redstone, 1));
		}
		this.setBlock(world, i + 2, j + 1, k + 3, Blocks.iron_block, 0);
		this.setBlock(world, i + 2, j + 1, k + 4, Blocks.stonebrick, 1);
		this.setBlock(world, i + 2, j + 2, k + 0, Blocks.stonebrick, 2);
		this.setBlock(world, i + 2, j + 2, k + 1, Blocks.stone_slab, 13);
		this.setBlock(world, i + 2, j + 2, k + 2, Blocks.stonebrick, 3);
		this.setBlock(world, i + 2, j + 2, k + 3, Blocks.stone_slab, 13);
		this.setBlock(world, i + 2, j + 2, k + 4, Blocks.stonebrick, 2);
		this.setBlock(world, i + 2, j + 3, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 3, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 3, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 3, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 3, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 4, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 4, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 4, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 4, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 4, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 5, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 5, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 5, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 5, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 5, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 6, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 6, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 6, k + 2, Blocks.stonebrick, 3);
		this.setBlock(world, i + 2, j + 6, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 6, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 0, k + 0, Blocks.stonebrick, 1);
		this.setBlock(world, i + 3, j + 0, k + 1, Blocks.stonebrick, 1);
		this.setBlock(world, i + 3, j + 0, k + 2, Blocks.stonebrick, 1);
		this.setBlock(world, i + 3, j + 0, k + 3, Blocks.stonebrick, 1);
		this.setBlock(world, i + 3, j + 0, k + 4, Blocks.stonebrick, 1);
		this.setBlock(world, i + 3, j + 1, k + 0, Blocks.stonebrick, 1);
		this.setBlock(world, i + 3, j + 1, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 1, k + 2, Blocks.lapis_block, 0);
		this.setBlock(world, i + 3, j + 1, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 1, k + 4, Blocks.stonebrick, 1);
		this.setBlock(world, i + 3, j + 2, k + 0, Blocks.stonebrick, 2);
		this.setBlock(world, i + 3, j + 2, k + 1, Blocks.stonebrick, 2);
		this.setBlock(world, i + 3, j + 2, k + 2, Blocks.stone_slab, 13);
		this.setBlock(world, i + 3, j + 2, k + 3, Blocks.stonebrick, 2);
		this.setBlock(world, i + 3, j + 2, k + 4, Blocks.stonebrick, 2);
		this.setBlock(world, i + 3, j + 3, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 3, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 3, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 3, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 3, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 4, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 4, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 4, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 4, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 4, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 5, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 5, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 5, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 5, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 5, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 6, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 6, k + 1, Blocks.stonebrick, 3);
		this.setBlock(world, i + 3, j + 6, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 6, k + 3, Blocks.stonebrick, 3);
		this.setBlock(world, i + 3, j + 6, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 0, k + 0, Blocks.stonebrick, 1);
		this.setBlock(world, i + 4, j + 0, k + 1, Blocks.stonebrick, 1);
		this.setBlock(world, i + 4, j + 0, k + 2, Blocks.stonebrick, 1);
		this.setBlock(world, i + 4, j + 0, k + 3, Blocks.stonebrick, 1);
		this.setBlock(world, i + 4, j + 0, k + 4, Blocks.stonebrick, 1);
		this.setBlock(world, i + 4, j + 1, k + 0, Blocks.stonebrick, 1);
		this.setBlock(world, i + 4, j + 1, k + 1, Blocks.stonebrick, 1);
		this.setBlock(world, i + 4, j + 1, k + 2, Blocks.stonebrick, 1);
		this.setBlock(world, i + 4, j + 1, k + 3, Blocks.stonebrick, 1);
		this.setBlock(world, i + 4, j + 1, k + 4, Blocks.stonebrick, 1);
		this.setBlock(world, i + 4, j + 2, k + 0, Blocks.stonebrick, 2);
		this.setBlock(world, i + 4, j + 2, k + 1, Blocks.stonebrick, 2);
		this.setBlock(world, i + 4, j + 2, k + 2, Blocks.stonebrick, 2);
		this.setBlock(world, i + 4, j + 2, k + 3, Blocks.stonebrick, 2);
		this.setBlock(world, i + 4, j + 2, k + 4, Blocks.stonebrick, 2);
		this.setBlock(world, i + 4, j + 3, k + 0, Blocks.stonebrick, 3);
		this.setBlock(world, i + 4, j + 3, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 3, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 3, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 3, k + 4, Blocks.stonebrick, 3);
		this.setBlock(world, i + 4, j + 4, k + 0, Blocks.stonebrick, 3);
		this.setBlock(world, i + 4, j + 4, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 4, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 4, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 4, k + 4, Blocks.stonebrick, 3);
		this.setBlock(world, i + 4, j + 5, k + 0, Blocks.stonebrick, 3);
		this.setBlock(world, i + 4, j + 5, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 5, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 5, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 5, k + 4, Blocks.stonebrick, 3);
		this.setBlock(world, i + 4, j + 6, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 6, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 6, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 6, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 6, k + 4, Blocks.air, 0);

		return true;
	}
}