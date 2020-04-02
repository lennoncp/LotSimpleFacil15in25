package application;

import java.io.File;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

public class SampleFullController implements Initializable {
	
	private Random rad = new Random(LocalTime.now().toNanoOfDay());
	private Integer[] dezenas;
	private List<Integer> sorteador = new ArrayList<Integer>();
	
	private ObservableList<ApostaConcurso> apostaConcursos = FXCollections.observableArrayList();
	private ObservableList<Aposta> apostas = FXCollections.observableArrayList();
	
	private ConcursoDAO cd;
	private ApostaDAO ad;

    @FXML
    private Button btnEntrar;

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
    private TableView<ApostaConcurso> tvApostas;

    @FXML
    private TableColumn<ApostaConcurso, Integer> tcCodigo;

    @FXML
    private TableColumn<ApostaConcurso, Integer> tcImpar;

    @FXML
    private TableColumn<ApostaConcurso, Integer> tcSoma;

    @FXML
    private TableColumn<ApostaConcurso, Button> tcAction;

    @FXML
    private TextField txfQtdApostas;

    @FXML
    private Button btnSortear;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnEntrar1;

    @FXML
    private TextField txfRangeConcursos;

    @FXML
    private TextField txfMediaImpar;

    @FXML
    private TextField txfArquivoExcel;

    @FXML
    private Button btnArqExcelArquivos;

    @FXML
    private Button btnArqExcelArquivosSalvar;
    
    @FXML
    private Button btnConcursoApostaChange;
    
    @FXML
    private Button btnApostasSalvas;

    @FXML
    void SalvarDBOnline(ActionEvent event) {
    	//for(Concurso c : concursos) {
    	for(Concurso c : LS.ConcursosGeral) {
    		cd = new ConcursoDAO();
	    	cd.salvarConcurso(c);
	    	System.out.println("concursos "+c.getConcurso()+" Data_sorteio: "+c.getDataConcurso()+""+c.getDezenas()+" salvo.");
	    }
    }

    @FXML
    void carregarArquivoExcelConcursos(ActionEvent event) {
    	
    	String URL = "";
    	
    	JFrame frame = new JFrame();
    	JFileChooser jfc = new JFileChooser();
    	
    	int userSelection = jfc.showSaveDialog(frame);
    	 
    	if (userSelection == JFileChooser.APPROVE_OPTION) {
    	    File fileToSave = jfc.getSelectedFile();
    	    URL = fileToSave.getAbsolutePath();
    	    System.out.println(URL);
    	    
    	    //concursos = ExcelReadWrite.lerArquivoExcelConcursos(URL);
    	    LS.ConcursosGeral = ExcelReadWrite.lerArquivoExcelConcursos(URL);
    	    
    	   /* for(Concurso c : concursos) {
    	    	System.out.println(c.getConcurso() + " "+ c.getDezenas().toString());
    	    }*/
    	}
    	
    	txfArquivoExcel.setText(URL);
    }

    @FXML
    void entrar(ActionEvent event) {

    }

    @FXML
    void salvarApostas(ActionEvent event) {
    	
    	ad = new ApostaDAO();
    	for(Aposta a: LS.apostas) {
    		ad.salvarAposta(a);
    		System.out.println("Aposta " + a.getCodigo() + " salva");
    	}
    	ad = new ApostaDAO();
    	LS.codigoAtualApostas = ad.getCodigoAposta()+1;
    }

    @FXML //REALIZA O SORTEIO DA APOSTA
    void sortear(ActionEvent event) {

 	int qtdApostas = Integer.valueOf(txfQtdApostas.getText());
    	
    	while(qtdApostas > 0) {
    		
	    	//inicializarSorteador();
	    	
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
	    	//btn.setOnAction((btnExcluir)->{System.out.println("Vazio");});
	    	//ad = new ApostaDAO();
	    	//Integer CodigoMaximoAtual = LS.codigoAtualApostas /*ad.getCodigoAposta()*/;
	    	Integer codigo = LS.codigoAtualApostas++;
	    	
	    	Aposta aposta = new Aposta(codigo, impPar, soma, dezenas, btn);
	    	aposta.getAction().setOnAction((btnExcluir)->{
	    		int id = aposta.getCodigo();
	    		System.out.println("Excluir Aposta: "+ id);
	    		defautButons();
	    		//apostaConcursos.remove(apostaConcursos.get(apostaConcursos.size()-1));
	    		LS.apostas.remove(aposta);
	    		//LS.codigoAtualApostas--;
	    		for(ApostaConcurso ac : LS.listaDeApostas) {
	    			Aposta a = ac.getAposta();
	    			if(a.getCodigo() == id) {
	    				LS.listaDeApostas.remove(ac);
	    			}
	    		}
	    	});
	    	
	    	Contagem c = new Contagem();
	    	int mediaImpar = c.contagemDeImparesGeral(LS.ConcursosGeral);
	    	System.out.println("Meia Impares: " + mediaImpar);
	    	if(impPar >= mediaImpar-1 && impPar <= mediaImpar+1) {
	    		
	    		LS.apostas.add(aposta);
		    	//apostaConcursos.add(ApostaConcurso.toApostaConcurso(aposta));
		    	
				LS.listaDeApostas.add(ApostaConcurso.toApostaConcurso(aposta));
				
				System.out.println(LS.apostas);
	    	
		    	qtdApostas--;
	    		
	    	}else {
	    		System.out.println("Media impar fora!");
	    		LS.codigoAtualApostas++;
	    	}
	    	
	    	
	    	
    	}
    	
    }

