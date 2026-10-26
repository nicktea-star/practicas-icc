import java.util.Scanner;

public class BinarioInteractivo {
	public static void main(String[] args) {
		int numero;
		int cociente;
		int residuo;
		Scanner lector = new Scanner(System.in);
		numero = lector.nextInt();
		lector.close();
		do {
			cociente = numero / 2;
			residuo = numero % 2;
			System.out.printf("%d", residuo);
			numero = cociente;
		} while(cociente != 0);
	}
}
