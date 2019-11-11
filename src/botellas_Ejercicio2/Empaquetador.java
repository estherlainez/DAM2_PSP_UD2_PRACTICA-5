package botellas_Ejercicio2;

import java.util.concurrent.Semaphore;

public class Empaquetador extends Thread{
	private static String nombre;
	Semaphore semEmpaquetador;
	Semaphore seEmbotellador;
	
	public Empaquetador(String nombre, Semaphore seEmpaquetador, Semaphore seEmbotellador) {
		this.nombre=nombre;
		this.semEmpaquetador=seEmpaquetador;
		this.seEmbotellador=seEmbotellador;
	}
	
	public void run() {
		super.run();
		try {
			while(true) {
				if(Caja.nBotellas.get()>=10) {
					semEmpaquetador.acquire();	
					seEmbotellador.acquire(3);
					Caja.tomarCaja(this);
					sleep(2000);
					Caja.sellarCaja(this);
					sleep(2000);
					Caja.guardarCaja(this);
					semEmpaquetador.release();
					seEmbotellador.release(3);
					sleep(15000);
				}
			
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}

}
