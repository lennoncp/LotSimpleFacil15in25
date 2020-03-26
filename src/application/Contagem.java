package application;

import java.util.Arrays;
import java.util.List;

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
	
	//CONTAGEM DE MINIMO E MAXIMO DE DEZENAS SORTEADAS POR LINHA (OBS MELHOR COM OS ULTIMOS 13 SORTEIOS)
	public ObservableList<Integer> mediaDezSorteadasPorLinha(ObservableList<Concurso> concursos){
		ObservableList<Integer> linhas = FXCollections.observableArrayList();
		linhas.addAll(Arrays.asList(5,0,5,0,5,0,5,0,5,0));
		
		for(int k = concursos.size()-1; k >=0; k--) {
			int contLinha1 = 0;
			int contLinha2 = 0;
			int contLinha3 = 0;
			int contLinha4 = 0;
			int contLinha5 = 0;
			
			for(int j = 0; j < 15; j++) {
				
				int valor = concursos.get(k).getDezenas().get(j);
			
				if(valor < 6) {
					contLinha1++;
				}
				
				if(valor >= 6 && valor < 11) {
					contLinha2++;
				}
				
				if(valor >= 11 && valor < 16) {
					contLinha3++;
				}
				
				if(valor >= 16 && valor < 21) {
					contLinha4++;
				}
				
				if(valor >=21 ) {
					contLinha5++;
				}
			}
			
			//VERIFICANDO CONTAGEM DA LINHA 1
			if(linhas.get(0) > contLinha1) {
				linhas.set(0, contLinha1);
			}
			
			if(linhas.get(1) < contLinha1) {
				linhas.set(1, contLinha1);
			}
			
			//VERIFICANDO CONTAGEM DA LINHA 2
			if(linhas.get(2) > contLinha2) {
				linhas.set(2, contLinha2);
			}
			
			if(linhas.get(3) < contLinha2) {
				linhas.set(3, contLinha2);
			}
			
			//VERIFICANDO CONTAGEM DA LINHA 3
			if(linhas.get(4) > contLinha3) {
				linhas.set(4, contLinha3);
			}
			
			if(linhas.get(5) < contLinha3) {
				linhas.set(5, contLinha3);
			}
			
			//VERIFICANDO CONTAGEM DA LINHA 4
			if(linhas.get(6) > contLinha4) {
				linhas.set(6, contLinha4);
			}
			
			if(linhas.get(7) < contLinha4) {
				linhas.set(7, contLinha4);
			}
			
			//VERIFICANDO CONTAGEM DA LINHA 5
			if(linhas.get(8) > contLinha5) {
				linhas.set(8, contLinha5);
			}
			
			if(linhas.get(9) < contLinha5) {
				linhas.set(9, contLinha5);
			}
		}
		
		return linhas;
	}

	//REALIZA A CONTAGEM DE TODOS OS IMPARES DA LISTA DE CONCURSOS
	public int contagemDeImparesGeral(ObservableList<Concurso> concursos) {
		int impar = 0;
		for(Concurso c : concursos) {
			for(int i : c.getDezenas()) {
				if(i % 2 != 0) {
					impar++;
				}

			}
		}
		
		return impar / concursos.size();
	}

	public ObservableList<Integer> contagemDeImparesPorFaixa(ObservableList<Concurso> concursos){
		ObservableList<Integer> rangeImpares = FXCollections.observableArrayList();
		rangeImpares.addAll(Arrays.asList(0,0,0,0,0,0,0,0,0,0));
		int imparGeral = contagemDeImparesGeral(concursos);
		System.out.println("Impar Geral: " + imparGeral);
		
		int imparFaixaA = 0;
		int imparFaixaB = 0;
		int imparFaixaC = 0;
		int imparFaixaD = 0;
		int imparFaixaE = 0;
		
		for(Concurso c : concursos) {
			
			int contImpar = 0;
			
			for(int d : c.getDezenas()) {
				if(d % 2 != 0)
					contImpar++;
			}
			
			if(contImpar <= (imparGeral - 2)) {
				imparFaixaA++;
				System.out.println("Contador de impar: " + contImpar + " Na Faixa A: " + imparFaixaA + " impargeral: " + imparGeral);
			}
			
			if(contImpar > (imparGeral - 2) && contImpar <= (imparGeral - 1)) {
				imparFaixaB++;
			}
			
			if(contImpar == imparGeral) {
				imparFaixaC++;
			}
			
			if(contImpar > imparGeral && contImpar <= (imparGeral + 1)) {
				imparFaixaD++;
			}
			
			if(contImpar >= (imparGeral + 2)) {
				imparFaixaE++;
			}
		}
		
		rangeImpares.set(0, imparGeral - 2);
		rangeImpares.set(1, imparFaixaA);
		rangeImpares.set(2, imparGeral - 1);
		rangeImpares.set(1, imparFaixaB);
		rangeImpares.set(4, imparGeral);
		rangeImpares.set(1, imparFaixaC);
		rangeImpares.set(6, imparGeral + 1);
		rangeImpares.set(1, imparFaixaD);
		rangeImpares.set(8, imparGeral + 2);
		rangeImpares.set(1, imparFaixaE);
		
		return rangeImpares;
	}
}
