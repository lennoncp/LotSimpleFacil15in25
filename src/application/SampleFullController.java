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

import application.model.Operacao;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

public class SampleFullController implements Initializable {
	
	private SimpleBooleanProperty encerrarProcesso = new SimpleBooleanProperty(false);
	private Thread tarefa = null;
	
	Runtime runtime = Runtime.getRuntime();
	private Random rad = new Random(LocalTime.now().toNanoOfDay() + (LocalTime.now().toSecondOfDay() ^2) + runtime.freeMemory());
	
	//TODO Random para a primeira linha
	private Random rad2 = new Random(LocalTime.now().toNanoOfDay() + (LocalTime.now().toSecondOfDay() ^2) + runtime.freeMemory()+(rad.nextInt() ^rad.nextInt()));
	private Random rad3 = new Random(rad2.nextInt(999999999));
	private Random rad4 = new Random(rad.nextInt(999999999));
	private Random rad5 = new Random(rad3.nextInt(999999999) + rad.nextInt(999999999));
	private List<Random> randons = Arrays.asList(rad, rad2, rad3, rad4, rad5);
	private Random radIn5 = new Random(rad.nextLong() + rad2.nextLong() + rad3.nextLong() + rad4.nextLong() + rad5.nextLong());
	
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
    private TextField txfDerivadasQTD;
    
    @FXML
    private TextField txfDerivadasDerivacao;

    @FXML
    private Button btnDerivadasSortear;

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
    private CheckBox cbGeral;
    
    @FXML
    private TextField txfQTDDezenasPorAposta;
    
    @FXML
    private TextField txfPeso1;

    @FXML
    private TextField txfPeso2;

    @FXML
    private TextField txfPeso3;
    
    @FXML
    private TextField txfMediaSomaMinima;
    
    @FXML
    private TextField txfMediaCompAposta;

    @FXML
    private TextField txfMediaSomaMaxima;
    
    @FXML
    private TextField txfSequenciaMaxima;
    
    @FXML
    private ComboBox<Concurso> cbSelecionarConcurso;
    
    @FXML
    private Button btnCompConcurso;
    
    @FXML
    private ListView<String> lvComparacaoConcurso;
    
    @FXML
    private ComboBox<Operacao> cbSelecionarDezenas11a15;
    
    @FXML
    private Label lblContagemDeDezenas;
    
    @FXML
    private ListView<String> lvConsole;
    
    @FXML
    void limparTodasAsApostas(ActionEvent event) {
    	LS.apostas.clear();
    	LS.listaDeApostas.clear();
    	tvApostas.refresh();
    }
    
    //VERIFICA SE O CHEQUEBOX GERAL ESTA SELECIONADO
    @FXML
    void chequeGeral(ActionEvent event) {
    	if(cbGeral.isSelected()) {
    		cd = new ConcursoDAO();
        	txfRangeConcursos.setText(cd.maxConcurso()+"");
    	}else {
        	txfRangeConcursos.setText(0+"");
    	}
    }

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
    	
