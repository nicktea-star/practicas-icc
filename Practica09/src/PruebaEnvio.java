/**
 * Programa de pruebas y simulacion para las Guias de Envios
 * Ejecuta pruebas automatizadas.
 * 
 * @author Tu Nombre / Tu Numero de Cuenta
 * @version 1.0
 */
public class PruebaEnvio {

    /*
    * - Incluye las secciones guiadas para que agregues las pruebas de tu diseno
    *   de Persona (Parte 2), Envio y generacion de folios consecutivos (Parte 3),
    *   asi como la simulacion integral de envios, clones y devolucion (Parte 4).
    */

    private static int pruebasExitosas = 0;
    private static int totalPruebas = 0;

    /**
     * Metodo principal de verificacion y simulacion no interactiva.
     * 
     * @param args Argumentos de linea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("  ICC 2027-1 | PRACTICA 9: AGREGACION, CLONACION Y GUIAS DE ENVIO");
        System.out.println("================================================================================\n");

        // ---------------------------------------------------------------------
        // PARTE 1: PAQUETES ESTANDARIZADOS (CONSTRUCTOR POR COPIA Y TOSTRING)
        // ---------------------------------------------------------------------
        System.out.println(">>> PARTE 1: REPRESENTACION TEXTUAL Y CLONACION DE PAQUETE");
        Paquete kitBase = new Paquete("KIT-101", 4.0, 20.0, 20.0, 20.0, 500.0, false);
        Paquete otroPaquete = new Paquete("PKG-202", 12.0, 40.0, 30.0, 30.0, 1500.0, false);

        String txtKit = kitBase.toString();
        verificar("Paquete.toString() incluye el codigo de rastreo",
                  txtKit != null && txtKit.contains("KIT-101") && !txtKit.contains("Paquete@"));

        Paquete kitClon = new Paquete(kitBase);
        double pesoOriginal = kitBase.getPeso();
        kitBase.setPeso(99.0);
        verificar("Constructor por copia de Paquete crea instancia independiente en memoria",
                  kitClon != kitBase && Math.abs(kitClon.getPeso() - pesoOriginal) < 1e-6);
        kitBase.setPeso(pesoOriginal);

        kitClon.setCodigoRastreo("KIT-102"); // Nuevo codigo para envio en serie
        verificar("Modificar el codigo del paquete clonado no altera el paquete plantilla original",
                  "KIT-101".equals(kitBase.getCodigoRastreo()) && "KIT-102".equals(kitClon.getCodigoRastreo()));

        Paquete clonNulo = new Paquete(null);
        verificar("Constructor por copia con null asigna valores predeterminados validos",
                  clonNulo.getCodigoRastreo() != null && clonNulo.getPeso() > 0.0);
        System.out.println();

        // ---------------------------------------------------------------------
        // PARTE 2: PRUEBAS DE TU DISENO DE LA CLASE PERSONA
        // ---------------------------------------------------------------------
        System.out.println(">>> PARTE 2: VERIFICACION DE LA CLASE PERSONA");
        Persona personaX = new Persona("ID-001","Victor Manuel Mendiola", 14748, false);
        Persona personaY = new Persona("ID-002","Geovani Martinez Martinez", 14748, false);
        Persona personaZ = new Persona("ID-001","Oscar Constantino Hernandez", 97481, false);
        verificar("Misma ubicación funciona para mismas ubicaciones", personaX.mismaUbicacionQue(personaY));
        verificar("Es la misma persona funciona", personaX.esLaMismaPersona(personaZ));
        verificar("Funciona toString", personaX.toString() instanceof String);
        System.out.println();

        // ---------------------------------------------------------------------
        // PARTE 3: PRUEBAS DE AGREGACION, FOLIOS CONSECUTIVOS Y OPERACIONES EN ENVIO
        // ---------------------------------------------------------------------
        System.out.println(">>> PARTE 3: VERIFICACION DE ENVIO Y FOLIOS AUTOMATICOS");
        verificar("El contador de folios empieza en 0", Envio.consultarContador() == 0);
        Envio guiaLocal = new Envio(personaX, personaY, kitBase);
        Envio guiaForanea = new Envio(personaX, personaZ, kitClon);
        verificar("Primer guia tiene folio", guiaLocal.getFolioGuia() !=null);
        verificar("Segunda guia tiene folio", guiaForanea.getFolioGuia() !=null);
        verificar("Las dos guias tienen folios distintos", guiaLocal.getFolioGuia() != guiaForanea.getFolioGuia());
        verificar("La primer guia tiene numero 1", guiaLocal.getFolioGuia().charAt(guiaLocal.getFolioGuia().length() - 1) == '1');
        verificar("La segunda guia tiene numero 2", guiaForanea.getFolioGuia().charAt(guiaForanea.getFolioGuia().length() - 1) == '2');
        // El truco de arriba lo aprendí trabajando en mi repositorio Fen2Fen, revíselo si cree que lo saqué de IA
        verificar("Se emitieron dos guias", Envio.consultarContador() == 2);
        verificar("Funciona esEnvioForaneo", guiaForanea.esEnvioForaneo());
        verificar("Funciona esAutoEnvio", guiaForanea.esAutoEnvio());
        verificar("Funciona calcularCostoTotal", guiaForanea.calcularCostoTotal() == CotizadorEnvio.cotizarEnvio(guiaForanea.getPaquete()) + 80);
        verificar("cambiarDestinatario rechaza null", guiaLocal.cambiarDestinatario(null) == false);
        verificar("cambiarDestinatario acepta otra persona", guiaLocal.cambiarDestinatario(personaZ) == true);
        verificar("cambiarDestinatario acepta a la misma persona", guiaLocal.cambiarDestinatario(personaX) == true);
        System.out.println();

        // ---------------------------------------------------------------------
        // PARTE 4: SIMULACION INTEGRAL (CLONACION DE GUIA Y DEVOLUCION / RETORNO)
        // ---------------------------------------------------------------------
        System.out.println(">>> PARTE 4: SIMULACION DE ENVIOS, CLONACION DE GUIA Y RETORNO");
        // POR HACER (Parte 4):
        // Modela e imprime en consola el siguiente escenario completo:
        // a) Persona X envia 'kitBase' a Persona Y (imprime la guia generada).
        // b) Persona X necesita enviar un segundo paquete ('otroPaquete') a la misma Persona Y
        //    clonando la guia anterior; verifica que conserva remitente y destinatario
        //    pero tiene el nuevo paquete y un nuevo folio consecutivo.
        // c) Persona Y solicita devolver el primer paquete a Persona X generando una guia de retorno;
        //    verifica con verificar(...) que en la guia de retorno el remitente es Y, el destinatario es X,
        //    el paquete es una copia independiente con prefijo "RET-" y cuenta con un nuevo folio consecutivo.
        //    Imprime la guia de retorno y el total acumulado de guias emitidas en el sistema.
        Envio guiaPrueba = new Envio(personaX, personaY, kitBase);
        guiaPrueba.toString();
        Envio segundoEnvio = new Envio(guiaPrueba, otroPaquete);
        verificar("El paquete clonado conserva remitente", segundoEnvio.getRemitente() == guiaPrueba.getRemitente());
        verificar("El paquete clonado conserva destinatario", segundoEnvio.getDestinatario() == guiaPrueba.getDestinatario());
        verificar("El paquete clonado tiene un nuevo paquete", segundoEnvio.getPaquete() == otroPaquete);
        char ultimoDigitoGuiaPrueba = guiaPrueba.getFolioGuia().charAt(guiaPrueba.getFolioGuia().length() - 1);
        char ultimoDigitoSegundoEnvio = segundoEnvio.getFolioGuia().charAt(segundoEnvio.getFolioGuia().length() - 1);
        verificar("El paquete clonado tiene folio consecutivo",  (int) ultimoDigitoSegundoEnvio == ((int) ultimoDigitoGuiaPrueba) + 1 );

        System.out.println("\n================================================================================");
        System.out.println("  RESUMEN DE PRUEBAS: " + pruebasExitosas + " / " + totalPruebas + " pruebas superadas con exito");
        System.out.println("================================================================================");
    }

    /**
     * Evalua una condicion booleana e imprime [OK] o [FALLO].
     * 
     * @param nombrePrueba Descripcion breve del caso evaluado.
     * @param condicion Resultado booleano esperado (true si paso).
     */
    private static void verificar(String nombrePrueba, boolean condicion) {
        totalPruebas++;
        if (condicion) {
            pruebasExitosas++;
            System.out.println("  [OK]    " + nombrePrueba);
        } else {
            System.out.println("  [FALLO] " + nombrePrueba);
        }
    }
}
