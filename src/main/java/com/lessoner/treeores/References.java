package com.lessoner.treeores;


import net.minecraftforge.fml.common.Mod;

/**
 * Created by Anguarmas on 9/22/2015.
 */
public class References {

    public static final String MODID = "treeores";
    public static final String VERSION = "1.1"; //TODO: Change every update
    public static final String NAME = "TreeOres Mod";
    public static final String CLIENTSIDEPROXY = "com.lessoner.treeores.Proxy.ClientProxy";
    public static final String SERVERSIDEPROXY = "com.lessoner.treeores.Proxy.CommonProxy";
    @Mod.Instance("treeores")
    public static TreeOresMod instance;
    public static boolean ironTree;
    public static boolean goldTree;
    public static boolean coalTree;
    public static boolean redstoneTree;
    public static boolean diamondTree;
    public static boolean emeraldTree;
    public static boolean lapisTree;
    public static boolean obsidianTree;
    public static boolean quartzTree;
    public static boolean glowstoneTree;
    public static boolean xpTree;

    public static boolean canFertilize;

    public static boolean enableChops;

    public static String oreDictLeaves;
    public static String oreDictLogs;
    public static String oreDictSaplings;

    public static String ironBossTexture = "treeores:textures/model/ironboss.png";
    public static String goldBossTexture = "treeores:textures/model/goldboss.png";
    public static String coalBossTexture = "treeores:textures/model/coalboss.png";
    public static String redstoneBossTexture = "treeores:textures/model/redstoneboss.png";
    public static String emeraldBossTexture = "treeores:textures/model/emeraldboss.png";
    public static String diamondBossTexture = "treeores:textures/model/diamondboss.png";
    public static String lapisBossTexture = "treeores:textures/model/lapisboss.png";
    public static String obsidianBossTexture = "treeores:textures/model/obsidianboss.png";
    public static String quartzBossTexture = "treeores:textures/model/quartzboss.png";
    public static String glowstoneBossTexture = "treeores:textures/model/glowstoneboss.png";
    public static String xpBossTexture = "treeores:textures/model/xpboss.png";

    //Thaumcraft
    public static String thaumiumBossTexture = "treeores:textures/model/THC/thaumiumboss.png";
    public static String airBossTexture = "treeores:textures/model/THC/airboss.png";
    public static String fireBossTexture = "treeores:textures/model/THC/fireboss.png";
    public static String waterBossTexture = "treeores:textures/model/THC/waterboss.png";
    public static String earthBossTexture = "treeores:textures/model/THC/earthboss.png";
    public static String orderBossTexture = "treeores:textures/model/THC/orderboss.png";
    public static String entropyBossTexture = "treeores:textures/model/THC/entropyboss.png";
    public static String cinnabarBossTexture = "treeores:textures/model/THC/cinnabarboss.png";

    public static String oreDictTHCLeaves;
    public static String oreDictTHCLogs;
    public static String oreDictTHCSaplings;

    public static boolean thaumiumTree;
    public static boolean airTree;
    public static boolean fireTree;
    public static boolean waterTree;
    public static boolean earthTree;
    public static boolean orderTree;
    public static boolean entropyTree;
    public static boolean cinnabarTree;
}
