public class PiInteractivo {
	public static void main(String[] args) {
		int dardosLanzados = 1000000;
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
