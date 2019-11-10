package botellas;

import java.util.concurrent.Semaphore;

public class MainBotellas {

	public static void main(String[] args) {
		Semaphore seEmbotellador=new Semaphore(1);
		Semaphore seEmpaquetador=new Semaphore(1);
		Embotellador em1=new Embotellador("Embotellador",seEmbotellador,seEmpaquetador);
		Empaquetador ep1=new Empaquetador("Empaquetador",seEmpaquetador);
		
		em1.start();
		ep1.start();
		

	}

}
