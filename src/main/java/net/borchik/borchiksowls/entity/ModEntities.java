package net.borchik.borchiksowls.entity;

import net.borchik.borchiksowls.OwlsMod;
import net.borchik.borchiksowls.entity.custom.ElfOwlEntity;
import net.borchik.borchiksowls.entity.custom.OwlEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, OwlsMod.MOD_ID);

    public static final Supplier<EntityType<OwlEntity>> OWL =
            ENTITY_TYPES.register("owl", ()-> EntityType.Builder.of(OwlEntity::new, MobCategory.CREATURE).
                    sized(0.5f, 0.5f).build("owl"));

    public static final Supplier<EntityType<ElfOwlEntity>> ELF_OWL =
            ENTITY_TYPES.register("elf_owl", ()-> EntityType.Builder.of(ElfOwlEntity::new, MobCategory.CREATURE).
                    sized(0.3f, 0.4f).build("elf_owl"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
