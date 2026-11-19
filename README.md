# Optimizer Sodium Addon (Fabric 26.1.2)

Fabric Loader 0.20.1 · Fabric API 0.155.3+26.1.2 · Sodium 0.9.2 (config API, optional) · modid `optimizersodiumaddon` · package `nadiendev.osa` · author NadienDev

Install it on both client and server. It adds no blocks, items or network packets.

## Building

```
JAVA_HOME="C:/Program Files/Java/jdk-25.0.2" ./gradlew build
```

The jar ends up in `build/libs/`. Fabric Loom 1.19.3 (unobfuscated Minecraft) with Gradle 9.8.1 and JDK 25.

## Configuration

A single file: `config/optimizersodiumaddon.json`, with `server`, `common` and `client` sections (same names and defaults as the NeoForge version). The Discord webhook goes in `common.discord` and is never sent to players. It is read at startup; `/osa reload` reads it again. Dedicated server threads are still configured in `config/optimizersodiumaddon-threads.properties`.

Client options can also be edited from the "Optimizer Sodium Addon" page inside Sodium's video settings.

## Differences from 1.21.1

- `SavedData` saving is already asynchronous in the base game, so only `level.dat` is saved on another thread (`performance.asyncSave`).
- The GPU memory leak is fixed by closing the textures and views of discarded `RenderTarget`s.
- The fog options modify the fog data (Blindness and Darkness fog is never touched).
- Dedicated server background threads are changed in `Util.maxAllowedExecutorThreads`.

All other features, options and `/osa` commands are the same as in 1.21.1.

## Credits and license

Parts of this mod are based on code from [Minecraft Borderless Window](https://www.curseforge.com/minecraft/mc-mods/minecraft-borderless-window) by [ArrivedBog593](https://www.curseforge.com/members/arrivedbog593/projects), used under the MIT License:

*   Borderless fullscreen and the F11 window modes
*   Fog toggles (terrain, water, lava and powder snow)
*   Screen overlay toggles (water and fire)

The original copyright notice and the full MIT License text are included in [THIRD_PARTY_NOTICES.txt](THIRD_PARTY_NOTICES.txt), which is also packaged inside the mod jar. Thanks to ArrivedBog593 for the original work.
