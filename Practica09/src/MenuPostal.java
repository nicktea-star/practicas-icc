import java.util.Scanner;

/**
 * Programa interactivo por consola para gestionar guias de envio (Parte 4).
 * 
 * @author Tu Nombre / Tu Numero de Cuenta
 * @version 1.0
 */
public class MenuPostal {


    /**
     * Ciclo principal del menu interactivo.
     * 
     * @param args Argumentos de linea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Envio guiaActiva = null;
        boolean continuar = true;

        System.out.println("================================================================");
        System.out.println("  SISTEMA INTERACTIVO DE GUIAS POSTALES | ICC 2027-1");
        System.out.println("================================================================");

        while (continuar) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Emitir nueva guia de envio");
            System.out.println("2. Clonar guia activa con un nuevo paquete (mismo remitente y destinatario)");
            System.out.println("3. Clonar paquete de la guia activa para enviarlo a otro destinatario");
            System.out.println("4. Generar guia de retorno (devolucion al remitente)");
            System.out.println("5. Mostrar detalle y costo de la guia activa");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            String opcion = sc.nextLine().trim();

            switch (opcion) {
                case "1":
                    guiaActiva = emitirNuevaGuia(sc);
                    break;

                case "2":
                    guiaActiva = clonarGuiaActiva(sc, guiaActiva);
                    break;

                case "3":
                    guiaActiva = clonarCambioDestinatario(sc, guiaActiva);
                    break;

                case "4":
                    guiaActiva = clonarGuiaRetorno(sc, guiaActiva);
                    break;

                case "5":
                    mostrarGuiaActiva(guiaActiva);
                    break;

                case "0":
                    continuar = false;
                    System.out.println("Saliendo del sistema postal...");
                    break;

                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
                    break;
            }
        }
        sc.close();
    }

    /**
     * Metodo auxiliar que solicita al usuario por consola
     * los datos de un paquete y devuelve la instancia creada.
     * 
     * @param sc Lector de entrada estandar.
     * @return Nuevo objeto Paquete con los datos capturados.
     */
    private static Paquete capturarPaquete(Scanner sc) {
        System.out.println("\n--- Captura de datos del Paquete ---");
        System.out.print("  Codigo de rastreo (ej. PKG-500): ");
        String codigo = sc.nextLine().trim();

        System.out.print("  Peso fisico en kg (ej. 3.5): ");
        double peso = leerDouble(sc, 1.0);

        System.out.print("  Alto en cm (ej. 20): ");
        double alto = leerDouble(sc, 10.0);

        System.out.print("  Ancho en cm (ej. 20): ");
        double ancho = leerDouble(sc, 10.0);

        System.out.print("  Largo en cm (ej. 30): ");
        double largo = leerDouble(sc, 10.0);

        System.out.print("  Valor declarado en MXN (ej. 800): ");
        double valor = leerDouble(sc, 100.0);

        System.out.print("  ¿Es envio express? (s/n): ");
        boolean express = sc.nextLine().trim().equalsIgnoreCase("s");

        return new Paquete(codigo, peso, alto, ancho, largo, valor, express);
    }

    /**
     * Lee un numero decimal validando con hasNextDouble() y limpiando el salto de linea
     * del buffer de entrada sin utilizar manejo de excepciones.
     * 
     * @param sc Lector de entrada estandar.
     * @param valorPorOmision Valor a regresar si el usuario no ingresa un numero valido.
     * @return El numero leido, o valorPorOmision si la entrada no fue numerica.
     */
    private static double leerDouble(Scanner sc, double valorPorOmision) {
        if (sc.hasNextDouble()) {
            double valor = sc.nextDouble();
            sc.nextLine(); // Limpia el salto de linea pendiente en el buffer
            return valor;
        }
        sc.nextLine(); // Descarta la entrada no numerica
        return valorPorOmision;
    }

    private static int leerCodigoPostal(Scanner sc) {
        if (sc.hasNextInt()) {
            int valor = sc.nextInt();
            sc.nextLine();
            if (valor > 0 && Integer.toString(valor).length() == 5) {
                return valor;
            } else {
                return 06010;
            }
        }
        sc.nextLine();
        return 06010;
    }

