package net.wizards.client.armor;

import mod.azure.azurelibarmor.common.api.client.model.GeoModel;
import net.minecraft.util.Identifier;
import net.wizards.WizardsMod;
import net.wizards.item.WizardArmor;

public class WizardArmorModel extends GeoModel<WizardArmor> {
    @Override
    public Identifier getModelResource(WizardArmor object) {
        return Identifier.of(WizardsMod.ID, "geo/wizard_robes.geo.json");
    }

    @Override
    public Identifier getTextureResource(WizardArmor armor) {
        var textureId = armor.getFirstLayerId();
        return Identifier.of(textureId.getNamespace(), "textures/armor/" + textureId.getPath() + ".png");
    }

    @Override
    public Identifier getAnimationResource(WizardArmor animatable) {
        return null; // Identifier.of(WizardsMod.ID, "animations/armor_idle.json");
    }
}
