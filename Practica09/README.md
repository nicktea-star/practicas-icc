# Práctica 9: Agregación, Clonación de Objetos y Guías de Envío
**Introducción a las Ciencias de la Computación (Semestre 2027-1)**  
**Facultad de Ciencias, UNAM**

---

## Datos del alumno

> **Nota de privacidad:** Si publicas tu proyecto en un repositorio público de GitHub, **no es necesario que incluyas esta sección** en este archivo para proteger tu privacidad. Es suficiente con que tus datos completos estén registrados en la entrega directa de Google Classroom.

- **Nombre completo:** [Escribe aquí tu nombre completo]
- **Número de cuenta:** [Escribe aquí tu número de cuenta]
- **Correo institucional:** [tu_correo@ciencias.unam.mx]

---

## Descripción de la práctica y decisiones de diseño en los métodos y clases

Describe brevemente los atributos, constructores y métodos que decidiste diseñar para `Persona.java`, así como tu implementación de `Envio.java`:
>

---

## Comandos para compilar, ejecutar y documentar

Ejecuta los siguientes comandos desde la terminal ubicado en la raíz de esta carpeta (`practica09/`):

### 1. Compilación
```bash
javac src/* -d bin/
```

### 2. Ejecución de pruebas y simulación (`PruebaEnvio`)
```bash
java -cp bin/ PruebaEnvio
```

### 3. Ejecución del menú interactivo (`MenuPostal`)
```bash
java -cp bin/ MenuPostal
```

### 4. Generación de documentación Javadoc
```bash
javadoc -d doc - author - version src /*. java
```

---

## Evidencia de ejecución

### 1. Salida de `PruebaEnvio`
Copia y pega aquí la salida final que mostró tu terminal al ejecutar `PruebaEnvio`:

```text
================================================================================
  ICC 2027-1 | PRACTICA 9: AGREGACION, CLONACION Y GUIAS DE ENVIO
================================================================================

>>> PARTE 1: REPRESENTACION TEXTUAL Y CLONACION DE PAQUETE
  [OK]    Paquete.toString() incluye el codigo de rastreo
  [OK]    Constructor por copia de Paquete crea instancia independiente en memoria
  [OK]    Modificar el codigo del paquete clonado no altera el paquete plantilla original
  [OK]    Constructor por copia con null asigna valores predeterminados validos

>>> PARTE 2: VERIFICACION DE LA CLASE PERSONA
  [OK]    Misma ubicación funciona para mismas ubicaciones
  [OK]    Es la misma persona funciona
  [OK]    Funciona toString

>>> PARTE 3: VERIFICACION DE ENVIO Y FOLIOS AUTOMATICOS
  [OK]    El contador de folios empieza en 0
  [OK]    Primer guia tiene folio
  [OK]    Segunda guia tiene folio
  [OK]    Las dos guias tienen folios distintos
  [OK]    La primer guia tiene numero 1
  [OK]    La segunda guia tiene numero 2
  [OK]    Se emitieron dos guias
  [OK]    Funciona esEnvioForaneo
  [OK]    Funciona esAutoEnvio
  [OK]    Funciona calcularCostoTotal
  [OK]    cambiarDestinatario rechaza null
  [OK]    cambiarDestinatario acepta otra persona
  [OK]    cambiarDestinatario acepta a la misma persona

>>> PARTE 4: SIMULACION DE ENVIOS, CLONACION DE GUIA Y RETORNO
  [OK]    El paquete clonado conserva remitente
  [OK]    El paquete clonado conserva destinatario
  [OK]    El paquete clonado tiene un nuevo paquete
  [OK]    El paquete clonado tiene folio consecutivo
  [OK]    El remitente del retorno es Y
  [OK]    El destinatario del retorno es X
  [OK]    El paquete del retorno es una copia independiente
  [OK]    El paquete tiene prefijo RET-
  [OK]    El retorno tiene un folio consecutivo

Estos son los detalles del envío: 
Folio: GUIA-OJX-5
Detalles del remitente: 
Las especificaciones del cliente son: 
Código alfanumerico: ID-002
Nombre completo: Geovani Martinez Martinez
Codigo Postal: 14748
¿Es cliente preferencial?false
Detalles del destinatario: 
Las especificaciones del cliente son: 
Código alfanumerico: ID-001
Nombre completo: Victor Manuel Mendiola
Codigo Postal: 14748
¿Es cliente preferencial?false
Detalles del paquete: 
Las especificaciones de su paquete son: 
Código de rastreo: RET-KIT-101
Peso real: 4.0
Peso volumétrico: 1.6
Peso cobrable: 4.0
Valor declarado500.0
Modalidad expressfalse
No es un envío personal


Total de guias emitidas por el sistema: 5 


================================================================================
  RESUMEN DE PRUEBAS: 29 / 29 pruebas superadas con exito
================================================================================
```

### 2. Ejemplo de ejecución interactiva (`MenuPostal`)
Copia y pega aquí un ejemplo sencillo de interacción en terminal ejecutando `MenuPostal`:

