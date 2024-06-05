package modelo;
import java.util.Date;
public class Cita {
	private int numCita;
	private Date fecha;
	private Date hora;
	private Mascota mascota;
	public Cita(int numCita, Date fecha, Date hora, Mascota mascota, Asistente asistente) {
		super();
		this.numCita = numCita;
		this.fecha = fecha;
		this.hora = hora;
		this.mascota = mascota;
		this.asistente = asistente;
	}
	public Cita(int numCita, Date fecha, Date hora, Mascota mascota, Veterinario veterinario) {
		super();
		this.numCita = numCita;
		this.fecha = fecha;
		this.hora = hora;
		this.mascota = mascota;
		this.veterinario = veterinario;
	}
	private Veterinario veterinario;
	private Asistente asistente;
	public int getNumCita() {
		return numCita;
	}
	public void setNumCita(int numCita) {
		this.numCita = numCita;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public Mascota getMascota() {
		return mascota;
	}
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	public Veterinario getVeterinario() {
		return veterinario;
	}
	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}
	public Asistente getAsistente() {
		return asistente;
	}
	public void setAsistente(Asistente asistente) {
		this.asistente = asistente;
	}

}
