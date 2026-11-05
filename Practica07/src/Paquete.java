/**
 * Clase que modela un paquete para una empresa de envios postales y paqueteria.
 * Permite registrar sus dimensiones espaciales, peso fisico y valor declarado,
 * asi como calcular su peso volumetrico y determinar el peso cobrable final.
 *
 * @author Hugo Tonatiuh Carrillo Bonilla
 * @version 1.0
 */
public class Paquete {

    /**
     * La clase paquete cuenta con los siguientes atributos:
     * <ul>
     *  <li> Un codigo alfanumérico para identificarlo. </li>
     *  <li> Un peso en kilogramos </li>
     *  <li> Tres numeros para identificar sus dimensiones </li>
     *  <li> Un numero para indicar el valor monetario del producto </li>
     * </ul>
     */
    private String codigoAlfanumerico;
    private double pesoKg;
    private double altoCm;
    private double anchoCm;
    private double largoCm;
    private int valorMonetario;

    /**
     * El constructor con parametros devuelve un peso negativo si las dimensiones son invalidas y esto es usado por el verificador de paquetes
     * @param codigoAlfanumerico va primero.
     * @param pesoKg es segundo, e indica el peso en <b>kilogramos</b>
     * @param altoCm
     * @param anchoCm
     * @param largoCm en ese orden, para las dimensiones en <b>centimetros</b> del paquete.
     * @param valorMonetario Un entero (no acepta centavos) para el valor en pesos del paquete.
     */
    public Paquete(String codigoAlfanumerico, double pesoKg, double altoCm, double anchoCm, double largoCm, int valorMonetario){
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

    /**
     * El constructor sin parametros devuelve un paquete sin peso, dimensiones, valor, o identificador.
     */
    public Paquete() {
        this.codigoAlfanumerico = "";
        this.pesoKg = 0;
        this.altoCm = 0;
        this.anchoCm = 0;
        this.largoCm = 0;
        this.valorMonetario = 0;
    }


    /**
     * Los siguientes son métodos getters y setters para los atributos de un <i>ejemplar</i> de la clase paquete.
     * Los nombres son autoexplicativos.
     */
    public void setCodigoAlfanumerico(String codigoAlfanumerico) {
        this.codigoAlfanumerico = codigoAlfanumerico;
    }
    public String getCodigoAlfanumerico() {
        return codigoAlfanumerico;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    } 
    public double getPesoKg() {
        return pesoKg;
    }

    public void setAnchoCm(double anchoCm) {
        this.anchoCm = anchoCm;
    }
    public double getAnchoCm() {
        return anchoCm;
    }

    public void setAltoCm(double altoCm) {
        this.altoCm = altoCm;
    }
    public double getAltoCm() {
        return altoCm;
    }

    public void setLargoCm(double largoCm) {
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

    /**
     * Calcula el peso volumetrico del paquete segun el estandar comercial (IATA):
     * (largo * ancho * alto) / 5000.
     * 
     * @return El peso volumetrico equivalente en kilogramos.
     */
    public double calculaPesoVolumetrico() {
        // POR HACER: Implementa la formula de peso volumetrico
        double pesoVolumetrico = (anchoCm * altoCm * largoCm)/(5000);
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


    /**
     * Evalua si el paquete es de mayor peso volumetrico que peso real,
     * esto se utiliza en paqueterías para poner todos los paquetes ligeros
     * en un cargo aparte, pues estos tienden a ser frágiles.
     */
    public boolean determinarLiviano() {
        if (calculaPesoVolumetrico() >= pesoKg) {
            System.out.println("Su paquete es liviano");
            return true;
        } else {
            System.out.println("Su paquete no es liviano");
            return false;
        }
    }
}