    	Contagem cont = new Contagem();
    	
    }

    @FXML //REALIZA O SORTEIO DA APOSTA
    void sortear(ActionEvent event) {

 	int qtdApostas = Integer.valueOf(txfQtdApostas.getText());

	Thread tarefa = new Thread(new Runnable() {
		
		@Override
		public void run() {
					auxSorteador(qtdApostas);									
		}
	});
	tarefa.start();
 	   	
    }
    
    private void auxSorteador() {
    	
    	//int qtdApostas = Integer.valueOf(txfQtdApostas.getText());
    	int qtdApostas = 1;
    	
     	//RE-CALCULANDO VALORES DO RANGE
     	cd = new ConcursoDAO();
    	LS.ConcursosRange3M = cd.listaDeConcursos(Integer.valueOf(txfRangeConcursos.getText()));
    	Contagem contAux = new Contagem();
    	LS.contagemConcursosRange3M = contAux.contagemConcursos(LS.ConcursosRange3M);
    	LS.mediaCorteLista3Meses = listaTiraMediaDeCorte(LS.contagemConcursosRange3M, media(LS.contagemConcursosRange3M), 1, 1);
    	
        	while(qtdApostas > 0) {
        		
        		setQTDDezenasPorLinha();
        		
    	    	//inicializarSorteador();
    	    	
    	    	dezenas = new Integer[Integer.valueOf(txfQTDDezenasPorAposta.getText())];
    	    	
    	    	/*for(int i = 0; i < 15; i++) {
    	    		dezenas[i] = getSorteador();
    	    	}*/
    	    	int c1 = Integer.valueOf(txfC1.getText());
    	    	int c2 = Integer.valueOf(txfC2.getText());
    	    	int c3 = Integer.valueOf(txfC3.getText());
    	    	int c4 = Integer.valueOf(txfC4.getText());
    	    	int c5 = Integer.valueOf(txfC5.getText());
    	    	
    	    	System.out.println("C1: "+ c1 + " C2: "+ c2 + " C3: "+ c3 + " C4: "+ c4 + " C5: "+ c5);
    	    	
    	    	List<Integer> qtdDezenasPorLinha = Arrays.asList(c1,c2,c3,c4,c5);
    	    	dezenas = getSorteador(qtdDezenasPorLinha);
    	    	
    	    	System.out.print("DEZENAS: getSorteador: ");
    	    	for(int i : dezenas) {
    	    		System.out.print(" " + i);
    	    	}
    	    	System.out.println("");
    	    	
    	    	Integer soma = 0;
    	    	Integer impPar = 0;
    	    	for(int i: dezenas) {
    	    		if(i % 2 != 0) impPar++;
    	    		soma += i;
    	    	}
    	   
    	    	Button btn = new Button("X");
    	    	Integer codigo = LS.codigoAtualApostas;
    	    	
    	    	Aposta aposta = new Aposta(codigo, impPar, soma, dezenas, btn);
    	    	aposta.getAction().setOnAction((btnExcluir)->{
    	    		defautButons();
    	    		int id = aposta.getCodigo();
    	    		System.out.println("Excluir Aposta: "+ id);
    	    		int index = 0;
    	    		int indexAC = -1;
    	    		for(ApostaConcurso ac : LS.listaDeApostas) {
    	    			Aposta a = ac.getAposta();
    	    			if(a.getCodigo() == id) {
    	    				indexAC = index;
    	    			}
    	    			index++;
    	    		}
    	    		LS.apostas.remove(indexAC);
    	    		LS.listaDeApostas.remove(indexAC);
    	    		refatoraCodigoApostas();//TODO refatoraCodigoApostas
    				tvApostas.refresh();
    				//LS.codigoAtualApostas--;
    	    	});
    	    	
    	    	Contagem c = new Contagem();
    	    	int mediaImpar = c.contagemDeImparesGeral(LS.ConcursosGeral);
    	    	System.out.println("Meia Impares: " + mediaImpar);
    	    	
    	    	//DIFERENÇA DE 15 A 18 DEZENAS
    	    	int imparDiferencial = mediaImpar;
    	    	int qtdDezenasPorAposta = Integer.valueOf(txfQTDDezenasPorAposta.getText());
    	    	if(qtdDezenasPorAposta > 15) {
    	    		imparDiferencial = mediaImpar + (qtdDezenasPorAposta - 15);
    	    		System.out.println("imparDiferencial: " + imparDiferencial);
    	    	}
    	    	
    	    	if(impPar >=  imparDiferencial-1 && impPar <=  imparDiferencial+1) {    	    		
    		    	
    	    		Comparador comp = new Comparador();
    	    		
    	    		boolean comparadorApostas = comp.comparaApostas(aposta, LS.apostas);
    	    		boolean comparadorConcursos = comp.comparaApostaComConcursos(aposta, LS.ConcursosGeral);
    	    		
    	    		System.out.println("RETORNO COMPARADOR: APOSTAS: "+comparadorApostas+" CONCURSOS: "+comparadorConcursos);
    	    		
    		    	if(!comparadorApostas && !comparadorConcursos) {
    			    	
    			    	Contagem cont = new Contagem();
    		    		List<Integer> minimoEMaximo =  cont.minimoEmaximoDeQTDDeSomasDeConcurso(cont.contagemDeFrequenciaDeSomas(cont.listSomaConcursos(LS.ConcursosGeral)));
    		    		
    		    		int somaAposta = cont.somaDezenasAposta(aposta);
    		    		
    		    		System.out.println("minimoEMaximo.get(0): "+minimoEMaximo.get(0)+"<= somaAposta: "+somaAposta+" && somaAposta: "+somaAposta+" <= minimoEMaximo.get(1): "+minimoEMaximo.get(1));
    		    		if((minimoEMaximo.get(0) <= somaAposta) && (somaAposta <=  minimoEMaximo.get(1)) ) {   		   
    		    			
    		    			for(Aposta a: LS.auxConcursoPAposta3D) {
    		    				LS.listApostasComparacao.add(a);
    		    			}
    		    			
    		    			for(Aposta a: LS.apostas) {
    		    				LS.listApostasComparacao.add(a);
    		    			}
	
    		    			Comparador comp2 = new Comparador();
    		    			int mediaDeComparacao = Integer.valueOf(txfMediaCompAposta.getText());
    		    			
    		    			//if(!LS.apostas.isEmpty()) {
    		    			if(!LS.listApostasComparacao.isEmpty()) {
    		    				int retornoMediaComparacao = (int) comp2.mediaApostaComparacaoListApostas(aposta, LS.listApostasComparacao);
    			    			if(retornoMediaComparacao >= mediaDeComparacao) {
    			    				System.out.println("MEDIA DE COMPARACAO: " + mediaDeComparacao);
    			    				
    			    				
    			    				int seq = Sequencia.contDezenasEmSequencia(aposta.toConcurso());
    			    				//TODO tornar controle de sequencia editavel
    			    				if(seq <= 7) {
    			    					
    			    					LS.apostas.add(aposta);
    							    	//apostaConcursos.add(ApostaConcurso.toApostaConcurso(aposta));
    							    	
    									LS.listaDeApostas.add(ApostaConcurso.toApostaConcurso(aposta));
    									tvApostas.refresh();
    									
    									for(Aposta a : LS.apostas) {
    										System.out.println(a);
    									}
    									LS.codigoAtualApostas++;
    							    	qtdApostas--;
    			    					
    			    				}else {
    			    					System.out.println("QTD Sequencia indesejavel: " + seq);
    			    				}
    			    				
    			    			}else {
    			    				System.out.println("Media de Comparacao com as Apostas inadequado: " + retornoMediaComparacao);
    			    			}
    			    			
    		    			}else {
    		    				
    		    				int seq = Sequencia.contDezenasEmSequencia(aposta.toConcurso());
    		    				//TODO tornar controle de sequencia editavel
    		    				if(seq <= 7) {
    		    					
    		    					LS.apostas.add(aposta);
    						    	//apostaConcursos.add(ApostaConcurso.toApostaConcurso(aposta));
    						    	
    								LS.listaDeApostas.add(ApostaConcurso.toApostaConcurso(aposta));
    								tvApostas.refresh();
    								
    								for(Aposta a : LS.apostas) {
    									System.out.println(a);
    								}
    								LS.codigoAtualApostas++;
    						    	qtdApostas--;
    		    					
    		    				}else {
    		    					System.out.println("QTD Sequencia indesejavel: " + seq);
    		    				}

    		    			}
    		    			
    		    		}else {
    		    			System.out.println("Soma Aposta inadeguado...");
    		    		}
    			    	
    			    	
    		    	}else {
    		    		System.out.println("Apostas iguais... Aposta: " + aposta.getDezenas());
    		    	}
    	    		
    	    	}else {
    	    		System.out.println("Media impar fora!");
    	    		//LS.codigoAtualApostas++;
    	    	}
    	    	
    	    	
        	}
        	
        	ObservableList<Concurso> auxConcursos = FXCollections.observableArrayList();
        	ObservableList<Integer> contagemDeDezenasApostas = FXCollections.observableArrayList();
        	auxConcursos = Concurso.toConcursos(LS.apostas);
        	Contagem auxCont = new Contagem();
        	contagemDeDezenasApostas = auxCont.contagemConcursos(auxConcursos);
        	for(int i = 0; i < contagemDeDezenasApostas.size(); i++) {
        		System.out.println(" Dezena " + (i+1) + ": " +contagemDeDezenasApostas.get(i));
        	}
    	
    }
    
    private void auxSorteador(int qtdApostas) {
    	
    	for(int j = 0; j < qtdApostas; j++) {
    	
     	//RE-CALCULANDO VALORES DO RANGE
     	cd = new ConcursoDAO();
    	LS.ConcursosRange3M = cd.listaDeConcursos(Integer.valueOf(txfRangeConcursos.getText()));
    	Contagem contAux = new Contagem();
    	LS.contagemConcursosRange3M = contAux.contagemConcursos(LS.ConcursosRange3M);
    	LS.mediaCorteLista3Meses = listaTiraMediaDeCorte(LS.contagemConcursosRange3M, media(LS.contagemConcursosRange3M), 1, 1);
    	
        	while(qtdApostas > 0) {
        		
        		setQTDDezenasPorLinha();
    	    	
    	    	dezenas = new Integer[Integer.valueOf(txfQTDDezenasPorAposta.getText())];

    	    	int c1 = Integer.valueOf(txfC1.getText());
    	    	int c2 = Integer.valueOf(txfC2.getText());
    	    	int c3 = Integer.valueOf(txfC3.getText());
    	    	int c4 = Integer.valueOf(txfC4.getText());
    	    	int c5 = Integer.valueOf(txfC5.getText());
    	    	
    	    	System.out.println("C1: "+ c1 + " C2: "+ c2 + " C3: "+ c3 + " C4: "+ c4 + " C5: "+ c5);
    	    	
    	    	List<Integer> qtdDezenasPorLinha = Arrays.asList(c1,c2,c3,c4,c5);
    	    	dezenas = getSorteador(qtdDezenasPorLinha);
    	    	
    	    	System.out.print("DEZENAS: getSorteador: ");
    	    	for(int i : dezenas) {
    	    		System.out.print(" " + i);
    	    	}
    	    	System.out.println("");
    	    	
    	    	Integer soma = 0;
    	    	Integer impPar = 0;
    	    	for(int i: dezenas) {
    	    		if(i % 2 != 0) impPar++;
    	    		soma += i;
    	    	}
    	   
    	    	Button btn = new Button("X");
    	    	Integer codigo = LS.codigoAtualApostas;
    	    	
    	    	Aposta aposta = new Aposta(codigo, impPar, soma, dezenas, btn);
    	    	aposta.getAction().setOnAction((btnExcluir)->{
    	    		defautButons();
    	    		int id = aposta.getCodigo();
    	    		System.out.println("Excluir Aposta: "+ id);
    	    		int index = 0;
    	    		int indexAC = -1;
    	    		for(ApostaConcurso ac : LS.listaDeApostas) {
    	    			Aposta a = ac.getAposta();
    	    			if(a.getCodigo() == id) {
    	    				indexAC = index;
    	    			}
    	    			index++;
    	    		}
    	    		LS.apostas.remove(indexAC);
    	    		LS.listaDeApostas.remove(indexAC);
    	    		refatoraCodigoApostas();//TODO refatoraCodigoApostas
    				tvApostas.refresh();
    				//LS.codigoAtualApostas--;
    	    	});
    	    	
    	    	Contagem c = new Contagem();
    	    	System.out.println("Lita Geral Size: " + LS.ConcursosGeral.size() );
    	    	int mediaImpar = c.contagemDeImparesGeral(LS.ConcursosGeral);
    	    	System.out.println("Meia Impares: " + mediaImpar);
    	    	
    	    	//DIFERENÇA DE 15 A 18 DEZENAS
    	    	int imparDiferencial = mediaImpar;
    	    	int qtdDezenasPorAposta = Integer.valueOf(txfQTDDezenasPorAposta.getText());
    	    	if(qtdDezenasPorAposta > 15) {
    	    		imparDiferencial = mediaImpar + (qtdDezenasPorAposta - 15);
    	    		System.out.println("imparDiferencial: " + imparDiferencial);
    	    	}
    	    	
    	    	if(impPar >=  imparDiferencial-1 && impPar <=  imparDiferencial+1) {    	    		
    		    	
    	    		Comparador comp = new Comparador();
    	    		
    	    		boolean comparadorApostas = comp.comparaApostas(aposta, LS.apostas);
    	    		boolean comparadorConcursos = comp.comparaApostaComConcursos(aposta, LS.ConcursosGeral);
    	    		
    	    		System.out.println("RETORNO COMPARADOR: APOSTAS: "+comparadorApostas+" CONCURSOS: "+comparadorConcursos);
    	    		
    		    	if(!comparadorApostas && !comparadorConcursos) {
    			    	
    			    	Contagem cont = new Contagem();
    		    		List<Integer> minimoEMaximo =  cont.minimoEmaximoDeQTDDeSomasDeConcurso(cont.contagemDeFrequenciaDeSomas(cont.listSomaConcursos(LS.ConcursosGeral)));
    		    		
    		    		int somaAposta = cont.somaDezenasAposta(aposta);
    		    		
    		    		System.out.println("minimoEMaximo.get(0): "+minimoEMaximo.get(0)+"<= somaAposta: "+somaAposta+" && somaAposta: "+somaAposta+" <= minimoEMaximo.get(1): "+minimoEMaximo.get(1));
    		    		if((minimoEMaximo.get(0) <= somaAposta) && (somaAposta <=  minimoEMaximo.get(1)) ) {   		   
    		    			
    		    			for(Aposta a: LS.auxConcursoPAposta3D) {
    		    				LS.listApostasComparacao.add(a);
    		    			}
    		    			
    		    			for(Aposta a: LS.apostas) {
    		    				LS.listApostasComparacao.add(a);
    		    			}
	
    		    			Comparador comp2 = new Comparador();
    		    			int mediaDeComparacao = Integer.valueOf(txfMediaCompAposta.getText());
    		    			
    		    			//if(!LS.apostas.isEmpty()) {
    		    			if(!LS.listApostasComparacao.isEmpty()) {
    		    				int retornoMediaComparacao = (int) comp2.mediaApostaComparacaoListApostas(aposta, LS.listApostasComparacao);
    			    			if(retornoMediaComparacao >= mediaDeComparacao) {
    			    				System.out.println("MEDIA DE COMPARACAO: " + mediaDeComparacao);
    			    				
    			    				
    			    				int seq = Sequencia.contDezenasEmSequencia(aposta.toConcurso());
    			    				//TODO tornar controle de sequencia editavel
    			    				if(seq <= 7) {
    			    					
    			    					LS.apostas.add(aposta);
    							    	//apostaConcursos.add(ApostaConcurso.toApostaConcurso(aposta));
    			    					lvConsole.getItems().add(aposta.toString());
    							    	
    									LS.listaDeApostas.add(ApostaConcurso.toApostaConcurso(aposta));
    									tvApostas.refresh();
    									
    									for(Aposta a : LS.apostas) {
    										System.out.println(a);
    									}
    									LS.codigoAtualApostas++;
    							    	qtdApostas--;
    			    					
    			    				}else {
    			    					System.out.println("QTD Sequencia indesejavel: " + seq);
    			    				}
    			    				
    			    			}else {
    			    				System.out.println("Media de Comparacao com as Apostas inadequado: " + retornoMediaComparacao);
    			    			}
    			    			
    		    			}else {
    		    				
    		    				int seq = Sequencia.contDezenasEmSequencia(aposta.toConcurso());
    		    				//TODO tornar controle de sequencia editavel
    		    				if(seq <= 7) {
    		    					
    		    					LS.apostas.add(aposta);
    						    	//apostaConcursos.add(ApostaConcurso.toApostaConcurso(aposta));
    						    	
    								LS.listaDeApostas.add(ApostaConcurso.toApostaConcurso(aposta));
    								tvApostas.refresh();
    								
    								for(Aposta a : LS.apostas) {
    									System.out.println(a);
    								}
    								LS.codigoAtualApostas++;
    						    	qtdApostas--;
    		    					
    		    				}else {
    		    					System.out.println("QTD Sequencia indesejavel: " + seq);
    		    				}

    		    			}
    		    			
    		    		}else {
    		    			System.out.println("Soma Aposta inadeguado...");
    		    		}
    			    	
    			    	
    		    	}else {
    		    		System.out.println("Apostas iguais... Aposta: " + aposta.getDezenas());
    		    	}
    	    		
    	    	}else {
    	    		System.out.println("Media impar fora!");
    	    		//LS.codigoAtualApostas++;
    	    	}
    	    	
    	    	
        	}
        	
        	ObservableList<Concurso> auxConcursos = FXCollections.observableArrayList();
        	ObservableList<Integer> contagemDeDezenasApostas = FXCollections.observableArrayList();
        	auxConcursos = Concurso.toConcursos(LS.apostas);
        	Contagem auxCont = new Contagem();
        	contagemDeDezenasApostas = auxCont.contagemConcursos(auxConcursos);
        	for(int i = 0; i < contagemDeDezenasApostas.size(); i++) {
        		System.out.println(" Dezena " + (i+1) + ": " +contagemDeDezenasApostas.get(i));
        	}
        }
    }
    
    private int auxSorteadorComRetorno(int qtdApostas) {
    	
    	int indexRetorno = 0;
    	
    	for(int j = 0; j < qtdApostas; j++) {
    	
     	//RE-CALCULANDO VALORES DO RANGE
     	cd = new ConcursoDAO();
    	LS.ConcursosRange3M = cd.listaDeConcursos(Integer.valueOf(txfRangeConcursos.getText()));
    	Contagem contAux = new Contagem();
    	LS.contagemConcursosRange3M = contAux.contagemConcursos(LS.ConcursosRange3M);
    	LS.mediaCorteLista3Meses = listaTiraMediaDeCorte(LS.contagemConcursosRange3M, media(LS.contagemConcursosRange3M), 1, 1);
    	
        	while(qtdApostas > 0) {
        		
        		setQTDDezenasPorLinha();
    	    	
    	    	dezenas = new Integer[Integer.valueOf(txfQTDDezenasPorAposta.getText())];

    	    	int c1 = Integer.valueOf(txfC1.getText());
    	    	int c2 = Integer.valueOf(txfC2.getText());
    	    	int c3 = Integer.valueOf(txfC3.getText());
    	    	int c4 = Integer.valueOf(txfC4.getText());
    	    	int c5 = Integer.valueOf(txfC5.getText());
    	    	
    	    	System.out.println("C1: "+ c1 + " C2: "+ c2 + " C3: "+ c3 + " C4: "+ c4 + " C5: "+ c5);
    	    	
    	    	List<Integer> qtdDezenasPorLinha = Arrays.asList(c1,c2,c3,c4,c5);
    	    	dezenas = getSorteador(qtdDezenasPorLinha);
    	    	
    	    	System.out.print("DEZENAS: getSorteador: ");
    	    	for(int i : dezenas) {
    	    		System.out.print(" " + i);
    	    	}
    	    	System.out.println("");
    	    	
    	    	Integer soma = 0;
    	    	Integer impPar = 0;
    	    	for(int i: dezenas) {
    	    		if(i % 2 != 0) impPar++;
    	    		soma += i;
    	    	}
    	   
    	    	Button btn = new Button("X");
    	    	Integer codigo = LS.codigoAtualApostas;
    	    	
    	    	Aposta aposta = new Aposta(codigo, impPar, soma, dezenas, btn);
    	    	aposta.getAction().setOnAction((btnExcluir)->{
    	    		defautButons();
    	    		int id = aposta.getCodigo();
    	    		System.out.println("Excluir Aposta: "+ id);
    	    		int index = 0;
    	    		int indexAC = -1;
    	    		for(ApostaConcurso ac : LS.listaDeApostas) {
    	    			Aposta a = ac.getAposta();
    	    			if(a.getCodigo() == id) {
    	    				indexAC = index;
    	    			}
    	    			index++;
    	    		}
    	    		LS.apostas.remove(indexAC);
    	    		LS.listaDeApostas.remove(indexAC);
    	    		refatoraCodigoApostas();//TODO refatoraCodigoApostas
    				tvApostas.refresh();
    				//LS.codigoAtualApostas--;
    	    	});
    	    	
    	    	Contagem c = new Contagem();
    	    	int mediaImpar = c.contagemDeImparesGeral(LS.ConcursosGeral);
    	    	System.out.println("Meia Impares: " + mediaImpar);
    	    	
    	    	//DIFERENÇA DE 15 A 18 DEZENAS
    	    	int imparDiferencial = mediaImpar;
    	    	int qtdDezenasPorAposta = Integer.valueOf(txfQTDDezenasPorAposta.getText());
    	    	if(qtdDezenasPorAposta > 15) {
    	    		imparDiferencial = mediaImpar + (qtdDezenasPorAposta - 15);
    	    		System.out.println("imparDiferencial: " + imparDiferencial);
    	    	}
    	    	
    	    	if(impPar >=  imparDiferencial-1 && impPar <=  imparDiferencial+1) {    	    		
    		    	
    	    		Comparador comp = new Comparador();
    	    		
    	    		boolean comparadorApostas = comp.comparaApostas(aposta, LS.apostas);
    	    		boolean comparadorConcursos = comp.comparaApostaComConcursos(aposta, LS.ConcursosGeral);
    	    		
    	    		System.out.println("RETORNO COMPARADOR: APOSTAS: "+comparadorApostas+" CONCURSOS: "+comparadorConcursos);
    	    		
    		    	if(!comparadorApostas && !comparadorConcursos) {
    			    	
    			    	Contagem cont = new Contagem();
    		    		List<Integer> minimoEMaximo =  cont.minimoEmaximoDeQTDDeSomasDeConcurso(cont.contagemDeFrequenciaDeSomas(cont.listSomaConcursos(LS.ConcursosGeral)));
    		    		
    		    		int somaAposta = cont.somaDezenasAposta(aposta);
    		    		
    		    		System.out.println("minimoEMaximo.get(0): "+minimoEMaximo.get(0)+"<= somaAposta: "+somaAposta+" && somaAposta: "+somaAposta+" <= minimoEMaximo.get(1): "+minimoEMaximo.get(1));
    		    		if((minimoEMaximo.get(0) <= somaAposta) && (somaAposta <=  minimoEMaximo.get(1)) ) {   		   
    		    			
    		    			for(Aposta a: LS.auxConcursoPAposta3D) {
    		    				LS.listApostasComparacao.add(a);
    		    			}
    		    			
    		    			for(Aposta a: LS.apostas) {
    		    				LS.listApostasComparacao.add(a);
    		    			}
	
    		    			Comparador comp2 = new Comparador();
    		    			int mediaDeComparacao = Integer.valueOf(txfMediaCompAposta.getText());
    		    			
    		    			//if(!LS.apostas.isEmpty()) {
    		    			if(!LS.listApostasComparacao.isEmpty()) {
    		    				int retornoMediaComparacao = (int) comp2.mediaApostaComparacaoListApostas(aposta, LS.listApostasComparacao);
    			    			if(retornoMediaComparacao >= mediaDeComparacao) {
    			    				System.out.println("MEDIA DE COMPARACAO: " + mediaDeComparacao);
    			    				
    			    				
    			    				int seq = Sequencia.contDezenasEmSequencia(aposta.toConcurso());
    			    				//TODO tornar controle de sequencia editavel
    			    				if(seq <= 7) {
    			    					
    			    					LS.apostas.add(aposta);
    			    					indexRetorno = LS.apostas.size();
    							    	//apostaConcursos.add(ApostaConcurso.toApostaConcurso(aposta));
    							    	
    									LS.listaDeApostas.add(ApostaConcurso.toApostaConcurso(aposta));
    									tvApostas.refresh();
    									
    									for(Aposta a : LS.apostas) {
    										System.out.println(a);
    									}
    									LS.codigoAtualApostas++;
    							    	qtdApostas--;
    			    					
    			    				}else {
    			    					System.out.println("QTD Sequencia indesejavel: " + seq);
    			    				}
    			    				
    			    			}else {
    			    				System.out.println("Media de Comparacao com as Apostas inadequado: " + retornoMediaComparacao);
    			    			}
    			    			
    		    			}else {
    		    				
    		    				int seq = Sequencia.contDezenasEmSequencia(aposta.toConcurso());
    		    				//TODO tornar controle de sequencia editavel
    		    				if(seq <= 7) {
    		    					
    		    					LS.apostas.add(aposta);
    						    	//apostaConcursos.add(ApostaConcurso.toApostaConcurso(aposta));
    						    	
    								LS.listaDeApostas.add(ApostaConcurso.toApostaConcurso(aposta));
    								tvApostas.refresh();
    								
    								for(Aposta a : LS.apostas) {
    									System.out.println(a);
    								}
    								LS.codigoAtualApostas++;
    						    	qtdApostas--;
    		    					
    		    				}else {
    		    					System.out.println("QTD Sequencia indesejavel: " + seq);
    		    				}

    		    			}
    		    			
    		    		}else {
    		    			System.out.println("Soma Aposta inadeguado...");
    		    		}
    			    	
    			    	
    		    	}else {
    		    		System.out.println("Apostas iguais... Aposta: " + aposta.getDezenas());
    		    	}
    	    		
    	    	}else {
    	    		System.out.println("Media impar fora!");
    	    		//LS.codigoAtualApostas++;
    	    	}
    	    	
    	    	
        	}
        	
        	ObservableList<Concurso> auxConcursos = FXCollections.observableArrayList();
        	ObservableList<Integer> contagemDeDezenasApostas = FXCollections.observableArrayList();
        	auxConcursos = Concurso.toConcursos(LS.apostas);
        	Contagem auxCont = new Contagem();
        	contagemDeDezenasApostas = auxCont.contagemConcursos(auxConcursos);
        	for(int i = 0; i < contagemDeDezenasApostas.size(); i++) {
        		System.out.println(" Dezena " + (i+1) + ": " +contagemDeDezenasApostas.get(i));
        	}
        }
    	return indexRetorno;
    }
    
    //REALIZA O SORTEIO DAS APOSTAS DERIVADAS OU DE SEQUENCIA DE DEZENAS FALTANTES
    @FXML
    void sortearDerivadas(ActionEvent event) {
    	
    	Aposta apostaSorteada = new Aposta();

    	if(LS.apostas.isEmpty()) {
    		txfQtdApostas.setText("1");
    		sortear(new ActionEvent());
    		apostaSorteada = LS.apostas.get(0);
    		System.out.println(apostaSorteada);
    	}else {
    		System.out.println("Lista de apostas não esta vazia");
    		apostaSorteada = LS.apostas.get(randons.get(radIn5.nextInt(5)).nextInt(LS.apostas.size()));
    		System.out.println(apostaSorteada);
    	}
    	
    	List<Integer> dezenasEspelho = apostaSorteada.DezNaoSorteadas();
    	System.out.println(dezenasEspelho);
    	
    	int qtdDerivadas = Integer.valueOf(txfDerivadasQTD.getText());
    	int derivacao = Integer.valueOf(txfDerivadasDerivacao.getText());
    	int contDerivacao = 0;
    	
    	Comparador comparadorDerivado = new Comparador();
    	ObservableList<Aposta> listaParaComparacao = FXCollections.observableArrayList();
    	
    	while(qtdDerivadas > 0) {
    		while(contDerivacao < derivacao) {
    			
    			Aposta aposta = new Aposta(apostaSorteada.getCodigo(), apostaSorteada.getImpPar(), apostaSorteada.getSoma(), apostaSorteada.getDezenas(), apostaSorteada.getAction());
    			
    			int indexDeAlteracao = randons.get(radIn5.nextInt(5)).nextInt(aposta.getDezenas().length);
    			int indexDoEspelho = randons.get(radIn5.nextInt(5)).nextInt(dezenasEspelho.size());
    			
    			System.out.println("IndexDeAlteracao: " + indexDeAlteracao + " indexDoEspelho: " + indexDoEspelho);
    			
    			aposta.setDezenaEmDezenas(indexDeAlteracao, dezenasEspelho.get(indexDoEspelho));
    			
    			if(comparadorDerivado.comparaApostaComApostasEConcuros(aposta, LS.apostas, LS.ConcursosGeral)) {
    				
    				listaParaComparacao.clear();
    				listaParaComparacao.add(aposta);
    				
    				int mediaComparacao = comparadorDerivado.contadorDeDezenasIguaisMAX(aposta.toConcurso(), LS.toObsConcursos(LS.apostas));
    				int valorDaDiferencaComDerivacao = (aposta.getDezenas().length - (contDerivacao+1));
    				
    				//COMPARACAO COM O FATOR DE DERIVAÇÃO
    				if( mediaComparacao == valorDaDiferencaComDerivacao) {
    					
    					int impar = Integer.valueOf(txfMediaImpar.getText());
    					int imparDaAposta = LS.verificaImpar(aposta.getDezenas());
    					//VERIFICANDO A QUANTIDADE DE IMPAR.
    					if((imparDaAposta >= impar-1) && (imparDaAposta <= impar+1)) {
    						
    						//VERIFICA A SOMA DAS DEZENAS
    						int menorSoma = Integer.valueOf(txfMediaSomaMinima.getText());
    						int maiorSoma = Integer.valueOf(txfMediaSomaMaxima.getText());
    						int soma = LS.somaDezenas(aposta.getDezenas());
    						
    						if((menorSoma <= soma) && (soma <= maiorSoma)) {
    							
    							//VERIFICA SEQUENCIA DAS DERIVADAS
    							int sequenciaMaxima = Integer.valueOf(txfSequenciaMaxima.getText());
    							int seq = Sequencia.contDezenasEmSequencia(aposta.toConcurso());
    							if(seq <= sequenciaMaxima) {
    								
    								
    								LS.codigoAtualApostas++;
    					    		
    					    		Aposta nova = new Aposta(LS.codigoAtualApostas, imparDaAposta, soma, aposta.getDezenas(), new Button("X"));
    					    		nova.getAction().setOnAction((btnExcluir)->{
    						    		defautButons();
    						    		int id = nova.getCodigo();
    						    		System.out.println("Excluir Aposta: "+ id);
    						    		//apostaConcursos.remove(apostaConcursos.get(apostaConcursos.size()-1));
    						    		//LS.apostas.remove(aposta);
    						    		//LS.codigoAtualApostas--;
    						    		int index = 0;
    						    		int indexAC = -1;
    						    		for(ApostaConcurso ac : LS.listaDeApostas) {
    						    			Aposta a = ac.getAposta();
    						    			if(a.getCodigo() == id) {
    						    				indexAC = index;
    						    			}
    						    			index++;
    						    		}
    						    		LS.apostas.remove(indexAC);
    						    		LS.listaDeApostas.remove(indexAC);
    						    		refatoraCodigoApostas();//TODO refatoraCodigoApostas
    									tvApostas.refresh();
    									//LS.codigoAtualApostas--;
    						    	});
    					    		
    					    		LS.apostas.add(nova);
    					    		LS.listaDeApostas.add(ApostaConcurso.toApostaConcurso(nova));
    					    		tvApostas.refresh();
    								
    					    		for(Aposta aposta2: LS.apostas) {
    					    			System.out.println(aposta2);
    					    		}
    					    		
    					    		contDerivacao++;
    					    		qtdDerivadas++;
    								
    							}else {
    								System.out.println("Sequencia inadequada seq: " + seq + " Sequencia Maxima: " + sequenciaMaxima);
    							}
    							
    							
    						}else {
    							System.out.println("Apostas Derivadas Soma de dezenas inadequada. SOMA: " + soma + " MenorSoma: "+ menorSoma + " MaiorSoma: " + maiorSoma);
    						}
    						
    						
    					}else {
    						System.out.println("Aposta derivada qtd de impares forado range: impar: "+ impar + " Impar da Aposta: " + imparDaAposta);
    					}
    					
    				}else {
    					System.out.println("Comparacao da aposta de referencia inadeguado: media Comparada: " + mediaComparacao + " Valor da Diferenca: " + valorDaDiferencaComDerivacao );
    				}
    				
    			}else {
    				System.out.println("Dericavas comparador erro apostas iguais.");
    			}
    		}
    		
    		contDerivacao = 0;
    		System.out.println("eita estou no loop ainda!");
    	}
    	
    }
    
    //REFATORA TODOS OS CODIGOS DA LISTA DE APOSTAS
    public void refatoraCodigoApostas() {
    	int codigo = LS.codigoUltimaApostaSalvaBD+1;
    	int cod = 0;
    	for(int i = 0; i < LS.apostas.size(); i++) {
    		cod = codigo++;
    		LS.apostas.get(i).setCodigo(cod);
    		LS.listaDeApostas.get(i).setCodigo(cod);
    		System.out.println("COD in: " + cod);
    	}
    	LS.codigoAtualApostas = cod+1;
    	System.out.println("COD: " + cod + " LS.codigoAtualApostas " + LS.codigoAtualApostas);
    	tvApostas.refresh();
    }
    
    //CRIADO PARA SOMAR UM OU DECREMENTAR UM NO SORTEIO DAS DEZENAS POR LINHA
    public int maisUmOuMenosUm(int valor) {
    	int retorno = 0;
    	if(rad.nextInt(2) == 1) {
    		retorno = valor + 1;
    	}else {
    		retorno = valor - 1;
    	}
    	return retorno;
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
    		tvApostas.setItems(LS.listaDeApostas);
    		tvApostas.refresh();
    		btnConcursoApostaChange.setText("C");
    	}else {
    		
    		cd = new ConcursoDAO();
    		LS.ConcursosGeral = cd.listaDeConcursos(cd.maxConcurso());
    		
    		//TODO LISTAGEM DE CONCURSOS GERAL
    		for(Concurso c: LS.ConcursosGeral) {
    			//System.out.println("Iniciando Concurso: " + c);
    			LS.listaDeConcursos.add(ApostaConcurso.toApostaConcurso(c));
    		}
    		
    		tvApostas.setItems(LS.listaDeConcursos);
    		tvApostas.refresh();
    		btnConcursoApostaChange.setText("A");
    	}
    	
    }
    
    @FXML
    void changeApostasSalvas(ActionEvent event) {
    	System.out.println("Realizando a leitura das apostas: "+ LS.listaDBApostas.size());
    	LS.listaDBApostas = ad.getListaDeApostasSalvas();
    	tvApostas.setItems(LS.listaDBApostas);
    	tvApostas.refresh();
    }
    
    @FXML
    void compararApostaComConcursos(ActionEvent event) {

    	lvComparacaoConcurso.getItems().clear();
    	lblContagemDeDezenas.setText("0");
    	
    	Comparador comparadorAC = new Comparador();
    	
    	if(!cbSelecionarConcurso.getSelectionModel().isEmpty()) {
    		Concurso concurso = cbSelecionarConcurso.getSelectionModel().getSelectedItem();
    		
    		System.out.println(concurso);
    		
    		if(LS.apostas.isEmpty()) {
    			sortear(new ActionEvent());
    		}
    		
    		//int dez11a15 = cbSelecionarDezenas11a15.getSelectionModel().getSelectedItem();
    		Operacao op = cbSelecionarDezenas11a15.getSelectionModel().getSelectedItem();
    		
    		System.out.println("DEZ11A15 : " + op);
    		
    		int cont = 0;
    		
    		if(op == Operacao.SEQUENCIA) {
    			
    			txfQtdApostas.setText("1");
    			
    			LS.apostas.clear();
				
    			tarefa = new Thread(new Runnable() {
    				
    				@Override
    				public void run() {

    					int contAux = 0;
    					
    					while(true) {
    						
    						auxSorteador(1);
        					
        					Aposta aposta = LS.apostas.get(LS.apostas.size()-1);
        					int dez = comparadorAC.contadorDeDezenasIguais(concurso, aposta.toConcurso());
        					lvComparacaoConcurso.getItems().add("Concurso: " + aposta.getCodigo() + " Dezenas: " + dez);
        					contAux++;
        					
        					if(Thread.currentThread().isInterrupted()) {
        						Thread.currentThread().interrupt();
        						break;
        					}
        					
        					lblContagemDeDezenas.setText(contAux+"");
    					}
    				}
    			});
    			tarefa.setName("THREAD-COMPARADOR");
    			tarefa.start();
			}
    		
    		if(op == Operacao.COMPCONCURSOS) {
    			
    			tarefa = new Thread(new Runnable() {
					
					@Override
					public void run() {
						int contAux = 0;
						int [] comparante = new int[15];
						for(int i = 0; i < LS.ConcursosGeral.size(); i++) {
							int dez = comparadorAC.contadorDeDezenasIguais(LS.ConcursosGeral.get(i+1), LS.ConcursosGeral.get(i));							
							comparante[dez]++;
							String contagem = ""; 
							for(int j = 0; j < comparante.length; j++) {
								contagem = contagem + " " + j + ": " + comparante[j];
							}
        					lvComparacaoConcurso.getItems().add("Concurso: " + LS.ConcursosGeral.get(i+1).getConcurso() + " Dezenas: " + dez + " " + contagem);
        					contAux++;
						}
						lblContagemDeDezenas.setText(contAux+"");
					}
				});
    			tarefa.start();
    		}
    		
    		for(Aposta apostaConcurso : LS.apostas) {
    			int dez = comparadorAC.contadorDeDezenasIguais(concurso, apostaConcurso.toConcurso());
    			
    			//dez11a15 = cbSelecionarDezenas11a15.getSelectionModel().getSelectedItem();
    			
    			if(op == Operacao.SORTEAVEIS) {
    				lvComparacaoConcurso.getItems().add("Concurso: " + apostaConcurso.getCodigo() + " Dezenas: " + dez);
					cont++;
    			}
    								
    			
    				switch (op) {
    				/*case 0:
    					lvComparacaoConcurso.getItems().add("Concurso: " + apostaConcurso.getCodigo() + " Dezenas: " + dez);
    					cont++;
    					break;*/
    				case SORTEAVEIS_11:
    					lvComparacaoConcurso.getItems().add("Concurso: " + apostaConcurso.getCodigo() + " Dezenas: " + dez);
    					cont++;
    					break;
    				case SORTEAVEIS_12:
    					lvComparacaoConcurso.getItems().add("Concurso: " + apostaConcurso.getCodigo() + " Dezenas: " + dez);
    					cont++;
    					break;
    				case SORTEAVEIS_13:
    					lvComparacaoConcurso.getItems().add("Concurso: " + apostaConcurso.getCodigo() + " Dezenas: " + dez);
    					cont++;
    					break;
    				case SORTEAVEIS_14:
    					lvComparacaoConcurso.getItems().add("Concurso: " + apostaConcurso.getCodigo() + " Dezenas: " + dez);
    					cont++;
    					break;
    				case SORTEAVEIS_15:
    					lvComparacaoConcurso.getItems().add("Concurso: " + apostaConcurso.getCodigo() + " Dezenas: " + dez);
    					cont++;
    					break;
    				default:
    					break;
    				}
    						
    		}
    		
    		lblContagemDeDezenas.setText(cont+"");
    	}
    	
    }
    
    @FXML
    void encerrarProcesso(ActionEvent event) {
    	tarefa.interrupt();

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
    
    //REMOVE O VALOR REPETIDO DAS LISTA DO SORTEADOR
    public void removeValorDaLista(List<Integer> lista, int valor){
    	
    	while(lista.contains(valor)) {
    		for(int i = 0; i < lista.size(); i++) {
        		if(lista.get(i) == valor) {
        			lista.remove(i);
        		}
        	}
    	}
    	
    	//TODO System.out.println("Valor Removido: " + valor + " Lista: " + lista);
    }
    
  //REMOVE O VALOR PARA LISTA DE LINHA
    public void removeValorDaListaDeLinhas(List<Integer> lista, int valor){
    	
    	while(lista.contains(valor)) {
    		for(int i = 0; i < lista.size(); i++) {
        		if(lista.get(i) == valor) {
        			
        			System.out.println("lista.get(i): " + lista.get(i) + " Valor: " + valor + " Lista: " + lista + " i: " + i);
        			
        			lista.remove(i);
        		}
        	}
    	}
    	
    }
    
    //SORTEIA AS DEZENAS POR LINHA  DE 1 A 5
    public Integer[] getSorteador(List<Integer> qtdDezenasPorLinha) {
    	
    	System.out.println(" qtdDezenasPorLinha: " + qtdDezenasPorLinha);
    	int dezenasPorAposta = Integer.valueOf(txfQTDDezenasPorAposta.getText());
    	//TODO Quantia de dezenas por sorteio e fixa aqui
    	Integer[] dezenas = new Integer[dezenasPorAposta];
    	
    	//TODO RELAÇÃO DE MEDIA DE CORTE
    	/*ObservableList<Integer> listaGeral = listaTiraMediaDeCorte(LS.contagemConcursosGeral, media(LS.contagemConcursosGeral), 5, 5);
    	ObservableList<Integer> lista3Meses = listaTiraMediaDeCorte(LS.contagemConcursosRange3M, media(LS.contagemConcursosRange3M), 1, 1);
    	ObservableList<Integer> lista13Dias = listaTiraMediaDeCorte(LS.contagemConcursos13D, media(LS.contagemConcursos13D), 1, 1);
    	
    	System.out.println(" ListaGeral: " + listaGeral );
    	System.out.println(" Lista3Meses: " + lista3Meses );
    	System.out.println(" Lista13Dias: " + lista13Dias);*/
    	
    	ObservableList<Integer> pesoPorDezenas = indexDeMulplicacaoDeDezenas(LS.mediaCorteListaGeral, LS.mediaCorteLista3Meses, LS.mediaCorteLista13Dias, 
    			                                                              Integer.valueOf(txfPeso1.getText()), Integer.valueOf(txfPeso2.getText()), Integer.valueOf(txfPeso3.getText()));
    	
    	System.out.println("Pesos por Dezenas: " + pesoPorDezenas);
    	
    	//List<Integer> linha1 = Arrays.asList(1,2,3,4,5);
    	List<Integer> linha1 = new ArrayList<Integer>();
    	/*linha1.add(1);
    	linha1.add(2);
    	linha1.add(3);
    	linha1.add(4);
    	linha1.add(5);*/
    	
    	for(int i = 0; i < 5; i++) {
    		int p = pesoPorDezenas.get(i);
    		for(int j = 0; j < p; j++  ) {
    			linha1.add(i+1);
    		}
    	}
    	
    	List<Integer> linha2 = new ArrayList<Integer>();
    	/*linha2.add(6);
    	linha2.add(7);
    	linha2.add(8);
    	linha2.add(9);
    	linha2.add(10);*/
    	
    	for(int i = 5; i < 10; i++) {
    		int p = pesoPorDezenas.get(i);
    		for(int j = 0; j < p; j++  ) {
    			linha2.add(i+1);
    		}
    	}
    	
    	List<Integer> linha3 = new ArrayList<Integer>();
    	/*linha3.add(11);
    	linha3.add(12);
    	linha3.add(13);
    	linha3.add(14);
    	linha3.add(15);*/
    	for(int i = 10; i < 15; i++) {
    		int p = pesoPorDezenas.get(i);
    		for(int j = 0; j < p; j++  ) {
    			linha3.add(i+1);
    		}
    	}
    	
    	List<Integer> linha4 = new ArrayList<Integer>();
    	/*linha4.add(16);
    	linha4.add(17);
    	linha4.add(18);
    	linha4.add(19);
    	linha4.add(20);*/
    	for(int i = 15; i < 20; i++) {
    		int p = pesoPorDezenas.get(i);
    		for(int j = 0; j < p; j++  ) {
    			linha4.add(i+1);
    		}
    	}
    	
    	List<Integer> linha5 = new ArrayList<Integer>();
    	/*linha5.add(21);
    	linha5.add(22);
    	linha5.add(23);
    	linha5.add(24);
    	linha5.add(25);*/
    	for(int i = 20; i < 25; i++) {
    		int p = pesoPorDezenas.get(i);
    		for(int j = 0; j < p; j++  ) {
    			linha5.add(i+1);
    		}
    	}
    	
    	System.out.println("LISTA 1: " + linha1);
    	System.out.println("LISTA 2: " + linha2);
    	System.out.println("LISTA 3: " + linha3);
    	System.out.println("LISTA 4: " + linha4);
    	System.out.println("LISTA 5: " + linha5);
    	
    	//int linha = 1;
    	List<Integer> linhaOrdem = new ArrayList<Integer>();
    	linhaOrdem.add(1);
    	linhaOrdem.add(2);
    	linhaOrdem.add(3);
    	linhaOrdem.add(4);
    	linhaOrdem.add(5);
    	int linha = linhaOrdem.get(radIn5.nextInt(linhaOrdem.size()));
    	
    	int indexDezenas = 0;
    	for(int d : qtdDezenasPorLinha) {
    		int index = 0;
    		for(int i = d; i > 0; i--) {
    			//if(indexDezenas > 14) {
    			if(indexDezenas > (dezenasPorAposta-1)) {
    				break;
    			}
    			
    			
    			switch (linha) {
    			case 1:
    				//index = rad3.nextInt(linha1.size()); //TODO INDEX COM PROBLEMAS
    				index = randons.get(radIn5.nextInt(5)).nextInt(linha1.size());
    				
    				//dezenas[indexDezenas++] = linha1.get(index);
    				int valor = linha1.get(index);
    				dezenas[indexDezenas] = valor;
    				//TODO System.out.println("Index: "+index+ " LInha1: "+linha1.toString());
    				removeValorDaLista(linha1, valor);
    				//linha1.remove(index);
    			break;
    			case 2:
    				//index = rad.nextInt(linha2.size());
    				index = randons.get(radIn5.nextInt(5)).nextInt(linha2.size());
    				valor = linha2.get(index);
    				dezenas[indexDezenas] = valor;
    				//dezenas[indexDezenas++] = linha2.get(index);
    				removeValorDaLista(linha2, valor);
    				//linha2.remove(index);
    			break;
    			case 3:
    				//index = rad.nextInt(linha3.size());
    				index = randons.get(radIn5.nextInt(5)).nextInt(linha3.size());
    				//dezenas[indexDezenas++] = linha3.get(index);
    				valor = linha3.get(index);
    				dezenas[indexDezenas] = valor;
    				removeValorDaLista(linha3, valor);
    				//linha3.remove(index);
    			break;
    			case 4:
    				//index = rad.nextInt(linha4.size());
    				index = randons.get(radIn5.nextInt(5)).nextInt(linha4.size());
    				//dezenas[indexDezenas++] = linha4.get(index);
    				//linha4.remove(index);
    				valor = linha4.get(index);
    				dezenas[indexDezenas] = valor;
    				removeValorDaLista(linha4, valor);
    			break;
    			case 5:
    				//index = rad.nextInt(linha5.size());
    				index = randons.get(radIn5.nextInt(5)).nextInt(linha5.size());
    				//dezenas[indexDezenas++] = linha5.get(index);
    				//linha5.remove(index);
    				valor = linha5.get(index);
    				
    				//TODO ERRO INDEX OF SIZE
    				System.out.println("DEZENAS LENGTH: "+ dezenas.length);
    				System.out.println("indexDezenas++: "+ indexDezenas);
    				System.out.println("valor: "+ valor);
    				dezenas[indexDezenas] = valor;
    				removeValorDaLista(linha5, valor);
    			break;
    			default:
    				break;
    			}
    			indexDezenas++;
    		}
    		
    		//linha++;
    		removeValorDaListaDeLinhas(linhaOrdem, linha);
    		int ordem = linhaOrdem.size();
    		System.out.println("order: " + ordem);
    		if(ordem == 0) break;
    		linha = linhaOrdem.get(radIn5.nextInt(ordem));
    	}
    	
    	return dezenas;
    }
    
    public List<Integer> sortearQuantidadeDezenasPorLinha() {
    	
    	int soma = 0;
    	List<Integer> qtdLinha = new ArrayList<Integer>();
    	int dezenasPorAposta = Integer.valueOf(txfQTDDezenasPorAposta.getText());
    	while(soma == dezenasPorAposta) {
    		for(int i = 0; i < 5;i++) {
    			qtdLinha.add(rad.nextInt(5));
    		}
    		
    		for(int i = 0 ; i < 5; i++) {
    			soma+= rad.nextInt(5);
    		}
    	}
    	
    	//TODO QUANTIDADE DE DEZENAS POR LINHA
    	System.out.println("QUANTIDADE DE DEZENAS POR LINHA: " + qtdLinha);
    	return qtdLinha;
    }
    
    //ESPECIFICA A QUANTIDADE DE DEZENAS SORTEADAS POR LINHA
    public void setQTDDezenasPorLinha() {
    	
    	Contagem cont = new Contagem();
    	List<ObservableList<Integer>> qtdLinhas = cont.quantidadeDezenasSorteadasPorLinhaDe0a5(cd.listaDeConcursos(Integer.valueOf(txfRangeConcursos.getText())));
    	System.out.println("QTDLINHAS: " + qtdLinhas);
    	List<Integer> dezenasPorLinha = cont.fatorMediaDezenasPorLinha(qtdLinhas);
    	System.out.println("DEZENASPORLINHA: " + dezenasPorLinha);
    	for(int i = 0 ; i < dezenasPorLinha.size(); i++) {
    		if(dezenasPorLinha.get(i) != 0) {
    			if(rad.nextInt(2) == 1) {
    				dezenasPorLinha.set(i, dezenasPorLinha.get(i) + 1);
    			}else {
    				dezenasPorLinha.set(i, dezenasPorLinha.get(i) - 1);
    			}
    		}
    	}
    	
    	int soma = somaInteiros(dezenasPorLinha);
    	
    	int dezenasPorAposta = Integer.valueOf(txfQTDDezenasPorAposta.getText());
    	
    	while (soma < dezenasPorAposta) {
    		int index = rad.nextInt(5);
    		if(dezenasPorLinha.get(index) < 5) {
    			dezenasPorLinha.set(index, dezenasPorLinha.get(index) + rad.nextInt(2));
        		soma = somaInteiros(dezenasPorLinha);
    		}
    		/*dezenasPorLinha.set(index, dezenasPorLinha.get(index) + rad.nextInt(2));
    		soma = somaInteiros(dezenasPorLinha);*/
		}
    	
    	while (soma > dezenasPorAposta) {
    		int index = rad.nextInt(5);
    		if(dezenasPorLinha.get(index) < 5) {
    			dezenasPorLinha.set(index, dezenasPorLinha.get(index) - rad.nextInt(2));
        		soma = somaInteiros(dezenasPorLinha);
    		}
    		/*dezenasPorLinha.set(index, dezenasPorLinha.get(index) + rad.nextInt(2));
    		soma = somaInteiros(dezenasPorLinha);*/
		}
    	   	
		txfC1.setText(dezenasPorLinha.get(0)+"");
		txfC2.setText(dezenasPorLinha.get(1)+"");
		txfC3.setText(dezenasPorLinha.get(2)+"");
		txfC4.setText(dezenasPorLinha.get(3)+"");
		txfC5.setText(dezenasPorLinha.get(4)+"");
    }
    
    //SOMA AS DEZENAS QUE CADA LINHA
    public int somaInteiros(List<Integer> inteiros) {
    	int soma = 0;
    	for(int i : inteiros) {
    		soma += i;
    	}
    	return soma;
    }
    
    //TIRA O VALOR MEDIA DE UMA LISTA DE INTEIROS
    /**
     * 
     * @param listaDeInteiros
     * @return
     */
    public int media(ObservableList<Integer> listaDeInteiros) {
    	int media = 0;
    		for(int i : listaDeInteiros) {
    			media += i;
    		}
    	return media/listaDeInteiros.size();
    }
    
    //FAZ O CORTE DOS INDEX FORA DA MEDIA
    /**
     * 
     * @param lista
     * @param media
     * @param positivo
     * @param negativo
     * @return
     */
    public ObservableList<Integer> listaTiraMediaDeCorte(ObservableList<Integer> lista, int media, int positivo, int negativo){
    	ObservableList<Integer> listaTiraMediaDeCorte = FXCollections.observableArrayList();
    	for(int i = 0; i < lista.size(); i++) {
    		if(lista.get(i) >= (media - negativo) && lista.get(i) <= (media + positivo)) {
    			listaTiraMediaDeCorte.add(i+1);
    		}
    	}
    	return listaTiraMediaDeCorte;
    }
    
    //FAZ A LISTAGEM DOS INDEX COM OS RESPACTIVOS VALORES DE MULTIPLICAÇÃO
    /**
     * <h1>LISTA DE DEZENAS E SUA MULTIPLICACAO</h1>
     * @param listaGeral
     * @param lista3Meses
     * @param lista13Dias
     * @param peso1
     * @param peso2
     * @param peso3
     * @return
     */
    public ObservableList<Integer> indexDeMulplicacaoDeDezenas(ObservableList<Integer> listaGeral, ObservableList<Integer> lista3Meses, ObservableList<Integer> lista13Dias, int peso1, int peso2, int peso3){
    	ObservableList<Integer> listaIndexEvalorAmultiplicar = FXCollections.observableArrayList();
    	listaIndexEvalorAmultiplicar.addAll(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
    	for(int g : listaGeral) {
    		g = g - 1;
    		listaIndexEvalorAmultiplicar.set(g, listaIndexEvalorAmultiplicar.get(g) + peso1);
    	}
    	
    	for(int m3 : lista3Meses) {
    		m3 = m3 - 1;
    		listaIndexEvalorAmultiplicar.set(m3, listaIndexEvalorAmultiplicar.get(m3) + peso2);
    	}
    	
    	for(int d13 : lista13Dias) {
    		d13 = d13 - 1;
    		listaIndexEvalorAmultiplicar.set(d13, listaIndexEvalorAmultiplicar.get(d13) + peso3);
    	}
    	return listaIndexEvalorAmultiplicar;
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		LS.apostas = apostas;
		
		Contagem cont = new Contagem();
		
		ad = new ApostaDAO();
    	LS.codigoAtualApostas = ad.getCodigoAposta()+1;
    	ad = new ApostaDAO();
    	LS.listaDBApostas= ad.getListaDeApostasSalvas();
    	
    	//TODO quantidade de apostas salvas
    	System.out.println("ULTIMA APOSTA SALVA: " + LS.listaDBApostas.get(LS.listaDBApostas.size() - 1));
    	LS.codigoUltimaApostaSalvaBD = LS.listaDBApostas.get(LS.listaDBApostas.size() - 1).getCodigo();
		
		cd = new ConcursoDAO();
		LS.ConcursosGeral = cd.listaDeConcursos(cd.maxConcurso());
		cd = new ConcursoDAO();
		LS.ConcursosRange3M = cd.listaDeConcursos(Integer.valueOf(txfRangeConcursos.getText()));
		cd = new ConcursoDAO();
		LS.Concursos13D = cd.listaDeConcursos(13);
		
		cd = new ConcursoDAO();
		LS.Concursos3D = cd.listaDeConcursos(2);
		System.out.println("LS.Concursos3D SIZE: " + LS.Concursos3D.size());
		
		//CONVERTENDO OS 13 UTIMOS CONCURSOS PARA APOSTA
		for(Concurso c: LS.Concursos3D) {
			LS.auxConcursoPAposta3D.add(c.toAposta());
		}
		
		//TODO ULTIMO CONCURSO REALIZADO SALVO NO BANCO
		System.out.println("ULTIMO CONCURSO SALVO: " + LS.ConcursosGeral.get(LS.ConcursosGeral.size()-1));
		
		LS.contagemConcursosGeral = cont.contagemConcursos(LS.ConcursosGeral);
		LS.contagemConcursosRange3M = cont.contagemConcursos(LS.ConcursosRange3M);
		LS.contagemConcursos13D = cont.contagemConcursos(LS.Concursos13D);
		
		//TODO LISTAGEM DE CONCURSOS GERAL
		for(Concurso c: LS.ConcursosGeral) {
			//System.out.println("Iniciando Concurso: " + c);
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
		
		LS.mediaCorteListaGeral = listaTiraMediaDeCorte(LS.contagemConcursosGeral, media(LS.contagemConcursosGeral), 5, 5);
    	LS.mediaCorteLista3Meses = listaTiraMediaDeCorte(LS.contagemConcursosRange3M, media(LS.contagemConcursosRange3M), 1, 1);
    	LS.mediaCorteLista13Dias = listaTiraMediaDeCorte(LS.contagemConcursos13D, media(LS.contagemConcursos13D), 1, 1);
    	
    	System.out.println(" ListaGeral: " + LS.mediaCorteListaGeral );
    	System.out.println(" Lista3Meses: " + LS.mediaCorteLista3Meses );
    	System.out.println(" Lista13Dias: " + LS.mediaCorteLista13Dias);
		
		//Contagem cont = new Contagem();
		ObservableList<Integer> contagem = cont.top5ranqueMediaSomaConcursos(LS.Concursos13D);
		System.out.println("top5ranqueMediaSomaConcursos: " + contagem);
		
		//CONTAGEM DE SORTEADOS POR LINHA
		System.out.println("CONTAGEM DE SORTEADOS POR LINHA: " +cont.quantidadeDezenasSorteadasPorLinhaDe0a5(LS.Concursos13D));
		
		//List<Integer> qtdLinhas = cont.quantidadeDezenasSorteadasPorLinhaDe0a5(LS.ConcursosGeral);
		//System.out.println(qtdLinhas);
		
		//MEDIA DE SOMAS DOS CONCURSOS
		List<Integer> minimoEMaximo =  cont.minimoEmaximoDeQTDDeSomasDeConcurso(cont.contagemDeFrequenciaDeSomas(cont.listSomaConcursos(LS.ConcursosGeral)));
		txfMediaSomaMinima.setText(minimoEMaximo.get(0)+"");
		txfMediaSomaMaxima.setText(minimoEMaximo.get(1)+"");
		System.out.println("minimoEMaximo: " + minimoEMaximo);
		
		int somaSeq = 0;
		int contSeq = 0;
		Integer[] seqSequencias = new Integer[15];
		
		for(int i = 0; i < seqSequencias.length; i++) seqSequencias[i]=0;
			
		for(Concurso c: LS.ConcursosGeral) {
			int seq = Sequencia.contDezenasEmSequencia(c);
			seqSequencias[seq-1]++;
			somaSeq += seq;
			contSeq++;
			System.out.print("Concurso: " + c.getConcurso() +" Sequencia: " + seq + " Media: " + (somaSeq/contSeq) + " SeqSequencia[]: ");
			lvConsole.getItems().add(("Concurso: " + c.getConcurso() +" Sequencia: " + seq + " Media: " + (somaSeq/contSeq) + " SeqSequencia[]: "));
			for(int i = 0 ; i < seqSequencias.length; i++) System.out.print(" [" + seqSequencias[i] + "] ");
			for(int i = 0 ; i < seqSequencias.length; i++) System.out.print(lvConsole.getItems().add(" [" + seqSequencias[i] + "] "));
			System.out.println(" ");
		}
		
		cbSelecionarConcurso.setItems(LS.ConcursosGeral);
		ObservableList<Integer> ob11a15 = FXCollections.observableArrayList();
		ob11a15.setAll(Arrays.asList(0,11,12,13,14,15,20));
		cbSelecionarDezenas11a15.setItems(FXCollections.observableArrayList(Operacao.values()));
		
		
	
	}

}

class Tarefa extends Thread{
	@Override
	public void run() {
		SampleFullController sampleFullController = new SampleFullController();
		
	}
}
