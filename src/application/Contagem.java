package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.print.Collation;

public class Contagem {
	
	//CONTAGEM DE DEZENAS SORTEADAS DE CONCURSOS APARTIR DE UMA LISTAGEM DE CONCURSOS
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
	
	//CONTAGEM DE MINIMO E MAXIMO DE DEZENAS SORTEADAS POR LINHA (OBS MELHOR COM OS ULTIMOS 13 SORTEIOS)
		public ObservableList<ObservableList<Integer>> quantidadeDezenasSorteadasPorLinhaDe0a5(ObservableList<Concurso> concursos){
			ObservableList<ObservableList<Integer>> linhas = FXCollections.observableArrayList();
			
			ObservableList<Integer> linha1 = FXCollections.observableArrayList();
			ObservableList<Integer> linha2 = FXCollections.observableArrayList();
			ObservableList<Integer> linha3 = FXCollections.observableArrayList();
			ObservableList<Integer> linha4 = FXCollections.observableArrayList();
			ObservableList<Integer> linha5 = FXCollections.observableArrayList();
			//linhas.addAll(Arrays.asList(0,0,0,0,0));
			
			int contLinha1_0 = 0;
			int contLinha1_1 = 0;
			int contLinha1_2 = 0;
			int contLinha1_3 = 0;
			int contLinha1_4 = 0;
			int contLinha1_5 = 0;
			
			int contLinha2_0 = 0;
			int contLinha2_1 = 0;
			int contLinha2_2 = 0;
			int contLinha2_3 = 0;
			int contLinha2_4 = 0;
			int contLinha2_5 = 0;
			
			int contLinha3_0 = 0;
			int contLinha3_1 = 0;
			int contLinha3_2 = 0;
			int contLinha3_3 = 0;
			int contLinha3_4 = 0;
			int contLinha3_5 = 0;
			
			int contLinha4_0 = 0;
			int contLinha4_1 = 0;
			int contLinha4_2 = 0;
			int contLinha4_3 = 0;
			int contLinha4_4 = 0;
			int contLinha4_5 = 0;
			
			int contLinha5_0 = 0;
			int contLinha5_1 = 0;
			int contLinha5_2 = 0;
			int contLinha5_3 = 0;
			int contLinha5_4 = 0;
			int contLinha5_5 = 0;
			
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
				
				//contagem da linha 1
				switch (contLinha1) {
					case 0:
						contLinha1_0++;
					break;
					case 1:
						contLinha1_1++;
					break;
					case 2:
						contLinha1_2++;
					break;
					case 3:
						contLinha1_3++;
					break;
					case 4:
						contLinha1_4++;
					break;
					case 5:
						contLinha1_5++;
					break;
					default:
						break;
				}
				
				//contagem da linha 1
				switch (contLinha1) {
					case 0:
						contLinha1_0++;
					break;
					case 1:
						contLinha1_1++;
					break;
					case 2:
						contLinha1_2++;
					break;
					case 3:
						contLinha1_3++;
					break;
					case 4:
						contLinha1_4++;
					break;
					case 5:
						contLinha1_5++;
					break;
					default:
						break;
				}
				
				//contagem da linha 2
				switch (contLinha2) {
					case 0:
						contLinha2_0++;
					break;
					case 1:
						contLinha2_1++;
					break;
					case 2:
						contLinha2_2++;
					break;
					case 3:
						contLinha2_3++;
					break;
					case 4:
						contLinha2_4++;
					break;
					case 5:
						contLinha2_5++;
					break;
					default:
						break;
				}
				
				//contagem da linha 3
				switch (contLinha3) {
					case 0:
						contLinha3_0++;
					break;
					case 1:
						contLinha3_1++;
					break;
					case 2:
						contLinha3_2++;
					break;
					case 3:
						contLinha3_3++;
					break;
					case 4:
						contLinha3_4++;
					break;
					case 5:
						contLinha3_5++;
					break;
					default:
						break;
				}
				
				//contagem da linha 4
				switch (contLinha4) {
					case 0:
						contLinha4_0++;
					break;
					case 1:
						contLinha4_1++;
					break;
					case 2:
						contLinha4_2++;
					break;
					case 3:
						contLinha4_3++;
					break;
					case 4:
						contLinha4_4++;
					break;
					case 5:
						contLinha4_5++;
					break;
					default:
						break;
				}
				
				//contagem da linha 5
				switch (contLinha5) {
					case 0:
						contLinha5_0++;
					break;
					case 1:
						contLinha5_1++;
					break;
					case 2:
						contLinha5_2++;
					break;
					case 3:
						contLinha5_3++;
					break;
					case 4:
						contLinha5_4++;
					break;
					case 5:
						contLinha5_5++;
					break;
					default:
						break;
				}
			}
			linha1.addAll(Arrays.asList(contLinha1_0, contLinha1_1, contLinha1_2, contLinha1_3, contLinha1_4, contLinha1_5));
			linha2.addAll(Arrays.asList(contLinha2_0, contLinha2_1, contLinha2_2, contLinha2_3, contLinha2_4, contLinha2_5));
			linha3.addAll(Arrays.asList(contLinha3_0, contLinha3_1, contLinha3_2, contLinha3_3, contLinha3_4, contLinha3_5));
			linha4.addAll(Arrays.asList(contLinha4_0, contLinha4_1, contLinha4_2, contLinha4_3, contLinha4_4, contLinha4_5));
			linha5.addAll(Arrays.asList(contLinha5_0, contLinha5_1, contLinha5_2, contLinha5_3, contLinha5_4, contLinha5_5));
			
