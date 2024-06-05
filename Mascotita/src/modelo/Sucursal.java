package modelo;

public enum Sucursal {
	 CENTRO(1,"Sucursal 1, del centro"),
	 SUR(2,"Sucursal 2, del sur"),
	 NORTE(3,"Sucursal 3, del norte"),
	 ESTE(4,"Sucursal 4, del este"),
	 OESTE(5,"Sucursal 5, del oeste");
	private final int id;
	private final String nombre;
	private Sucursal(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	
}
