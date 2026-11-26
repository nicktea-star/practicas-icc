/**
 * Modela una estacion meteorologica universitaria que almacena y procesa
 * las temperaturas diarias (en grados Celsius) de un periodo de monitoreo.
 *
 * @author [Tu Nombre Completo]
 * @version 1.0
 */
public class EstacionMeteorologica {

    private String nombreEstacion;
    private double[] temperaturas;

    // CONSTRUCTORES

    /**
     * Inicializa la estacion con el nombre predeterminado "Estacion UNAM"
     * y reserva espacio para una semana (7 dias), marcando cada posicion
     * inicialmente sin lectura registrada (-300.0).
     */
    public EstacionMeteorologica() {
        this.nombreEstacion = "Estacion UNAM";
        this.temperaturas = new double[7];
        for (int i = 0; i < temperaturas.length; i++) {
            this.temperaturas[i] = -300.0;
        }
    }

    // POR HACER (Parte 5.3): Redacta la documentacion Javadoc para este constructor y los metodos restantes.
    public EstacionMeteorologica(String nombreEstacion, int numDias) {
        this.nombreEstacion = (nombreEstacion.length() > 0) ? nombreEstacion : "Estacion UNAM";
        this.temperaturas = (numDias > 0) ?  new double[numDias] :  new double[7];
        for (int i = 0; i < temperaturas.length; i++) {
            this.temperaturas[i] = -300.0;
        }
    }

    // METODOS DE CONSULTA Y REGISTRO (PARTE 1)

    public String getNombreEstacion() {
        // POR HACER (1.3)
        return this.nombreEstacion;
    }

    public int getNumeroDias() {
        // POR HACER (1.3)
        return this.temperaturas.length;
    }

    /**
     * Registra la temperatura de un dia especifico en grados Celsius.
     * Solo modifica el arreglo si el indice es valido y la temperatura esta
     * dentro del rango fisico ambiental [-90.0, 60.0].
     *
     * @param indiceDia Posicion del dia a registrar (desde 0 hasta N - 1).
     * @param temp Temperatura ambiental registrada en grados Celsius.
     * @return true si el dato fue valido y se almaceno; false en caso contrario.
     */
    public boolean registrarTemperatura(int indiceDia, double temp) {
        if (indiceDia >= 0 && indiceDia < temperaturas.length && temp >= -90.0 && temp <= 60.0) {
            temperaturas[indiceDia] = temp;
            return true;
        } else {
            return false;
        }
    }

    public double obtenerTemperatura(int indiceDia) {
        return (0 <= indiceDia && indiceDia < temperaturas.length) ? temperaturas[indiceDia] : -300.0 ;
    }

    // METODOS ESTADISTICOS (PARTE 2)

    public double calcularPromedio() {
        double promedio = 0;
        for (int i = 0; i < temperaturas.length; i++) {
            promedio += temperaturas[i];
        }
        promedio /= temperaturas.length;
        return promedio;
    }

    public double obtenerMaxima() {
        double maxima = -300.0;
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] > maxima) {
                maxima = temperaturas[i];
            } else {
                continue;
            }
        }
        return maxima;
    }

    public int contarDiasCalurosos(double umbral) {
        int contador = 0;
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] >= umbral) {
                contador++;
            } else {
                continue;
            }
        }
        return contador;
    }

    @Override
    public String toString() {
        String s = "";
        s += "Estacion: " + nombreEstacion + " | ";
        s += "Dias: " + temperaturas.length + " | ";
        s += "Promedio: " + this.calcularPromedio() + " C " + " | ";
        s += "Maxima: " + this.obtenerMaxima() + " C " + " | ";
        s += "\n";
        return s;
    }

    // CONVERSION DE ESCALAS (PARTE 3)

    public double convertirAFahrenheit(double celsius) {
        // POR HACER (3.2): Decide si este metodo sera de instancia o static y realiza la conversion.
        return 0.0;
    }

    // POR HACER (3.3): Una vez creado Escala.java, descomenta y completa el metodo sobrecargado:
    /*
    public double calcularPromedio(Escala escala) {
        return 0.0;
    }
    */

    // RETOS (PARTE 4)

    public int buscarPrimerDiaHelada() {
        // POR HACER (4.1): Devuelve el indice del primer dia con temp <= 0.0, o -1 si no hubo heladas.
        return -1;
    }

    public double mayorCambioConsecutivo() {
        // POR HACER (4.2): Calcula la mayor variacion |t[i+1] - t[i]| entre dias seguidos.
        return 0.0;
    }
}
