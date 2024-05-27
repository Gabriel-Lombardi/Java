import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	private static Scanner s = new Scanner(System.in);
	private static Cuenta jugador;
	
	public static void main(String[] args) {
		
		ingresarDatos();
		
		Tienda tienda = new Tienda(jugador);
		tienda.comprarModificaciones();
		
		System.out.println("\nDatos del usuario");
		jugador.obtenerDatos();
		System.out.println("\nValor total del auto: " + jugador.getAuto().getValor() + "\n");
		
		System.out.println("Modificacion de menor valor: " + jugador.getAuto().getModificacionMenorValor().obtenerDatos());
		System.out.println("Modificacion de mayor valor: " + jugador.getAuto().getModificacionMayorValor().obtenerDatos());
	}

	private static void ingresarDatos() {
		String[][] autos = {
			    {"Volkswagen", "Gol", "Blanco", "170"},
			    {"Ford", "Fiesta", "Rojo", "120"},
			    {"Chevrolet", "Corsa", "Azul", "150"},
			    {"Toyota", "Corolla", "Negro", "200"},
			    {"Honda", "Civic", "Gris", "180"},
			    {"Nissan", "Sentra", "Blanco", "160"},
			    {"Mazda", "3", "Rojo", "220"},
			    {"Hyundai", "Elantra", "Azul", "140"},
			    {"Kia", "Rio", "Negro", "190"},
			    {"Renault", "Clio", "Verde", "210"}
			};
		
		System.out.println("N E E D   F O R   S P E E D");
		System.out.print("Ingrese su nombre: ");
		String nombre = s.nextLine();
		System.out.print("Ingrese su apellido: ");
		String apellido = s.nextLine();
		System.out.print("Ingrese su edad (9 - 99): ");
		int edad = ingresarEntero(9, 99);
		
		System.out.println("Perfecto " + nombre + " " + apellido + ". Bienvenido a Need For Speed. Vamos al concesionario a elegir tu auto, dale?\n");
		
		for (int i = 0; i < autos.length; i++) {
			System.out.printf("%02d. ", (i+1));
			System.out.println("Marca: " + autos[i][0]
						  + " | Modelo: " + autos[i][1]
						  + " | Color: " + autos[i][2]
						  + " | Velocidad Base: " + autos[i][3] + "km/h" );
		}
		
		int eleccionAuto = ingresarEntero(1, autos.length)-1;
		
		Auto auto = new Auto(autos[eleccionAuto][0],
							 autos[eleccionAuto][1],
							 autos[eleccionAuto][2],
			Integer.parseInt(autos[eleccionAuto][3]));
		
		jugador = new Cuenta(nombre, apellido, edad, auto);
		
		System.out.println("Presione enter para continuar.");
		// TRUCO
		boolean truco = ingresarTruco();
		if (truco) {
			System.out.println("Activaste un truco!! +$20000\n");
			jugador.dinero += 20000;
		}
	}

	private static boolean ingresarTruco() {
		String palabraTruco = "regmebaby";
		String palabraIngresada = s.nextLine();
		boolean encontroTruco = false;
		
		if (palabraIngresada.equals(palabraTruco)) {
			encontroTruco = true;
		}
		
		return encontroTruco;
	}

	private static int ingresarEntero(int min, int max) {
		int opc = 0;
		boolean error = false;
		
		do {
			error = false;
			
			try {
				opc = s.nextInt();
				s.nextLine();
				if (opc < min || opc > max) {
					System.out.println("Error. El dato ingresado debe ser un numero entre " + min + " y " + max);
					error = true;
				}

			} catch(InputMismatchException e) {
				System.out.println("Error. El dato ingresado debe ser un numero entero.");
				error = true;
				s.nextLine();
			} catch(Exception e) {
				System.out.println("Error inesperado.");
				e.printStackTrace();
				error = true;
			}
			
		} while(error);
		
		return opc;
	}
	
}
