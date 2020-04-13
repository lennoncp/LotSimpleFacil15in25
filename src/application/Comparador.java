package application;

import java.util.Arrays;
import java.util.Date;

import javafx.collections.ObservableList;

public class Comparador {
	
	public boolean comparaApostas(Aposta aposta, ObservableList<Aposta> apostas) {
		boolean retorno = false;
		Concurso concursoAuxAposta = new Concurso(0, new Date(), Arrays.asList(aposta.getDezenas()));
		for(Aposta a : apostas) {
			Concurso concursoAuxA = new Concurso(0, new Date(), Arrays.asList(a.getDezenas()));
			
			if(concursoAuxA.getDezenas().equals(concursoAuxAposta.getDezenas())) {
				System.out.println("APOSTA IGUAL APOSTAs APOSTA: "+Arrays.toString(aposta.getDezenas())+" APOSTAS: "+Arrays.toString(a.getDezenas()));
				
				retorno = true;
			}else {
				System.out.println("COMPARADORAPOSTA falso");
				retorno = false;	
			}
		}
		return retorno;
	}
	
	public boolean comparaApostaComConcursos(Aposta aposta, ObservableList<Concurso> concursos) {
		boolean retorno = false;
		Concurso concursoAuxAposta = new Concurso(0, new Date(), Arrays.asList(aposta.getDezenas()));
		for(Concurso c : concursos) {
			if(c.getDezenas().equals(concursoAuxAposta.getDezenas())) {
				System.out.println("APOSTA IGUAL CONCUROS APOSTA IGUAL CONCUROS APOSTA: "+Arrays.toString(aposta.getDezenas())+" CONCURSO: "+c.getDezenas());
				return true;
			}else {
				System.out.println("COMPARADORCONCURSO falso");
				retorno = false;	
			}
		}		
		return retorno;
	}

}
