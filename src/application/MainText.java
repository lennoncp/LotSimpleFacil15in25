package application;

import java.util.Random;

public class MainText {

	public static void main(String[] args) {
		Random rad = new Random();
		
		for(int i = 0; i < 25; i++) {
			System.out.println(rad.nextInt(2));
		}

	}

}
