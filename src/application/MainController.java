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
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MainController implements Initializable{
	Bar bar = new Bar();
	
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
     
    @FXML
    private ImageView imgBar0;
    
    @FXML
    private ImageView imgBar1;
    
    @FXML
    private ImageView imgBar2;
    
    @FXML
    private ImageView imgBar3;
    
    @FXML
    private ImageView imgBar4;
    
    @FXML
    private ImageView imgBar5;
    
    @FXML
    private ImageView imgBar6;
    
    @FXML
    private ImageView imgBar7;
    
    @FXML
    private ImageView imgBar8;
    
    @FXML
    private ImageView imgBar9;
    
    @FXML
    private ImageView imgBar10;
    
    @FXML
    private ImageView imgCliente0;
    
    @FXML
    private ImageView imgCliente1;
    
    @FXML
    private ImageView imgCliente2;
    
    @FXML
    private ImageView imgCliente3;
    
    @FXML
    private ImageView imgCliente4;
    
    @FXML
    private ImageView imgCliente5;
    
    @FXML
    private ImageView imgCliente6;
    
    @FXML
    private ImageView imgCliente7;
    
    @FXML
    private ImageView imgCliente8;
    
    @FXML
    private ImageView imgCliente9;
    
    @FXML
    private ImageView imgCliente10;
    
    @FXML
    private ImageView imgCliente11;
    
    
    
    private final ImageView imgs_bar[] = new ImageView[11];
    private final ImageView imgs_clientes[] = new ImageView[12];

    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
        imgs_bar[0] = imgBar0;
        imgs_bar[1] = imgBar1;
        imgs_bar[2] = imgBar2;
        imgs_bar[3] = imgBar3;
        imgs_bar[4] = imgBar4;
        imgs_bar[5] = imgBar5;
        imgs_bar[6] = imgBar6;
        imgs_bar[7] = imgBar7;
        imgs_bar[8] = imgBar8;
        imgs_bar[9] = imgBar9;
        imgs_bar[10] = imgBar10;
        
        imgs_clientes[0] = imgCliente0;
        imgs_clientes[1] = imgCliente1;
        imgs_clientes[2] = imgCliente2;
        imgs_clientes[3] = imgCliente3;
        imgs_clientes[4] = imgCliente4;
        imgs_clientes[5] = imgCliente5;
        imgs_clientes[6] = imgCliente6;
        imgs_clientes[7] = imgCliente7;
        imgs_clientes[8] = imgCliente8;
        imgs_clientes[9] = imgCliente9;
        imgs_clientes[10] = imgCliente10;
        imgs_clientes[11] = imgCliente11;
		
	}
	
	
	@FXML
	private void addCliente() {
		try {
			
			bar.qntdCliente++;
			
			int id = 1;
			
			while (bar.cliente[id] != null) {
				id++;
			}
			
			String nomeCliente = clienteNome.getText();
			int tbCliente = Integer.parseInt(clienteTb.getText());
			int tcCliente = Integer.parseInt(clienteTc.getText());
			
            if( tbCliente<=0 || tcCliente<=0 || nomeCliente.isEmpty()){
                throw new NumberFormatException();
            }			
			
			logFila("Cliente: " + nomeCliente + " foi adicionado com tempo no bar: " + 
					tbCliente + ", tempo em casa: " + tcCliente + " e com id: " + id);
			
			bar.adiciona_cliente(id, nomeCliente, tbCliente, tcCliente);
			
            if(bar.qntdCliente == 10){
                adicionaCliente.setDisable(true);
            }			
			
			clienteNome.clear();
			clienteTb.clear();
			clienteTc.clear();
			
			//TODO não criar cliente caso bar esteja sem cadeiras
		}
		catch(NumberFormatException e) {
			logFila("Valores invalidos para clientes");
		}
	}
	
	@FXML
	private void addCadeira() {
		try { 
			int numCadeiras = Integer.parseInt(cadeirasQntd.getText());
			
	        if(!(numCadeiras >= 1 && numCadeiras <=  10)) {
	            throw new NumberFormatException();
	        }
	        
	        logBar("Foram adicionadas " + numCadeiras + " cadeiras.");
	        
	        imgs_bar[0].setVisible(false);
            imgs_bar[numCadeiras].setVisible(true);
            
            bar.adiciona_cadeira(numCadeiras);
            
            cadeirasQntd.setDisable(true);
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
