package application;

import java.util.Arrays;

import javafx.scene.control.Button;

public class Aposta {
	
	private Integer codigo;
	private Integer impPar;
	private Integer soma;
	private Integer[] dezenas;
	private Button action;
	
	public Aposta(Integer codigo, Integer impPar, Integer soma, Integer[] dezenas, Button action) {
		super();
		this.codigo = codigo;
		this.impPar = impPar;
		this.soma = soma;
		this.dezenas = dezenas;
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
		this.dezenas = dezenas;
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


}
