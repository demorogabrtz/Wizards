package net.wizards;

import net.fabric_extras.structure_pool.api.StructurePoolConfig;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.spell_engine.api.item.ItemConfig;
import net.tinyconfig.ConfigManager;
import net.wizards.config.Default;
import net.wizards.config.TweaksConfig;
import net.wizards.effect.Effects;
import net.wizards.item.Armors;
import net.wizards.item.Group;
import net.wizards.item.Weapons;
import net.wizards.item.WizardBooks;
import net.wizards.villager.WizardVillagers;

public class WizardsMod {
    public static final String ID = "wizards";

    public static ConfigManager<ItemConfig> itemConfig = new ConfigManager<>
            ("items_v5", Default.itemConfig)
            .builder()
            .setDirectory(ID)
            .sanitize(true)
            .build();
    public static ConfigManager<StructurePoolConfig> villageConfig = new ConfigManager<>
            ("villages", Default.villageConfig)
            .builder()
            .setDirectory(ID)
            .sanitize(true)
            .build();
    public static ConfigManager<TweaksConfig> tweaksConfig = new ConfigManager<>
            ("tweaks", new TweaksConfig())
            .builder()
            .setDirectory(ID)
            .sanitize(true)
            .build();

    public static void init() {
        itemConfig.refresh();
        tweaksConfig.refresh();
        villageConfig.refresh();
        Registry.register(Registries.ITEM_GROUP, Group.KEY, Group.WIZARDS);
        WizardBooks.register();
        Weapons.register(itemConfig.value.weapons);
        Armors.register(itemConfig.value.armor_sets);
        itemConfig.save();
        Effects.register();
        WizardVillagers.register();
    }
}