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
			for (int i = 1; i <= meses; i++) {
				saldo = saldo * (1+tasaMensual);
				System.out.printf("En el mes %d se tiene un saldo de %.2f %n",i,saldo);
			}

			double interesCompuestoTeorico = precio * (Math.pow((1+tasaMensual),21));

			System.out.printf("Interés compuesto: %.2f Interés compuesto teórico: %.2f", saldo, interesCompuestoTeorico);
			
		} else if (!(meses > 0)) {
			System.out.println("Su préstamo se tiene que pagar en al menos un mes.");
		} else if (!(precio > 0)) {
			System.out.println("Su precio tiene que ser mayor a 0.");
		} else {
			System.out.println("La categoría de su cliente no es válida, si este no es el caso, ocurrió un error inesperado. Contacte al mantenedor de su programa.");
		}
	}
}
