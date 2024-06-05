package modelo;
import java.util.Date;

public class Cliente extends Persona{
	private int noCliente;
	private Mascota mascota;
	private Tarejeta card;
	public int getNoCliente() {
		return noCliente;
	}
	public void setNoCliente(int noCliente) {
		this.noCliente = noCliente;
	}
	public Mascota getMascota() {
		return mascota;
	}
	public Cliente(String nombre, String aPaterno, String aMaterno, String fechaNacimiento, String curp,int noCliente, Mascota mascota, Tarejeta card) {
		super(nombre,aPaterno,aMaterno,fechaNacimiento,curp);
		this.noCliente = noCliente;
		this.mascota = mascota;
		this.card = card;
	}
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	public Tarejeta getCard() {
		return card;
	}
	public void setCard(Tarejeta card) {
		this.card = card;
	}
	  @Override
	    public String toString() {
	        return super.toString() + "," + noCliente + "," + mascota + "," + card;
	    }
	

}