package exemplo;
import java.util.concurrent.Semaphore;

public class Cliente extends Thread{
	
	int numCadeiras = 4;
//	private Semaphore ocupadas = new Semaphore(0);
	private Semaphore mutex = new Semaphore(1);
//	private Semaphore full = new Semaphore (0);  
	int filaDeEspera = 0;
	int esperando = 0;
	int bebendo = 0;
	int aux = 0;
	boolean flag = false;
	
	public void run() {
		while(true) {
			
			System.out.println("Start");
			System.out.println("Bebendo: " + bebendo);
			System.out.println("Fila: " + filaDeEspera);
			System.out.println("Esperando: " + esperando);
			System.out.println("Mutex: " + mutex);
			
			try {
				mutex.acquire();
				
				System.out.println("Mutex: " + mutex);
				
				if(filaDeEspera == 1)
				{
					esperando++;
					System.out.println("Esperando: " + esperando);
					mutex.release();
				}
				else 
				{
					bebendo++;
					System.out.println("Bebendo: " + bebendo);
					if(bebendo == numCadeiras) {
						filaDeEspera = 1;
						System.out.println("Bebendo: " + bebendo);
						flag = true;
					}
					else {
						filaDeEspera = 0;
					}
					mutex.release();
				}
				
				try {
					mutex.acquire();
					
					if(flag == true) {
						
						bebendo--;
						
						if(bebendo == 0) 
						{
							if(esperando >= numCadeiras) {
								aux = numCadeiras;
							}
							else {
								aux = esperando;
							}
							
							esperando = esperando - aux;
							bebendo = bebendo + aux;
							
							if(bebendo == numCadeiras) { 
								filaDeEspera = 1;
							}
							else {
								filaDeEspera = 0;
							}
							flag = false;
						}
					}
					mutex.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
}