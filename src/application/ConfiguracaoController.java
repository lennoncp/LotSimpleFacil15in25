package application;

import java.io.File;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ConfiguracaoController implements Initializable {
	
	private String URL = "";
	
	private ObservableList<Concurso> concursos;
	private ConcursoDAO cd;

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
    void carregarArquivoExcelConcursos(ActionEvent event) {
    	
    	JFrame frame = new JFrame();
    	JFileChooser jfc = new JFileChooser();
    	
    	int userSelection = jfc.showSaveDialog(frame);
    	 
    	if (userSelection == JFileChooser.APPROVE_OPTION) {
    	    File fileToSave = jfc.getSelectedFile();
    	    URL = fileToSave.getAbsolutePath();
    	    System.out.println(URL);
    	    concursos = ExcelReadWrite.lerArquivoExcelConcursos(URL);
    	    
    	   /* for(Concurso c : concursos) {
    	    	System.out.println(c.getConcurso() + " "+ c.getDezenas().toString());
    	    }*/
    	}
    	
    	txfArquivoExcel.setText(URL);
    }
    
    @FXML
    void SalvarDBOnline(ActionEvent event) {
    	for(Concurso c : concursos) {
    		cd = new ConcursoDAO();
	    	cd.salvarConcurso(c);
	    	System.out.println("concursos "+c.getConcurso()+" Data_sorteio: "+c.getDataConcurso()+""+c.getDezenas()+" salvo.");
	    }
    }

    @FXML
    void entrar(ActionEvent event) {

    }

	@Override
	public void initialize(java.net.URL location, ResourceBundle resources) {
		concursos = FXCollections.observableArrayList();
		
	}

}


