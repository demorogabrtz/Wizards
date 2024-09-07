package net.wizards.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.util.Identifier;
import net.spell_engine.api.effect.CustomModelStatusEffect;
import net.spell_engine.api.effect.CustomParticleStatusEffect;
import net.spell_engine.api.render.CustomModels;
import net.wizards.WizardsMod;
import net.wizards.client.effect.FrostShieldRenderer;
import net.wizards.client.effect.FrozenParticles;
import net.wizards.client.effect.FrozenRenderer;
import net.wizards.client.effect.ArcaneChargeRenderer;
import net.wizards.effect.Effects;

import java.util.List;

public class WizardsClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CustomModels.registerModelIds(List.of(
                Identifier.of(WizardsMod.ID, "projectile/arcane_missile"),
                Identifier.of(WizardsMod.ID, "projectile/fireball_projectile"),
                Identifier.of(WizardsMod.ID, "projectile/fire_meteor"),
                Identifier.of(WizardsMod.ID, "projectile/frostbolt_projectile"),
                Identifier.of(WizardsMod.ID, "projectile/frost_shard_projectile"),
                ArcaneChargeRenderer.modelId,
                FrozenRenderer.modelId,
                FrostShieldRenderer.modelId_base,
                FrostShieldRenderer.modelId_overlay
        ));

        CustomModelStatusEffect.register(Effects.arcaneCharge.effect, new ArcaneChargeRenderer());
        CustomParticleStatusEffect.register(Effects.frostSlowness.effect, new FrozenParticles(1));
        CustomParticleStatusEffect.register(Effects.frozen.effect, new FrozenParticles(2));
        CustomModelStatusEffect.register(Effects.frozen.effect, new FrozenRenderer());
        CustomModelStatusEffect.register(Effects.frostShield.effect, new FrostShieldRenderer());
    }
}
