package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

public class LS {
	
	public static TextField txfMediaImpar = new TextField();
    public static TextField txfRangeConcursos = new TextField();
    
    public static ObservableList<Aposta> apostas = FXCollections.observableArrayList();
    
    public static ObservableList<Concurso> ConcursosGeral = FXCollections.observableArrayList(); 
    public static ObservableList<Concurso> ConcursosRange3M = FXCollections.observableArrayList(); 
    public static ObservableList<Concurso> Concursos13D = FXCollections.observableArrayList(); 

}