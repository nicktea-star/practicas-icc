import java.util.Scanner;

public class BinarioInteractivo {
	public static void main(String[] args) {
		int numero;
		int cociente;
		int residuo;
		String numeroBinario = "";
		boolean condicion = true;

		Scanner lector = new Scanner(System.in);
		while (condicion) {
			System.out.print("Introduzca el número que quiera convertir ");
			numero = lector.nextInt();
			lector.nextLine();
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
