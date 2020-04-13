package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.mysql.fabric.xmlrpc.base.Data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

public class MainText {

	public static void main(String[] args) {
		
		ObservableList<Aposta> apostas = FXCollections.observableArrayList();
		ObservableList<Concurso> concursos = FXCollections.observableArrayList();
		
		Integer[] dezenas = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		Aposta aposta = new Aposta(0, 7, 200, dezenas, null);
		apostas.add(aposta);
		
		Integer[] dezenas2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,18};
		Aposta aposta2 = new Aposta(0, 7, 200, dezenas2, null);
		apostas.add(aposta);
		
		List<Integer> dezenasC = new ArrayList<Integer>();
		dezenasC.addAll(Arrays.asList(dezenas));
		
		List<Integer> dezenasC2 = new ArrayList<Integer>();
		dezenasC2.addAll(Arrays.asList(dezenas2));
		
		Concurso concurso = new Concurso(1256, new Date(), dezenasC); 
		Concurso concurso2 = new Concurso(1256, new Date(), dezenasC2);
		List<Integer> dezenasC3 = new ArrayList<Integer>();
		dezenasC3.add(1);
		dezenasC3.add(2);
		dezenasC3.add(3);
		dezenasC3.add(4);
		dezenasC3.add(5);
		dezenasC3.add(6);
		dezenasC3.add(7);
		dezenasC3.add(8);
		dezenasC3.add(9);
		dezenasC3.add(10);
		dezenasC3.add(11);
		dezenasC3.add(12);
		dezenasC3.add(13);
		dezenasC3.add(14);
		dezenasC3.add(18);
		Concurso concurso3 = new Concurso(1256, new Date(), dezenasC3);
		
		concursos.add(concurso);
		concursos.add(concurso2);
		concursos.add(concurso3);
		
		Concurso concursoAuxApostaComparador = new Concurso(0, new Date(), Arrays.asList(aposta.getDezenas()));
		Concurso concursoAuxApostaComparado = new Concurso(0, new Date(), Arrays.asList(aposta2.getDezenas()));
		
		System.out.println("Apostas: " + apostas.get(0).getDezenas().equals(aposta.getDezenas()));
		System.out.println("Aposta: " + aposta.getDezenas().equals(aposta2.getDezenas()));
		System.out.println("Concurso: " + concurso.getDezenas().equals(aposta.getDezenas()));
		System.out.println("Concurso -> concurso: " + concurso.getDezenas().equals(concurso2.getDezenas()));
		System.out.println("Comparando Concurso -> concurso: " + concursoAuxApostaComparador.getDezenas().equals(concursoAuxApostaComparado.getDezenas()));
		
		Comparador comparador = new Comparador();
		System.out.println("Aposta em Apostas: " + comparador.comparaApostas(aposta2, apostas));
		System.out.println("Aposta em Concursos: " + comparador.comparaApostaComConcursos(aposta, concursos));
		
		
		System.out.println(aposta);
		System.out.println(concurso);
		
		
		
		/*List<Integer> lList = new ArrayList<Integer>();
        lList.add(4);

        lList.add(1);
        lList.add(7);
        lList.add(2);
        lList.add(9);
        lList.add(1);
        lList.add(5);

        Collections.sort(lList);
        for(int i=0; i<lList.size();i++ )
        {
            System.out.println(lList);
        }*/

	}

}
