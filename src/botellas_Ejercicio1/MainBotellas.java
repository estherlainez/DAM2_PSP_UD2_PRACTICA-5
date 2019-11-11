package botellas_Ejercicio1;

import java.util.concurrent.Semaphore;

public class MainBotellas {

	public static void main(String[] args) {
		Semaphore seEmbotellador=new Semaphore(1);
		Semaphore seEmpaquetador=new Semaphore(1);
		Embotellador em1=new Embotellador("Embotellador",seEmbotellador,seEmpaquetador);
		Empaquetador ep1=new Empaquetador("Empaquetador",seEmbotellador,seEmpaquetador);
		
		em1.start();
		ep1.start();
		

	}

}
