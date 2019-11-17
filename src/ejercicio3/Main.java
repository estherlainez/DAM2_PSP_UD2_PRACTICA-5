package ejercicio3;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Semaphore com = new Semaphore(3);
		Semaphore colM = new Semaphore(1);
		Semaphore colH = new Semaphore(1);
		
		Canario canarios[] = new Canario[5];
		Canaria canarias[] = new Canaria[5];

		for(int i=0;i<5;i++) {
			canarios[i] = new Canario("Canario_"+i, com, colM, colH);
			canarios[i].start();
			canarias[i] = new Canaria("Canaria_"+i, com, colM, colH);
			canarias[i].start();
		}
		
		
		
	}

}
