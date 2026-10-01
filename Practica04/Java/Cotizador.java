public class Cotizador {
	public static void main(String[] args) {
		// Nuestras variables inamovibles
		int precio = 12899;
		int meses = 21;
		// Usamos double para evitar problemas con el compilador,
		// primero calculamos cuántas mensualidades vamos a cobrar,
		// después calculamos el interés total
		// y al final lo sumamos para tener el pago total
		double anios = meses / 12;
		double tasa = 15.0;
		double mensualidad = precio / meses;
		double interes = precio * (tasa/100) * anios;
		double total = precio + interes;
		// Usamos printf como aprendimos en clase
		System.out.printf("Mensualidades: %.2f%n Interés: %.2f%n Pago total: %.2f%n", mensualidad, interes, total);
	}
}
