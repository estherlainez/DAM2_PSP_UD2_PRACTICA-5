package ejercicio3;

import java.util.concurrent.Semaphore;

public class Canario extends Thread{

	private String nombre;
	Semaphore com;
	Semaphore col;
	Semaphore colH;
	
	
	
	public Canario(String nombre, Semaphore com, Semaphore col, Semaphore colH) {
		super();
		this.nombre = nombre;
		this.com = com;
		this.col = col;
		this.colH = colH;
	}



	@Override
	public void run() {
		
		super.run();
		
		while(true) {
			try {
				com.acquire();
				Comedero.comer(this.nombre);
				Thread.sleep(2000);
				Comedero.noComer(this.nombre);
				com.release();
				
				col.acquire();
				Columpio.columpiar(this.nombre);
				Thread.sleep(2000);
				Columpio.noColumpiar(this.nombre);
				col.release();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}
