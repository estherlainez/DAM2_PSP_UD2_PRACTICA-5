package canarios;

import java.util.concurrent.Semaphore;

public class Comedero {
	private static String canario;
	private static String canaria;
	public Comedero() {
		super();
	}
	
	public static void Comer(String nombre) {
		System.out.println(nombre+" esta comiendo");
	}
	
	public static void AcabarComer(String nombre) {
		System.out.println(nombre+" ya ha comido");
	}

}
