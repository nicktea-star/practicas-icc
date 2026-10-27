import java.util.Scanner;

public class BinarioInteractivo {
	public static void main(String[] args) {
		int numero = 0;
		int cociente;
		int residuo;
		boolean condicion = true;
		boolean condicionInput = false;

		Scanner lector = new Scanner(System.in);
		while (condicion) {
			String numeroBinario = "";

			System.out.print("Introduzca el número que quiera convertir ");
			while (!(condicionInput)) {
				if (lector.hasNextInt()) {
					numero = lector.nextInt();
					if (numero >= 0) {
						condicionInput = true;
					} else {
						System.out.println("Tiene que introducir un número no negativo.");
						condicionInput = false;
					}
				} else {
					System.out.println("Tiene que introducir un número.");
					condicionInput = false;
				}
				lector.nextLine();
			}

			do {
				cociente = numero / 2;
				residuo = numero % 2;
				numeroBinario = residuo + numeroBinario;
				numero = cociente;
			} while(cociente != 0);
			System.out.printf("%s %n", numeroBinario);

			System.out.print("¿Quiere convertir otro número? ");
			char inputCondicion = lector.next().charAt(0);
			lector.nextLine();
			if (inputCondicion == 'S' || inputCondicion == 's') {
				condicion = true;
			} else {
				condicion = false;
			}
		}
		lector.close();
	}
}
