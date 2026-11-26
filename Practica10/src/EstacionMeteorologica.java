/**
 * Modela una estacion meteorologica universitaria que almacena y procesa
 * las temperaturas diarias (en grados Celsius) de un periodo de monitoreo.
 *
 * @author Hugo Tonatiuh Carrillo Bonilla
 * @version 2.0
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

    /**
     * Inicializa la estacion con el nombre indicado
     * y reserva espacio para los días que el usuario desee
     * @param nombreEstacion El nombre de la estacion meteorologica
     * @param numDias El numero de dias a reservar para la estacion
     */
    public EstacionMeteorologica(String nombreEstacion, int numDias) {
        if (nombreEstacion != null && nombreEstacion.length() > 0)  {
            this.nombreEstacion = nombreEstacion;
        } else {
            this.nombreEstacion = "Estacion UNAM";
        }
        this.temperaturas = (numDias > 0) ?  new double[numDias] :  new double[7];
        for (int i = 0; i < temperaturas.length; i++) {
            this.temperaturas[i] = -300.0;
        }
    }

    // METODOS DE CONSULTA Y REGISTRO (PARTE 1)

    public String getNombreEstacion() {
        return this.nombreEstacion;
    }

    public int getNumeroDias() {
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

    /**
     * Devuelve la temperatura en Celsius de un día
     * Porque accede a un arreglo,
     * reste uno mentalmente al dia que quiera acceder
     *
     * @param indiceDia Posicion del dia para obtener la temperatura
     * @return temperatura del dia si era un dia valido,
     * cero absoluto de lo contrario
     */
    public double obtenerTemperatura(int indiceDia) {
        return (0 <= indiceDia && indiceDia < temperaturas.length) ? temperaturas[indiceDia] : -300.0 ;
    }

    // METODOS ESTADISTICOS (PARTE 2)

    /**
     * Calcula el promedio de todas las temperaturas registradas
     *
     * @return El promedio de todos los dias
     */
    public double calcularPromedio() {
        double promedio = 0;
        for (int i = 0; i < temperaturas.length; i++) {
            promedio += temperaturas[i];
        }
        promedio /= temperaturas.length;
        return promedio;
    }

    /**
     * Regresa la temperatura maxima registrada en todos los dias
     *
     * @return El promedio de todos los dias
     */
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

    /**
     * Devuelve la cantidad de dias que tuvieron una temperatura mayor o 
     * igual a un umbral indicado
     *
     * @param umbral Temperatura minima que se considera para los dias calurosos
     * @return La cantidad de dias que tuvieron una temperatura mayor
     * o superior al umbral
     * cero absoluto de lo contrario
     */
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
        s += "Promedio: " + this.calcularPromedio() + " C" + " | ";
        s += "Maxima: " + this.obtenerMaxima() + " C";
        return s;
    }

    // CONVERSION DE ESCALAS (PARTE 3)

    /**
     * Convierte una temperatura en double a Celsius
     *
     * @param celsius Temperatura a convertir
     * @return La temperatura en Celsius
     */
    public double convertirAFahrenheit(double celsius) {
        return (celsius * 1.8) + 32.0;
    }

    /**
     * Este metodo supersede para devolver el promedio de la
     * temperatura de los dias medidos en Fahrenheit o en Celsius
     * segun se indique
     *
     * @param escala Escala en la que se quiera obtener el promedio
     * @return La temperatura en en Fahrenheit o en Celsius segun sea el caso
     */
    public double calcularPromedio(Escala escala) {
        switch (escala) {
        case FAHRENHEIT:
            return convertirAFahrenheit(calcularPromedio());
        }
        return calcularPromedio();
    }

    // RETOS (PARTE 4)

    /**
     * Regresa el indice del primer dia en el que se detecto una temperatura
     * menor al punto de fusion del agua
     *
     * @return Indice del dia, -1 si nunca sucedio
     */
    public int buscarPrimerDiaHelada() {
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] <= 0.0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Regresa el mayor salto de temperatura entre dos dias consecutivos
     *
     * @return El mayor salto
     */
    public double mayorCambioConsecutivo() {
        double maximo = 0;
        double local;
        if (temperaturas.length >= 2) {
            for (int i = 0; i < temperaturas.length -1; i++) {
                local = Math.abs(temperaturas[i+1]-temperaturas[i]);
                maximo = (local > maximo) ? local : maximo;
            }
            return maximo;
        } else {
            return 0.0;
        }
    }
}
