package modelo;

import java.util.Date;

public class Gerente extends Persona{
	public int numGerente;
    public Sucursal sucursal;
	public int getNumGerente() {
		return numGerente;
	}
	public void setNumGerente(int numGerente) {
		this.numGerente = numGerente;
	}
	public Gerente(String nombre, String aPaterno, String aMaterno, String fechaNacimiento, String curp, int numGerente, Sucursal sucursal) {
		super(nombre,aPaterno,aMaterno,fechaNacimiento,curp);
		this.numGerente = numGerente;
		this.sucursal = sucursal;
	}
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	@Override
    public String toString() {
        return super.toString() + "," + numGerente + "," + sucursal.name();
    }

}
