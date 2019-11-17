package ejercicio1;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Semaphore com = new Semaphore(3);
		Semaphore col = new Semaphore(1);
		
		Canario canarios[] = new Canario[5];

		for(int i=0;i<5;i++) {
			canarios[i] = new Canario("Canario_"+i, com, col);
			canarios[i].start();
		}
		
		
		
	}

}
