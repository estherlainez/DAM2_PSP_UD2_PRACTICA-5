package canarios;

import java.util.concurrent.Semaphore;

public class MainPajaros2 {

	public static void main(String[] args) {
		Canario canarios[]=new Canario[5];
		Semaphore se=new Semaphore(1);
		for(int i=0;i<5;i++) {
			canarios[i]=new Canario("Canario "+i, se);
			canarios[i].start();
			
		}
	}

}
