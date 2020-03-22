package application;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ConfiguracaoController {
	
	private String URL = "";

    @FXML
    private Button btnEntrar;

    @FXML
    private TextField txfMediaImpar;

    @FXML
    private TextField txfArquivoExcel;

    @FXML
    private Button btnArqExcelArquivos;

    @FXML
    private Button btnArqExcelArquivosSalvar;

    @FXML
    void SalvarDBOnline(ActionEvent event) {

    }

    @FXML
    void carregarArquivoExcelConcursos(ActionEvent event) {
    	ExcelReadWrite erw = new ExcelReadWrite();
    	
    	JFrame frame = new JFrame();
    	JFileChooser jfc = new JFileChooser();
    	
    	ObservableList<Concurso> concursos = FXCollections.observableArrayList();
    	
    	int userSelection = jfc.showSaveDialog(frame);
    	 
    	if (userSelection == JFileChooser.APPROVE_OPTION) {
    	    File fileToSave = jfc.getSelectedFile();
    	    URL = fileToSave.getAbsolutePath();
    	    
    	    concursos = erw.lerArquivoExcelConcursos(URL);
    	    System.out.println(concursos.toString());
    	}
    	
    	txfArquivoExcel.setText(URL);
    }

    @FXML
    void entrar(ActionEvent event) {

    }

}


