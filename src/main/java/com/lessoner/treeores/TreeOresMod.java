package com.lessoner.treeores;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MODID, version = References.VERSION, name = References.NAME)
public class TreeOresMod
{

    public static CreativeTabs treeOresTab;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        treeOresTab = new CreativeTabs("treeOresTab") {
            @Override
            public Item getTabIconItem() {
                return Item.getItemFromBlock(Blocks.sapling);
            }
        };
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
