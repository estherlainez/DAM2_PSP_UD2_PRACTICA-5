package canarios;

import java.util.concurrent.Semaphore;

public class MainPajareria {

	public static void main(String[] args) {
		Semaphore se;
		Canario canarios[]=new Canario[3];
		se=new Semaphore(1);
		for(int i=0;i<3;i++) {
			canarios[i]=new Canario("Canario "+i, se);
			canarios[i].start();
		}
	}

}
