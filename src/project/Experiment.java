package project;

public class Experiment {

	 static String str = "soybean1987.txt"; //  (47x35)
	 static int inst = 47; 
	 static int attr = 35; 

	public static void main(String[] args) {
	
		//Setup data
		int k = 4;
		String[][] matrix = importdata.txt2array(str, inst, attr); // ma tran du lieu se xu ly
		System.out.println("----------------------------------------------------------- Initial Data: ----------------------------------------------------------------------");
		importdata.printStringArray2d(matrix);
		int experiment[][] = new int[200][k];
		for(int i = 0; i < 200; i++){
		//K-modes Algorithm
		KmodesAlgorithm kma = new KmodesAlgorithm(matrix, k);
		//Step 1:
		System.out.println("\nInitial mode:");
		importdata.printMode(kma.karray);
//		//Step 2:
//		kma.allocateObject();
		//Step 3&4
		kma.checkAndUpdate();
		//--- result after clustering-----
		System.out.println("\n\n------------------------------------------------------------- Result -------------------------------------------------------------------------------------");
		importdata.printIntArray(kma.resultTbl);
		System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n--------------------------------------------------------------- K-modes! ------------------------------------------------------------------------------------");
		importdata.printMode(kma.karray);
		System.out.println("\ntotal loop: " + (kma.loop + 1));
		System.out.println("\n--------------------------------------------------------------- statistic ------------------------------------------------------------------------------------");
		experiment[i] =  kma.statistic();
		}
		importdata.printIntArray2d(experiment);
		int count =0;
		for(int i = 0; i < experiment.length; i++){
			int temp=0;
			for(int j = 0; j < experiment[0].length; j++){
				if( (experiment[i][j] == 10) || (experiment[i][j] == 17) ){
					temp++;
				}
			}
			if(temp == 4){
				count++;
				for(int j = 0; j < experiment[0].length; j++){
					}
			}
		}
		int count1 =0;
		for(int i = 0; i < experiment.length; i++){
			int temp=0;
			for(int j = 0; j < experiment[0].length; j++){
				if( (experiment[i][j] == 10) || (experiment[i][j] == 12) || (experiment[i][j] == 15) ){
					temp++;
				}
			}
			if(temp == 4){
				count1++;
				for(int j = 0; j < experiment[0].length; j++){
					}
			}
		}
		System.out.println("Count [10 10 10 17] = "+count);
		System.out.println("Count [10 10 12 15] = "+count1);
	}

}
