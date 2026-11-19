/*
 * Portions of this file are derived from Minecraft Borderless Window
 * (https://github.com/ArrivedBog593/Borderless-Window),
 * Copyright (c) 2026 ArrivedBog593, licensed under the MIT License.
 * See THIRD_PARTY_NOTICES.txt for the full license text.
 */
package nadiendev.osa.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import nadiendev.osa.client.VisualToggles;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ScreenEffectRenderer.class)
public abstract class ScreenEffectRendererMixin {

    @Inject(method = "renderWater", at = @At("HEAD"), cancellable = true)
    private static void osa$hideWater(Minecraft minecraft, PoseStack poseStack, CallbackInfo ci) {
        if (VisualToggles.hideWaterOverlay()) ci.cancel();
    }

    @Inject(method = "renderFire", at = @At("HEAD"), cancellable = true)
    private static void osa$hideFire(Minecraft minecraft, PoseStack poseStack, CallbackInfo ci) {
        if (VisualToggles.hideFireOverlay()) ci.cancel();
    }
}
