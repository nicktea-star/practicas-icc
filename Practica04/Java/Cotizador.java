public class Cotizador {
	public static void main(String[] args) {
		int precio = 12899;
		int meses = 21;
		double anios = meses / 12;
		double tasa = 15.0;
		double mensualidad = precio / meses;
		double interes = precio * (tasa/100) * anios;
		double total = precio + interes;
		System.out.printf("Mensualidades: %.2f%n Interés: %.2f%n Pago total: %.2f%n", mensualidad, interes, total);
	}
}
