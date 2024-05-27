
public class Modificacion {

	private String tipo, marca;
	private int precio, velIncremento;
	
	public Modificacion(String tipo, String marca, int precio, int velIncremento) {
		this.tipo = tipo;
		this.marca = marca;
		this.precio = precio;
		this.velIncremento = velIncremento;
	}
	
	public String obtenerDatos() {
		return "Tipo: " + tipo + " | Marca: " + marca + " | Precio: $" + precio + " | Velocidad de incremento: " + velIncremento + " km/h";
	}

	public String getTipo() {
		return tipo;
	}

	public String getMarca() {
		return marca;
	}

	public int getPrecio() {
		return precio;
	}

	public int getVelIncremento() {
		return velIncremento;
	}
	
	
	
}
