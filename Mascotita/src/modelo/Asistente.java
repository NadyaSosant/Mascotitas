package modelo;

import java.util.Date;
public class Asistente extends Persona {
    private int cedula;

    public Asistente(String nombre, String aPaterno, String aMaterno, String fechaNacimiento, String curp, int cedula) {
        super(nombre, aPaterno, aMaterno, fechaNacimiento, curp);
        this.cedula = cedula;
    }

    public int getCedula() { return cedula; }

    @Override
    public String toString() {
        return super.toString() + "," + cedula + ",Asistente";
    }
}