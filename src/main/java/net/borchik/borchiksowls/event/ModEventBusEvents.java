package net.borchik.borchiksowls.event;

import net.borchik.borchiksowls.OwlsMod;
import net.borchik.borchiksowls.entity.ModEntities;
import net.borchik.borchiksowls.entity.client.OwlModel;
import net.borchik.borchiksowls.entity.custom.OwlEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber (modid = OwlsMod.MOD_ID) //IF SOMETHING BREAKS ITS PROBABLY HERE CAUSE I DIDNT ADD A BIT OF STUFF
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(OwlModel.LAYER_LOCATION, OwlModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.OWL.get(), OwlEntity.createAttributes().build());
    }


}
