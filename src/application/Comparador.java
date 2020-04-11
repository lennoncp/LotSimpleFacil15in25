package application;

import java.util.Arrays;

import javafx.collections.ObservableList;

public class Comparador {
	
	public boolean comparaApostas(Aposta aposta, ObservableList<Aposta> apostas) {
		boolean retorno = false;
		for(Aposta a : apostas) {
			System.out.println("APOSTA IGUAL APOSTA IGUAL APOSTA IGUAL APOSTA: "+Arrays.toString(aposta.getDezenas())+" APOSTAS: "+Arrays.toString(a.getDezenas()));
			return a.equals(aposta);
		}
		return retorno;
	}
	
	public boolean comparaApostaComConcursos(Aposta aposta, ObservableList<Concurso> concursos) {
		boolean retorno = false;
		for(Concurso c : concursos) {
			System.out.println("APOSTA IGUAL CONCUROS APOSTA IGUAL CONCUROS APOSTA: "+Arrays.toString(aposta.getDezenas())+" CONCURSO: "+c.getDezenas());
			return c.getDezenas().equals(aposta.getDezenas());
		}
		return retorno;
	}

}
