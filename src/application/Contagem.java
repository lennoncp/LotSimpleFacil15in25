package application;

import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Contagem {
	
	public ObservableList<Integer> contagemConcursos(ObservableList<Concurso> concursos){
		ObservableList<Integer> dezenas = FXCollections.observableArrayList();
		
		dezenas.addAll(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0));
		
		for(int j = concursos.size()-1; j >= 0; j--) {
			//System.out.println("entrou primeiro for j: " + j);
			for(int i = 0; i < 25; i++) {
				//System.out.println("entrou segundo for i: " + i);
				if(concursos.get(j).getDezenas().contains(i+1)) {
					dezenas.set(i, dezenas.get(i) + 1);
					//System.out.println("encontrou");
				}
			}
		}
		return dezenas;
	}

}
