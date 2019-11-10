package botellas;

import java.util.concurrent.Semaphore;

import canarios.Columpio;
import canarios.Comedero;

public class Embotellador extends Thread{
	private static String nombre;
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
				while(Caja.nBotellas<10) {
					Botella.llenarBotella(this);
					sleep(1000);
					Botella.colocarBotellaEnCaja(this.nombre);
					sleep(1000);
					Caja.nBotellas ++;
					System.out.println("numero botellas="+Caja.nBotellas);
				}
				seEmpaquetador.release();
				if(Caja.nBotellas==10) {
					seEmbotellador.acquire();
					Botella.enviarSeñal(this);
					System.out.println("Empieza nueva caja");
					Caja.nBotellas=0;
					seEmbotellador.release();
				}
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

}
