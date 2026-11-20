/**
 * Representa a una persona registrada en el sistema postal, la cual puede actuar
 * como remitente o como destinatario dentro de una guia de envio.
 *  * 
 * @author Tu Nombre / Tu Numero de Cuenta
 * @version 1.0
 */
public class Persona {


    // 1. ATRIBUTOS

    /*
     PARTE 2 (DISENO ABIERTO):
     Define los atributos privados, constructores, getters/setters y metodos necesarios
     para modelar a una persona considerando al menos:
     - Un identificador corto unico
     - Nombre completo.
     - Ubicacion (ciudad, alcaldia o codigo postal) para distinguir envios locales de foraneos.
     */

    // POR HACER: Declara los atributos que consideres necesarios
    // para representar a la persona (identificador unico, nombre, ubicacion, etc.).


    // 2. CONSTRUCTORES 

    // POR HACER: Implementa al menos un constructor por omision y un constructor
    // con parametros (aplicando validaciones basicas para evitar cadenas nulas o vacias).


    // 3. GETTERS, SETTERS Y COLABORACION 

    // POR HACER: Implementa los getters y setters necesarios para tus atributos.

    /**
     * Determina si esta persona se encuentra en la misma ubicacion (ciudad o codigo postal)
     * que otra persona recibida como parametro, para saber si un envio entre ambas
     * es local o foraneo.
     * 
     * @param otra La otra persona con quien comparar la ubicacion.
     * @return true si otra no es null y ambas comparten la misma ubicacion; false en caso contrario.
     */
    public boolean mismaUbicacionQue(Persona otra) {
        // POR HACER: Compara la ubicacion de this contra la de 'otra'.
        return false;
    }


    /**
     * Determina si este objeto Persona y el recibido como parametro representan
     * a la misma persona comparando su identificador unico.
     * 
     * @param otra La otra persona a comparar.
     * @return true si otra no es null y ambas tienen el mismo identificador; false en caso contrario.
     */
    public boolean esLaMismaPersona(Persona otra) {
        // POR HACER: Verifica que otra != null y compara el identificador unico.
        return false;
    }


    // 4. REPRESENTACION TEXTUAL

    /**
     * Devuelve una representacion legible de la persona con sus datos principales.
     * 
     * @return Cadena con el identificador, nombre y ubicacion de la persona.
     */
    public String toString() {
        // POR HACER: Sobrescribe toString() con el formato de tu preferencia.
        return "";
    }
}
