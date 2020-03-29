package application;

import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

public class ApostaConcurso {
	
	private Integer codigo;
	private Integer Impar;
	private Integer soma;
	private ObservableList<Integer> dezenas;
	private Button button;
	
	public ApostaConcurso() {
		// TODO Auto-generated constructor stub
	}
	
	

	public ApostaConcurso(Integer codigo, Integer impar, Integer soma, ObservableList<Integer> dezenas, Button button) {
		super();
		this.codigo = codigo;
		Impar = impar;
		this.soma = soma;
		this.dezenas = dezenas;
		this.button = button;
	}



	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getImpar() {
		return Impar;
	}
	public void setImpar(Integer impar) {
		Impar = impar;
	}
	public Integer getSoma() {
		return soma;
	}
	public void setSoma(Integer soma) {
		this.soma = soma;
	}
	
	public ObservableList<Integer> getDezenas() {
		return dezenas;
	}

	public void setDezenas(ObservableList<Integer> dezenas) {
		this.dezenas = dezenas;
	}

	public Button getButton() {
		return button;
	}
	public void setButton(Button button) {
		this.button = button;
	}
	
	public Aposta getAposta() {
		Integer[] dezenas = new Integer[this.dezenas.size()];
		for(int i = 0; i < this.dezenas.size(); i++) {
			dezenas[i]=this.dezenas.get(i);
		}
		Aposta aposta = new Aposta(this.getCodigo(), this.Impar, this.soma, dezenas, this.button);
		return aposta;
	}
	
	public static ApostaConcurso toApostaConcurso(Aposta aposta) {
		int impar = 0;
		int soma = 0;
		for(Integer d: aposta.getDezenas()) {
			soma += d;
			if(d % 2 != 0) {
				impar++;
			}
		}
		Button button = new Button("X");
		ApostaConcurso ac = new ApostaConcurso(aposta.getCodigo(), impar, soma, FXCollections.observableArrayList(Arrays.asList(aposta.getDezenas())), button);
		return ac;
		
	}
	
	public static ApostaConcurso toApostaConcurso(Concurso concurso) {
		int impar = 0;
		int soma = 0;
		for(Integer d: concurso.getDezenas()) {
			soma += d;
			if(d % 2 != 0) {
				impar++;
			}
		}
		Button button = new Button("X");
		ApostaConcurso ac = new ApostaConcurso(concurso.getConcurso(), impar, soma, FXCollections.observableArrayList(concurso.getDezenas()), button);
		return ac;
	}

}
