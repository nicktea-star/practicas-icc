# Práctica 8 (Mini-Lab): La Clase Punto
**Introducción a las Ciencias de la Computación (Semestre 2027-1)**  
**Facultad de Ciencias, UNAM**

---

## Datos del alumno

> **Nota de privacidad:** Si publicas tu proyecto en un repositorio público de GitHub, **no es necesario que incluyas esta sección** en este archivo para proteger tu privacidad. Es suficiente con que tus datos completos estén registrados en la entrega directa de Google Classroom.

- **Nombre completo:** [Escribe aquí tu nombre completo]
- **Número de cuenta:** [Escribe aquí tu número de cuenta]
- **Correo institucional:** [tu_correo@ciencias.unam.mx]

---

## Descripción de la práctica

Breve descripción de los ejercicios realizados.
> Este paquete introduce una clase llamada `Punto`, para representar puntos en el plano real. Cuenta con métodos matemáticamente útiles como:
- Desplazar el punto
- Determinar distancia
- Establecer punto medio entre dos puntos
- Determinar a qué cuadrante pertenece
- Leer los datos del punto de manera cómoda
- Determinar si dos puntos son aproximadamente similares
- Determina la colinealidad de tres puntos
---

## Comandos para compilar, ejecutar y documentar

Ejecuta los siguientes comandos desde la terminal ubicado en la raíz de esta carpeta:

### 1. Compilación
```bash
javac src/* -d bin/
```

### 2. Ejecución de la verificación
```bash
java -cp bin/ PruebaPunto
```

### 3. Generación de documentación Javadoc
```bash
javadoc -d doc -author -version -notree -noindex -nohelp -nonavbar -nodeprecatedlist -notimestamp src/Punto.java
```

---

## Evidencia de ejecución

Copia y pega aquí el resumen final que mostró tu terminal al ejecutar `PruebaPunto`:

```text
================================================================================
  ICC 2027-1 | VERIFICACION AUTOMATIZADA: CLASE PUNTO (MINI-LAB 8)
================================================================================

>>> 1. PROBANDO CONSTRUCTORES Y GETTERS:
  [OK] Constructor por omision inicializa en (0.0, 0.0)
  [OK] Constructor con parametros inicializa en (3.0, 4.0)

>>> 2. PROBANDO SETTERS:
  [OK] Setters modifican correctamente las coordenadas

>>> 3. PROBANDO METODO DESPLAZAR:
  [OK] desplazar(1.5, -1.0) actualiza a (3.5, 2.0)

>>> 4. PROBANDO DISTANCIA EUCLIDIANA:
  [OK] Distancia de (0.0, 0.0) a (3.0, 4.0) es 5.0
  [OK] Distancia de (1.0, 2.0) a (4.0, 6.0) es 5.0
  [OK] Distancia con referencia null regresa -1.0

>>> 5. PROBANDO PUNTO MEDIO (OBJETO RETORNADO):
  [OK] Punto medio entre (1.0, 2.0) y (4.0, 6.0) es (2.5, 4.0)
  [OK] Punto medio con null regresa null

>>> 6. PROBANDO DETERMINACION DE CUADRANTES:
  [OK] Cuadrante de (5.0, 8.0) es I
  [OK] Cuadrante de (-3.0, 4.0) es II
  [OK] Cuadrante de (-2.0, -7.0) es III
  [OK] Cuadrante de (6.0, -1.0) es IV
  [OK] Cuadrante de (0.0, 5.0) en eje es 0
  [OK] Cuadrante del origen (0.0, 0.0) es 0

>>> 7. PROBANDO METODO toString():
  [OK] toString() de (3.0, 4.0) devuelve "(3.0, 4.0)"

>>> 8. PROBANDO METODO EQUALS (IDENTIDAD VS CONTENIDO):
  [OK] p1.equals(new Punto(3.0, 4.0)) retorna true
  [OK] p1.equals(new Punto(3.0, 4.1)) retorna false
  [OK] p1.equals(null) retorna false de forma segura

>>> 9. PROBANDO COLINEALIDAD (RETO: TRES PUNTOS EN UNA RECTA):
  [OK] (1,1), (2,2) y (5,5) estan alineados
  [OK] (1,1), (2,2) y (5,6) NO estan alineados

================================================================================
  RESUMEN DE PRUEBAS: 21 / 21 pruebas superadas con exito.
  ¡FELICIDADES! Todos los metodos de la clase Punto funcionan correctamente.
================================================================================

```

---

## Preguntas de reflexión (1.0 punto)

1. **¿Por qué el método `puntoMedio` crea y regresa un nuevo objeto `Punto`, mientras que `desplazar` modifica al mismo objeto que recibe el mensaje?**
   > Porque, en general, si se tienen dos puntos en el plano, su punto medio va a ser distinto de ellos mismos. Por esto, hace sentido que nuestra función cree un nuevo punto. Por el contrario, si la segunda función generara un punto nuevo, el nombre de nuestra función sería un poco engañoso, ya que en realidad estamos creando un nuevo punto, y el punto que se usa como argumento queda intacto.

2. **Al ejecutar `p1.distancia(p2)`, ¿a qué objeto en memoria hace referencia `this` y cómo accede el método a las coordenadas de `p2`?**
   > `this` hace referencia a p1, pues distancia es un método asociado al *objeto* p1, mientras que accede a las coordenadas de p2 con los setters que le escribimos.

3. **Observa el archivo `PruebaPunto.java`: ¿por qué los atributos `pruebasExitosas`, `totalPruebas` y el método `verificar` están declarados como `static`? ¿Qué ocurriría si les quitáramos la palabra `static` y los llamáramos desde `main`? Menciona además dos métodos estáticos de las bibliotecas estándar de Java que utilizaste en `Punto.java`.**
   > Porque es más conveniente que existan asociados a la clase que a un objeto. De lo contrario, tendríamos que generar un ejemplar de la clase `PruebaPunto`, de lo contrario, el compilador nos diría que estamos invocando un método de una cosa que no existe. Por esto mismo, hemos usado los métodos estáticos de la clase `Math` llamados `pow` y `abs`.
