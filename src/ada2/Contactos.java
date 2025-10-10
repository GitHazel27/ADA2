package ada2;

public class Contactos {
	private int numero;
	private String nombre;
	private String telefono;
	private String imagen;
	
	public Contactos (int num,String nomb, String tel, String ima) {
		numero = num;
		nombre = nomb;
		telefono = tel;
		imagen = ima;
	}
	
	public int getNum() {
		return numero;
	}
	public String getNomb() {
		return nombre;
	}
	public String getTel() {
		return telefono;
	}
	public String getIma() {
		return imagen;
	}

}
