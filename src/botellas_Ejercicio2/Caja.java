package botellas_Ejercicio2;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Caja {
	public static AtomicInteger nBotellas= new AtomicInteger(0);
	public static AtomicBoolean embotellando= new AtomicBoolean(false);
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
