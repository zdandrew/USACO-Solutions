import java.util.*;
import java.io.*;

public class IcyPerimeter2 {
	public static int maxCount = 0;
	public static int tempCount = 0;
	public static int xvalue = 0;
	public static int yvalue = 0;
	public static int perim = 0;
	public static int perimTemp = 0;
	public static ArrayList<GridNode> nodesVisited ;
	public static ArrayList<GridNode> maxNodesVisited;
	public static final int[] horiz = {-1, 0, 1, 0};
	public static final int[] vert = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
        BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));

		int length = Integer.parseInt(br.readLine());
		int[][] arr = new int[length][length];

		for (int i = 0; i<length; i++) {
			String str = br.readLine();;
			for (int j = 0; j<length; j++) {
				if(str.charAt(j) == 35) {
					arr[i][j] = 1;
				}
				else {
					arr[i][j] = 0;
				}
			}
		}
		
		/*for (int i = 0; i<length; i++) {
			for(int j = 0; j<length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}*/
		boolean[][] used =  new boolean[length][length];
		for (int i = 0; i<length; i++) {
			for (int j = 0; j<length; j++) {
				tempCount = 0;
				//System.out.println(perimTemp);
				perimTemp = 0;
				if (!used[i][j] && arr[i][j] == 1) {
					nodesVisited = new ArrayList<>();
					visit(used, i, j, arr);
					//System.out.println("perim: " + perimTemp);
					if (tempCount > maxCount) {
						maxCount = tempCount;
						maxNodesVisited = nodesVisited;
						perim = 0;
						//xvalue = i;
						//yvalue = j;				
					}
					else if (tempCount == maxCount) {
						perim = compuPerim(maxNodesVisited, arr);
						perimTemp = compuPerim(nodesVisited, arr);
						if (perimTemp < perim) {
							maxNodesVisited = nodesVisited;
							perim = perimTemp;
						}
						
						//xvalue = i;
						//yvalue = j;
					}
				}
				
			}
		}
		//System.out.println(maxCount);
		//System.out.println(xvalue);
		//System.out.println(yvalue);
		//boolean[][] used2 = new boolean[arr.length][arr.length];
		//perim(used2, xvalue, yvalue, arr);
		if (perim == 0)
			perim = compuPerim(maxNodesVisited, arr);
		System.out.println(maxCount + " " + perim);
		PrintWriter out = new PrintWriter(new File("perimeter.out"));
		out.println(maxCount + " " + perim);
		out.close();
		br.close();
		
		

	}
	
	public static int compuPerim(List<GridNode> nodes, int[][] arr) {
		int localPerim = 0;
		for (GridNode node: nodes) {
			int i = node.x;
			int j = node.y;
			if (i < arr.length-1 && arr[i+1][j] == 0)
				localPerim++;
			if (i > 0 && arr[i-1][j] == 0)
				localPerim++;
			if (j > 0 && arr[i][j-1] == 0)
				localPerim++;
			if (j < arr.length -1 && arr[i][j+1] == 0)
				localPerim++;
			if (j == arr.length-1 || j == 0)
				localPerim++;
			if (i == arr.length-1 || i == 0)
				localPerim++;
		}
		return localPerim;
		
	}
	public static void visit(boolean[][] used, int i, int j, int[][] arr) {

		used[i][j] = true;
		

		nodesVisited.add(new GridNode(i, j));
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
		if ( i >= 0 && j>= 0 && i<arr.length && j<arr.length  && !used[i][j] && arr[i][j] == 1)
			return true;
		return false;
	}

}

class GridNode {
	int x, y;
	
	public GridNode(int i, int j) {
		x = i;
		y = j;
	}
}
