package project;

import java.util.Random;

public class KmodesAlgorithm {

	String[][] matrix; // Ma tran du lieu
	int[] resultTbl; // Mang nay dung de luu ket qua khi chay thuat toan
	String[][] karray; // Chon k dong trong du lieu trong du lieu lam modes
	int k, loop;
	
//	int[] tempresulttbl;

	public KmodesAlgorithm(String[][] matrix, int k) {
		this.matrix = matrix;
		this.k = k;
		initResultTable();
		selectKModes();
	}

	// Khoi tao ban ket qua
	public void initResultTable() {
		// init cluster
		System.out.println("\ninit result table (array that indicates Obj <=> Mode)");
		resultTbl = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			resultTbl[i] = 0;
			System.out.println("Oject "+i+" = "+resultTbl[i]);
		}
	}
	
	
	// /////////////////////////////////////////operation//////////////////////////////////////////////////////////
	public void selectKModes() {
		System.out.println("\n-------------------------------------- Step 1: chooses randomly initial K-modes from given dataset with k = "+k+" ------------------------------------------------------");
		Random rand = new Random();
		boolean isDuplicate = false;
		karray = new String[k][matrix[0].length]; 
		
		for (int i = 0; i < k; i++) {
			
			do {
				isDuplicate = false;
				String temp[] = matrix[rand.nextInt(matrix.length)];
				for (int j = 0; j < i; j++) {
					if (distance(karray[j], temp) == 0) {
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
		int[] tempresulttbl = new int[matrix.length];

		do {
			
			 System.out.println("\n-----loop "+(loop+1)+":");


				for (int i = 0; i < matrix.length; i++) { 
					System.out.println("Alocating Object "+i);
					int distance = matrix[0].length + 1; 
				
					for (int kno = 0; kno < k; kno++) { 
						int temp = 0;
						System.out.print(" with K-Mode "+kno);
						
						temp = distance(karray[kno], matrix[i]);
						System.out.println(" have distance = "+temp);
						if (temp <= distance) { 
							distance = temp;
							resultTbl[i] = kno;
						}
					}
					System.out.println("=>Min distance :" + distance+"\n");
			}
				
				importdata.printIntArray(resultTbl);
				
				for (int i = 0; i < karray.length; i++) {
					for (int a = 0; a < matrix[0].length; a++) {
						int max = 0;
						for (int x = 0; x < matrix.length; x++) {
							if (resultTbl[x] == i) {
								int temp1 = 0;
								for (int y = x; y < matrix.length; y++) {
									if ( (resultTbl[y] == i) && (matrix[x][a].equals(matrix[y][a])) ) {
											temp1++;
									}
								}
								if (temp1 >= max) { 
									max = temp1;
									karray[i][a] = matrix[x][a];
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

	public boolean checkIsChanged(int resultTbl[], int tempresulttbl[]){
		boolean changed = false;
		for (int i = 0; i < matrix.length; i++) {
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
	
	
	// tinh khoang cach d giua 2 object va instances va tra ve khoang cach
	public int distance(String[] array1, String[] array2) {
		int dis = 0;
		for (int i = 0; i < array1.length; i++) { 
			if (!array1[i].equals(array2[i])) { 
				dis++;
			}
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
