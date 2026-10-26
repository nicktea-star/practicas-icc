import java.util.Scanner;

public class CabanaDelMisterio {
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		String nombreCliente;
		int precio;
		int meses;
		char califCliente;
		double tasa;

		// Input de Mabel o del cliente.
		System.out.print("Introduzca el nombre de su cliente. ");
		nombreCliente = lector.nextLine();
		System.out.print("Introduzca la categoría de Cliente 'P' 'E' o 'R'. ");
		califCliente = lector.next().charAt(0);
		System.out.print("Introduzca el capital prestado. ");
		precio = lector.nextInt();
		lector.nextLine();
		System.out.print("Introduzca la tasa de interés anual base. ");
		tasa = lector.nextDouble();
		lector.nextLine();
		System.out.print("¿En cuántos meses se pagará su préstamo? ");
		meses = lector.nextInt();

		boolean inputsValidos = (((califCliente == 'P') || (califCliente == 'R') || (califCliente == 'E')) && (precio > 0) && (meses > 0) && (tasa > 0));

		// Datos a computar en el programa:
		double tasaMensual = (tasa / 100) / 12.0;

		double anios = meses / 12.0;
		double interesSimple = precio * (tasa/100) * anios;
		double totalSimple = precio + interesSimple;
		String califClientePalabra = "";

		if (califCliente == 'P') {
			tasa -= 2;
			califClientePalabra = "Preferente";
		} else if (califCliente == 'R') {
			tasa += 3;
			califClientePalabra = "Riesgoso";
		} else if (califCliente == 'E') {
			tasa = tasa;
			califClientePalabra = "Estándar";
		} else {
			inputsValidos = false;
		}

		// Input de menú para usar el programa.
		System.out.println("##### Sistema de prestamos de la Cabaña del misterio #####");
		System.out.println("> Las operaciones disponibles son:");
		System.out.println("1) Cotizar con interes simple.");
		System.out.println("2) Cotizar con interes compuesto.");
		System.out.println("3) Comparar interes simple y compuesto.");
		System.out.println("4) Cambiar el capital del prestamo.");
		System.out.println("0) Salir.");
		System.out.println("> Por favor, elige una opción :");

		int opcion = lector.nextInt();
		switch (opcion) {
			case 1:
				System.out.println("### Opción 1 : Cotización de interés simple ###");
				System.out.printf("- Nombre: %s %n", nombreCliente);
				System.out.printf("- Tipo de Cliente: %s %n", califClientePalabra);
				System.out.printf("- Capital del préstamo: %d %n", precio);
				System.out.printf("- Tasa anual: %.0f %n", tasa);
				System.out.printf("- Plazo en meses: %d %n %n", meses);
				System.out.printf("> Interés simple: %.2f %n", interesSimple);
				System.out.printf("> Total a pagar: %.2f %n", totalSimple);
				break;
			case 2:
				System.out.println("### Opción 2 : Cotización de interés compuesto ###");
				System.out.printf("- Nombre: %s %n", nombreCliente);
				System.out.printf("- Tipo de Cliente: %s %n", califClientePalabra);
				System.out.printf("- Capital del préstamo: %d %n", precio);
				System.out.printf("- Tasa anual: %.0f %n", tasa);
				System.out.printf("- Plazo en meses: %d %n %n", meses);
				System.out.printf("> Interés simple = %.2f %n", interesSimple);
				System.out.printf("> Total a pagar con interés simple = %.2f %n", totalSimple);
				double saldo = precio ;
				for (int i = 1; i <= meses; i++) {
					saldo = saldo * (1+tasaMensual);
					System.out.printf("> Mes %d = %.2f %n",i,saldo);
				}
				double interesCompuesto = saldo - precio;
				System.out.printf("> Interés compuesto = %.2f %n",interesCompuesto);
				System.out.printf("> Total a pagar = %.2f",precio+interesCompuesto);
				break;
			case 3:
				System.out.println("### Opción 3 : Comparación de intereses ###");
				double interesCompuestoTeorico = precio * (Math.pow((1+tasaMensual),21));
				System.out.printf("> Interés Simple = %.2f %n",interesSimple);
				System.out.printf("> Interés Compuesto = %.2f %n",interesCompuestoTeorico);
				System.out.printf("> La diferencia entre ellos es de %.2f %n", Math.abs(interesSimple - interesCompuestoTeorico));
				if (interesSimple > interesCompuestoTeorico) {
					System.out.println("El Interés Simple es mayor");
				} else if (interesSimple < interesCompuestoTeorico) {
					System.out.println("El Interés Compuesto es mayor");
				} else {
					System.out.println("Ambos intereses son iguales.");
				}
				break;
			case 4:
				System.out.println("### Opción 4 : Cambio de capital de préstamo ###");
				System.out.print("Introduzca el nuevo capital: ");
				precio = lector.nextInt();
				lector.nextLine();
				break;
			case 0:
				System.out.printf("- Nombre: %s %n", nombreCliente);
				System.out.printf("- Tipo de Cliente: %s %n", califClientePalabra);
				System.out.printf("- Capital del préstamo: %d %n", precio);
				System.out.printf("- Tasa anual: %.0f %n", tasa);
				break;
			default:
				System.out.println("Elija una opción correcta");
		}
	}
}
