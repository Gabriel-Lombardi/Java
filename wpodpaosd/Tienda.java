import java.util.InputMismatchException;
import java.util.Scanner;

public class Tienda {
	
	private Scanner s = new Scanner(System.in);

	private String[][] modificacionesAux = {{"Aleron","Hero","10000","5"}, {"Motor","Kestrel","50000","20"}, {"Transmision","Medion","30000","10"}, {"Escape","Zero","7000","5"},
			{"Suspension","Velocicom","5000","3"}, {"Frenos","Dawndraft","4000","3"}, {"Llantas","Speedsciens","5000","2"}, {"Turbo","Norset","25000","15"},
			{"Nitro","Norset","40000","25"}, {"Luces de neon","Transtek","7000","0"}, {"Tinte de vidrios","Transtek","3000","0"},
			{"Capo fibra de carbono","Richter","25000","7"}, {"Faldon","Richter","7000","5"}, {"Paragolpes","Richter","6000","3"},
			{"Techo fibra de carbono","NovaT","25000","7"}, {"Toma de aire","NovaT","9000","4"}, {"Blindaje","URSA","10000","-5"},
			{"Patente","Omnia","2500","0"}, {"Claxon","Omnia","1500","0"}, {"Luces","Omnia","3000","0"}};

	private Modificacion[] modificaciones = new Modificacion[modificacionesAux.length];
	
	private int precioMenorModificacion = 0;
	
	private Cuenta jugador;
	
	public Tienda(Cuenta jugador) {
		
		for (int i = 0; i < modificaciones.length; i++) {
			modificaciones[i] = new Modificacion(modificacionesAux[i][0],
												 modificacionesAux[i][1],
								Integer.parseInt(modificacionesAux[i][2]),
								Integer.parseInt(modificacionesAux[i][3]));
		}
		obtenerModificacionMenorPrecio();
		this.jugador = jugador;
	}
	
	public void obtenerModificacionMenorPrecio() {
		int min = 0;
		for (int i = 1; i < modificaciones.length; i++) {
			if(modificaciones[i].getPrecio() < modificaciones[min].getPrecio()) {
				min = i;
			}
		}
		this.precioMenorModificacion = modificaciones[min].getPrecio();
	}
	
	public void comprarModificaciones() {
		boolean fin = false;
		
		System.out.println("Bienvenido a la tienda.\n");
		
		do {
			if (jugador.dinero == 0 || jugador.dinero < precioMenorModificacion) {
				System.out.println("No tiene dinero suficiente para comprar modificaciones.");
				fin = true;
			} else {
				System.out.println("Elija qué modificación desea comprar.\n"
								 + "Dinero disponible: " + jugador.dinero);
				for (int i = 0; i < modificaciones.length; i++) {
					System.out.printf("%02d " + modificaciones[i].obtenerDatos() + "\n", (i+1));
				}
				int opcElegida = ingresarEntero(1, modificaciones.length)-1;
				
				if(modificaciones[opcElegida].getPrecio() <= jugador.dinero) {
					boolean existe = buscarSiExiste(modificaciones[opcElegida].getTipo(), jugador.getAuto().getModificaciones(), jugador.getAuto().getCantidadModificaciones());
					if(!existe) {
						jugador.getAuto().agregarModificaciones(modificaciones[opcElegida]);
						jugador.dinero -= modificaciones[opcElegida].getPrecio();
						
					} else {
						System.out.println("No puede comprar esa modificación porque ya tiene una de ese mismo tipo.");
					}
				} else {
					System.out.println("No le alcanza el dinero para comprar esa modificación.");
				}
				
				if (jugador.getAuto().getCantidadModificaciones() == jugador.getAuto().getModificaciones().length) {
					System.out.println("Ha alcanzado el máxmio de modificaciones que puede comprar.");
					fin = true;
				} else {
					System.out.println("¿Quiere comprar otra modificacion?\n"
							+ "1. Si\n"
							+ "2. No\n");
					
					int opc = ingresarEntero(1, 2);
					
					if(opc == 2) {
						fin = true;
					}
				}
			}
		} while (!fin);
	}
	
	private boolean buscarSiExiste(String tipo, Modificacion[] modificacionesCompradas, int cantidadModificaciones) {
		boolean existe = false;
		int i = 0;
		
		while(i < cantidadModificaciones && !existe) {
			if(modificacionesCompradas[i].getTipo().equals(tipo)) {
				existe = true;
			}
			i++;
		}
		
		return existe;
	}

	private int ingresarEntero(int min, int max) {
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
