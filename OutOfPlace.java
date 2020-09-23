/*import java.util.*;
import java.io.*;

public class OutOfPlace {

	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(new File("outofplace.in"));
		int length = reader.nextInt();
		int[] arr = new int[length];
		for (int i = 0; i<length; i++) {
			arr[i] = reader.nextInt();
		}
		int bessieIndex = -1;
		int bessieValue = -1;
		int numRepeat = 0;
		int indexIdeal = -1;

		for (int i = 1 ; i<length; i++) {
			if (arr[0] > arr[1]) {
				bessieIndex = 0;
				bessieValue = arr[0];
			}

			else if (arr[i] < arr[i-1]) {
				bessieIndex = i;
				bessieValue = arr[i];
				break;
			}
		}
		for (int i = 1; i<length; i++) {
			if (bessieValue > arr[i-1] && bessieValue < arr[i]) {
				indexIdeal = i;
				break;
			}
			else if(bessieValue < arr[0]) {
				indexIdeal = 0;	
				break;
			}
		}

		if ((bessieIndex - indexIdeal) > 0) {
			for (int i = indexIdeal+1; i < bessieIndex; i++) {
				if (arr[i] == arr[i-1]) {
					numRepeat++;
				}
			}
		}
		else {
			for (int i = bessieIndex +1; i<indexIdeal; i++ ) {
				if (arr[i] == arr[i-1]) {
					numRepeat++;
				}
			}
		}
		int ans = Math.abs(bessieIndex - indexIdeal) - numRepeat;
		System.out.println(ans);
		PrintWriter out = new PrintWriter(new File("outofplace.out"));
		out.println(ans);
		out.close();
		reader.close();


	}

}
*/
import java.io.*;
import java.util.*;
public class OutOfPlace {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("outofplace.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));

		int n = Integer.parseInt(br.readLine());
		int[] height = new int[n];
		int[] sorted = new int[n];
		for(int i = 0; i < n; i++) {
			height[i] = Integer.parseInt(br.readLine());
			sorted[i] = height[i];
		}
		Arrays.sort(sorted);
		int swaps = -1;
		for(int a = 0; a < n; a++) {
			if(sorted[a] != height[a]) {
				swaps++;
			}
		}
		swaps = Math.max(0, swaps);
		pw.println(swaps);
		pw.close();
	}
	
}
