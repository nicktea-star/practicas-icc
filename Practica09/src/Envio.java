import java.util.Random;
/**
 * Modela una Guia de Envio postal relacionando a una Persona remitente, 
 * una Persona destinatario y un objeto Paquete.
 * 
 * Cada guia recibe automaticamente un folio unico al momento de crearse
 * (compuesto por caracteres aleatorios y un numero consecutivo global).
 * 
 * @author Tu Nombre / Tu Numero de Cuenta
 * @version 1.0
 */
public class Envio {


    // 1. ATRIBUTOS

    /** Cargo adicional fijo en pesos para envios foraneos (entre distintas ubicaciones). */
    public static final double CARGO_FORANEO = 80.0;

    // POR HACER:
    // 1. Declara los atributos para una guia:
    
    // 2. Deduce y declara lo necesario a nivel de clase para llevar el conteo
    //    consecutivo global de guias emitidas y generar automaticamente cada folioGuia.
    private String folioGuia;
    private Persona remitente;
    private Persona destinatario;
    private Paquete paquete;


    // 2. CONSTRUCTORES 

    /**
     * Constructor principal para emitir una nueva guia de envio.
     * Genera automaticamente el folioGuia (2 o 3 letras/digitos aleatorios + consecutivo).
     * Valida que ninguna referencia recibida sea invalida; si se envia a la misma
     * persona se permite (envio personal o mudanza).
     * 
     * @param remitente Persona que envia el paquete.
     * @param destinatario Persona que recibe el paquete.
     * @param paquete Paquete fisico amparado por esta guia.
     */
    public Envio(Persona remitente, Persona destinatario, Paquete paquete) {
        this.folioGuia = generadorFolios();
        if (remitente != null) {
            this.remitente = remitente;
        } else {
            this.remitente = new Persona();
        }

        if (destinatario != null) {
            this.destinatario = destinatario;
        } else {
            this.destinatario = new Persona();
        }

        if (paquete != null && CotizadorEnvio.esPaqueteValido(paquete)) {
            this.paquete = paquete;
        } else {
            this.paquete = new Paquete();
        }
    }

    /**
     * Constructor para copiar una guia existente cuando el mismo remitente envia
     * un nuevo paquete al mismo destinatario.
     * Conserva las referencias a remitente y destinatario de guiaBase, asocia el
     * nuevoPaquete y genera un NUEVO folioGuia consecutivo para esta guia.
     * 
     * @param guiaBase Guia original de la cual se toman remitente y destinatario.
     * @param nuevoPaquete El nuevo paquete que viajara bajo esta nueva guia.
     */
    public Envio(Envio guiaBase, Paquete nuevoPaquete) {
        this.folioGuia = generadorFolios();
        this.remitente = guiaBase.getRemitente();
        this.destinatario = guiaBase.getDestinatario();
        if (nuevoPaquete != null && CotizadorEnvio.esPaqueteValido(nuevoPaquete)) {
            this.paquete = nuevoPaquete;
        } else {
            this.paquete = new Paquete();
        }
    }


    // 3. METODOS DE ACCESO (GETTERS) Y CONSULTA DE GUIAS EMITIDAS

    /** @return El folio unico generado para esta guia. */
    public String getFolioGuia() {return folioGuia;}
    public Persona getRemitente() {return remitente;}
    public Persona getDestinatario() {return remitente;}
    public Paquete getPaquete() {return paquete;}

    private static int contadorFolios = 0;

    private static String letrasAzar() {
		String s = "";
		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			char c = (char) (r.nextInt(26)+'A');
			s += c;
		}
        return s;
    }

    private static String generadorFolios() {
        String folio = "GUIA-";
        folio += letrasAzar() + "-";
        folio += ++contadorFolios; // Espero no tener que arrepentirme de este truco sintático y que no se me olvide borrar este comentario para la entrega.
        return folio;
    }

    /** Todo paquete cuenta con un contador que permite saber cuántos folios de envio se han generado en la sesion. Este metodo permite acceder a este contador. */
    public static int consultarContador() {
        return contadorFolios;
    }

    // 4. METODOS DE OPERACION SOBRE LOS OBJETOS AGREGADOS  

    /**
     * Determina si el envio es foraneo verificando si el remitente y el destinatario
     * se encuentran en distinta ubicacion.
     * 
     * @return true si viaja entre distintas ubicaciones; false si es un envio local.
     */
    public boolean esEnvioForaneo() {
        return !(remitente.getCodigoPostal() == destinatario.getCodigoPostal());
    }

    /**
     * Determina si el remitente y el destinatario representan a la misma persona
     * (por ejemplo, un envio personal o mudanza).
     * 
     * @return true si remitente y destinatario son la misma persona; false en caso contrario.
     */
    public boolean esAutoEnvio() {
        return remitente.getIdentificador() == destinatario.getIdentificador();
    }

    /**
     * Calcula el costo total del envio:
     * Obtiene la tarifa base del paquete y, si es un envio foraneo,
     * suma el cargo adicional correspondiente.
     * 
     * @return El costo total de la guia en pesos (MXN), o -1.0 si el paquete es invalido.
     */
    public double calcularCostoTotal() {
        // POR HACER: Calcula la tarifa base (con CotizadorEnvio) + cargo foraneo si aplica.
        if (esEnvioForaneo()) {
            return CotizadorEnvio.cotizarEnvio(paquete) + CARGO_FORANEO ;
        } else {
            return CotizadorEnvio.cotizarEnvio(paquete);
        }
    }

    /**
     * Redirige el envio a un nuevo destinatario antes de su despacho.
     * Verifica unicamente que nuevoDestinatario no sea null.
     * 
     * @param nuevoDestinatario Nueva persona destinataria.
     * @return true si el cambio fue valido y aplicado; false si nuevoDestinatario es null.
     */
    public boolean cambiarDestinatario(Persona nuevoDestinatario) {
        // POR HACER: Valida que nuevoDestinatario != null y actualiza.
        if (nuevoDestinatario != null) {
            destinatario = nuevoDestinatario;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Genera y devuelve una NUEVA guia de envio para devolver la mercancia al origen:
     * 1. Invierte los roles entre remitente y destinatario.
     * 2. Crea una copia independiente del paquete en memoria y actualiza su codigo
     *    de rastreo anteponiendo el prefijo "RET-".
     * 3. La nueva guia recibe automaticamente su propio folioGuia consecutivo.
     * 
     * @return Nuevo objeto Envio configurado para el retorno al remitente original.
     */
    public Envio generarGuiaRetorno() {
        paquete.setCodigoRastreo("RET-" + paquete.getCodigoRastreo());
        Envio retorno = new Envio(destinatario, remitente, paquete);
        return retorno;
    }

    /**
     * Emite el comprobante textual de la guia de envio delegando en toString()
     * de remitente, destinatario y paquete, e indicando el folio, tipo de ruta
     * (LOCAL o FORANEO) y el costo total.
     * 
     * @return Cadena con el formato completo de la guia de envio.
     */
    @Override
    public String toString() {
        String s = "Estos son los detalles del envío: \n";
        s += "Folio: " + folioGuia + "\n";
        s += "Detalles del remitente: \n";
        s += remitente.toString();
        s += "Detalles del destinatario: \n";
        s += destinatario.toString();
        s += "Detalles del paquete: \n"
        s += paquete.toString();
        if (esAutoEnvio()) {
            s += "Es un envío personal\n"
        } else {
            s += "No es un envío personal\n"
        }
        return s;
    }
}
