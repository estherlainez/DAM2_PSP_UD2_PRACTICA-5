package botellas;

import java.util.concurrent.Semaphore;

public class Empaquetador extends Thread{
	private static String nombre;
	Semaphore semEmpaquetador;
	
	public Empaquetador(String nombre, Semaphore seEmpaquetador) {
		this.nombre=nombre;
		this.semEmpaquetador=seEmpaquetador;
	}
	
	public void run() {
		super.run();
		try {
			semEmpaquetador.acquire(1);			
			Caja.tomarCaja(this);
			sleep(2000);
			Caja.sellarCaja(this);
			sleep(2000);
			Caja.guardarCaja(this);
			semEmpaquetador.release(1);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}

}
