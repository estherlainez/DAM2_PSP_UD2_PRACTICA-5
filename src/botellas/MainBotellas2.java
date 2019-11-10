package botellas;

import java.util.concurrent.Semaphore;

public class MainBotellas2 {

	public static void main(String[] args) {
		Embotellador embotelladores[]=new Embotellador[3];
		Semaphore seEmpaquetador=new Semaphore(1);
		Semaphore seEmbotellador=new Semaphore(embotelladores.length);
		Empaquetador ep1=new Empaquetador("Empaquetador",seEmpaquetador);
		for(int i=0;i<embotelladores.length;i++) {
			embotelladores[i]=new Embotellador("Embotellador___"+i,seEmbotellador,seEmpaquetador);
			embotelladores[i].start();
		}
		
		ep1.start();

	}

}
