package application;

import java.util.concurrent.Semaphore;

import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;

public class Cliente extends Thread {
	
	int id, numCadeiras;
	String nome;
	int tbCliente;
	int tcCliente;
	Mesa mesa;
	Fila fila;
	Tempos tempos;
	ImageView img[];
	
	private Semaphore mutex = new Semaphore(1);
	private Semaphore mutex2 = new Semaphore(1);
	private Semaphore cadeiras;
	

	public Cliente(int id, String nome, int tbCliente, int tcCliente, Fila fila, Mesa mesa, Semaphore cadeiras, ImageView imgs_clientes[]) {
		this.id = id;
		this.nome = nome;
		this.tbCliente = tbCliente;
		this.tcCliente = tcCliente;
		this.numCadeiras = mesa.getNumCadeiras();
		this.mesa = mesa;
		this.fila = fila;
		this.cadeiras = cadeiras;
		this.img = imgs_clientes;
		this.tempos = new Tempos(tbCliente, tcCliente);
	}
	
	public void run() {

		while(true) {
			
			try {
				mutex.acquire();
				
				Cliente aux = this;
				fila.insereCliente(aux);			
	            
				mutex.release();
				
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}

			if(fila.inQueue(this)) {
							
				try {
					mutex.acquire();
					//TODO : mover sprite
					mutex.release();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}								
			}
			
			if(fila.getIndex(this) == 0){
				try {
					mutex2.acquire();
					bebedeira();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
		}
	} 	
	
	public void bebedeira() {
		long t1, t2; 	
		int segundos = 1;
		
		try {
			this.cadeiras.acquire();
			
			if(mesa.isBebendo()) {
				System.out.println("Esperando...");
				mutex2.acquire();
			}
			
			t1 = System.currentTimeMillis();
			t2 = System.currentTimeMillis();
		
			
			fila.removeCliente();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		mutex2.release();
		
		mesa.insereCliente();
		
		while(!mesa.isBebendo()){
			System.out.println("Esperando");
		}
		
		t1 = System.currentTimeMillis();
		t2 = System.currentTimeMillis();
		
		while(!checaTempoBar(t2-t1)){

			System.out.println(nome + " está há " + segundos + " segundos bebendo.");
			t2 = System.currentTimeMillis();
			segundos++;
		}
		
		System.out.println(nome + " estorou seu tempo no bar, teleportando para casa.");
		
		mesa.removeCliente();
		
		if(!mesa.isBebendo()){
			mutex2.release();
		}	
		
		this.cadeiras.release();		
	}
	
	private boolean checaTempoBar(long tempo){
		return tempo >= tempos.getTempoBar();
	}	

}
