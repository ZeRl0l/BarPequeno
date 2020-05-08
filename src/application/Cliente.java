package application;

import java.util.concurrent.Semaphore;

public class Cliente extends Thread {
	
	int id;
	String nome;
	int tbCliente;
	int tcCliente;
	Mesa mesa;
	
	private Semaphore mutex = new Semaphore(1);
	
	private Semaphore sem, mutex2;

	public Cliente(int id, String nome, int tbCliente, int tcCliente) {
		this.id = id;
		this.nome = nome;
		this.tbCliente = tbCliente;
		this.tcCliente = tcCliente;
	}
	
	public void run() {
		while(true) {
			bebedeira();
		}
	} 	
	
	public void bebedeira() {
//		long t1, t2; 
		
		System.out.println("Start...");		
		
		try {
			this.mutex.acquire();
			
			if(mesa.isBebendo()) {
				System.out.println("Esperando...");
				mutex2.acquire();
			}
			
//			t1 = System.currentTimeMillis();
//			t2 = System.currentTimeMillis();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		mutex2.release();

	}

}
