public class Bienvenida {
	public static void main(String[] args) {
		String nombre = "Nikté Carrillo Bonilla";
		String noCuenta = "320026379"; // Esto en realidad es un mal diseño de sistemas: porque el número de cuenta se usa algebraicamente.
		String expertiz = "Nada";
		int edad = 22;
		char inicial = nombre.charAt(0);
		System.out.println(nombre + " " + noCuenta + " " + expertiz + " " + edad + " " + inicial);
	}
}
