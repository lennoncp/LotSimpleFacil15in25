package application;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ConfiguracaoController {
	
	String URL = "";

    @FXML
    private Button btnEntrar;

    @FXML
    private TextField txfMediaImpar;

    @FXML
    private TextField txfArquivoExcel;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnLimpar;

    @FXML
    void SalvarDBOnline(ActionEvent event) {

    }

    @FXML
    void carregarArquivoExcelConcursos(ActionEvent event) {
    	JFrame frame = new JFrame();
    	JFileChooser jfc = new JFileChooser();
    	
    	int userSelection = jfc.showSaveDialog(frame);
    	 
    	if (userSelection == JFileChooser.APPROVE_OPTION) {
    	    File fileToSave = jfc.getSelectedFile();
    	    URL = fileToSave.getAbsolutePath();
    	}
    	
    	txfArquivoExcel.setText(URL);
    }

    @FXML
    void entrar(ActionEvent event) {

    }

}


