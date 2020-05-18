package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.collections.ObservableList;

public class Sequencia {
	
	public static Integer contDezenasEmSequencia(Concurso concurso) {
		int MAX = 0;
		List<Integer> sequencia = new ArrayList<Integer>();
		sequencia.addAll(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0));
		
			for(int i: concurso.getDezenas()) {
				sequencia.set(i-1, 1);
			}

		
		int cont = 0;
		for(int i: sequencia) {
			
			if(i == 1) {
				cont++;
			}else {
				if(cont > MAX) {
					MAX = cont;
				}
				
				cont = 0;
			}
		}
		
		return MAX;
	}

}
