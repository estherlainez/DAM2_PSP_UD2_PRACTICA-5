package botellas_Ejercicio1;

import java.util.concurrent.Semaphore;

import canarios.Columpio;
import canarios.Comedero;

public class Embotellador extends Thread{
	private String nombre;
	private Semaphore seEmbotellador;
	private Semaphore seEmpaquetador;
	
	public Embotellador(String nombre, Semaphore seEmbotellador,Semaphore seEmpaquetador) {
		this.nombre=nombre;
		this.seEmbotellador=seEmbotellador;
		this.seEmpaquetador=seEmpaquetador;
	}
	
	public void run() {
		
		super.run();
		for(;;) {
			try {	
				seEmpaquetador.acquire();
				
				
				if(Caja.nBotellas.get()<10) {
					Botella.llenarBotella(this);
					sleep(1000);
					Botella.colocarBotellaEnCaja(this.nombre);
					sleep(1000);
					Caja.nBotellas.getAndIncrement();
					System.out.println("numero botellas="+Caja.nBotellas);
				}
				
				if(Caja.nBotellas.get()==10) {
					
					Botella.enviarSeñal(this);
					System.out.println("Empieza nueva caja");
					Caja.nBotellas.set(0);
					System.out.println("numero botellas="+Caja.nBotellas);
					sleep(2000);
					Caja.embotellando.set(false);
					
				}
				seEmpaquetador.release();
				
				sleep(3000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

}
