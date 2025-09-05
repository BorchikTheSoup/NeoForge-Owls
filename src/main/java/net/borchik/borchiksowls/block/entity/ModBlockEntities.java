package net.borchik.borchiksowls.block.entity;

import net.borchik.borchiksowls.OwlsMod;
import net.borchik.borchiksowls.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, OwlsMod.MOD_ID);

    public static final Supplier<BlockEntityType<OakOwlNestBlockEntity>> OAK_OWL_NEST_BE =
            BLOCK_ENTITIES.register("oak_owl_nest_be", ()-> BlockEntityType.Builder.of(
                    OakOwlNestBlockEntity::new, ModBlocks.OAK_OWL_NEST.get()).build(null));



    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
