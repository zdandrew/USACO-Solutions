import java.util.*;
import java.io.*;

public class ModernArt {
	
	public static int size;
	
	public static boolean contains(char[] arr, char key) {
		for (int i = 0; i<arr.length; i++) {
			if(arr[i] == key) {
				return true;
			}
		}
		return false;
	}
	//returns the one on top, or returns '0'
	
	
	
	public static char overlap(char a, char b, char[][] grid) {
		// 0- top, 1-right, 2- bot, 3-left
		int[] aRec = new int[4];
		aRec = rect(a, grid);
		int[] bRec = new int[4];
		bRec = rect(b, grid);
		for (int i = 0; i<size; i++) {
			for (int j = 0; j<size; j++) {
				if (inside(i, j, aRec) && inside(i, j, bRec) && (grid[i][j] == a || grid[i][j] == b)) {
					//System.out.print(grid[i][j]);
					//System.out.print(i);
					//System.out.println(j);
					return grid[i][j];
				}
			}
		}
		//System.out.println("hello");	
		return '0';
	}
	
	public static boolean inside(int row, int col, int[] rect) {
		
		if (row >= rect[0] && row <= rect[2] && col >= rect[3] && col<= rect[1]) {
			//System.out.println(rect[0] + rect[1]);
			//System.out.println();
			//System.out.print(rect[0]);
			//System.out.print(rect[1]);
			//System.out.print(rect[2]);
			//System.out.println(rect[3]);
			//System.out.println();
			return true;
		}
				
		return false;
	}
		
	
	 public static int[] rect(char x, char[][] grid) {
		 int top = 9999;
		 int right = -1;
		 int bot = -1;
		 int left = 9999;
		 for (int i = 0; i<size; i++) {
			 for (int j = 0; j<size; j++) {
				 if(grid[i][j] == x) {
					 top = Math.min(top, i);
					 right = Math.max(right, j);
					 bot = Math.max(bot, i);
					 left = Math.min(left, j);
				 }
			 }
		 }
		 int[] ans = new int[4];
		 ans[0] = top;
		 ans[1] = right;
		 ans[2] = bot;
		 ans[3] = left;
		 for (int i = 0; i<4; i++) {
			 //System.out.print(ans[i]);
		 }
		 return ans;
	 }
	
	
	
	
	public static void remove(char[] arr, char key) {
		if (key == '0') {
			return;
		}
		for (int i = 0; i<arr.length; i++) {
			if (arr[i] == key) {
				arr[i] = '0';
				return;
			}
		}
		return;
	}
		
	public static void main(String[] args) throws IOException {
		
		Scanner reader = new Scanner(new File("art.in"));
		size = reader.nextInt();
		char[][] grid = new char[size][size];
		char[] nums = new char[9];
		String[] strArr = new String[size];
		int counter = 0;
		reader.nextLine();
		for(int i = 0; i<size; i++) {
			strArr[i] = reader.nextLine();
			for (int j = 0; j<size; j++) {
				grid[i][j] = strArr[i].charAt(j);
				if (!contains(nums, grid[i][j]) && grid[i][j] != '0'){
					nums[counter] = grid[i][j];
					counter++;
				}
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
		for (int i = 0; i<9; i++) {
			System.out.println(nums[i]);
		}
		char[] pos = nums.clone();
		for(int i = 0; i<nums.length-1; i++) {
			for (int j = i+1; j<nums.length; j++) {
				remove(pos,overlap(nums[i], nums[j], grid));
				for (int a = 0; a<pos.length; a++) {
					System.out.print(pos[a]);
				}
				System.out.println();
			}
		}
		System.out.println();
		int answer = 0;
		for (int i = 0; i<pos.length; i++) {
			if ( pos[i] == '1' || pos[i] == '2' || pos[i] == '3' || pos[i] == '4' || pos[i] == '5' || pos[i] == '6' ||
					 pos[i] == '7' || pos[i] == '8' || pos[i] == '9') {
				answer++;
				System.out.print(pos[i]);
			}
		}
		System.out.println();
		System.out.println(answer);
		PrintWriter out = new PrintWriter(new File("art.out"));
		out.println(answer);
		out.close();
		reader.close();
		System.out.println(overlap('7', '3', grid));

		System.out.println();
		
		
		
		

	}

}
