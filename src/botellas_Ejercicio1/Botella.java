package botellas_Ejercicio1;

public class Botella {
	public static int nBotellas=0;
	public static String Embotellador;
	public static String Empaquetador;
	
	public Botella() {
		super();
	}
	
	public static void llenarBotella(Thread t) {
		System.out.println("La botella se ha llenado");
	
	}
	public static void colocarBotellaEnCaja(String Embotellador) {
		System.out.println(Embotellador+" ha colocado botella en la caja");
	
	}
	
	public static void enviarSeñal(Thread t) {
		System.out.println("La caja tiene las 10 botellas,retirela");
	
	}
	
}
