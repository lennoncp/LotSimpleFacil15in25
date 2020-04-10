package application;

import javafx.collections.ObservableList;

public class Comparador {
	
	public boolean comparaApostas(Aposta aposta, ObservableList<Aposta> apostas) {
		return apostas.contains(aposta);
	}
	
	public boolean comparaApostaComConcursos(Aposta aposta, ObservableList<Concurso> concursos) {
		return concursos.contains(aposta);
	}

}
