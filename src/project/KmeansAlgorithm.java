package project;

import java.util.Random;

public class KmeansAlgorithm {

	double[][] data; // Mang du lieu, du lieu se duoc dua vao trong mang 2 chieu nay 
	double[] resultTbl; // Mang nay dung de luu ket qua khi chay thuat toan, 
	double[][] karray; // Chon k dong trong du lieu trong du lieu lam modes
	int k, loop;
	
//	int[] tempresulttbl;

	public KmeansAlgorithm(double[][] data, int k) {
		this.data = data;
		this.k = k;
		initResultTable();
		selectKModes();
	}

	// Khoi tao ban ket qua
	public void initResultTable() {
		// init cluster
		System.out.println("\ninit result table (array that indicates Obj <=> Mode)");
		resultTbl = new double[data.length];
		for (int i = 0; i < data.length; i++) {
			resultTbl[i] = 0;
			System.out.println("Oject "+i+" = "+resultTbl[i]);
		}
	}
	
	
	// /////////////////////////////////////////operation//////////////////////////////////////////////////////////
	public void selectKModes() {
		System.out.println("\n-------------------------------------- Step 1: chooses randomly initial K-modes from given dataset with k = "+k+" ------------------------------------------------------");
		Random rand = new Random();
		boolean isDuplicate = false;
		karray = new double[k][data[0].length]; 
		
		for (int i = 0; i < k; i++) {
			do {
				isDuplicate = false;
				double temp[] = data[rand.nextInt(data.length)];
				for (int j = 0; j < i; j++) {
					if (distanceCalculate(karray[j], temp) == 0) {
						isDuplicate = true;
					}
				}
				for(int j = 0 ; j < karray[0].length ; j++){
					karray[i][j] = temp[j];
				}
			} while (isDuplicate);
		}
	}
	
	
	// Buoc 2 3 & 4:
	public void checkAndUpdate() {
		System.out.println("\n--------------------------------------------------- Step 2-3&4 : recheck and relocate K-modes ---------------------------------------------------------------------------------\n");
		loop = 0;
		double[] tempresulttbl = new double[data.length];

		do {
			
			 System.out.println("\n-----loop "+(loop+1)+":");


			for (int i = 0; i < data.length; i++) { 
				System.out.println("Alocating Object "+i);
				double distance = data[0].length + 1; 
				
				for (int kno = 0; kno < k; kno++) { 
					double temp = 0;
					System.out.print(" with K-Mode "+kno);
					
					temp = distanceCalculate(karray[kno], data[i]);
					System.out.println(" have distance = "+temp);
					if (temp <= distance) { 
						distance = temp;
						resultTbl[i] = kno;
					}
				}
				System.out.println("=>Min distance :" + distance+"\n");
			}
			
			importdata.printDoubleArray(resultTbl);
			for (int i = 0; i < karray.length; i++) {
				for (int a = 0; a < data[0].length; a++) {
					int max = 0;
					for (int x = 0; x < data.length; x++) {
						if (resultTbl[x] == i) {
							int temp1 = 0;
							for (int y = x; y < data.length; y++) {
								if ( (resultTbl[y] == i) && ( data[x][a] == data[y][a] ) ) {
										temp1++;
								}
							}
							if (temp1 >= max) { 
								max = temp1;
								karray[i][a] = data[x][a];
							}
						}
					}
				}
			}
			
			System.out.println("\nUpdate K-Mode");
			importdata.printMode(karray);
			loop++;
		}while (checkIsChanged(resultTbl,tempresulttbl));
	}

	public boolean checkIsChanged(double resultTbl[], double tempresulttbl[]){
		boolean changed = false;
		for (int i = 0; i < data.length; i++) {
			if (resultTbl[i] != tempresulttbl[i]) {
				changed = true;
			}
		}
		if(changed){
			for(int i = 0 ; i < resultTbl.length ; i++){
				tempresulttbl[i] = resultTbl[i];
			}
		}
		return changed;
	}
	
	// Calculate distance between 2 objects
	// Tinh khoang cach d giua 2 object va instances va tra ve khoang cach
	public double distanceCalculate(double[] array1, double[] array2) {
		double dis = 0;
		for (int i = 0; i < array1.length; i++) { 
//			if (!array1[i].equals(array2[i])) { 
//				dis++;
//			}
			dis = dis + (Math.pow(array1[i],2) - Math.pow(array2[i],2));
		}
		return dis;
	}
	
	public int[] statistic(){
		int array[] = new int[k];
		int count;
		for (int i = 0; i < k; i++){
			count = 0;
			for (int j = 0; j < resultTbl.length; j++){
				if(resultTbl[j] == i){
					count ++;
				}
			}
			array[i] = count;
			System.out.println("Mode " + i + " have :" + count + " instances!");
		}
		return array;
	}

}
