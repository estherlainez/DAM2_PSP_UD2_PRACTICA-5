package canarios;

import java.util.concurrent.Semaphore;

public class CanarioHembra extends Thread{
	private String nombre;
	private Semaphore sema1;
	private Semaphore sema2;
	
	public CanarioHembra (String nombre, Semaphore sem1, Semaphore sem2) {
		this.nombre=nombre;
		this.sema1=sem1;
		this.sema2=sem2;
	}
	
	public void run() {
		super.run();
		for(;;) {
			try {
				//sema.acquire(3);
				Comedero.Comer(this.nombre);
				Thread.sleep(1000);
				Comedero.AcabarComer(this.nombre);
				Thread.sleep(1000);
				//sema.release();
				sema1.acquire(1);
				Columpio.columpiar(this.nombre);
				Thread.sleep(1000);
				Columpio.finColumpiar(this.nombre);
				sema1.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
				
		}
	}
}
