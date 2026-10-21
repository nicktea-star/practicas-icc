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
			double tasaMensual = (tasa / 100) / 12.0;
			double saldo = precio ;
			double total = 0;

			double anios = meses / 12.0;
			double interesSimple = precio * (tasa/100) * anios;
			double totalSimple = precio + interesSimple;

			for (int i = 1; i <= meses; i++) {
				saldo = saldo * (1+tasaMensual);
				System.out.printf("En el mes %d se tiene un saldo de %.2f %n",i,saldo);
			}
			double interesCompuesto = saldo - precio;
			double interesCompuestoTeorico = precio * (Math.pow((1+tasaMensual),21));

			System.out.printf("Tasa aplicada: %.0f %nPréstamo: $%d %nMeses de pago: %d%n", tasa, precio, meses);
			System.out.printf("Interés Simple: %.2f %nTotal con interés simple: %.2f %n", interesSimple, totalSimple);
			System.out.printf("Interés Compuesto: %.2f%n Total con interés compuesto: %.2f%n",interesCompuesto,saldo);
			System.out.printf("Interés compuesto teórico para comprobar que nuestro for funciona bien: %.2f",interesCompuestoTeorico);

		} else if (!(meses > 0)) {
			System.out.println("Su préstamo se tiene que pagar en al menos un mes.");
		} else if (!(precio > 0)) {
			System.out.println("Su precio tiene que ser mayor a 0.");
		} else {
			System.out.println("La categoría de su cliente no es válida. Si este no es el caso, ocurrió un error inesperado, contacte al mantenedor de su programa.");
		}
	}
}
