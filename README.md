# Optimizer Sodium Addon (Fabric 1.21.1)

Fabric Loader 0.20.1 · Fabric API 0.116.17+1.21.1 · Sodium 0.8.13 (optional) · modid `optimizersodiumaddon` · package `nadiendev.osa` · author NadienDev

Install it on both client and server. It adds no blocks, items or network packets.

## Building

```
JAVA_HOME="C:/Program Files/Java/jdk-21" ./gradlew build
```

The jar ends up in `build/libs/`. Loom 1.17.21 with Gradle 9.8.1 and JDK 21.

## Configuration

A single file: `config/optimizersodiumaddon.json`, with `server`, `common` and `client` sections (same names and defaults as the NeoForge version). The Discord webhook goes in `common.discord` and is never sent to players. It is read at startup; `/osa reload` reads it again. Dedicated server threads are still configured in `config/optimizersodiumaddon-threads.properties`.

Client options can also be edited from the "Optimizer Sodium Addon" page inside Sodium's video settings.

## Features and commands

Same as the NeoForge 1.21.1 version: armor stands, far-away mobs, items, XP orbs, asynchronous saving, background threads, Discord alerts, render limits, particles, GPU leak fix, borderless F11, fog and overlays, join timer and `/osa` (`stats`, `tps`, `top`, `kill`, `blockentities`, `alert test`, `memory`, plus `reload`).

## Credits and license

Parts of this mod are based on code from [Minecraft Borderless Window](https://www.curseforge.com/minecraft/mc-mods/minecraft-borderless-window) by [ArrivedBog593](https://www.curseforge.com/members/arrivedbog593/projects), used under the MIT License:

*   Borderless fullscreen and the F11 window modes
*   Fog toggles (terrain, water, lava and powder snow)
*   Screen overlay toggles (water and fire)

The original copyright notice and the full MIT License text are included in [THIRD_PARTY_NOTICES.txt](THIRD_PARTY_NOTICES.txt), which is also packaged inside the mod jar. Thanks to ArrivedBog593 for the original work.
