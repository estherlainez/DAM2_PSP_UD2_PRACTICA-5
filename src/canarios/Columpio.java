package canarios;

import java.util.concurrent.Semaphore;

public class Columpio {
	private static String canario;
	private static String canaria;
	public Columpio(String nombre) {
		super();
	}
	public static void columpiar(String nombre) {
		System.out.println(nombre+" se esta columpiando");
	}
	public static void finColumpiar(String nombre) {
		System.out.println(nombre+" ha acabado de columpiarse");
	}

}
