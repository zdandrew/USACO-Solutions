import java.util.*;
import java.io.*;

public class Billboard2 {
	
	public int area(int[] arr) {
		int sol = (arr[3] - arr[1]) * (arr[2] - arr[0]);
		//System.out.println(sol);
		return sol;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(new File("billboard.in"));
		int[] bad = new int[4];
		int[] good = new int[4];
		for (int i = 0; i<4; i++) {
			bad[i] = reader.nextInt();
			//System.out.println(bad[i]);
		}
		for (int i = 0; i<4; i++) {
			good[i] = reader.nextInt();
		}
		int answer = 0;
		Billboard2 board = new Billboard2();
		//if there is a corner inside the bad, answer is area of bad
		if(good[2] > bad[0] && good[2] < bad[2] && good[3] > bad[1] && good[3] < bad[3]) {
			answer = board.area(bad);
		}
		if(good[0] > bad[0] && good[0] < bad[2] && good[3] > bad[1] && good[3] < bad[3]) {
			answer = board.area(bad);
		}
		if(good[0] > bad[0] && good[0] < bad[2] && good[1] > bad[1] && good[1] < bad[3]) {
			answer = board.area(bad);
		}
		if(good[2] > bad[0] && good[2] < bad[2] && good[1] > bad[1] && good[1] < bad[3]) {
			answer = board.area(bad);
		}
		
		
		if (good[2] >= bad[0] && good[2] <= bad[2] && good[3] >= bad[3] && good[1] <= bad[1]) {
			answer = (bad[3]-bad[1]) * (bad[2] - good[2]);
		}
		if (good[2] >= bad[2] && good[0] <= bad[0] && good[3] >= bad[1] && good[3] <= bad[3]) {
			answer = (bad[2]-bad[0]) * (bad[3] - good[3]);
		}
		if (good[1] >= bad[1] && good[1] <= bad[3] && good[2] >= bad[2] && good[0] <= bad[0]) {
			answer = (bad[2]-bad[0]) * (good[1] - bad[1]);
		}
		if (good[3] >= bad[3] && good[1] <= bad[1] && good[2] >= bad[2] && good[0] <= bad[0]) {
			answer = (bad[3]-bad[1]) * (good[0] - bad[0]);
		}
		
		
		if (good[3] >= bad[3] && good[0] <= bad[0] && good[2] >= bad[2] && good[1] <= bad[1]) {
			answer = 0;
		}
		
		
		PrintWriter out = new PrintWriter(new File("billboard.out"));
		out.println(answer);
		out.close();
		reader.close();
		System.out.println(answer);
		
		

	}

}