    /**
     * Solicita por consola los datos de una Persona de acuerdo con los atributos
     * que disenaste en Persona.java y devuelve el objeto instanciado.
     * 
     * @param sc Lector de entrada estandar.
     * @return Nueva instancia de Persona con los datos capturados.
     */
    private static Persona capturarPersona(Scanner sc) {
        // TODO: Implementar leerCodigoPostal
        System.out.println("\n--- Captura de datos de una Persona ---");
        System.out.print("  Codigo de identificacion (ej. ID-001): ");
        String identificador = sc.nextLine();
        System.out.print("  Nombre legal (ej. Oscar Constatino Hernandez): ");
        String nombreCompleto = sc.nextLine();
        System.out.print("  Codigo postal (ej. 01001): ");
        int codigoPostal = leerCodigoPostal(sc);
        System.out.print("  Indique si es cliente preferencial (s/n): ");
        boolean clientePreferencial = sc.nextLine().trim().equalsIgnoreCase("s");
        Persona persona = new Persona(identificador, nombreCompleto, codigoPostal, clientePreferencial);
        return persona;
    }

    /**
     * Opcion 1 (REFERENCIA IMPLEMENTADA): Captura remitente, destinatario
     * y paquete para emitir y mostrar una nueva guia de envio.
     * 
     * @param sc Lector de entrada estandar.
     * @return La nueva guia de envio creada.
     */
    private static Envio emitirNuevaGuia(Scanner sc) {
        System.out.println("\n--- Captura de datos del REMITENTE ---");
        Persona remitente = capturarPersona(sc);

        System.out.println("\n--- Captura de datos del DESTINATARIO ---");
        Persona destinatario = capturarPersona(sc);

        Paquete paquete = capturarPaquete(sc);
        Envio nuevaGuia = new Envio(remitente, destinatario, paquete);
        System.out.println("\nGuia emitida con exito:\n" + nuevaGuia);
        return nuevaGuia;
    }

    private static void mostrarGuiaActiva(Envio guiaActiva) {
        if (guiaActiva == null) {
            System.out.println("Aviso: No hay ninguna guia activa.");
        } else {
            System.out.println("\n" + guiaActiva.toString());
        }
    }

    /**
     * Opcion 2 : Clona la guia actualmente en memoria
     * y captura un nuevo paquete.
     * 
     * @param sc Lector de entrada estandar.
     * @param guiaActiva Envio en memoria.
     * @return Una nueva guia de envio clonada.
     */
    private static Envio clonarGuiaActiva(Scanner sc, Envio guiaActiva) {
        if (guiaActiva == null) {
            System.out.println("Aviso: No hay ninguna guia activa.");
            System.out.println("Se le generará una guia generica con un paquete por defecto.");
            Envio clonGuiaActiva = new Envio(null,null,null);
            return clonGuiaActiva;
        } else {
            Paquete paquete = capturarPaquete(sc);
            Envio clonGuiaActiva = new Envio(guiaActiva, paquete);
            return clonGuiaActiva;
        }
    }

    /**
     * Opcion 3 : Clona la guia actualmente en memoria
     * y captura un nuevo destinatario.
     * 
     * @param sc Lector de entrada estandar.
     * @param guiaActiva Envio en memoria.
     * @return Una nueva guia de envio clonada.
     */
    private static Envio clonarCambioDestinatario(Scanner sc, Envio guiaActiva) {
        if (guiaActiva == null) {
            System.out.println("Aviso: No hay ninguna guia activa.");
            System.out.println("Se le generará una guia generica con un paquete por defecto.");
            Envio clonCambioDestinatario = new Envio(null,null,null);
            return clonCambioDestinatario;
        } else {
            Envio clonCambioDestinatario = new Envio(guiaActiva, guiaActiva.getPaquete());
            System.out.println("\n--- Captura de datos del DESTINATARIO ---");
            clonCambioDestinatario.cambiarDestinatario(capturarPersona(sc));
            return clonCambioDestinatario;
        }
    }

    /**
     * Opcion 4 : Genera una nueva guia que invierte los roles
     * de destinatario y remitente.
     * 
     * @param sc Lector de entrada estandar.
     * @param guiaActiva Envio en memoria.
     * @return Una nueva guia de envio clonada.
     */
    private static Envio clonarGuiaRetorno(Scanner sc, Envio guiaActiva) {
        if (guiaActiva == null) {
            System.out.println("Aviso: No hay ninguna guia activa.");
            System.out.println("Se le generará una guia generica con un paquete por defecto.");
            Envio clonGuiaRetorno = new Envio(null,null,null);
            return clonGuiaRetorno;
        } else {
            return guiaActiva.generarGuiaRetorno();
        }
    }
}
