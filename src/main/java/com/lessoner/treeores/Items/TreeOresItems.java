package com.lessoner.treeores.Items;

import com.lessoner.treeores.TreeOresMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * Created by P8 on 19-Dec-15.
 */
public class TreeOresItems {

    public static Item TreeOresChops1;
    public static Item TreeOresChops2;
    public static Item TreeOresChops3;
    public static Item TreeOresBossSpawners1;
    public static Item TreeOresBossSpawners2;
    public static Item TreeOresBossSpawners3;
    public static Item TreeOresTransformers;
    public static Item TreeOresSpawnerParts;
    public static Item TreeOresNormalApples1;
    public static Item TreeOresNormalApples2;
    public static Item TreeOresNormalApples3;
    public static Item TreeOresEnchantedApples1;
    public static Item TreeOresEnchantedApples2;
    public static Item TreeOresEnchantedApples3;

    public static void init(){
        TreeOresChops1 = new TreeOresChops1().setTextureName("tchops").setUnlocalizedName("tchops1").setCreativeTab(TreeOresMod.treeOresTab);
        TreeOresChops2 = new TreeOresChops2().setTextureName("tchops").setUnlocalizedName("tchops2").setCreativeTab(TreeOresMod.treeOresTab);
        TreeOresChops3 = new TreeOresChops3().setTextureName("tchops").setUnlocalizedName("tchops3").setCreativeTab(TreeOresMod.treeOresTab);

        TreeOresNormalApples1 = new TreeOresNormalApples1(10,10,false).setAlwaysEdible().setTextureName("tapples").setUnlocalizedName("tapples1").setCreativeTab(TreeOresMod.treeOresTab);
        TreeOresNormalApples2 = new TreeOresNormalApples2(10,10,false).setAlwaysEdible().setTextureName("tapples").setUnlocalizedName("tapples2").setCreativeTab(TreeOresMod.treeOresTab);
        TreeOresNormalApples3 = new TreeOresNormalApples3(10,10,false).setAlwaysEdible().setTextureName("tapples").setUnlocalizedName("tapples3").setCreativeTab(TreeOresMod.treeOresTab);

        TreeOresEnchantedApples1 = new TreeOresEnchantedApples1(10,10,false).setAlwaysEdible().setTextureName("tapples").setUnlocalizedName("bapples1").setCreativeTab(TreeOresMod.treeOresTab);
        TreeOresEnchantedApples2 = new TreeOresEnchantedApples2(10,10,false).setAlwaysEdible().setTextureName("tapples").setUnlocalizedName("bapples2").setCreativeTab(TreeOresMod.treeOresTab);
        TreeOresEnchantedApples3 = new TreeOresEnchantedApples3(10,10,false).setAlwaysEdible().setTextureName("tapples").setUnlocalizedName("bapples3").setCreativeTab(TreeOresMod.treeOresTab);

        TreeOresBossSpawners1 = new TreeOresBossSpawners1().setTextureName("bspawner").setUnlocalizedName("bspawner1").setCreativeTab(TreeOresMod.treeOresTab);
        TreeOresBossSpawners2 = new TreeOresBossSpawners2().setTextureName("bspawner").setUnlocalizedName("bspawner2").setCreativeTab(TreeOresMod.treeOresTab);
        TreeOresBossSpawners3 = new TreeOresBossSpawners3().setTextureName("bspawner").setUnlocalizedName("bspawner3").setCreativeTab(TreeOresMod.treeOresTab);

        TreeOresTransformers = new TreeOresTransformers().setTextureName("transformers").setUnlocalizedName("transformers").setCreativeTab(TreeOresMod.treeOresTab);
        TreeOresSpawnerParts = new TreeOresSpawnerParts().setTextureName("bparts").setUnlocalizedName("bparts").setCreativeTab(TreeOresMod.treeOresTab);
    }

    public static void register(){

    }

    private void registerRenderers(){

    }

    private void registerRenderer(Item item, int metadata, String itemName) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, metadata, new ModelResourceLocation(itemName, "inventory"));
    }
}
