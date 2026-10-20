public class PrecisionPi {
	public static void main(String[] args) {
		double aproximacion = 0;
		double margenError = 0.01;
		double diferenciaError = Math.abs(Math.PI - aproximacion);
		int dardosLanzados = 0;
		int dardosDentro = 0;
		while (diferenciaError >= margenError) {
			double dardoAbcisa = Math.random();
			double dardoOrdenada = Math.random();
			double dardo = (dardoOrdenada*dardoOrdenada )+(dardoAbcisa*dardoAbcisa );
			if (dardo <= 1.0) {
				dardosDentro++;
			}
			dardosLanzados++;
			aproximacion = 4 * ((double) dardosDentro/dardosLanzados);
			diferenciaError = Math.abs(Math.PI - aproximacion);
			System.out.printf("%f %d %f %f %n",aproximacion, dardosLanzados, aproximacion, diferenciaError);
		}
	}
}
