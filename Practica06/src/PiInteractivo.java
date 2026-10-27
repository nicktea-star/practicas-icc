import java.util.Scanner;
public class PiInteractivo {
	public static void main(String[] args) {
		int dardosLanzados = 0;
		int inputDardos;
		boolean condicion;
		Scanner lector = new Scanner(System.in);

		do {
			System.out.println("Introduzca el número de dardos que quiere lanzar para calcular Pi.");
			if (lector.hasNextInt()) {
				inputDardos = lector.nextInt();
				if (inputDardos > 0) {
					dardosLanzados = inputDardos;
					condicion = true;
				} else {
					System.out.println("Su número entero debe de ser positivo.");
					condicion = false;
				}
			} else {
				condicion = false;
				System.out.println("Su entrada debe de ser un número entero.");
			}
			lector.nextLine();
		} while (!(condicion));

		lector.close();


		int dardosDentro = 0;
		int contador = 0;
		while (contador <= dardosLanzados) {
			double dardoAbcisa = Math.random();
			double dardoOrdenada = Math.random();
			double dardo = (dardoAbcisa*dardoAbcisa)+(dardoOrdenada*dardoOrdenada);
			if (dardo <= 1.0) {
				dardosDentro++;
			}
			contador++;
		}
		double pi = 4 * ((double) dardosDentro / dardosLanzados);
		System.out.println(pi);
	}
}
