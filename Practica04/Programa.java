// Todo programa en Java debe estar dentro de una clase, esta clase debe ser pública
public class Programa{
	// Inicializamos un método en nuestra clase público,para la JVM
	// Los métodos estáticos pueden ser invocados sin tener que crear una instancia de la clase
	// void nos dice que regresa ningún valor
	// main nos dice que es el método principal que la JVM va a buscar para inicializar
	// Los argumentos son guardados en un array de Strings
	public static void main(String[] args) {
	
	// Inicializamos cuatro variables
	String producto = "Laptop para la carrera";
	int precio = 15000;
	int descuento = 3000;
	double meses = 18.0;

	// Imprimimos al sistema
	System.out.println("=== Ficha de compra ===");
	System.out.println("- Producto : " + producto);	
	System.out.println("- Precio con descuento : " + (precio - descuento));
	System.out.println("- Plazo de pago en anios : " + (meses / 12.0));
	System.out.printf("- Pago mensual : " + ((precio - descuento) / meses));
	System.out.println("=== Fin de la ficha ===");

	}
}
