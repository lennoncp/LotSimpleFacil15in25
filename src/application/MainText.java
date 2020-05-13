package application;

import java.time.LocalDate;
import java.time.LocalTime;
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
		
		Random rad = new Random(LocalTime.now().toNanoOfDay());
		
		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		int n4 = 0;
		int n5 = 0;
		int zero = 0;
		
		for(int i =0; i < 100; i++) {
			int r = rad.nextInt(5);
			
			switch (r) {
			case 1:
				n1++; 
				break;
			case 2:
				n2++; 
				break;
			case 3:
				n3++; 
				break;
			case 4:
				n4++; 
				break;
			case 5:
				n5++; 
				break;

			default:
				zero++;
				break;
			}
			
		}

		System.out.println("Zero: " + zero + " N1: " + n1 + "" + " N2: " + n2 + ""+ " N3: " + n3 + ""+ " N4: " + n4 + ""+ " N5: " + n5);
	}

}
