package ejercicio3_Canarios;

import java.util.concurrent.Semaphore;

public class Canaria extends Thread{
	private String nombre;
	Semaphore com;
	Semaphore col;
	Semaphore colH;
	
	
	
	public Canaria(String nombre, Semaphore com, Semaphore col, Semaphore colH) {
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
				
				colH.acquire();
				Columpio.columpiar(this.nombre);
				Thread.sleep(2000);
				Columpio.noColumpiar(this.nombre);
				colH.release();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}
