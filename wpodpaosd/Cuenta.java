
public class Cuenta {

	private String nombre, apellido;
	private int edad;
	public int dinero = 70000;
	private Auto auto;

	public Cuenta(String nombre, String apellido, int edad, Auto auto) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.auto = auto;
	}

	public void obtenerDatos() {
		System.out.println("\nNombre: " + this.nombre
						 + "\nApellido: " + this.apellido
						 + "\nEdad: " + this.edad
						 + "\nDinero: $" + this.dinero);
		
		System.out.println("\nDatos del auto: \n" + this.auto.obtenerDatosAuto());
		System.out.println("\nModificaciones realizadas: ");
		for (int i = 0; i < this.auto.getCantidadModificaciones(); i++) {
			System.out.printf("\n%02d. " + this.auto.getModificaciones()[i].obtenerDatos(), (i+1));
		}
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	public Auto getAuto() {
		return auto;
	}
	
	
	
}
