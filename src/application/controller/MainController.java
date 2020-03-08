package application.controller;

import application.Main;
import application.model.Cliente;
import javafx.fxml.FXML;

public class MainController {
	
	@FXML
	private void handleNovoCliente() {
		
		Cliente cliente = new Cliente();
	    boolean okClicked = Main.showAdicionaPessoa(cliente);;
	}
}
