package modelo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public abstract class Persona{
	private String nombre;
	private String aPaterno;
	private String aMaterno;
	private Date fechaNacimiento;
	private String curp;
	public Persona(){

	}
    public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getaPaterno() {
		return aPaterno;
	}
	public void setaPaterno(String aPaterno) {
		this.aPaterno = aPaterno;
	}
	public String getaMaterno() {
		return aMaterno;
	}
	public void setaMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public Persona(String nombre, String aPaterno, String aMaterno, String fechaNacimientostr, String curp) {
		
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
			 this.fechaNacimiento = dateFormat.parse(fechaNacimientostr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.nombre = nombre;
		this.aPaterno = aPaterno;
		this.aMaterno = aMaterno;
		this.curp = curp;
	}
	@Override
    public String toString() {
        return nombre + "," + aPaterno + "," + aMaterno + "," + fechaNacimiento + "," + curp;
    }

}