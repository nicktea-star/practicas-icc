import java.util.Scanner;
public class CheckInput {
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		String check = lector.nextLine();
		if (lector.hasNextInt()) {
			System.out.println("Su input es un número");
			int lol = lector.nextInt();
			System.out.println(lol);
		} else {
			System.out.println("Su input no es un número");
		}
	}
}
