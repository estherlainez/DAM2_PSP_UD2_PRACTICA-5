package botellas_Ejercicio1;

import java.util.concurrent.Semaphore;

import botellas_Ejercicio2.Caja;

public class Empaquetador extends Thread{
	private static String nombre;
	Semaphore semEmpaquetador;
	Semaphore semEmbotellador;
	public Empaquetador(String nombre, Semaphore seEmpaquetador, Semaphore seEmbotellador) {
		this.nombre=nombre;
		this.semEmpaquetador=seEmpaquetador;
		this.semEmbotellador=seEmbotellador;
	}
	
	public void run() {
		super.run();
		
		while(true) {
			try {
				//semEmpaquetador.acquire();
				if(Caja.nBotellas.get()>=10) {	
					semEmbotellador.acquire();
					Caja.tomarCaja(this);
					sleep(2000);
					Caja.sellarCaja(this);
					sleep(2000);
					Caja.guardarCaja(this);
					//semEmpaquetador.release();
					sleep(2000);
					semEmbotellador.release();
				}
				
				//semEmpaquetador.release();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
	}
	

}
