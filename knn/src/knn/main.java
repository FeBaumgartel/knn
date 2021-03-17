package knn;

 	
import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {

		int treinamento[][] = { { 1, 10, 200, 1 }, { 2, 20, 230, 1 }, { 6, 25, 150, 1 }, { 7, 45, 100, 1 },
				{ 10, 50, 125, 1 }, { 3, 24, 111, 1 }, { 100, 4, 10, 2 }, { 250, 7, 50, 2 }, { 243, 5, 68, 2 },
				{ 210, 2, 90, 2 }, { 200, 1, 95, 2 }, { 215, 0, 68, 2 }, { 56, 200, 1, 3 }, { 79, 234, 3, 3 },
				{ 80, 210, 8, 3 }, { 95, 200, 10, 3 }, { 80, 210, 4, 3 }, { 49, 207, 1, 3 } };

		int teste[][] = { { 1, 2, 100 }, { 10, 20, 30 }, { 8, 5, 20 }, { 237, 45, 100 }, { 1, 50, 101 },
				{ 67, 121, 12 } };

		int k3[] = new int[6];
		int k5[] = new int[6];
		int k7[] = new int[6];

		for (int i = 0; i < teste.length; i++) {
			double distancia[][] = new double[treinamento.length][2];
			double aux[] = new double[2];

			int classk3[] = { 0, 0, 0 };
			int classk5[] = { 0, 0, 0 };
			int classk7[] = { 0, 0, 0 };

			for (int j = 0; j < treinamento.length; j++) {
				distancia[j][0] = Math.sqrt(Math.pow(teste[i][0] - treinamento[j][0], 2)
											+ Math.pow(teste[i][1] - treinamento[j][1], 2) 
											+ Math.pow(teste[i][2] - treinamento[j][2], 2));
				distancia[j][1] = treinamento[j][3];

			}

			for (int j = 0; j < distancia.length; j++) {
				for (int k = 0; k < distancia.length; k++) {
					if (distancia[j][0] < distancia[k][0]) {
						aux = distancia[j];
						distancia[j] = distancia[k];
						distancia[k] = aux;
					}
				}
			}

			for (int j = 0; j < distancia.length; j++) {
				int item = (int) distancia[j][1];
				if (j < 7) {
					switch (item) {
					case 1:
						classk7[0]++;
						break;
					case 2:
						classk7[1]++;
						break;
					case 3:
						classk7[2]++;
						break;
					}

				}
				if (j < 5) {
					switch (item) {
					case 1:
						classk5[0]++;
						break;
					case 2:
						classk5[1]++;
						break;
					case 3:
						classk5[2]++;
						break;
					}

				}
				if (j < 3) {
					switch (item) {
					case 1:
						classk3[0]++;
						break;
					case 2:
						classk3[1]++;
						break;
					case 3:
						classk3[2]++;
						break;
					}

				}
			}
			if(classk3[0] > classk3[1]) {
				if(classk3[1] < classk3[2]) {
					if(classk3[0] > classk3[2]) {
						k3[i]=1;
					}else {
						k3[i]=3;
					}
				}else {
					k3[i]=1;
				}
			}else if(classk3[1]>classk3[0]){
				if(classk3[0] < classk3[2]) {
					if(classk3[1] > classk3[2]) {
						k3[i]=2;
					}else {
						k3[i]=3;
					}
				}else {
					k3[i]=2;
				}
			}else if(classk3[2]>classk3[0]){
				if(classk3[0] < classk3[1]) {
					if(classk3[2] > classk3[1]) {
						k3[i]=3;
					}else {
						k3[i]=2;
					}
				}else {
					k3[i]=3;
				}
			}
			
			if(classk5[0] > classk5[1]) {
				if(classk5[1] < classk5[2]) {
					if(classk5[0] > classk5[2]) {
						k5[i]=1;
					}else {
						k5[i]=3;
					}
				}else {
					k5[i]=1;
				}
			}else if(classk5[1]>classk5[0]){
				if(classk5[0] < classk5[2]) {
					if(classk5[1] > classk5[2]) {
						k5[i]=2;
					}else {
						k5[i]=3;
					}
				}else {
					k5[i]=2;
				}
			}else if(classk5[2]>classk5[0]){
				if(classk5[0] < classk5[1]) {
					if(classk5[2] > classk5[1]) {
						k5[i]=3;
					}else {
						k5[i]=2;
					}
				}else {
					k5[i]=3;
				}
			}
			
			if(classk7[0] > classk7[1]) {
				if(classk7[1] < classk7[2]) {
					if(classk7[0] > classk7[2]) {
						k7[i]=1;
					}else {
						k7[i]=3;
					}
				}else {
					k7[i]=1;
				}
			}else if(classk7[1]>classk7[0]){
				if(classk7[0] < classk7[2]) {
					if(classk7[1] > classk7[2]) {
						k7[i]=2;
					}else {
						k7[i]=3;
					}
				}else {
					k7[i]=2;
				}
			}else if(classk7[2]>classk7[0]){
				if(classk7[0] < classk7[1]) {
					if(classk7[2] > classk7[1]) {
						k7[i]=3;
					}else {
						k7[i]=2;
					}
				}else {
					k7[i]=3;
				}
			}

			System.out.println("k3 para o "+(i+1)+" teste:" + k3[i]);
			System.out.println("k5 para o "+(i+1)+" teste:" + k5[i]);
			System.out.println("k7 para o "+(i+1)+" teste:" + k7[i]);
		}
		
		
	}
}