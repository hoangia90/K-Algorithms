package project;

public class Main {

//	static String str = "dataSet/balloons.txt"; //  6x8
//	static int inst = 16; 
//	static int attr = 5; 

//	 static String str = "dataSet/soybean.txt"; //  (683x35)
//	 static int inst = 683; 
//	 static int attr = 35; 
	 
	 static String str = "dataSet/soybean1987.txt"; //  (47x35) k=4
	 static int inst = 47; 
	 static int attr = 35; 
	 
//	 static String str = "dataSet/test2.txt"; //  (5x6) k=2
//	 static int inst = 5; 
//	 static int attr = 6; 

	public static void main(String[] args) {

		//Initialize data
		int k = 4;
		String[][] matrix = importdata.txt2array(str, inst, attr); // ma tran du lieu se xu ly
		System.out.println("----------------------------------------------------------- Initial Data: ----------------------------------------------------------------------");
		importdata.printStringArray2d(matrix);
		
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

		kma.statistic();

	}
}
