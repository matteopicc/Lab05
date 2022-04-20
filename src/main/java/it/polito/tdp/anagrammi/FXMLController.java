package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.AnagrammiModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AnagrammiModel model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCalcola;

    @FXML
    private Button btnReset;

    @FXML
    private TextArea txtAnagrammiCorr;

    @FXML
    private TextArea txtAnagrammiErr;

    @FXML
    private TextField txtPaolaIniziale;

    @FXML
    void handleCalcola(ActionEvent event) {
    	String parola = txtPaolaIniziale.getText();
    	txtAnagrammiCorr.clear();
    	txtAnagrammiErr.clear();
    	
    	if(parola.length()<2) {
    		txtAnagrammiCorr.appendText("La parola inserita è troppo corta");
    	}
    	if(parola.length()>8) {
    		txtAnagrammiCorr.appendText("La parola inserita è troppo lunga");
    	}
    	
    	Set<String>anagrammi= this.model.calcolaAnagrammi(parola);
    	for(String anagramma : anagrammi) {
    		if(this.model.isCorrect(anagramma)) {
    			txtAnagrammiCorr.appendText(anagramma +"\n");
    		}
    		else {
    			txtAnagrammiErr.appendText(anagramma +"\n");
    		}
    	}

    }

    @FXML
    void handleReset(ActionEvent event) {
    	txtAnagrammiCorr.clear();
    	txtAnagrammiErr.clear();
    	txtPaolaIniziale.clear();

    }

    @FXML
    void initialize() {
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiCorr != null : "fx:id=\"txtAnagrammiCorr\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErr != null : "fx:id=\"txtAnagrammiErr\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtPaolaIniziale != null : "fx:id=\"txtPaolaIniziale\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(AnagrammiModel model) {
    	this.model = model;
    }

}
