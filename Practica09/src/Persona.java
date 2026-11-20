/**
 * Representa a una persona registrada en el sistema postal, la cual puede actuar
 * como remitente o como destinatario dentro de una guia de envio.
 *  * 
 * @author Hugo Tonatiuh Carrillo Bonilla
 * @version 2.0
 */
public class Persona {


    // 1. ATRIBUTOS

    /** Codigo alfanumerico unico que identifica a un cliente. */
    private String identificador;
    /** Nombre legal del cliente. */
    private String nombreCompleto;
    /** Codigo de cinco digitos para identificar la <b>colonia</b> de entrega. */
    private int codigoPostal;
    /** Valor booleano que determina si el cliente es frecuente o paga una suscripcion. */
    private boolean clientePreferencial;

    // 2. CONSTRUCTORES 
    /**
     * Crea un cliente estandar sin datos personales.
     */
    public Persona() {
        this.identificador = "ID-000";
        this.nombreCompleto = "N.N.N.";
        this.codigoPostal = 06010 ; // Código postal de la oficina de correos de México
        this.clientePreferencial = false;
    }

    /**
     * Constructor con todos los parametros.
     *
     * @param identificador Identificador alfanumerico.
     * @param nombreCompleto Nombre legal.
     * @param codigoPostal Codigo postal de la colonia (no puede ser negativo).
     * @param clientePreferencial <tt>true</tt> si es un cliente preferencial, <tt>false</tt> de lo contrario.
     */
    public Persona(String identificador, String nombreCompleto, int codigoPostal, boolean clientePreferencial) {
        this.identificador = identificador;
        this.nombreCompleto = nombreCompleto;
        this.codigoPostal = codigoPostal;
        this.clientePreferencial = clientePreferencial;
    }

    /**
     * Crea una nueva persona independiente en memoria cuyos atributos iniciales
     * sean replicas exactas de los de la persona recibida. Sirve para que una misma persona abra más de una cuenta
     * 
     * @param otro El paquete original a duplicar. Si es null, inicializa con valores por omision.
     */
    public Persona(Persona otra) {
        if (otra == null) {
            this.identificador = "ID-000";
            this.nombreCompleto = "N.N.N.";
            this.codigoPostal = 06010 ; // Código postal de la oficina de correos de México
            this.clientePreferencial = false;
        } else {
            this.identificador = otra.getIdentificador() + "01";
            this.nombreCompleto = otra.getNombreCompleto();
            this.codigoPostal = otra.getCodigoPostal() ; // Código postal de la oficina de correos de México
            this.clientePreferencial = otra.getClientePreferencial();
        }
    }
    // 3. GETTERS, SETTERS Y COLABORACION 

    /** @return El codigo del cliente. */
    public String getIdentificador() {
        return identificador;
    }

    /** @param identificador El nuevo codigo alfanumerico de identificacion. */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    /** @return El nombre legal del cliente. */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /** @param nombreCompleto El nuevo nombre del cliente. */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /** @return El codigo postal del cliente. */
    public int getCodigoPostal() {
        return codigoPostal;
    }

    /** @param codigoPostal El nuevo codigo postal del cliente. */
    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /** @return Valor booleano que representa si el cliente es preferencial. */
    public boolean getClientePreferencial() {
        return clientePreferencial;
    }

    /** @param codigoPostal El nuevo valor preferencial del cliente. */
    public void setClientePreferencial(boolean clientePreferencial) {
        this.clientePreferencial = clientePreferencial;
    }

    /**
     * Determina si esta persona se encuentra en la misma ubicacion (ciudad o codigo postal)
     * que otra persona recibida como parametro, para saber si un envio entre ambas
     * es local o foraneo.
     * 
     * @param otra La otra persona con quien comparar la ubicacion.
     * @return true si otra no es null y ambas comparten la misma ubicacion; false en caso contrario.
     */
    public boolean mismaUbicacionQue(Persona otra) {
        if (otra != null && (otra.getCodigoPostal() == this.getCodigoPostal())) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Determina si este objeto Persona y el recibido como parametro representan
     * a la misma persona comparando su identificador unico.
     * 
     * @param otra La otra persona a comparar.
     * @return true si otra no es null y ambas tienen el mismo identificador; false en caso contrario.
     */
    public boolean esLaMismaPersona(Persona otra) {

        if (otra != null && (otra.getIdentificador() == this.getIdentificador())) {
            return true;
        } else {
            return false;
        }
    }


    // 4. REPRESENTACION TEXTUAL

    /**
     * Devuelve una representacion legible de la persona con sus datos principales.
     * 
     * @return Cadena con el identificador, nombre y ubicacion de la persona.
     */
    public String toString() {
        String mensaje = "Las especificaciones del cliente son: \n";
        mensaje += "Código alfanumerico: " + this.getIdentificador() + "\n";
        mensaje += "Nombre completo: " + this.getNombreCompleto() + "\n";
        mensaje += "Codigo Postal: " + this.getCodigoPostal() + "\n";
        mensaje += "¿Es cliente preferencial?" + this.getClientePreferencial() + "\n";
        return mensaje;
    }
}
