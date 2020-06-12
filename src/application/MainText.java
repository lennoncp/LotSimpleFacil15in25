package application;

import java.util.Random;

public class MainText {
	
	public static void main(String[] args) {
		

			for(int i = 0; i < 5; i++) {
				new TarefaAux().start();
			}

		
	}

}

class TarefaAux extends Thread{
	@Override
	public void run() {
		int nome = new Random().nextInt();
		for(int i = 0 ; i < 100; i++) {
			System.out.println(" run Thread"+ nome +" i: " + i);
		}
	}
}