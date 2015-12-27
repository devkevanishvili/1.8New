package com.lessoner.treeores.Blocks;

import com.google.common.base.Predicate;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by P8 on 19-Dec-15.
 */
public class TreeOresLogs2 extends BlockLog{

    public static final PropertyEnum VARIANT = PropertyEnum.create("variant", TreeOresLogs2.EnumType.class, new Predicate()
    {
        public boolean apply(TreeOresLogs2.EnumType type)
        {
            return type.getMetadata() < 4;
        }
        public boolean apply(Object p_apply_1_)
        {
            return this.apply((TreeOresLogs2.EnumType)p_apply_1_);
        }
    });

    public TreeOresLogs2()
    {
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, TreeOresLogs2.EnumType.DIAMOND).withProperty(LOG_AXIS, EnumAxis.Y));
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(itemIn, 1, TreeOresLogs2.EnumType.DIAMOND.getMetadata()));
        list.add(new ItemStack(itemIn, 1, TreeOresLogs2.EnumType.EMERALD.getMetadata()));
        list.add(new ItemStack(itemIn, 1, TreeOresLogs2.EnumType.LAPIS.getMetadata()));
        list.add(new ItemStack(itemIn, 1, TreeOresLogs2.EnumType.OBSIDIAN.getMetadata()));
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, TreeOresLogs2.EnumType.byMetadata((meta & 3) % 4));

        switch (meta & 12)
        {
            case 0:
                iblockstate = iblockstate.withProperty(LOG_AXIS, EnumAxis.Y);
                break;
            case 4:
                iblockstate = iblockstate.withProperty(LOG_AXIS, EnumAxis.X);
                break;
            case 8:
                iblockstate = iblockstate.withProperty(LOG_AXIS, EnumAxis.Z);
                break;
            default:
                iblockstate = iblockstate.withProperty(LOG_AXIS, EnumAxis.NONE);
        }

        return iblockstate;
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0 | ((TreeOresLogs2.EnumType)state.getValue(VARIANT)).getMetadata();

        switch (TreeOresLogs2.SwitchEnumAxis.AXIS_LOOKUP[((EnumAxis)state.getValue(LOG_AXIS)).ordinal()])
        {
            case 1:
                i |= 4;
                break;
            case 2:
                i |= 8;
                break;
            case 3:
                i |= 12;
        }

        return i;
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {VARIANT, LOG_AXIS});
    }

    protected ItemStack createStackedBlock(IBlockState state)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, ((TreeOresLogs2.EnumType)state.getValue(VARIANT)).getMetadata());
    }

    /**
     * Get the damage value that this Block should drop
     */
    public int damageDropped(IBlockState state)
    {
        return ((TreeOresLogs2.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    static final class SwitchEnumAxis
    {
        static final int[] AXIS_LOOKUP = new int[EnumAxis.values().length];
        private static final String __OBFID = "CL_00002083";

        static
        {
            try
            {
                AXIS_LOOKUP[EnumAxis.X.ordinal()] = 1;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }

            try
            {
                AXIS_LOOKUP[EnumAxis.Z.ordinal()] = 2;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                AXIS_LOOKUP[EnumAxis.NONE.ordinal()] = 3;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }

    public static enum EnumType implements IStringSerializable
    {
        DIAMOND(0, "diamond"),
        EMERALD(1, "emerald"),
        LAPIS(2, "lapis"),
        OBSIDIAN(3, "obsidian");
        private static final TreeOresLogs2.EnumType[] META_LOOKUP = new TreeOresLogs2.EnumType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;


        private EnumType(int meta, String name)
        {
            this(meta, name, name);
        }

        private EnumType(int meta, String name, String unlocalizedName)
        {
            this.meta = meta;
            this.name = name;
            this.unlocalizedName = unlocalizedName;
        }

        public int getMetadata()
        {
            return this.meta;
        }

        public String toString()
        {
            return this.name;
        }

        public static TreeOresLogs2.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName()
        {
            return this.name;
        }

        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }

        static
        {
            TreeOresLogs2.EnumType[] var0 = values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2)
            {
                TreeOresLogs2.EnumType var3 = var0[var2];
                META_LOOKUP[var3.getMetadata()] = var3;
            }
        }
    }
}
