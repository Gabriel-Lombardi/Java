
public class NumeroParOImpar {
	public static void main(String[] args) {
        for (int numero = 50; numero <= 100; numero++) {
            boolean esPrimo = true;
            
            if (numero <= 1) {
                esPrimo = false;
            } else {
                for (int i = 2; i <= Math.sqrt(numero); i++) {
                    if (numero % i == 0) {
                        esPrimo = false;
                        break;
                    }
                }
            }
            
            System.out.print(numero + ": ");
            
            if (esPrimo) {
                System.out.println("Es primo.");
            } else {
                System.out.print("No es primo. Divisores: ");
                for (int i = 2; i <= numero / 2; i++) {
                    if (numero % i == 0) {
                        System.out.print(i + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
