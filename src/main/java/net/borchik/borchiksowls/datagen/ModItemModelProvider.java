package net.borchik.borchiksowls.datagen;

import net.borchik.borchiksowls.OwlsMod;
import net.borchik.borchiksowls.item.custom.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, OwlsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        withExistingParent(ModItems.OWL_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
}
