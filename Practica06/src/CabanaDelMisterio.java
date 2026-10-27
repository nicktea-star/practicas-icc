import java.util.Scanner;

public class CabanaDelMisterio {
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		String nombreCliente;
		int precio = 1;
		int meses = 1;
		char califCliente;
		String califClientePalabra = "";
		double tasa = 2;
		boolean inputsValidos;

		// Input de Mabel o del cliente.
		System.out.print("Introduzca el nombre de su cliente. ");
		nombreCliente = lector.nextLine();
		do {
			System.out.print("Introduzca la tasa de interés anual base. ");
			if (lector.hasNextDouble()) {
				tasa = lector.nextDouble();
				if (tasa >= 2) {
					inputsValidos = true;
				} else {
					System.out.println("Su porcentaje de tasa anual tiene que ser mayor al 2% . \n Esto se debe a que, si el cliente tiene esta tasa y se vuelve preferente, pasa a tener una tasa anual del 0% .");
					inputsValidos = false;
				}
			} else {
				System.out.println("Introduzca un número que sea igual al porcentaje de su tasa anual base.");
				inputsValidos = false;
			}
			lector.nextLine();
		} while (!(inputsValidos));
		do {
			System.out.print("Introduzca la categoría de Cliente 'P' 'E' o 'R'. ");
			califCliente = lector.next().charAt(0);
			if (califCliente == 'P') {
				tasa -= 2;
				califClientePalabra = "Preferente";
				inputsValidos = true;
			} else if (califCliente == 'R') {
				tasa += 3;
				califClientePalabra = "Riesgoso";
				inputsValidos = true;
			} else if (califCliente == 'E') {
				tasa = tasa;
				califClientePalabra = "Estándar";
				inputsValidos = true;
			} else {
				System.out.println("Tiene que introducir solo una letra, sin estar rodeada por comillas: E para clientes estándar, P para preferentes y R para riesgosos.");
				inputsValidos = false;
			}
			lector.nextLine();
		} while (!(inputsValidos));
		do {
			System.out.print("Introduzca el capital prestado. ");
			if (lector.hasNextInt()) {
				precio = lector.nextInt();
				if (precio > 0) {
					inputsValidos = true;
				} else {
					System.out.println("Introduzca un número mayor a cero para prestar.");
					inputsValidos = false;
				}
			} else {
				System.out.println("Introduzca un número ENTERO para prestar.");
				inputsValidos = false;
			}
			lector.nextLine();
		} while(!(inputsValidos));
		do {
			System.out.print("¿En cuántos meses se pagará su préstamo? ");
			if (lector.hasNextInt()) {
				meses = lector.nextInt();
				if (meses > 0) {
					inputsValidos = true;
				} else {
					System.out.println("El número de meses en los que se paga el préstamo tiene que ser mayor a cero.");
					inputsValidos = false;
				}
			} else {
				System.out.println("Tiene que introducir un número para los meses en los que se pagará el préstamo.");
				inputsValidos = false;
			}
			lector.nextLine();
		} while(!(inputsValidos));


		// Datos a computar en el programa:
		double tasaMensual = (tasa / 100) / 12.0;

		double anios = meses / 12.0;
		double interesSimple = precio * (tasa/100) * anios;
		double totalSimple = precio + interesSimple;

		int erroresMenu = 0;
		int operacionesEfectivas = 0;
		boolean condicionMenu = true;
		while (condicionMenu) {
			// Input de menú para usar el programa.
			System.out.println("##### Sistema de prestamos de la Cabaña del misterio #####");
			System.out.println("> Las operaciones disponibles son:");
			System.out.println("1) Cotizar con interes simple.");
			System.out.println("2) Cotizar con interes compuesto.");
			System.out.println("3) Comparar interes simple y compuesto.");
			System.out.println("4) Cambiar el capital del prestamo.");
			System.out.println("0) Salir.");
			System.out.print("> Por favor, elige una opción : ");

			if (lector.hasNextInt()) {
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
						operacionesEfectivas++;
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
						operacionesEfectivas++;
						break;
					case 3:
						System.out.println("### Opción 3 : Comparación de intereses ###");
						double interesCompuestoTeorico = (precio * (Math.pow((1+tasaMensual),21))) - precio;
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
						operacionesEfectivas++;
						break;
					case 4:
						System.out.println("### Opción 4 : Cambio de capital de préstamo ###");
						System.out.print("Introduzca el nuevo capital: ");
						precio = lector.nextInt();
						lector.nextLine();
						operacionesEfectivas++;
						break;
					case 0:
						System.out.printf("- Nombre: %s %n", nombreCliente);
						System.out.printf("- Tipo de Cliente: %s %n", califClientePalabra);
						System.out.printf("- Capital del préstamo: %d %n", precio);
						System.out.printf("- Tasa anual: %.0f %n", tasa);
						operacionesEfectivas++;
						condicionMenu = false;
						break;
					default:
						System.out.println("Elija una opción correcta");
					erroresMenu++;
				}
			} else {
				System.out.println("Introduzca un número del menú para realizar una operación");
				erroresMenu++;
			}
			lector.nextLine();

			if (erroresMenu >= 3) {
				System.out.println("Ha cometido 3 errores en el menú. El programa será abortado por este motivo.");
				System.out.printf("- Nombre: %s %n", nombreCliente);
				System.out.printf("- Tipo de Cliente: %s %n", califClientePalabra);
				System.out.printf("- Capital del préstamo: %d %n", precio);
				System.out.printf("- Tasa anual: %.0f %n", tasa);
				condicionMenu = false;
			}
			if (operacionesEfectivas >= 5) {
				System.out.println("Ha realizado 5 operaciones en el programa. El programa será abortado por este motivo.");
				System.out.printf("- Nombre: %s %n", nombreCliente);
				System.out.printf("- Tipo de Cliente: %s %n", califClientePalabra);
				System.out.printf("- Capital del préstamo: %d %n", precio);
				System.out.printf("- Tasa anual: %.0f %n", tasa);
				condicionMenu = false;
			}
		}
	}
}
