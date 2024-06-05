package modelo;

public class Mascota /*implements Vacunas*/{
	private String nombre;
	private String raza;
	private int numeroMascota;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public int getNumeroMascota() {
		return numeroMascota;
	}
	public void setNumeroMascota(int numeroMascota) {
		this.numeroMascota = numeroMascota;
	}
	public Mascota(String nombre, String raza, int numeroMascota) {
		//super();
		this.nombre = nombre;
		this.raza = raza;
		this.numeroMascota = numeroMascota;
	}
	
}
