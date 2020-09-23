// Andrew Zhang
// 12/15/18
// Solution to 2018 December Bronze: Bucket List

import java.util.*;
import java.io.*;
public class TotalBuckets {
	
	public static void main(String[] args) throws IOException {
		
		Scanner reader = new Scanner(new File("blist.in"));
		int length = reader.nextInt();
		int[] start = new int[length];
		int[] end = new int[length];
		int[] amt = new int[length];
		int[] all = new int[1001];
		for (int i = 0; i<length; i++) {
			start[i] = reader.nextInt();
			end[i] = reader.nextInt();
			amt[i] = reader.nextInt();
		}
		for (int i = 0; i<length; i++) {
			for (int j = start[i]; j<= end[i]; j++) {
				all[j] += amt[i];
			}
		}
		int max = -1;
		for (int i = 0; i<1001; i++) {
			if (all[i] > max) {
				max = all[i];
			}
		}
		System.out.println(max);
		PrintWriter out = new PrintWriter(new File("blist.out"));
		out.println(max);
		out.close();
		reader.close();

		
	}

}