			linhas.addAll(linha1, linha2, linha3, linha4, linha5);
			return linhas;
		}
		
		//Encontrando a quantidade de dezenas por linha
		public List<Integer> fatorMediaDezenasPorLinha(List<ObservableList<Integer>> contagem){
			List<Integer> listaDeContagemPorLinha = new ArrayList<Integer>();
			
			for (ObservableList<Integer> l: contagem) {
				int valorDezena = 0;
				int indexDoValorDezena = 0;
				for(int i = 0; i < l.size(); i++) {
					if(l.get(i) > valorDezena) {
						valorDezena = l.get(i);
						indexDoValorDezena = i;
					}
				}
				listaDeContagemPorLinha.add(indexDoValorDezena);
			}
			
			return listaDeContagemPorLinha;
		}

	//REALIZA A CONTAGEM DE TODOS OS IMPARES DA LISTA DE CONCURSOS e tira a media
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
		//System.out.println("Impar Geral: " + imparGeral);
		
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
			
			//System.out.println("ContIMpar: " + contImpar);
			
			if(contImpar <= (imparGeral - 2)) {
				imparFaixaA++;
			}
			
			if(contImpar == (imparGeral - 1)) {
				imparFaixaB++;
			}
			
			if(contImpar == imparGeral) {
				imparFaixaC++;
			}
			
			if(contImpar == (imparGeral + 1)) {
				imparFaixaD++;
			}
			
			if(contImpar >= (imparGeral + 2)) {
				imparFaixaE++;
			}
		}
		
		rangeImpares.set(0, imparGeral - 2);
		rangeImpares.set(1, imparFaixaA);
		rangeImpares.set(2, imparGeral - 1);
		rangeImpares.set(3, imparFaixaB);
		rangeImpares.set(4, imparGeral);
		rangeImpares.set(5, imparFaixaC);
		rangeImpares.set(6, imparGeral + 1);
		rangeImpares.set(7, imparFaixaD);
		rangeImpares.set(8, imparGeral + 2);
		rangeImpares.set(9, imparFaixaE);
		
		return rangeImpares;
	}
	
	public int getMaiorFaixaImpar(ObservableList<Integer> faixaDeImpares) {
		int maior = 0;
		int media = 0;
		for(int i = 9; i >= 0; i-=2) {
			if(faixaDeImpares.get(i) > maior) {
				maior = faixaDeImpares.get(i);
				media = faixaDeImpares.get(i-1);
			}
			System.out.println("faixa: " + faixaDeImpares.get(i) + " maior: " + maior);
		}
		return media;
	}

	//Media Geral da soma das dezenas de um concurso
	public int somaConcursosMediaGeral(ObservableList<Concurso> concursos) {
		int media = 0;
		int somaGeral = 0;
		for(Concurso c : concursos) {
			int somaPorConcurso = 0;
			for(int j = 0 ; j < 15; j++) {
				somaPorConcurso += c.getDezenas().get(j);
			}
			System.out.println("Soma dor Concurso: " + somaPorConcurso);
			somaGeral += somaPorConcurso;
		}
		media = somaGeral / concursos.size();
		return media;
	}
	
	//Lista de Soma dos concursos
	public ObservableList<Integer> listSomaConcursos(ObservableList<Concurso> concursos) {
		ObservableList<Integer> concursosSomados = FXCollections.observableArrayList(); 
		for(Concurso c : concursos) {
			int somaPorConcurso = 0;
			for(int j = 0 ; j < 15; j++) {
				somaPorConcurso += c.getDezenas().get(j);
			}
			concursosSomados.add(somaPorConcurso);
		}
		
		return concursosSomados;
	}
	
	//CONTANDO A MEDIA DE SOMA DE CONCURSOS
	public ObservableList<Integer> top5ranqueMediaSomaConcursos(ObservableList<Concurso> concursos) {
		ObservableList<Integer> top5 = FXCollections.observableArrayList(); 
		ObservableList<Integer> listaDeConcursosSomados = FXCollections.observableArrayList();
		Integer mediaDeSoma = somaConcursosMediaGeral(concursos);
		listaDeConcursosSomados = listSomaConcursos(concursos);
		
		Integer mediaMenos15 = mediaDeSoma - 13;
		Integer mediaMenos10 = mediaDeSoma - 8;
		Integer mediaMenos5 = mediaDeSoma - 3;
		Integer media = mediaDeSoma;
		Integer mediaMais5 = mediaDeSoma + 3;
		Integer mediaMais10 = mediaDeSoma + 8;
		Integer mediaMais15 = mediaDeSoma + 13;
		
		Integer contMediaMenos15 = 0;
		Integer contMediaMenos10 = 0;
		Integer contMediaMenos5 = 0;
		Integer contMedia = 0;
		Integer contMediaMais5 = 0;
		Integer contMediaMais10 = 0;
		Integer contMediaMais15 = 0;
		
		for(Integer s: listaDeConcursosSomados) {
			if(s <= mediaMenos15)
				contMediaMenos15++;
			
			if(s > mediaMenos15 && s <= mediaMenos10)
				contMediaMenos10++;
			
			if(s > mediaMenos10 && s <= mediaMenos5)
				contMediaMenos5++;
			
			if(s > mediaMenos5 && s < mediaMais5)
				contMedia++;
			
			if(s >= mediaMais5 && s < mediaMais10)
				contMediaMais5++;
			
			if(s >= mediaMais10 && s < mediaMais15)
				contMediaMais10++;
			
			if(s >= mediaMais15)
				contMediaMais15++;
		}
		
		top5.addAll(Arrays.asList(mediaMenos15,contMediaMenos15,mediaMenos10,contMediaMenos10,mediaMenos5,contMediaMenos5,media,contMedia,mediaMais5,contMediaMais5,mediaMais10,contMediaMais10,mediaMais15,contMediaMais15));
		
		return top5;
	}
	
	
	public ObservableList<Integer> contagemDeFrequenciaDeSomas(ObservableList<Integer> listaDeSomaDeConcursos){
		ObservableList<Integer> contagem = FXCollections.observableArrayList();
		for(int i = 0; i <= 300; i++) {
			contagem.add(0);
		}
		
		System.out.println("Contagem: " + contagem);
		
		for(int c : listaDeSomaDeConcursos) {
			int valor = contagem.get(c);
			contagem.set(c, (valor + 1));
			System.out.println("C: " + c + " Valor: "+ valor);
		}
		
		return contagem;
	}
	
	//Lista de Ocorrencias por media de soma dos concursos
	public List<List<Integer>> mediaDeOcorrenciasPorSomaDeConcursos(ObservableList<Integer> frequenciaDeSomas) {
    	
		List<List<Integer>> medias = new ArrayList<List<Integer>>();
		List<Integer> mediaEQuantidades = new ArrayList<Integer>();
		
		
    	int max = 0;
    	for(int f : frequenciaDeSomas) {
    		if(f > max) {
    			max = f;
    		}
    	}
    	
    	int somaF = 0;
    	int somaI = 0;
    	int qtdDeSomas = 0;
    	for(int i = 0; i < frequenciaDeSomas.size(); i++) {
    		int f = frequenciaDeSomas.get(i);
    		if(f >= (max - max) && f <= max)
    			if(f != 0) {
    				System.out.println("Frequencia maximas: " + f + " index: " + i);
    				somaF += f;
    				somaI += i;
    			    qtdDeSomas++;
    			    
    			    mediaEQuantidades.add((i));
    	    		mediaEQuantidades.add((f));
    	    		medias.addAll(Arrays.asList(mediaEQuantidades));
    			}
	}
    	
    	
    	return medias;
  }	
	
}
