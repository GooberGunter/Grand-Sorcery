package com.GooberGunter.GrandSorcery;

import java.util.logging.Logger;

import com.GooberGunter.GrandSorcery.client.gui.GSGuiHandler;
import com.GooberGunter.GrandSorcery.common.items.ItemOldTome;
import com.GooberGunter.GrandSorcery.common.networking.GrandSorceryPacketHandler;
import com.GooberGunter.GrandSorcery.common.proxy.CommonProxy;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/**
 * This class is what initializes the proxies. Since we have the proxies initialized for the three different methods that are run on startup, 
 * we can simply run everything else throught the specific proxies and keep this class clean
 * @author Justin
 *
 */
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
@Mod(modid = GSReferences.MODID, version = GSReferences.VERSION, useMetadata = true)
public class GrandSorcery
{
	
	@SidedProxy(clientSide="com.GooberGunter.GrandSorcery.common.proxy.ClientProxy", serverSide="com.GooberGunter.GrandSorcery.common.proxy.ServerProxy")
	public static CommonProxy proxy;
	
	public static GrandSorceryPacketHandler handler;
	
	@Instance
	public static GrandSorcery instance = new GrandSorcery();
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		//
		Util.logger = Logger.getLogger(GSReferences.MODID);
		proxy.preInit(event);
		
		Util.logger.info("preinit finished");
	}
	
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init(event);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GSGuiHandler());
        Util.logger.info("init finished");
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {
    	//
    	proxy.postInit(event);
    	Util.logger.info("postinit finished");
    }
    
    
}

/** CHECK THAT SHIT
 * Please use the registry events to register your blocks, items and other registry entries.
Use ModelLoader.setCustomModelResourceLocation in ModelRegistryEvent to register your item models. Do not use the ItemModelMesher.

Do not use methods that are deprecated in Forge or vanilla Minecraft. Usually there will be an explanatory method next to the method explaining what to use instead.
There is an exception for methods in the Block class, these may be overridden. Instead of calling them, use the one in IBlockState resp. it's supertypes. 

Do not use ITileEntityProvider or BlockContainer. These classes are legacy vanilla code. To add a TileEntity to your Block, override hasTileEntity and createTileEntity in your Block class. 

Do not use IInventory. Use the capability API with IItemHandler.

Do not reach across logical sides. This will cause subtle and not-so-subtle issues that may occur randomly and very rarely. Read and understand the documentation about sides to understand why this is a bad idea.

Do not use the unlocalized names for things other than displaying the name of a block/item. If you want to access the registry name for a registry entry, use IForgeRegistryEntry::getRegistryName.

Do not use numerical IDs for registry entries. They can and will change. Use the static references in e.g. the Items class or use textual IDs (e.g. minecraft:stone) if you need dynamic references.

Any IForgeRegistryEntry (commonly items and blocks) is singleton-like. That means that there is only once instance of your block class. There is not one block instances for every position in the world. This means that you cannot store position-related things as instance fields in your block class, etc.

Unlocalized names and TileEntity registration names should contain your ModID to avoid collisions between mods.

A TileEntity class must have a no-argument constructor. As a general recommendation a TileEntity should not have more than this one constructor, to avoid confusion.

An ItemStack variable should never be null and all of vanilla and Forge code expects this to be the case. Use ItemStack.EMPTY instead of null and ItemStack::isEmpty to check for empty stacks. Do not compare against ItemStack.EMPTY.

Registry names and asset file names must be completely lowercase.**/
 