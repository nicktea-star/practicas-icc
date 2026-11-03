/**
 * Clase que modela un paquete para una empresa de envios postales y paqueteria.
 * Permite registrar sus dimensiones espaciales, peso fisico y valor declarado,
 * asi como calcular su peso volumetrico y determinar el peso cobrable final.
 * 
 * @author Tu Nombre
 * @version 1.0
 */
public class Paquete {

    // *** ATRIBUTOS ***
    // POR HACER: Declara los atributos necesarios de acuerdo a tu diseno y a la documentacion.
    // Recuerda aplicar el principio de encapsulamiento (declararlos privados).


    // *** CONSTRUCTORES ***
    // POR HACER: Agrega el constructor por defecto y el constructor con parametros.
    // En el constructor con parametros, asegura que el paquete cuente con dimensiones validas.


    // *** METODOS DE ACCESO Y ASIGNACION ***
    // POR HACER: Agrega los metodos de consulta (getters) y de modificacion (setters) necesarios.


    // *** METODOS CALCULADORES BASE ***

    /**
     * Calcula el peso volumetrico del paquete segun el estandar comercial (IATA):
     * (largo * ancho * alto) / 5000.
     * 
     * @return El peso volumetrico equivalente en kilogramos.
     */
    public double calculaPesoVolumetrico() {
        // POR HACER: Implementa la formula de peso volumetrico
        return 0.0;
    }

    /**
     * Determina el peso cobrable final para efectos de tarificacion postal,
     * el cual corresponde al valor maximo entre el peso fisico y el volumetrico.
     * 
     * @return El mayor entre el peso real y el peso volumetrico.
     */
    public double obtenerPesoCobrable() {
        // POR HACER: Implementa la comparacion entre peso real y peso volumetrico
        return 0.0;
    }


    // *** PROPUESTA PERSONAL ***
    // POR HACER: Agrega aqui al menos un nuevo metodo calculador util para la empresa
    // (ejemplo: recargo por envio express, costo por material fragil, descuento local, etc.)
    // Incluye sus comentarios Javadoc y los atributos necesarios.

}
