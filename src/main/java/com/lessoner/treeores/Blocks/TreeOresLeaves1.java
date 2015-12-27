package com.lessoner.treeores.Blocks;

import com.google.common.base.Predicate;
import com.lessoner.treeores.LeafColors;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sun.reflect.generics.tree.Tree;

import java.util.List;

/**
 * Created by P8 on 20-Dec-15.
 */
public class TreeOresLeaves1 extends BlockLeaves {
    public static final PropertyEnum VARIANT = PropertyEnum.create("variant", TreeOresLogs1.EnumType.class, new Predicate() {
        public boolean apply(TreeOresLogs1.EnumType type) {
            return type.getMetadata() < 4;
        }

        public boolean apply(Object p_apply_1_) {
            return this.apply((TreeOresLogs1.EnumType) p_apply_1_);
        }
    });

    public TreeOresLeaves1() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, TreeOresLogs1.EnumType.IRON).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
    }

    @SideOnly(Side.CLIENT)
    public int getRenderColor(IBlockState state) {
        if (state.getBlock() != this) {
            return super.getRenderColor(state);
        } else {
            TreeOresLogs1.EnumType enumtype = (TreeOresLogs1.EnumType) state.getValue(VARIANT);
            return enumtype == TreeOresLogs1.EnumType.GOLD ? LeafColors.gold() : (enumtype == TreeOresLogs1.EnumType.COAL ? LeafColors.coal()
                    : (enumtype == TreeOresLogs1.EnumType.IRON ? LeafColors.iron() : (enumtype == TreeOresLogs1.EnumType.REDSTONE ? LeafColors
                    .redstone() : super.getRenderColor(state))));
        }
    }

    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass) {
        IBlockState iblockstate = worldIn.getBlockState(pos);

        if (iblockstate.getBlock() == this) {
            TreeOresLogs1.EnumType enumtype = (TreeOresLogs1.EnumType) iblockstate.getValue(VARIANT);

            if (enumtype == TreeOresLogs1.EnumType.IRON) {
                return LeafColors.iron();
            }

            if (enumtype == TreeOresLogs1.EnumType.GOLD) {
                return LeafColors.gold();
            }
            if (enumtype == TreeOresLogs1.EnumType.COAL) {
                return LeafColors.coal();
            }

            if (enumtype == TreeOresLogs1.EnumType.REDSTONE) {
                return LeafColors.redstone();
            }
        }

        return super.colorMultiplier(worldIn, pos, renderPass);
    }

    protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) {
        if (state.getValue(VARIANT) == TreeOresLogs1.EnumType.IRON && worldIn.rand.nextInt(chance) == 0) {
            spawnAsEntity(worldIn, pos, new ItemStack(Items.iron_ingot, 1, 0));
        }
        if (state.getValue(VARIANT) == TreeOresLogs1.EnumType.GOLD && worldIn.rand.nextInt(chance) == 0) {
            spawnAsEntity(worldIn, pos, new ItemStack(Items.gold_ingot, 1, 0));
        }
        if (state.getValue(VARIANT) == TreeOresLogs1.EnumType.COAL && worldIn.rand.nextInt(chance) == 0) {
            spawnAsEntity(worldIn, pos, new ItemStack(Items.coal, 1, 0));
        }
        if (state.getValue(VARIANT) == TreeOresLogs1.EnumType.REDSTONE && worldIn.rand.nextInt(chance) == 0) {
            spawnAsEntity(worldIn, pos, new ItemStack(Items.redstone, 1, 0));
        }
    }

    protected int getSaplingDropChance(IBlockState state) {
        return state.getValue(VARIANT) == TreeOresLogs1.EnumType.REDSTONE ? 40 : super.getSaplingDropChance(state);
    }

    @Override
    public BlockPlanks.EnumType getWoodType(int meta) {
        return BlockPlanks.EnumType.byMetadata((meta & 3) % 4);
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
        list.add(new ItemStack(itemIn, 1, TreeOresLogs1.EnumType.IRON.getMetadata()));
        list.add(new ItemStack(itemIn, 1, TreeOresLogs1.EnumType.GOLD.getMetadata()));
        list.add(new ItemStack(itemIn, 1, TreeOresLogs1.EnumType.COAL.getMetadata()));
        list.add(new ItemStack(itemIn, 1, TreeOresLogs1.EnumType.REDSTONE.getMetadata()));
    }

    protected ItemStack createStackedBlock(IBlockState state) {
        return new ItemStack(Item.getItemFromBlock(this), 1, ((TreeOresLogs1.EnumType) state.getValue(VARIANT)).getMetadata());
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, this.getWoodType(meta)).withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state) {
        byte b0 = 0;
        int i = b0 | ((TreeOresLogs1.EnumType) state.getValue(VARIANT)).getMetadata();

        if (!((Boolean) state.getValue(DECAYABLE)).booleanValue()) {
            i |= 4;
        }

        if (((Boolean) state.getValue(CHECK_DECAY)).booleanValue()) {
            i |= 8;
        }

        return i;
    }


    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[]{VARIANT, CHECK_DECAY, DECAYABLE});
    }

    /**
     * Get the damage value that this Block should drop
     */
    public int damageDropped(IBlockState state) {
        return ((TreeOresLogs1.EnumType) state.getValue(VARIANT)).getMetadata();
    }

    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te) {
        if (!worldIn.isRemote && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Items.shears) {
            player.triggerAchievement(StatList.mineBlockStatArray[Block.getIdFromBlock(this)]);
        } else {
            super.harvestBlock(worldIn, player, pos, state, te);
        }
    }

    @Override
    public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        IBlockState state = world.getBlockState(pos);
        return new java.util.ArrayList(java.util.Arrays.asList(new ItemStack(this, 1, ((TreeOresLogs1.EnumType) state.getValue(VARIANT)).getMetadata())));
    }
}

