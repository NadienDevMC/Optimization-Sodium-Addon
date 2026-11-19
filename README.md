# Optimizer Sodium Addon

NeoForge 26.3 (26.3.0.76-beta) · modid `optimizersodiumaddon` · package `nadiendev.osa` · author NadienDev

Install it on **both client and server**. It adds no blocks, items or network packets.

## Building

```
gradlew build
```

Requires JDK 25. The jar ends up in `build/libs/`.

## Differences from 1.21.1

- SavedData saving is already asynchronous in the game itself, so only `level.dat` is moved to another thread.
- The GPU leak fix closes the textures and views of discarded `RenderTarget`s.
- Fog and overlays use the 26.3 events (`FogData`, `ATMOSPHERIC` type for terrain, `ExtractBlockScreenEffectEvent`).
- Dedicated server background threads are applied on top of `Util.maxAllowedExecutorThreads`.
- `/osa` permissions use the new permission system (gamemaster / admin / owner).
- The config types changed: what used to be SERVER is now `SYNCED` (`optimizersodiumaddon-synced.toml`) and what used to be COMMON is now `LOCAL` (`config/optimizersodiumaddon-local.toml`, where the Discord webhook goes).
- The `borderlessF11` option is removed: the 26.3 client already switches between windowed and borderless fullscreen by default.
- The Sodium options page uses `sodium-neoforge-api` 0.9.2+mc26.3.

Features, commands and the rest of the config options: same as in the 1.21.1 version.

## Credits and license

Parts of this mod are based on code from [Minecraft Borderless Window](https://www.curseforge.com/minecraft/mc-mods/minecraft-borderless-window) by [ArrivedBog593](https://www.curseforge.com/members/arrivedbog593/projects), used under the MIT License:

*   Fog toggles (terrain, water, lava and powder snow)
*   Screen overlay toggles (water and fire)

The original copyright notice and the full MIT License text are included in [THIRD_PARTY_NOTICES.txt](THIRD_PARTY_NOTICES.txt), which is also packaged inside the mod jar. Thanks to ArrivedBog593 for the original work.
