import java.util.Scanner;
public class CheckInput {
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		boolean condicion;
		do {
			if (lector.hasNextInt()) {
				System.out.println("Su input es un número");
				condicion = true;
			} else {
				System.out.println("Su input no es un número");
				condicion = false;
			}
			String dummyVariable = lector.nextLine();
		} while (!(condicion));
	}
}
