package canarios;

import java.util.concurrent.Semaphore;
public class Canario extends Thread{
	private Semaphore sem;
	private Semaphore sem1;
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
				//sem1.acquire();
				Columpio.columpiar(this.nombre);
				Thread.sleep(1000);
				Columpio.finColumpiar(this.nombre);
				//sem1.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
