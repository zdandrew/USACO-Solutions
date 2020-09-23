import java.util.*;
import java.io.*;

public class Taming {

	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner( new File("taming.in"));
		int length = reader.nextInt();
		int[] arr = new int[length];
		for (int i = 0; i<length; i++) {
			arr[i] = reader.nextInt();
		}
		// 3 = breakour; 1 = nothing; 2 = unknown
		int[] array = new int[length];
		array[0] = 3;
		for (int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]);
		}
		boolean possible = true;
		for (int i = 1; i< arr.length ; i++) {

			if (arr[i] == 0) {
				array[i] = 3;
			}
			else if (arr[i] > 0) {
				System.out.println("hellothere");
				for (int j = i; j > (i - arr[i]) ; j--) {
					if (array[j] == 3) {
						possible = false;
					}
					array[j] = 1;
				}
				array[i-arr[i]] = 3;
			}

			else if (arr[i] == -1) {
				array[i] = 2;
			}
		}
		for (int i = 0; i<array.length; i++) {
			System.out.print(array[i]);
		}
		int min = 0;
		int max = 0;

		PrintWriter out = new PrintWriter(new File("taming.out"));

		
		if (possible) {

			for (int i = 0; i<array.length; i++) {
				if(array[i] == 3) {
					min++;
					max++;
				}
				else if (array[i] == 2) {
					max++;
				}
				
			}
			out.println(min + " " + max);
		}
		else {
			out.println(-1);

		}
		out.close();
		reader.close();



	}

}
