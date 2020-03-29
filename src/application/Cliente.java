package application;

import java.util.concurrent.Semaphore;

public class Cliente extends Thread {
	
	private int numCadeiras; 
	
	private Semaphore semaforo, mutex, mutex2;
	
	String nome;
	int TempoBar;
	int TempoCasa;
	
	public Cliente(Semaphore semaforo,Semaphore mutex,Semaphore mutex2,String nome, int tempoBar, int tempoCasa, int numCadeiras) {
		
		this.numCadeiras = numCadeiras;
	}
	
	public void irParaCasa() {}

}
