package canarios;

import java.util.concurrent.Semaphore;
public class Canario extends Thread{
	private Semaphore sem;
	private String nombre;
	
	public Canario (String nombre, Semaphore sem) {
		this.nombre=nombre;
		this.sem=sem;
	}
	
	public void run() {
		super.run();
		for(;;) {
			try {
				sem.acquire();
				Comedero.Comer(this.nombre);
				Thread.sleep(1000);
				Comedero.AcabarComer(this.nombre);
				Thread.sleep(1000);
				sem.release();
				Columpio.columpiar(this.nombre);
				Thread.sleep(1000);
				Columpio.finColumpiar(this.nombre);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
