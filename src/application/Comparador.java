package application;

import java.util.Arrays;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Comparador {
	
	public boolean comparaApostas(Aposta aposta, ObservableList<Aposta> apostas) {
		boolean retorno = false;
		Concurso concursoAuxAposta = new Concurso(0, new Date(), Arrays.asList(aposta.getDezenas()));
		for(Aposta a : apostas) {
			Concurso concursoAuxA = new Concurso(0, new Date(), Arrays.asList(a.getDezenas()));
			
			//System.out.println("APOSTAS CONTADOR: " + contadorDeDezenasIguais(concursoAuxAposta, concursoAuxA));
			
			if(concursoAuxA.getDezenas().equals(concursoAuxAposta.getDezenas())) {
				System.out.println("APOSTA IGUAL APOSTAs APOSTA: "+Arrays.toString(aposta.getDezenas())+" APOSTAS: "+Arrays.toString(a.getDezenas()));		
				retorno = true;
			}else {
				//System.out.println("APOSTA: "+ concursoAuxAposta.getDezenas() + " APOSTAS: " + concursoAuxA.getDezenas() + " FALSO");
				retorno = false;	
			}
		}
		
		ObservableList<Concurso> concursosApostas = FXCollections.observableArrayList();
		for(Aposta a: apostas) {
			concursosApostas.add(new Concurso(0, new Date(), Arrays.asList(a.getDezenas())));
		}
		System.out.println("APOSTAS CONTADOR MAX: " + contadorDeDezenasIguaisMAX(concursoAuxAposta, concursosApostas));
		
		return retorno;
	}
	
	public boolean comparaApostaComConcursos(Aposta aposta, ObservableList<Concurso> concursos) {
		boolean retorno = false;
		Concurso concursoAuxAposta = new Concurso(0, new Date(), Arrays.asList(aposta.getDezenas()));
		for(Concurso c : concursos) {	
			
			//System.out.println("CONCURSOS CONTADOR: " + contadorDeDezenasIguais(concursoAuxAposta, c));
		
			if(c.getDezenas().equals(concursoAuxAposta.getDezenas())) {
				System.out.println("APOSTA IGUAL CONCUROS APOSTA IGUAL CONCUROS APOSTA: "+Arrays.toString(aposta.getDezenas())+" CONCURSO: "+c.getDezenas());
				return true;
			}else {
				//System.out.println("CONCURSO: "+ c.getDezenas() + " APOSTA: " + Arrays.toString(aposta.getDezenas()) + " FALSO");
				retorno = false;	
			}
		}		
		
		System.out.println("CONCURSOS CONTADOR MAX: " + contadorDeDezenasIguaisMAX(concursoAuxAposta, concursos));
		
		return retorno;
	}
	
	public Integer contadorDeDezenasIguais(Concurso aposta, Concurso concurso) {
		int contador = 0;
		for(int i = 0; i < concurso.getDezenas().size(); i++){
			for(int j = 0; j < aposta.getDezenas().size(); j++) {
				if(concurso.getDezenas().get(i) == aposta.getDezenas().get(j)) {
					contador++;
				}
			}
		}
		
		//System.out.println("CONCURSOS CONTADOR: " + contador);
		return contador;
	}
	
	public Integer contadorDeDezenasIguaisMAX(Concurso aposta, ObservableList<Concurso> concursos) {
		int MAX = 0;
		
			for(Concurso c: concursos) {
				int contador = 0;
				for(int i = 0; i < c.getDezenas().size(); i++) {
					for(int j = 0; j < aposta.getDezenas().size(); j++) {
						if(c.getDezenas().get(i) == aposta.getDezenas().get(j)) {
							contador++;
						}
					}
				}
				
				if(contador > MAX) {
					MAX = contador;
				}
			}
			
		return MAX;
	}
	

}
