package com.vieuxcomputers;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.server.FMLServerStoppingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vieuxcomputers.init.BlocksInit;
import com.vieuxcomputers.init.ItemsInit;

import java.util.stream.Collectors;

@Mod("vieuxcomputers")
public class VieuxComputers {
	
    public static final Logger LOGGER = LogManager.getLogger();

    public VieuxComputers() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	LOGGER.info("Loading Lua 5.2 DLL..");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
        
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        InterModComms.sendTo("vieuxcomputers", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
       	// TODO register worker threads
    }
    
    @SubscribeEvent
    public void onServerStopping(FMLServerStoppingEvent event) {
    	// TODO unregister workers threads
    }
    
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
    	
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
        	IForgeRegistry<Block> blockRegistry = blockRegistryEvent.getRegistry();
        	BlocksInit.registerBlocks(blockRegistry);
        }
        
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
        	IForgeRegistry<Item> itemRegistry = itemRegistryEvent.getRegistry();
        	ItemsInit.registerItems(itemRegistry);
        }
        
    }
}
