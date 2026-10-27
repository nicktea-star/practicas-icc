# Práctica 6 -- Entrada de datos y cierre de la Cabaña del Misterio
## Contenido

Este proyecto contiene tres programas:

- **PiInteractivo**: Aproxima el valor de pi con el método Monte Carlo lanzando
  un número ajustable de dardos (Actividad 1.1).
- **Binario Interactivo**: Convierte un número decimal introducido por el usuario
  a su anotación binaria continuamente hasta decida salir (Actividad 1.2).
- **CabanaDelMisterio**: Pide entradas de un cliente crediticio y valida sus datos
  varias operaciones accesibles mediante un menú interactivo (Parte 2 completa).
## Estructura

```
Practica06/
|-- Readme.md (este documento)
|-- src/    código fuente (.java)
|-- bin/    archivos compilados (.class)
|-- docs/   reporte en pdf (y código fuente LaTeX para compilarlo)
    |-- images/ imagenes (capturas de pantalla)
```
## Cómo compilar y ejecutar

Desde la carpeta `Practica05`:

```
javac -d bin src/*.java
```
Para compilar todos los archivos en `src/` y guardar el resultado en `bin/`

```
java -cp bin EstimacionPi
java -cp bin PrecisionPi
java -cp bin CotizadorPines
```
Para ejecutar un *bytecode* de la clase elegida.
