# Optimizer Sodium Addon

NeoForge 1.21.11 (21.11.48) · Sodium 0.8.14 (config API) · modid `optimizersodiumaddon` · package `nadiendev.osa` · author NadienDev

Install it on **both client and server**. It adds no blocks, items or network packets.

## Building

```
JAVA_HOME="C:/Program Files/Java/jdk-21" ./gradlew build
```
The jar ends up in `build/libs/`.

## Differences from 1.21.1

- `SavedData` saving is already asynchronous in the base game, so only `level.dat` is saved on another thread (`performance.asyncSave`).
- The GPU memory leak is fixed by closing the textures and views of discarded `RenderTarget`s.
- The fog options modify the fog data of the render event (Blindness and Darkness fog is never touched).
- Dedicated server background threads are changed in `Util.maxAllowedExecutorThreads`.

All other features, config options and `/osa` commands are the same as in 1.21.1.

## Credits and license

Parts of this mod are based on code from [Minecraft Borderless Window](https://www.curseforge.com/minecraft/mc-mods/minecraft-borderless-window) by [ArrivedBog593](https://www.curseforge.com/members/arrivedbog593/projects), used under the MIT License:

*   Borderless fullscreen and the F11 window modes
*   Fog toggles (terrain, water, lava and powder snow)
*   Screen overlay toggles (water and fire)

The original copyright notice and the full MIT License text are included in [THIRD_PARTY_NOTICES.txt](THIRD_PARTY_NOTICES.txt), which is also packaged inside the mod jar. Thanks to ArrivedBog593 for the original work.
