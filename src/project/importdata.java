package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class importdata {

	// nhap tu file text de ra 1 mang 2 chieu kieu String
	public static String[][] txt2StrArray(String filePath, int inst, int attr) {
		BufferedReader br = null;
		String[][] matrix = new String[inst][attr];
		int i = 0;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(filePath));
			while ((sCurrentLine = br.readLine()) != null) {
				String[] ArrayCurrentline = sCurrentLine.split(",");
				for (int j = 0; j < attr; j++) {
					matrix[i][j] = ArrayCurrentline[j].toString();
				}
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return matrix;
	}
	
	public static int[][] txt2IntArray(String filePath, int inst, int attr) {
		BufferedReader br = null;
		int[][] matrix = new int[inst][attr];
		int i = 0;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(filePath));
			while ((sCurrentLine = br.readLine()) != null) {
				String[] ArrayCurrentline = sCurrentLine.split(",");
				for (int j = 0; j < attr; j++) {
					matrix[i][j] = Integer.parseInt(ArrayCurrentline[j].toString());
				}
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return matrix;
	}

	// in ra man hinh mang 2 chieu kieu string
	public static void printStringArray2d(String[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("Instance "+i+": " );
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
			;
		}
	}

	
	public static void printIntArray2d(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("experiment "+i+": " );
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
			;
		}
	}
	
	public static void printMode(int[][] karray) {
		for (int i = 0; i < karray.length; i++) {
			System.out.print("K (Centroid) "+i+": " );
			for (int j = 0; j < karray[0].length; j++) {
				System.out.print(karray[i][j] + " ");
			}
			System.out.println();
			;
		}
	}
	
	public static void printMode(String[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("Mode "+i+": " );
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
			;
		}
	}
	
	// in mang 1 chieu
	public static void printDoubleArray(double[] resultTbl) {
		for (int i = 0; i < resultTbl.length; i++) {
			System.out.println("instance " + (i + 1) + " belongs to cluster "
					+ resultTbl[i]);
		}
	}
	
	public static void printIntArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("instance " + (i + 1) + " belongs to cluster "
					+ array[i]);
		}
	}

}
