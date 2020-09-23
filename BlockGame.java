import java.util.*;
import java.io.*;

public class BlockGame {

	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(new File("blocks.in"));
		PrintWriter out = new PrintWriter(new File("blocks.out"));
		int count = reader.nextInt();
		int[] ans = new int[26];
		for (int i = 0; i<count; i++) {
			int[] word1 = calc(reader.next());
			int[] word2 = calc(reader.next());
			for (int j = 0; j<26; j++) {
				if(word1[j] > 0 || word2[j] >0) {
					ans[j] += Math.max(word1[j], word2[j]);
				}
			}
		}
		for (int i = 0; i<26; i++) {
			out.println(ans[i]);
		}

		out.close();
		reader.close();

	}
	 public static int[] calc(String str) {
		 int[] arr = new int[26];
		 int length = str.length();
		 for (int i = 0; i<length; i++) {
			 int index = str.charAt(i) - 'a';
			 arr[index]++;
		 }
		 return arr;
	 }

}
