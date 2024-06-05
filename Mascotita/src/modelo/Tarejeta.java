package modelo;
import java.util.Date;
public class Tarejeta {
	private int noTarjeta;
	private Date fechaVencimiento;
	private short cvc;
	private long saldo;
	public Tarejeta(int noTarjeta, Date fechaVencimiento, short cvc) {
		super();
		this.noTarjeta = noTarjeta;
		this.fechaVencimiento = fechaVencimiento;
		this.cvc = cvc;
	}
	public int getNoTarjeta() {
		return noTarjeta;
	}
	public void setNoTarjeta(int noTarjeta) {
		this.noTarjeta = noTarjeta;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public short getCvc() {
		return cvc;
	}
	public void setCvc(short cvc) {
		this.cvc = cvc;
	}
	public long getSaldo() {
		return saldo;
	}
	public void setSaldo(long saldo) {
		this.saldo = saldo;
	}
	@Override
    public String toString() {
        return noTarjeta + "," + fechaVencimiento + "," + cvc + "," + saldo;
    }
	

}
