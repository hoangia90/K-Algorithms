package project;

public class Main {

	//K-modes
//	static String dataSetPath = "dataSet/balloons.txt"; //  6x8
//	static int instances = 16; 
//	static int attributes = 5; 

//	 static String dataSetPath = "dataSet/soybean.txt"; //  (683x35)
//	 static int instances = 683; 
//	 static int attributes = 35; 
	
//	 static String dataSetPath = "dataSet/soybean1987.txt"; 
//	 static int instances = 683; 
//	 static int attributes = 35; 
	 
//	 static String dataSetPath = "dataSet/test2.txt"; //  (5x6) k=2
//	 static int instances = 5; 
//	 static int attributes = 6; 
	 
	 //K-means
	 static String dataSetPath = "dataSet/test3.txt"; 
	 static int instances = 4; 
	 static int attributes = 2; 
	 
//	 static String dataSetPath = "dataSet/soybean1987.txt"; 
//	 static int instances = 683; 
//	 static int attributes = 35; 
	
//	static String dataSetPath = "dataSet/a1.txt"; 
//	static int instances = 35; 
//	static int attributes = 2; 

	public static void main(String[] args) {
//		runKmodes(dataSetPath, instances, attributes, 4);
		runKmeans(dataSetPath, instances, attributes, 2);
		
	}
	
	 static void runKmodes (String dataSetPath, int instances, int attributes, int k) {
		//Initialize data
		String[][] matrix = importdata.txt2StrArray(dataSetPath, instances, attributes); // ma tran du lieu se xu ly
		System.out.println("----------------------------------------------------------- Initial Data: ----------------------------------------------------------------------");
		importdata.printStringArray2d(matrix);
		//K-modes Algorithm
		KmodesAlgorithm kma = new KmodesAlgorithm(matrix, k);
		//Step 1:
		System.out.println("\nInitial Modes:");
		importdata.printMode(kma.karray);
		//Step 2&3&4
		kma.checkAndUpdate();
		//--- result after clustering-----
		System.out.println("\n\n------------------------------------------------------------- Result -------------------------------------------------------------------------------------");
		importdata.printIntArray(kma.resultTbl);
		System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n--------------------------------------------------------------- K-modes ------------------------------------------------------------------------------------");
		importdata.printMode(kma.karray);
		System.out.println("\ntotal loop: " + (kma.loop + 1));
		System.out.println("\n--------------------------------------------------------------- Statistic ------------------------------------------------------------------------------------");
		kma.statistic();
	 }
	 
	 static void runKmeans (String dataSetPath, int instances, int attributes, int k) {
			//Initialize data
			int[][] matrix = importdata.txt2IntArray(dataSetPath, instances, attributes); // ma tran du lieu se xu ly
			System.out.println("----------------------------------------------------------- Initial Data: ----------------------------------------------------------------------");
			importdata.printIntArray2d(matrix);
			//K-modes Algorithm
			KmeansAlgorithm kma = new KmeansAlgorithm(matrix, k);
			//Step 1:
			System.out.println("\nInitial Clusters:");
			importdata.printMode(kma.karray);
			//Step 2&3&4
			kma.checkAndUpdate();
			//--- result after clustering-----
			System.out.println("\n\n------------------------------------------------------------- Result -------------------------------------------------------------------------------------");
			importdata.printIntArray(kma.resultTbl);
			System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("\n--------------------------------------------------------------- K-Means ------------------------------------------------------------------------------------");
			importdata.printMode(kma.karray);
			System.out.println("\ntotal loop: " + (kma.loop + 1));
			System.out.println("\n--------------------------------------------------------------- Statistic ------------------------------------------------------------------------------------");
			kma.statistic();
		 }
}
