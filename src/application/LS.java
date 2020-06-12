package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

public class LS {
	
	public static Integer codigoUltimaApostaSalvaBD = new Integer(0);
	public static Integer codigoAtualApostas = new Integer(0);
	
	public static TextField txfMediaImpar = new TextField();
    public static TextField txfRangeConcursos = new TextField();
    
    public static ObservableList<Aposta> apostas = FXCollections.observableArrayList();
    
    public static ObservableList<Concurso> ConcursosGeral = FXCollections.observableArrayList(); 
    public static ObservableList<Concurso> ConcursosRange3M = FXCollections.observableArrayList(); 
    public static ObservableList<Concurso> Concursos13D = FXCollections.observableArrayList(); 
    //PARA COMPARACAO
    public static ObservableList<Concurso> Concursos3D = FXCollections.observableArrayList(); 
    
    public static ObservableList<Integer> contagemConcursosGeral = FXCollections.observableArrayList(); 
    public static ObservableList<Integer> contagemConcursosRange3M = FXCollections.observableArrayList(); 
    public static ObservableList<Integer> contagemConcursos13D = FXCollections.observableArrayList(); 
    
    public static ObservableList<ApostaConcurso> listaDBApostas = FXCollections.observableArrayList();
    public static ObservableList<ApostaConcurso> listaDeApostas = FXCollections.observableArrayList();
    public static ObservableList<ApostaConcurso> listaDeConcursos = FXCollections.observableArrayList();
    
    public static ObservableList<Integer> mediaCorteListaGeral = FXCollections.observableArrayList();
    public static ObservableList<Integer> mediaCorteLista3Meses = FXCollections.observableArrayList();
    public static ObservableList<Integer> mediaCorteLista13Dias = FXCollections.observableArrayList();
    
    //LISTA PARA MEDIA DE COMPARACAO
    public static ObservableList<Aposta> auxConcursoPAposta3D = FXCollections.observableArrayList(); 
  	public static ObservableList<Aposta> listApostasComparacao = FXCollections.observableArrayList();
  	
	public static void removeValorDaListaDeLinhas(List<Integer> lista, int valor){	 	
	 	while(lista.contains(valor)) {
	 		for(int i = 0; i < lista.size(); i++) {
	     		if(lista.get(i) == valor) {	     			
	     			System.out.println("lista.get(i): " + lista.get(i) + " Valor: " + valor + " Lista: " + lista + " i: " + i);	     			
	     			lista.remove(i);
	     		}
	     	}
	 	}
	 	
	}
	
	public static Integer verificaImpar(List<Integer> lista) {
		int cont = 0;
		for(int i : lista) {
			if(i % 2 != 0) {
				cont++;
			}
		}
		
		return cont;
	}
	
	public static Integer verificaImpar(Integer[] lista) {
		int cont = 0;
		for(int i : lista) {
			if(i % 2 != 0) {
				cont++;
			}
		}
		
		return cont;
	}
	
	public static Integer somaDezenas(List<Integer> lista) {
		Integer soma = 0;
		for(int i : lista) {
			soma += i;
		}
		return soma;
	}
	
	public static Integer somaDezenas(Integer[] lista) {
		Integer soma = 0;
		for(int i : lista) {
			soma += i;
		}
		return soma;
	}
	
	public static Concurso toConcurso(Aposta aposta) {
		List<Integer> dezenas = new ArrayList<Integer>();
		for(int i = 0; i < aposta.getDezenas().length; i++) {
			dezenas.add(aposta.getDezenas()[i]);
		}
		return new Concurso(aposta.getCodigo(), new Date(), dezenas);
	}
	
	public static ObservableList<Concurso> toObsConcursos(ObservableList<Aposta> apostas){
		ObservableList<Concurso> concursos = FXCollections.observableArrayList();
		for(Aposta aposta : apostas) {
			concursos.add(aposta.toConcurso());
		}
		return concursos;
	}
	
}
