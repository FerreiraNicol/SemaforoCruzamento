package controller;

import java.util.concurrent.Semaphore;

public class ThreadController extends Thread{
	private String[] sentidos = {"Norte", "Sul", "Leste", "Oeste"};
	private int tid;
	private Semaphore semaforo;
	
	public ThreadController(Semaphore semaforo) {
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		tid = (int) threadId();
		int ind = (int)(Math.random()*3.1);
		System.out.println("O carro "+tid+" chegou ao cruzamento.");
		try {
			semaforo.acquire();
			System.out.println("O carro "+tid+" passou pelo cruzamento no sentido "+sentidos[ind]+".");
			try {
				sleep(500);
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			if(ind == 0 || ind == 2) {
				ind++;
			}else {
				ind--;
			}
			System.out.println("O carro "+tid+" mudou o sentido para "+sentidos[ind]+".");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
	}
}
