package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javafx.scene.control.Button;

public class Aposta {
	
	private Integer codigo;
	private Integer impPar;
	private Integer soma;
	private Integer[] dezenas;
	private Button action;
	
	public Aposta() {
		super();
	}

	public Aposta(Integer codigo, Integer impPar, Integer soma, Integer[] dezenas, Button action) {
		super();
		this.codigo = codigo;
		this.impPar = impPar;
		this.soma = soma;
		//this.dezenas = dezenas;
		this.dezenas = setDezenasSort(dezenas);
		this.action = action;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getImpPar() {
		return impPar;
	}

	public void setImpPar(Integer impPar) {
		this.impPar = impPar;
	}

	public Integer getSoma() {
		return soma;
	}

	public void setSoma(Integer soma) {
		this.soma = soma;
	}

	public Integer[] getDezenas() {
		return dezenas;
	}

	public void setDezenas(Integer[] dezenas) {
		List<Integer> dezenasList = new ArrayList<Integer>();
		Integer[] dezenasNovas = new Integer[dezenas.length];
		for(int i: dezenas) {
			dezenasList.add(i);
		}
		Collections.sort(dezenasList);
		for(int i = 0; i < dezenasList.size(); i++) {
			dezenasNovas[i] = dezenasList.get(i);
		}
		this.dezenas = dezenasNovas;
		
	}
	
	public Integer[] setDezenasSort(Integer[] dezenas) {
		List<Integer> dezenasList = new ArrayList<Integer>();
		Integer[] dezenasNovas = new Integer[dezenas.length];
		for(int i: dezenas) {
			dezenasList.add(i);
		}
		Collections.sort(dezenasList);
		for(int i = 0; i < dezenasList.size(); i++) {
			dezenasNovas[i] = dezenasList.get(i);
		}
		return dezenasNovas;
		
	}
	
	public void setDezenaEmDezenas(int index, int dezena) {
		this.dezenas[index] = dezena;
	}

	public Button getAction() {
		return action;
	}

	public void setAction(Button action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "Aposta [codigo=" + codigo + ", impPar=" + impPar + ", soma=" + soma + ", dezenas="
				+ Arrays.toString(dezenas) + ", action=" + action + "]";
	}

	public Concurso toConcurso() {
		List<Integer> dezenas = new ArrayList<Integer>();
		
		for(int i: getDezenas())
			dezenas.add(i);
			
		return new Concurso(getCodigo(), new Date(), dezenas);
	}
	
	public List<Integer> DezNaoSorteadas(){
		List<Integer> returnDezenas = new ArrayList<Integer>();
		returnDezenas.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25));
		System.out.println(returnDezenas);
		
		for(Integer i : getDezenas()) {
			LS.removeValorDaListaDeLinhas(returnDezenas, i);
		}
		
		return returnDezenas;
	}

}
