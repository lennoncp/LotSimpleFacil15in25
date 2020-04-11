package application;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainText {

	public static void main(String[] args) {
		
		ObservableList<Integer> lista1 = FXCollections.observableArrayList();
		lista1.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
		
		ObservableList<Integer> lista2 = FXCollections.observableArrayList();
		lista2.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,16));
		
		int i = 2;
		System.out.println("Contem: "+ lista1.contains(lista2));
		System.out.println("Equal: "+ lista1.equals(lista2));

	}

}
