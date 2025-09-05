package net.borchik.borchiksowls.block;

import net.borchik.borchiksowls.OwlsMod;
import net.borchik.borchiksowls.block.custom.OakOwlNestBlock;
import net.borchik.borchiksowls.item.custom.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(OwlsMod.MOD_ID);

    /* ALL THE BLOCKS*/

    public static final DeferredBlock<Block> OAK_OWL_NEST = registerBlock("oak_owl_nest",
            ()-> new OakOwlNestBlock(BlockBehaviour.Properties.of().noOcclusion()));




    /* REGISTRATION */

    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
