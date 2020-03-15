package application;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController implements Initializable{
	
    @FXML
	private TextField clienteNome;

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
	
    @FXML
    private TextArea txtBar;
    
    @FXML
    private TextArea txtFila;
    
    @FXML
    private TextArea txtClienteCasa;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	@FXML
	private void addCliente() {
		String nomeCliente = clienteNome.getText();
		int tbCliente = Integer.parseInt(clienteTb.getText());
		int tcCliente = Integer.parseInt(clienteTc.getText());
		
		logFila("Cliente: " + nomeCliente + " foi adicionado com tempo no bar: " + 
				tbCliente + " e tempo em casa: " + tcCliente);
		
		clienteNome.clear();
		clienteTb.clear();
		clienteTc.clear();
		
		//TODO
	}
	
	@FXML
	private void addCadeira() {
		try { 
			int numCadeiras = Integer.parseInt(cadeirasQntd.getText());
			
	        if(!(numCadeiras >= 1 && numCadeiras <=  10)){
	            throw new NumberFormatException();
	        }
	        logBar("Foram adicionadas " + numCadeiras + " cadeiras.");
	        
	        //TODO
	        
            adicionaCadeira.setDisable(true);
		}
		catch(NumberFormatException e) {
			logBar("Valores inválidos para cadeiras.");
            cadeirasQntd.clear();
		}
	}


	private void logBar(String string) {
        Platform.runLater(() -> {
            txtBar.appendText("\n["+LocalDateTime.now().getHour()+":" + LocalDateTime.now().getMinute()+":"
                    + LocalDateTime.now().getSecond()+"] - " + string);
        });
	}
	
	private void logFila(String string) {
        Platform.runLater(() -> {
            txtFila.appendText("\n["+LocalDateTime.now().getHour()+":" + LocalDateTime.now().getMinute()+":"
                    + LocalDateTime.now().getSecond()+"] - " + string);
        });
	}
	
	private void logCasa(String string) {
        Platform.runLater(() -> {
            txtClienteCasa.appendText("\n["+LocalDateTime.now().getHour()+":" + LocalDateTime.now().getMinute()+":"
                    + LocalDateTime.now().getSecond()+"] - " + string);
        });
	}
	
}
