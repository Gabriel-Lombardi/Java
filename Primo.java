package lombardi;

public class Primo {
	public static void main(String[] args) {
		for (int i = 50; i <= 100; i++) {
			System.out.print(i);
			
			if (i % 2 == 0) {
				System.out.println(" (par)");
			} else {
				System.out.println(" (impar)");
			}
		}
	}
}
