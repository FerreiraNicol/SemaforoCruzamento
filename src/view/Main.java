package view;

import controller.ThreadController;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		for(int i = 0; i < 8; i++) {
			Thread tc = new ThreadController(semaforo);
			tc.start();
		}
	}

}
