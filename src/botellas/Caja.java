package botellas;


public class Caja {
	public static int nBotellas=0;
	public static String Embotellador;
	public static String Empaquetador;
	public Caja() {
		super();
	}

	public static void tomarCaja(Thread t) {
		System.out.println("La caja se ha cogido");
	
	}
	
	public static void sellarCaja(Thread t) {
		System.out.println("La caja se ha sellado");
	
	}
	public static void guardarCaja(Thread t) {
		System.out.println("La caja se traslado al almacen");
	
	}
}
