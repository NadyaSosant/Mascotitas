package modelo;

public enum Servicio {
	 CORTE("Corte", 150.0,"Un Cambio de look a tu amigo de cuatro patitas"),
	 BANIO("Baño", 100.0,"Dejamos reluciente y aromática a tu mascota con los mejores productos"),
	 DESPARASITACION("Desparasitación", 200.0,"Cuidamos la salud de la pancita de tu mascosa"),
	 ESTERILIZACION("Esterilización", 500.0,"Esterilización con anestecia inhalada!"),
	 VACUNACION("Vacunación", 250.0,"Cumpel el esquema de vacunación con nosotros!");
	 private final String nombre;
     private final double precio;
     private final String descripcion;
	 private Servicio(String nombre, double precio, String descripcion) {
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
     

}
