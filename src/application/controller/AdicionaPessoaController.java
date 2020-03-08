package application.controller;

import java.awt.TextField;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AdicionaPessoaController {
	
	@FXML
	private TextField idField;
	@FXML
	private TextField tbField;
	@FXML
	private TextField tcField;
	
    private Stage dialogStage;
    
    private boolean okClicked = false;
    
    @FXML
    private void initialize() {
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public boolean isOkClicked() {
        return okClicked;
    }
    
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}
