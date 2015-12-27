package com.lessoner.treeores.Blocks;

import com.lessoner.treeores.TreeOresMod;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * Created by P8 on 19-Dec-15.
 */
public class TreeOresBlocks {

    // Logs
    public static Block TreeOresLogs1;
    public static Block TreeOresLogs2;
    public static Block TreeOresLogs3;
    // Leaves
    public static Block TreeOresLeaves1;
    public static Block TreeOresLeaves2;
    public static Block TreeOresLeaves3;
    // Saplings
    public static Block TreeOresSaplings1;
    public static Block TreeOresSaplings2;
    public static Block TreeOresSaplings3;
    // Leaves
    public static Block TreeOresBossLeaves1;
    public static Block TreeOresBossLeaves2;
    public static Block TreeOresBossLeaves3;
    // Saplings
    public static Block TreeOresBossSaplings1;
    public static Block TreeOresBossSaplings2;
    public static Block TreeOresBossSaplings3;

    public static void init(){
        // Logs
        TreeOresLogs1 = new TreeOresLogs1().setUnlocalizedName("tlogs1").setCreativeTab(TreeOresMod.treeOresTab);
        TreeOresLogs2 = new TreeOresLogs2().setUnlocalizedName("tlogs2").setCreativeTab(TreeOresMod.treeOresTab);
        TreeOresLogs3 = new TreeOresLogs3().setUnlocalizedName("tlogs3").setCreativeTab(TreeOresMod.treeOresTab);
        // Leaves
        TreeOresLeaves1 = new TreeOresLeaves1().setBlockName("tleaves1").setCreativeTab(TreeOresMod.treeOresTab);
        TreeOresLeaves2 = new TreeOresLeaves2().setBlockName("tleaves2").setCreativeTab(TreeOresMod.treeOresTab);
        TreeOresLeaves3 = new TreeOresLeaves3().setBlockName("tleaves3").setCreativeTab(TreeOresMod.treeOresTab);
        // Saplings
        TreeOresSaplings1 = new TreeOresSaplings1().setBlockName("tsaplings1").setCreativeTab(TreeOresMod.treeOresTab);
        TreeOresSaplings2 = new TreeOresSaplings2().setBlockName("tsaplings2").setCreativeTab(TreeOresMod.treeOresTab);
        TreeOresSaplings3 = new TreeOresSaplings3().setBlockName("tsaplings3").setCreativeTab(TreeOresMod.treeOresTab);
        // Leaves
        TreeOresBossLeaves1 = new TreeOresBossLeaves1().setBlockName("bleaves1").setCreativeTab(null);
        TreeOresBossLeaves2 = new TreeOresBossLeaves2().setBlockName("bleaves2").setCreativeTab(null);
        TreeOresBossLeaves3 = new TreeOresBossLeaves3().setBlockName("bleaves3").setCreativeTab(null);
        // Saplings
        TreeOresBossSaplings1 = new TreeOresBossSaplings1().setBlockName("bsaplings1").setCreativeTab(TreeOresMod.treeOresTab);
        TreeOresBossSaplings2 = new TreeOresBossSaplings2().setBlockName("bsaplings2").setCreativeTab(TreeOresMod.treeOresTab);
        TreeOresBossSaplings3 = new TreeOresBossSaplings3().setBlockName("bsaplings3").setCreativeTab(TreeOresMod.treeOresTab);

    }

    public static void register(){

    }

    private void registerRenderers(){

    }

    private void registerRenderer(Block block, int metadata, String blockName) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), metadata, new ModelResourceLocation(itemName, "inventory"));
    }
}