    @FXML
    void tvApostasONMouseClicked(/*MouseEvent event*/) {
    	
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
    
    @FXML
    void changeApostaConcurso(ActionEvent event) {
    	System.out.println("Realizar mudança");
    	defautButons();
    	if(tvApostas.getItems().size() > 1000) {
    		System.out.println("mostrar Concursos");
    		tvApostas.setItems(LS.listaDeApostas);
    		tvApostas.refresh();
    		btnConcursoApostaChange.setText("C");
    	}else {
    		System.out.println("mostrar apostas");
    		tvApostas.setItems(LS.listaDeConcursos);
    		tvApostas.refresh();
    		btnConcursoApostaChange.setText("A");
    	}
    	
    }
    
    @FXML
    void changeApostasSalvas(ActionEvent event) {
    	System.out.println("Realizando a leitura das apostas: "+ LS.listaDBApostas.size());
    	tvApostas.setItems(LS.listaDBApostas);
    	tvApostas.refresh();
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
    
    //SORTEIA AS DEZENAS POR LINHA  DE 1 A 5
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
    
    public List<Integer> sortearQuantidadeDezenasPorLinha() {
    	
    	int soma = 0;
    	List<Integer> qtdLinha = new ArrayList<Integer>();
    	while(soma == 15) {
    		for(int i = 0; i < 5;i++) {
    			qtdLinha.add(rad.nextInt(5));
    		}
    		
    		for(int i = 0 ; i < 5; i++) {
    			soma+= rad.nextInt(5);
    		}
    	}
    	
    	return qtdLinha;
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		LS.apostas = apostas;
		
		ad = new ApostaDAO();
    	LS.codigoAtualApostas = ad.getCodigoAposta()+1;
    	ad = new ApostaDAO();
    	LS.listaDBApostas= ad.getListaDeApostasSalvas();
		
		cd = new ConcursoDAO();
		LS.ConcursosGeral = cd.listaDeConcursos(1943);
		cd = new ConcursoDAO();
		LS.ConcursosRange3M = cd.listaDeConcursos(39);
		cd = new ConcursoDAO();
		LS.Concursos13D = cd.listaDeConcursos(13);
		
		for(Concurso c: LS.ConcursosGeral) {
			System.out.println("Iniciando Concurso: " + c);
			LS.listaDeConcursos.add(ApostaConcurso.toApostaConcurso(c));
		}
		
		tcCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
		tcImpar.setCellValueFactory(new PropertyValueFactory("Impar"));
		tcSoma.setCellValueFactory(new PropertyValueFactory("soma"));
		tcAction.setCellValueFactory(new PropertyValueFactory("button"));
		tvApostas.setItems(LS.listaDeApostas);
		
		//FAZ A VERIFICAÇÃO DE DEZENAS SORTEADAS ATRAVEZ DAS TECLAS DE UP E DOWN
		tvApostas.setOnKeyPressed((keyPressed)->{
			if(keyPressed.getCode().equals(KeyCode.UP)) {
				tvApostasONMouseClicked(/*MouseEvent event*/);
			}
			if(keyPressed.getCode().equals(KeyCode.DOWN)) {
				tvApostasONMouseClicked(/*MouseEvent event*/);
			}
		});
		
		Contagem cont = new Contagem();
		ObservableList<Integer> contagem = cont.top5ranqueMediaSomaConcursos(LS.Concursos13D);
		System.out.println(contagem);
		
		//CONTAGEM DE SORTEADOS POR LINHA
		System.out.println(cont.quantidadeDezenasSorteadasPorLinhaDe0a5(LS.Concursos13D));
		
		List<Integer> qtdLinhas = cont.quantidadeDezenasSorteadasPorLinhaDe0a5(LS.ConcursosGeral);
		System.out.println(qtdLinhas);
	}

}
