import java.util.*;
import java.io.*;

public class Lemonade {

	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(new File("lemonade.in"));
		int length = reader.nextInt();
		int[] arr = new int[length];
		for(int i = 0; i<length; i++) {
			arr[i] = reader.nextInt();
		}
		Arrays.sort(arr);

		int index = length-1;
		int count = 0;
		
		for (int i = index; i >= 0; i--) {
			if(length-i-1 <= arr[i]) {
				count++;
			}
			else {
				break;
			}
		}
		
		System.out.println(count);
		PrintWriter out = new PrintWriter(new File("lemonade.out"));
		out.println(count);
		out.close();
		reader.close();
		
		
	}

}