```text
================================================================
  SISTEMA INTERACTIVO DE GUIAS POSTALES | ICC 2027-1
================================================================

--- MENU PRINCIPAL ---
1. Emitir nueva guia de envio
2. Clonar guia activa con un nuevo paquete (mismo remitente y destinatario)
3. Clonar paquete de la guia activa para enviarlo a otro destinatario
4. Generar guia de retorno (devolucion al remitente)
5. Mostrar detalle y costo de la guia activa
0. Salir
Seleccione una opcion: 1

--- Captura de datos del REMITENTE ---

--- Captura de datos de una Persona ---
  Codigo de identificacion (ej. ID-001): ID-001
  Nombre legal (ej. Oscar Constatino Hernandez): Oscar Constantino Hernandez
  Codigo postal (ej. 01001): 16569
  Indique si es cliente preferencial (s/n): n

--- Captura de datos del DESTINATARIO ---

--- Captura de datos de una Persona ---
  Codigo de identificacion (ej. ID-001): ID-002
  Nombre legal (ej. Oscar Constatino Hernandez): Geovani Martinez Martinez
  Codigo postal (ej. 01001): 05721
  Indique si es cliente preferencial (s/n): s

--- Captura de datos del Paquete ---
  Codigo de rastreo (ej. PKG-500): PKG-001
  Peso fisico en kg (ej. 3.5): 10.2
  Alto en cm (ej. 20): 50
  Ancho en cm (ej. 20): 78
  Largo en cm (ej. 30): 120
  Valor declarado en MXN (ej. 800): 15000
  ¿Es envio express? (s/n): s

Guia emitida con exito:
Estos son los detalles del envío: 
Folio: GUIA-KFT-1
Detalles del remitente: 
Las especificaciones del cliente son: 
Código alfanumerico: ID-001
Nombre completo: Oscar Constantino Hernandez
Codigo Postal: 16569
¿Es cliente preferencial?false
Detalles del destinatario: 
Las especificaciones del cliente son: 
Código alfanumerico: ID-002
Nombre completo: Geovani Martinez Martinez
Codigo Postal: 3080
¿Es cliente preferencial?true
Detalles del paquete: 
Las especificaciones de su paquete son: 
Código de rastreo: PKG-001
Peso real: 10.2
Peso volumétrico: 93.6
Peso cobrable: 93.6
Valor declarado15000.0
Modalidad expresstrue
No es un envío personal


--- MENU PRINCIPAL ---
1. Emitir nueva guia de envio
2. Clonar guia activa con un nuevo paquete (mismo remitente y destinatario)
3. Clonar paquete de la guia activa para enviarlo a otro destinatario
4. Generar guia de retorno (devolucion al remitente)
5. Mostrar detalle y costo de la guia activa
0. Salir
Seleccione una opcion: 4

--- MENU PRINCIPAL ---
1. Emitir nueva guia de envio
2. Clonar guia activa con un nuevo paquete (mismo remitente y destinatario)
3. Clonar paquete de la guia activa para enviarlo a otro destinatario
4. Generar guia de retorno (devolucion al remitente)
5. Mostrar detalle y costo de la guia activa
0. Salir
Seleccione una opcion: 5

Estos son los detalles del envío: 
Folio: GUIA-DVW-2
Detalles del remitente: 
Las especificaciones del cliente son: 
Código alfanumerico: ID-002
Nombre completo: Geovani Martinez Martinez
Codigo Postal: 3080
¿Es cliente preferencial?true
Detalles del destinatario: 
Las especificaciones del cliente son: 
Código alfanumerico: ID-001
Nombre completo: Oscar Constantino Hernandez
Codigo Postal: 16569
¿Es cliente preferencial?false
Detalles del paquete: 
Las especificaciones de su paquete son: 
Código de rastreo: RET-PKG-001
Peso real: 10.2
Peso volumétrico: 93.6
Peso cobrable: 93.6
Valor declarado15000.0
Modalidad expresstrue
No es un envío personal


--- MENU PRINCIPAL ---
1. Emitir nueva guia de envio
2. Clonar guia activa con un nuevo paquete (mismo remitente y destinatario)
3. Clonar paquete de la guia activa para enviarlo a otro destinatario
4. Generar guia de retorno (devolucion al remitente)
5. Mostrar detalle y costo de la guia activa
0. Salir
Seleccione una opcion: 0
Saliendo del sistema postal...
```

---

## Preguntas de reflexión 

1. **¿En qué se diferencia clonar un `Paquete` (`new Paquete(kitBase)`) de clonar una guía de `Envio` (`new Envio(guiaBase, nuevoPaquete)`) respecto a qué objetos se comparten y cuáles se duplican en memoria?**
   > En el primer ejemplo, se tienen dos objetos Paquete distintos, y comparten todos sus atributos en memoria. En el segundo caso, se duplica un objeto Envio, que comparte atributos con el que se clonó desde un principio, pero por composición, hay un nuevo Paquete, que es distinto.

2. **Para generar el `folioGuia` con un número consecutivo global y consultar cuántas guías se han emitido en total, ¿qué modificador tuviste que utilizar en ese atributo y en su método de consulta? ¿Por qué no funcionaría si el contador fuera un atributo normal de instancia?**
   > El método para generar folios es interno, privado y nunca es utilizable por ningún otra clase o paquete. Por otro lado, para solamente acceder al contador (no cambiarlo) está asociado a la clase y es también estático. De no ser así, cada ejemplar distinto de Envio tendría folio 1, porque cada guia tendría su propio contador que se reinicia con cada iteración.

3. **Si una guía `envio1` se descarta (`envio1 = null;`), ¿qué ocurre en memoria con los objetos `Persona` (remitente/destinatario) y `Paquete` que estaban asociados a ella?**
   > Son desechados del heap.
