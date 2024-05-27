
public class Auto {

	private String marca, modelo, color;
	private int velocidadBase, velocidadFinal;
	private Modificacion[] modificaciones = new Modificacion[15];
	private int cantidadModificaciones = 0;
	private int iMin = 0, iMax = 0, valor = 0;

	public Auto(String marca, String modelo, String color, int velBase) {
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.velocidadBase = velBase;
		this.velocidadFinal = velBase;
	}
	
	public void agregarModificaciones(Modificacion modificacion) {
		this.modificaciones[cantidadModificaciones] = modificacion;
		velocidadFinal += + modificacion.getVelIncremento();
		if(modificacion.getPrecio() < this.modificaciones[iMin].getPrecio()) {
			iMin = cantidadModificaciones;
		}

		if(modificacion.getPrecio() > this.modificaciones[iMax].getPrecio()) {
			iMax = cantidadModificaciones;
		}
		
		this.valor += modificacion.getPrecio();
		
		cantidadModificaciones++;
	}
	
	public Modificacion getModificacionMenorValor() {
		return this.modificaciones[this.iMin];
	}

	public Modificacion getModificacionMayorValor() {
		return this.modificaciones[this.iMax];
	}
	
	public String obtenerDatosAuto() {
		return this.marca + " " + this.modelo + " " + this.color + "\nVelocidad Base:  " + this.velocidadBase + " km/h\nVelocidad Final: " + this.velocidadFinal + " km/h";
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getColor() {
		return color;
	}

	public int getVelBase() {
		return velocidadBase;
	}
	
	public int getVelocidadFinal() {
		return velocidadFinal;
	}
	
	public int getValor() {
		return valor;
	}
	
	public Modificacion[] getModificaciones() {
		return modificaciones;
	}
	
	public int getCantidadModificaciones() {
		return cantidadModificaciones;
	}
	
}
