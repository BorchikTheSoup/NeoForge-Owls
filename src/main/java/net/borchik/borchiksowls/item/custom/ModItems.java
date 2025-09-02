package net.borchik.borchiksowls.item.custom;

import net.borchik.borchiksowls.OwlsMod;
import net.borchik.borchiksowls.entity.ModEntities;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(OwlsMod.MOD_ID);

public static final DeferredItem OWL_SPAWN_EGG = ITEMS.register("owl_spawn_egg",
        ()-> new DeferredSpawnEggItem(ModEntities.OWL, 0x5b453c, 0x3a2212,
                new Item.Properties()));
public static final DeferredItem Elf_OWL_EGG = ITEMS.register("elf_owl_spawn_egg",
        ()-> new DeferredSpawnEggItem(ModEntities.ELF_OWL, 0x5b453c, 0x3a2212,
                new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
