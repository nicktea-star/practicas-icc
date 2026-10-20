public class CotizadorPines {
	public static void main(String[] args) {
		int precio = 12899;
		int meses = 21;
		char califCliente = 'E';
		boolean condicion = (meses > 0) && (precio > 0);

		double tasa = 15.0;
		if (califCliente == 'P') {
			tasa -= 2;
		} else if (califCliente == 'R') {
			tasa += 3;
		} else if (califCliente == 'E') {
			tasa = tasa;
		} else {
			condicion = false;
		}

		if (condicion) {
			double anios = meses / 12;
			double mensualidad = precio / meses;
			double interes = precio * (tasa/100) * anios;
			double total = precio + interes;
			System.out.printf("Mensualidades: %.2f%n Interés: %.2f%n Pago total: %.2f%n", mensualidad, interes, total);
		} else if (!(meses > 0)) {
			System.out.println("Su préstamo se tiene que pagar en al menos un mes.");
		} else if (!(precio > 0)) {
			System.out.println("Su precio tiene que ser mayor a 0.");
		} else {
			System.out.println("La categoría de su cliente no es válida, si este no es el caso, ocurrió un error inesperado. Contacte al mantenedor de su programa.");
		}
	}
}
