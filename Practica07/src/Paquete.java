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
    private String codigoAlfanumerico;
    private double pesoKg;
    private double altoCm;
    private double anchoCm;
    private double largoCm;
    private int valorMonetario;


    // *** CONSTRUCTORES ***
    // POR HACER: Agrega el constructor por defecto y el constructor con parametros.
    // En el constructor con parametros, asegura que el paquete cuente con dimensiones validas.

    /**
     * El constructor con parámetros devuelve un peso negativo si las dimensiones son inválidas y esto es usado por el verificador de paquetes
     */
    public void Paquete() {
        this.codigoAlfanumerico = A;
        this.pesoKg = 0;
        this.altoCm = 0;
        this.anchoCm = 0;
        this.largoCm = 0;
        this.valorMonetario = 0;
    }
    public void Paquete(String codigoAlfanumerico, double pesoKg, double altoCm, double anchoCm, double largoCm, int valorMonetario){
        this.codigoAlfanumerico = codigoAlfanumerico;
        this.pesoKg = pesoKg;
        if (altoCm < 0 || altoCm > 200) {
            System.out.println("Su valor es inválido");
            this.pesoKg = -1;
        } else {
            this.altoCm = altoCm;
        }
        if (anchoCm < 0 || anchoCm > 200) {
            System.out.println("Su valor es inválido");
            this.pesoKg = -1;
        } else {
            this.anchoCm = anchoCm;
        }
        if (largoCm < 0 || largoCm > 200) {
            System.out.println("Su valor es inválido");
            this.pesoKg = -1;
        } else {
            this.largoCm = largoCm;
        }
        this.valorMonetario = valorMonetario;
    }


    // *** METODOS DE ACCESO Y ASIGNACION ***
    public void setCodigoAlfanumerico(String codigoAlfanumerico) {
        this.codigoAlfanumerico = codigoAlfanumerico;
    }
    public String getCodigoAlfanumerico() {
        return codigoAlfanumerico;
    }

    public void setPesoKg(String pesoKg) {
        this.pesoKg = pesoKg;
    }
    public double getPesoKg() {
        return pesoKg;
    }

    public void setAnchoCm(String anchoCm) {
        this.anchoCm = anchoCm;
    }
    public double getAnchoCm() {
        return anchoCm;
    }

    public void setAltoCm(String altoCm) {
        this.altoCm = altoCm;
    }
    public double getAltoCm() {
        return altoCm;
    }

    public void setLargoCm(String largoCm) {
        this.largoCm = largoCm;
    }
    public double getLargoCm() {
        return largoCm;
    }

    public void setValorMonetario(int valorMonetario) {
        this.valorMonetario = valorMonetario;
    }
    public int getValorMonetario() {
        return valorMonetario;
    }
    // *** METODOS CALCULADORES BASE ***

    /**
     * Calcula el peso volumetrico del paquete segun el estandar comercial (IATA):
     * (largo * ancho * alto) / 5000.
     * 
     * @return El peso volumetrico equivalente en kilogramos.
     */
    public double calculaPesoVolumetrico() {
        // POR HACER: Implementa la formula de peso volumetrico
        double pesoVolumetrico = (anchoCm * altoCm * largoCm)/(500);
        return pesoVolumetrico;
    }

    /**
     * Determina el peso cobrable final para efectos de tarificacion postal,
     * el cual corresponde al valor maximo entre el peso fisico y el volumetrico.
     * 
     * @return El mayor entre el peso real y el peso volumetrico.
     */
    public double obtenerPesoCobrable() {
        // POR HACER: Implementa la comparacion entre peso real y peso volumetrico
        double pesoCobrable = Math.max(calculaPesoVolumetrico(), pesoKg);
        return pesoCobrable;
    }


    // *** PROPUESTA PERSONAL ***
    // POR HACER: Agrega aqui al menos un nuevo metodo calculador util para la empresa
    // (ejemplo: recargo por envio express, costo por material fragil, descuento local, etc.)
    // Incluye sus comentarios Javadoc y los atributos necesarios.
    /**
     * Evalua si el paquete es de mayor peso volumetrico que peso real,
     * esto se utiliza en paqueterías para poner todos los paquetes ligeros
     * en un cargo aparte, pues estos tienden a ser frágiles.
     */
    public boolean determinarLiviano() {
        if (calculaPesoVolumetrico() >= pesoKg) {
            System.out.println("Su paquete es liviano");
            return true
        } else {
            System.out.println("Su paquete no es liviano");
            return false
        }
    }
}
