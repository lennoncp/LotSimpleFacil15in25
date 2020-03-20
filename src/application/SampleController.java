package application;

import java.net.URL;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class SampleController implements Initializable {
	
	private Random rad = new Random(LocalTime.now().toNanoOfDay());
	private Integer[] dezenas;
	private List<Integer> sorteador = new ArrayList<Integer>();
	
	private ObservableList<Aposta> apostas = FXCollections.observableArrayList();

    @FXML
    private Button btnEntrar;

    @FXML
    private Button btn01;

    @FXML
    private Button btn06;

    @FXML
    private Button btn05;

    @FXML
    private Button btn04;

    @FXML
    private Button btn03;

    @FXML
    private Button btn02;

    @FXML
    private Button btn14;

    @FXML
    private Button btn09;

    @FXML
    private Button btn18;

    @FXML
    private Button btn13;

    @FXML
    private Button btn08;

    @FXML
    private Button btn17;

    @FXML
    private Button btn12;

    @FXML
    private Button btn16;

    @FXML
    private Button btn11;

    @FXML
    private Button btn07;

    @FXML
    private Button btn25;

    @FXML
    private Button btn20;

    @FXML
    private Button btn15;

    @FXML
    private Button btn10;

    @FXML
    private Button btn19;

    @FXML
    private Button btn24;

    @FXML
    private Button btn23;

    @FXML
    private Button btn22;

    @FXML
    private Button btn21;

    @FXML
    private Button btnSortear;
    
    @FXML
    private TextField txfC1;

    @FXML
    private TextField txfC2;

    @FXML
    private TextField txfC5;

    @FXML
    private TextField txfC4;

    @FXML
    private TextField txfC3;
    
    @FXML
    private TableView<Aposta> tvApostas;

    @FXML
    private TableColumn<Aposta, Integer> tcCodigo;

    @FXML
    private TableColumn<Aposta, Integer> tcImpar;

    @FXML
    private TableColumn<Aposta, Integer> tcSoma;

    @FXML
    private TableColumn<Aposta, Button> tcAction;
    
    @FXML
    private TextField txfQtdApostas;

    @FXML
    void entrar(ActionEvent event) {
    	Stage primaryStage = new Stage();
    	try {
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("Configuracao.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}	
    }

    @FXML
    void sortear(ActionEvent event) {

    	int qtdApostas = Integer.valueOf(txfQtdApostas.getText());
    	
    	while(qtdApostas > 0) {
    		
	    	inicializarSorteador();
	    	
	    	dezenas = new Integer[15];
	    	
	    	/*for(int i = 0; i < 15; i++) {
	    		dezenas[i] = getSorteador();
	    	}*/
	    	int c1 = Integer.valueOf(txfC1.getText());
	    	int c2 = Integer.valueOf(txfC2.getText());
	    	int c3 = Integer.valueOf(txfC3.getText());
	    	int c4 = Integer.valueOf(txfC4.getText());
	    	int c5 = Integer.valueOf(txfC5.getText());
	    	
	    	List<Integer> qtdDezenasPorLinha = Arrays.asList(c1,c2,c3,c4,c5);
	    	dezenas = getSorteador(qtdDezenasPorLinha);
	    	
	    	Integer soma = 0;
	    	Integer impPar = 0;
	    	for(int i: dezenas) {
	    		if(i % 2 != 0) impPar++;
	    		soma += i;
	    	}
	   
	    	Button btn = new Button("X");
	    	btn.setOnAction((btnExcluir)->{});
	    	Integer codigo = apostas.size() + 1;
	    	Aposta aposta = new Aposta(codigo, impPar, soma, dezenas, btn);
	    	
	    	btn.setOnAction((btnExcluir)->{
	    		defautButons();
	    		apostas.remove(aposta);		
	    	});
	    	
	    	apostas.add(aposta);
    	
	    	qtdApostas--;
    	}
    }
    
    @FXML
    void tvApostasONMouseClicked(MouseEvent event) {
    	//System.out.println("selected");
    	//System.out.println(Arrays.toString(tvApostas.getSelectionModel().getSelectedItem().getDezenas()));
    	
    	defautButons();
    	
    	for(int d : tvApostas.getSelectionModel().getSelectedItem().getDezenas()) {
    		switch (d) {
			case 1:
				btn01.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 2:
				btn02.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 3:
				btn03.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 4:
				btn04.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 5:
				btn05.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 6:
				btn06.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 7:
				btn07.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 8:
				btn08.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 9:
				btn09.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 10:
				btn10.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 11:
				btn11.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 12:
				btn12.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 13:
				btn13.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 14:
				btn14.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 15:
				btn15.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 16:
				btn16.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 17:
				btn17.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 18:
				btn18.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 19:
				btn19.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 20:
				btn20.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 21:
				btn21.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 22:
				btn22.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 23:
				btn23.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 24:
				btn24.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			case 25:
				btn25.setStyle("-fx-background-color:  #be4bdb; -fx-text-fill: #f8f0fc;");
				break;
			default:
				break;
			}
    	}
    }
    
    public void inicializarSorteador() {
    	sorteador.clear();
    	for(int i = 0 ; i < 25; i++) {
    		sorteador.add(i+1);
    	}
    	System.out.println("Sorteador: " + sorteador);
    }
    
    private void defautButons() {
    	btn01.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn02.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn03.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn04.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn05.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
        btn06.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn07.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn08.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn09.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn10.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn11.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn12.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn13.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn14.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn15.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn16.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn17.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn18.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn19.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn20.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn21.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn22.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn23.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn24.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
		btn25.setStyle("-fx-background-color:  #f3d9fa; -fx-text-fill: #ae3ec9;");
    }
    
    public int getSorteador() {
    	int index = rad.nextInt(sorteador.size());
    	int valor = sorteador.get(index);
    	sorteador.remove(index);
    	System.out.print(sorteador);
    	System.out.print(" ");
    	System.out.println("valor: " + valor  + " index: " + index);
    	return valor;
    }
    
    public Integer[] getSorteador(List<Integer> qtdDezenasPorLinha) {
    	Integer[] dezenas = new Integer[15];
    	
    	//List<Integer> linha1 = Arrays.asList(1,2,3,4,5);
    	List<Integer> linha1 = new ArrayList<Integer>();
    	linha1.add(1);
    	linha1.add(2);
    	linha1.add(3);
    	linha1.add(4);
    	linha1.add(5);
    	
    	List<Integer> linha2 = new ArrayList<Integer>();
    	linha2.add(6);
    	linha2.add(7);
    	linha2.add(8);
    	linha2.add(9);
    	linha2.add(10);
    	
    	List<Integer> linha3 = new ArrayList<Integer>();
    	linha3.add(11);
    	linha3.add(12);
    	linha3.add(13);
    	linha3.add(14);
    	linha3.add(15);
    	
    	List<Integer> linha4 = new ArrayList<Integer>();
    	linha4.add(16);
    	linha4.add(17);
    	linha4.add(18);
    	linha4.add(19);
    	linha4.add(20);
    	
    	List<Integer> linha5 = new ArrayList<Integer>();
    	linha5.add(21);
    	linha5.add(22);
    	linha5.add(23);
    	linha5.add(24);
    	linha5.add(25);
    	
    	int linha = 1;
    	int indexDezenas = 0;
    	for(int d : qtdDezenasPorLinha) {
    		int index = 0;
    		for(int i = d; i > 0; i--) {
    			switch (linha) {
    			case 1:
    				index = rad.nextInt(linha1.size()); //TODO INDEX COM PROBLEMAS
    				dezenas[indexDezenas++] = linha1.get(index);
    				System.out.println("Index: "+index+ " LInha1: "+linha1.toString());
    				linha1.remove(index);
    			break;
    			case 2:
    				index = rad.nextInt(linha2.size());
    				dezenas[indexDezenas++] = linha2.get(index);
    				linha2.remove(index);
    			break;
    			case 3:
    				index = rad.nextInt(linha3.size());
    				dezenas[indexDezenas++] = linha3.get(index);
    				linha3.remove(index);
    			break;
    			case 4:
    				index = rad.nextInt(linha4.size());
    				dezenas[indexDezenas++] = linha4.get(index);
    				linha4.remove(index);
    			break;
    			case 5:
    				index = rad.nextInt(linha5.size());
    				dezenas[indexDezenas++] = linha5.get(index);
    				linha5.remove(index);
    			break;
    			default:
    				break;
    			}
    		}
    		
    		linha++;
    	}
    	
    	return dezenas;
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
			tcCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
			tcImpar.setCellValueFactory(new PropertyValueFactory("impPar"));
			tcSoma.setCellValueFactory(new PropertyValueFactory("soma"));
			tcAction.setCellValueFactory(new PropertyValueFactory("action"));
			tvApostas.setItems(apostas);
	}

}
