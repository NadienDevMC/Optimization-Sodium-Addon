/*
 * Portions of this file are derived from Minecraft Borderless Window
 * (https://github.com/ArrivedBog593/Borderless-Window),
 * Copyright (c) 2026 ArrivedBog593, licensed under the MIT License.
 * See THIRD_PARTY_NOTICES.txt for the full license text.
 */
package nadiendev.osa.mixin.client;

import com.mojang.blaze3d.platform.Window;
import nadiendev.osa.config.OsaConfig;
import nadiendev.osa.client.BorderlessWindow;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Window.class)
public abstract class WindowMixin {
    @Shadow
    @Final
    private long window;

    @Inject(method = "toggleFullScreen", at = @At("HEAD"), cancellable = true)
    private void osa$borderless(CallbackInfo ci) {
        if (!OsaConfig.clientReady() || !OsaConfig.CLIENT.window.borderlessF11) return;
        if (BorderlessWindow.toggle(this.window)) ci.cancel();
    }
}
