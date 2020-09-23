// Andrew Zhang
// 12/15/18
// Solution to 2018 December Bronze: Mixing Milk

import java.util.*;
import java.io.*;

public class MixingMilk {
	
	public static int[] cow1 = new int[2];
	public static int[] cow2 = new int[2];
	public static int[] cow3 = new int[2];
	
	
	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(new File("mixmilk.in"));
		
		cow1[0] = reader.nextInt();
		cow1[1] = reader.nextInt();
		cow2[0] = reader.nextInt();
		cow2[1] = reader.nextInt();
		cow3[0] = reader.nextInt();
		cow3[1] = reader.nextInt();
		for (int i = 0; i<33; i++) {
			pour(cow1, cow2);
			pour(cow2, cow3);
			pour(cow3, cow1);
			
		}
		pour(cow1, cow2);
		System.out.println(cow1[1]);
		System.out.println(cow2[1]);
		System.out.println(cow3[1]);
		PrintWriter out = new PrintWriter(new File("mixmilk.out"));
		out.println(cow1[1]);
		out.println(cow2[1]);
		out.println(cow3[1]);
		out.close();
		reader.close();

		
	}
	
	public static void pour(int[] first, int[] second) {
		if (second[0] >= first[1] + second[1]) {
			second[1] += first[1];
			first[1] = 0;
		}
		else {
			int num = second[0] - second[1];
			first[1] -= num;
			second[1] = second[0];
		}
		
	}
}
