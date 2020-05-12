package application;

import java.util.concurrent.Semaphore;

import javafx.scene.image.ImageView;

public class Bar {
	
    Cliente cliente[] = new Cliente[10];
	Mesa mesa;
	int filaDeEspera = 0;
	int qntdCliente = 0;
	Fila fila;
    Semaphore cadeiras;
    
    public void adiciona_cliente(int id ,String nome, int tbCliente, int tcCliente, int numCadeiras, Mesa mesa, ImageView imgs_clientes[]) {
    	
    	this.mesa = mesa;
    	this.fila = new Fila();
    	this.cadeiras = new Semaphore(numCadeiras);
    	Cliente c = new Cliente(id ,nome, tbCliente, tcCliente, fila, mesa, cadeiras, imgs_clientes);
        this.cliente[id] = c;
        this.cliente[id].start();
    }    
    
//    public void adiciona_cadeira(int numCadeiras) {
//    	this.mesa = new Mesa(numCadeiras);
//    }
}
