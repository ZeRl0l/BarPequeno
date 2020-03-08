package application;
	
import java.io.IOException;

import application.controller.AdicionaPessoaController;
import application.model.Cliente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Main extends Application {
	
    private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		this.primaryStage = primaryStage;
		
		this.primaryStage.setResizable(false);
		this.primaryStage.setWidth(1280.0);
		this.primaryStage.setTitle("Problema do Bar Pequeno");	
		
		showTelaPrincipal();
	}
	
	
	public void showTelaPrincipal() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/Main.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	//TODO
	public boolean showAdicionaPessoa(Cliente cliente) throws IOException{
			
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/AdicionaPessoa.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Adiciona Cliente");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
        AdicionaPessoaController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        
        dialogStage.showAndWait();
		
        return controller.isOkClicked();
	}
	
    public Stage getPrimaryStage() {
        return primaryStage;
    }
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
