package canarios;

import java.util.concurrent.Semaphore;

public class MainCanariosMachosHembras {

	public static void main(String[] args) {
		Semaphore seCanarios=new Semaphore(1);
		Semaphore se2=new Semaphore(1);
		Canario canarios[]=new Canario[5];
		CanarioHembra c=new CanarioHembra("Periquita",se2,seCanarios);
		for(int i=0;i<5;i++) {
			canarios[i]=new Canario("Canario-->"+i, seCanarios);
			canarios[i].start();
	
		}
		c.start();
		

	}

}
