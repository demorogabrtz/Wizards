package net.wizards.client.armor;

import mod.azure.azurelibarmor.common.api.client.renderer.GeoArmorRenderer;
import net.wizards.item.WizardArmor;

public class WizardArmorRenderer extends GeoArmorRenderer<WizardArmor> {
    public WizardArmorRenderer() {
        super(new WizardArmorModel());
    }
}
