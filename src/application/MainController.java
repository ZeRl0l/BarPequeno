package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController implements Initializable{
	
    @FXML
	private TextField clienteId;

    @FXML
	private TextField clienteTb;

    @FXML
	private TextField clienteTc;
    
    @FXML
	private TextField cadeirasQntd;
    
    @FXML
    private Button adicionaCliente;
    
    @FXML
    private Button adicionaCadeira;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	@FXML
	private void addCliente() {
		System.out.println("Olha o cliente como vem");
	}
	
	@FXML
	private void addCadeira() {
		
	}

}
