package application;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Concurso {
	
	private Integer concurso;
	private Date dataConcurso;
	private List<Integer> dezenas;
	
	public Concurso() {
		super();
	}

	public Concurso(Integer concurso, Date dataConcurso, List<Integer> dezenas) {
		super();
		this.concurso = concurso;
		this.dataConcurso = dataConcurso;
		this.dezenas = dezenas;
	}

	public Integer getConcurso() {
		return concurso;
	}

	public void setConcurso(Integer concurso) {
		this.concurso = concurso;
	}

	public Date getDataConcurso() {
		return dataConcurso;
	}

	public void setDataConcurso(Date dataConcurso) {
		this.dataConcurso = dataConcurso;
	}

	public List<Integer> getDezenas() {
		return dezenas;
	}

	public void setDezenas(List<Integer> dezenas) {
		this.dezenas = dezenas;
	}

	@Override
	public String toString() {
		return "Concurso [concurso=" + concurso + ", dataConcurso=" + dataConcurso + ", dezenas=" + dezenas + "]";
	}
	
	public static ObservableList<Concurso> toConcursos(ObservableList<Aposta> apostas) {
		ObservableList<Concurso> concursos = FXCollections.observableArrayList();
		for(Aposta a : apostas) {
			Concurso concurso = new Concurso(a.getCodigo(), new Date(), Arrays.asList(a.getDezenas()));
			concursos.add(concurso);
		}
		return concursos;
	}
	

}
