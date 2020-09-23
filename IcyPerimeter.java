import java.util.*;
import java.io.*;

public class IcyPerimeter {
	public static int maxCount = 0;
	public static int tempCount = 0;
	public static int xvalue = 0;
	public static int yvalue = 0;
	public static int perim = 0;
	public static int perimTemp = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("perimeter.in"));
		int length = reader.nextInt();
		int[][] arr = new int[length][length];
		reader.nextLine();
		for (int i = 0; i<length; i++) {
			String str = reader.nextLine();
			for (int j = 0; j<length; j++) {
				if(str.charAt(j) == 35) {
					arr[i][j] = 1;
				}
				else {
					arr[i][j] = 0;
				}
			}
		}
		
		for (int i = 0; i<length; i++) {
			for(int j = 0; j<length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		boolean[][] used =  new boolean[length][length];
		for (int i = 0; i<length; i++) {
			for (int j = 0; j<length; j++) {
				tempCount = 0;
				//System.out.println(perimTemp);
				perimTemp = 0;
				if (!used[i][j] && arr[i][j] == 1) {
					visit(used, i, j, arr);
					System.out.println("perim: " + perimTemp);
					if (tempCount > maxCount) {
						maxCount = tempCount;
						perim = perimTemp;
						xvalue = i;
						yvalue = j;				
					}
					else if (tempCount == maxCount) {
						perim = Math.min(perim, perimTemp);
						xvalue = i;
						yvalue = j;
					}
				}
				
			}
		}
		//System.out.println(maxCount);
		//System.out.println(xvalue);
		//System.out.println(yvalue);
		//boolean[][] used2 = new boolean[arr.length][arr.length];
		//perim(used2, xvalue, yvalue, arr);
		System.out.println(maxCount + " " + perim);
		PrintWriter out = new PrintWriter(new File("perimeter.out"));
		out.println(maxCount + " " + perim);
		out.close();
		reader.close();
		
		

	}
	
	public static void visit(boolean[][] used, int i, int j, int[][] arr) {
		int[] horiz = {-1, 0, 1, 0};
		int[] vert = {0, 1, 0, -1};
		used[i][j] = true;
		if (i < arr.length-1 && arr[i+1][j] == 0)
			perimTemp++;
		if (i > 0 && arr[i-1][j] == 0)
			perimTemp++;
		if (j > 0 && arr[i][j-1] == 0)
			perimTemp++;
		if (j < arr.length -1 && arr[i][j+1] == 0)
			perimTemp++;
		if (j == arr.length-1 || j == 0)
			perimTemp++;
		if (i == arr.length-1 || i == 0)
			perimTemp++;
		

		tempCount++;
		for (int a = 0; a<4; a++) {
			if (valid(used, i + horiz[a], j + vert[a], arr)) {
				visit(used, i + horiz[a], j + vert[a], arr);
			}
			
		}
	}
	/*
	public static int perim(boolean[][] used2, int i, int j, int[][] arr) {

		
		int[] horiz = {-1, 0, 1, 0};
		int[] vert = {0, 1, 0, -1};
		used2[i][j] = true;
		if (i < arr.length-1 && arr[i+1][j] == 0)
			perim++;
		else if (i > 0 && arr[i-1][i] == 0)
			perim++;
		else if (j > 0 && arr[i][j-1] == 0)
			perim++;
		else if (j < arr.length && arr[i][j+1] == 0)
			perim++;
		for (int a = 0; a<4; a++) {
			if (valid(used2, i + horiz[a], j + vert[a], arr)) {
				visit(used2, i + horiz[a], j + vert[a], arr);
			}
			
		}
		return perim;
		
	}
	*/
	
	public static boolean valid(boolean[][] used, int i , int j , int[][] arr) {
		if (i >= 0 && j>= 0 && i<arr.length && j<arr.length && !used[i][j] && arr[i][j] == 1)
			return true;
		return false;
	}

}
