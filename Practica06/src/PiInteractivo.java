import java.util.Scanner;
public class PiInteractivo {
	public static void main(String[] args) {
		int dardosLanzados = 0;
		double inputDardos;
		boolean condicion;
		Scanner lector = new Scanner(System.in);

		do {
			System.out.println("Inserte el número de dardos que quiera lanzar");
			inputDardos = lector.nextDouble();
			condicion = (inputDardos % 1 == 0) && (inputDardos > 0);
			if (condicion) {
				dardosLanzados = (int) inputDardos;
			} else {
				System.out.println("Su número debe de ser un entero, mayor a cero y menor que 2147483647");
			}
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
