/*
 * Portions of this file are derived from Minecraft Borderless Window
 * (https://github.com/ArrivedBog593/Borderless-Window),
 * Copyright (c) 2026 ArrivedBog593, licensed under the MIT License.
 * See THIRD_PARTY_NOTICES.txt for the full license text.
 */
package nadiendev.osa.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import nadiendev.osa.client.VisualToggles;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.fog.FogRenderer;
import net.minecraft.client.renderer.fog.environment.FogEnvironment;
import net.minecraft.world.level.material.FogType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;

@Mixin(FogRenderer.class)
public abstract class FogRendererMixin {
    @Shadow
    @Final
    private static List<FogEnvironment> FOG_ENVIRONMENTS;

    @ModifyReturnValue(method = "setupFog", at = @At("RETURN"))
    private FogData osa$adjustFog(FogData fog, Camera camera, int renderDistanceInChunks, DeltaTracker deltaTracker,
                                  float darkenWorldAmount, ClientLevel level) {
        FogType type = camera.getFluidInCamera();
        if (type == FogType.NONE) type = FogType.ATMOSPHERIC;
        FogEnvironment chosen = null;
        for (FogEnvironment environment : FOG_ENVIRONMENTS) {
            if (environment.isApplicable(type, camera.entity())) {
                chosen = environment;
                break;
            }
        }
        VisualToggles.adjustFog(fog, type, chosen);
        return fog;
    }
}
