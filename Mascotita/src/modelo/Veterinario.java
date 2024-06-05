package modelo;
import java.util.Date;

public class Veterinario extends Persona{
	private int cedula;

	public Veterinario(String nombre, String aPaterno, String aMaterno, String fechaNacimiento, String curp,int cedula) {
		super(nombre,aPaterno,aMaterno,fechaNacimiento,curp);
		this.cedula = cedula;
	}

	public int getCedula() {
		return cedula;
	}

	public Veterinario() {

	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	@Override
    public String toString() {
        return super.toString() + "," + cedula + ",Veterinario";
    }
}
