# Optimization Sodium Addon

Lag reduction for big modpacks, on the server and on the client. It adds no blocks or items and sends no network packets, so players without it can join a server that has it, and you can remove it at any time.

## Server

*   **Armor stands**: no more push checks every tick, and they tick less when no player is near.
*   **Far-away mobs**: mobs with no player nearby only tick 1 in N ticks (default 1 in 4). Activation range and a whitelist are configurable.
*   **Dropped items**: merge from a wider radius and despawn sooner (default 3 minutes).
*   **XP orbs**: nearby orbs merge into one. Turns itself off if Clumps is installed.
*   **Asynchronous saving**: world data and `level.dat` are written off the main thread and flushed on shutdown. On 1.21.11 and newer vanilla already saves world data in the background, so the addon only handles `level.dat`.
*   **Dedicated server threads**: background workers can use every CPU core (configurable).
*   **Crafting**: tries the last used recipe first, which saves a lot of time on packs with thousands of recipes.
*   **Discord lag alerts**: a webhook message when the tick time stays high or a single chunk holds too many entities.
*   **Optional**: remove the "Moved too quickly" check. Off by default, because it disables an anti-cheat protection.

## Client

*   **Render limits**: only the closest armor stands, dropped items and XP orbs are drawn, with a distance cap for each.
*   **Particle caps**: limits on live particles, new particles per tick and distance.
*   **GPU memory leak fix**: frees video memory from render targets the game drops without closing.
*   **Borderless fullscreen**: F11 switches between windowed and borderless. Not included on 26.3, where the game already does it. Based on [Minecraft Borderless Window](https://www.curseforge.com/minecraft/mc-mods/minecraft-borderless-window) (MIT).
*   **Fog and overlays**: switch off terrain, water, lava and powder snow fog, and the water and fire screen overlays. Blindness and Darkness fog are never touched. Based on [Minecraft Borderless Window](https://www.curseforge.com/minecraft/mc-mods/minecraft-borderless-window) (MIT).
*   **Join timer**: shows how long each stage of joining a server took, so you can see what is slow.
*   **Compact Machines preview fix** (NeoForge 1.21.1 only): frees the memory of the 3D room preview. Works with Compact Machines and Compact Machines: Sandbox Edition.

## Sodium

With Sodium installed, the addon adds its own section to Sodium's video settings, with pages for General, Fog and overlays, Render limits and Particles. Sodium is optional. On NeoForge the options are also in the Mods menu. Sodium 1.20.1 has no config API, so on 1.20.1 the client options live in the config file.

## Commands

All need OP.

*   `/osa stats` entities, items, XP, armor stands, block entities and chunks per dimension, plus RAM
*   `/osa tps` tick time and TPS
*   `/osa top [n]` the heaviest chunks around you, with coordinates
*   `/osa kill items|xp|armorstands|hostile|passive|mobs [radius]` cleans up entities. Never touches players, named, tamed, leashed or ridden mobs, or bosses
*   `/osa blockentities list [radius]` block entities by type
*   `/osa memory [gc|heapdump]` RAM and GC stats, force a GC, or dump the heap
*   `/osa alert test` sends a test message to Discord
*   `/osa reload` reloads the config (Fabric)

## Supported versions

| Minecraft | NeoForge | Fabric |
| --------- | -------- | ------ |
| 1.20.1    | -        | yes    |
| 1.21.1    | yes      | yes    |
| 1.21.11   | yes      | yes    |
| 26.1.2    | yes      | yes    |
| 26.2      | yes      | yes    |
| 26.3      | yes      | yes    |

Fabric versions need Fabric API.

## Configuration

Every feature has an on/off switch and its values in the config folder. NeoForge uses `optimizersodiumaddon-client.toml`, `optimizersodiumaddon-common.toml` (this is where the Discord webhook goes, and it is never sent to players) and the server config of each world. Fabric uses a single `optimizersodiumaddon.json`.

## FAQ

**Do I need Sodium?** No. The client options page only appears when Sodium is installed.

**Client, server or both?** Both for the full effect. Server only gives you the server features, and client only gives you the client features.

**Is it safe to remove?** Yes. It adds no content to the world.

## Credits and license

Parts of this mod are based on code from [Minecraft Borderless Window](https://www.curseforge.com/minecraft/mc-mods/minecraft-borderless-window) by [ArrivedBog593](https://www.curseforge.com/members/arrivedbog593/projects), used under the MIT License:

*   Borderless fullscreen and the F11 window modes
*   Fog toggles (terrain, water, lava and powder snow)
*   Screen overlay toggles (water and fire)

The original copyright notice and the full MIT License text are included in the [LICENSE](https://github.com/NadienDevMC/Optimization-Sodium-Addon/blob/Neo/1.21.1/LICENSE) file. Thanks to ArrivedBog593 for the original work.
