// Andrew Zhang
// 12/15/18
// Solution to 2018 december Bronze: Back Forth

import java.util.*;
import java.io.*;

public class BackForth {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("backforth.in"));
		int[] first = new int[10];
		int[] second = new int[10];
		for (int i = 0; i<10; i++) {
			first[i] = reader.nextInt();
		}
		for (int i = 0; i<10; i++) {
			second[i] = reader.nextInt();
		}
		int[] poss = new int[2001];
		for (int a = 0; a < 10; a++ ) {
			for (int b = 0; b<10; b++) {
				for(int c = 0; c<10; c++) {
					for (int d = 0; d<10; d++) {
						if(a != c && b != d) {
							int num = 1000 - first[a] + second[b] - first[c] + second[d];
							poss[num] = 1;
						}
					}
				}
			}
		}
		poss[1000] = 1;
		// get unique values
		List<Integer> unique1 = new ArrayList<Integer>();
		List<Integer> unique2 = new ArrayList<Integer>();
		for (int i = 0; i<10; i++) {
			if(unique1.indexOf(first[i]) == -1) {
				unique1.add(first[i]);
			}
		}
		for (int i = 0; i<10; i++) {
			if(unique2.indexOf(second[i]) == -1) {
				unique2.add(second[i]);
			}
		}
		for (int i = 0; i<unique1.size(); i++) {
			for (int j = 0; j<unique2.size(); j++) {
				int num = 1000 - unique1.get(i) + unique2.get(j);
				poss[num] = 1;
			}
		}
		int count = 0;
		for (int i = 0; i<2001; i++) {
			if(poss[i] == 1) {
				count++;
			}
		}
		System.out.println(count);
		PrintWriter out = new PrintWriter(new File("backforth.out"));
		out.println(count);
		out.close();
		reader.close();

	}

}
