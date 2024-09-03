package net.wizards.mixin.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import net.wizards.effect.Effects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityFrozen {
    @Shadow public abstract boolean hasStatusEffect(RegistryEntry<StatusEffect> effect);

    @Inject(method = "baseTick", at = @At("TAIL"))
    public void baseTick_TAIL_FrozenByStatusEffect(CallbackInfo ci) {
        var entity = (LivingEntity) ((Object)this);
        entity.inPowderSnow = entity.inPowderSnow || hasStatusEffect(Effects.frozen.registryEntry);
    }

    @Inject(method = "jump", at = @At("HEAD"), cancellable = true)
    public void jump_HEAD_NoJumpingWhileFrozen(CallbackInfo ci) {
        if (hasStatusEffect(Effects.frozen.registryEntry)) {
            ci.cancel();
        }
    }
}
