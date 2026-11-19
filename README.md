# Optimizer Sodium Addon

NeoForge 1.21.11 (21.11.48) · Sodium 0.8.14 (API de configuracion) · modid `optimizersodiumaddon` · paquete `nadiendev.osa` · autor NadienDev

Se instala en **cliente y servidor**. No agrega bloques, items ni paquetes de red.

## Compilar

```
JAVA_HOME="C:/Program Files/Java/jdk-21" ./gradlew build
```
El jar queda en `build/libs/`.

## Diferencias con la version 1.21.1

- El guardado de `SavedData` ya es asincrono en el juego base, asi que solo se guarda `level.dat` en otro hilo (`performance.asyncSave`).
- La fuga de memoria de GPU se corrige cerrando las texturas y vistas de los `RenderTarget` descartados.
- Las opciones de niebla modifican los datos de niebla del evento de render (la de Ceguera y Oscuridad no se toca).
- Los hilos de fondo del servidor dedicado se cambian en `Util.maxAllowedExecutorThreads`.

El resto de funciones, opciones de configuracion y comandos `/osa` son los mismos que en 1.21.1.

## Credits and license

Parts of this mod are based on code from [Minecraft Borderless Window](https://www.curseforge.com/minecraft/mc-mods/minecraft-borderless-window) by [ArrivedBog593](https://www.curseforge.com/members/arrivedbog593/projects), used under the MIT License:

*   Borderless fullscreen and the F11 window modes
*   Fog toggles (terrain, water, lava and powder snow)
*   Screen overlay toggles (water and fire)

The original copyright notice and the full MIT License text are included in [THIRD_PARTY_NOTICES.txt](THIRD_PARTY_NOTICES.txt), which is also packaged inside the mod jar. Thanks to ArrivedBog593 for the original work.
