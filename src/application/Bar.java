package application;

import java.util.concurrent.Semaphore;

public class Bar {
	
    Cliente cliente[] = new Cliente[10];
	Mesa mesa;
	int filaDeEspera = 0;
	int qntdCliente = 0;
    Semaphore mutex = new Semaphore(1,true);

    public void adiciona_cliente(int id ,String nome, int tbCliente, int tcCliente) {
    	Cliente c = new Cliente(id ,nome, tbCliente, tcCliente);
        this.cliente[id] = c;
        this.cliente[id].start();
    }    
    
    public void adiciona_cadeira(int numCadeiras) {
    	this.mesa = new Mesa(numCadeiras);
    	mesa.start();
    }
}
