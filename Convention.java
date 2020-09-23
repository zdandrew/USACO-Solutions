// Andrew Zhang
// 12/16/18
// Solution to usaco Silver 2018: Convention


import java.util.*;
import java.io.*;
public class Convention {

	public static void main(String[] args) throws IOException {
		
		Scanner reader = new Scanner(new File("/Users/andrewzhang/Downloads/convention_silver_dec18/3.in"));
		int cows = reader.nextInt();
		int bus = reader.nextInt();
		int size = reader.nextInt();
		int[] times = new int[cows];
		for (int i = 0; i<cows; i++) {
			times[i] = reader.nextInt();
		}
		Arrays.sort(times);
		int min = 999;
		for (int i = 0; i< Math.pow(size, bus); i++) {
			//System.out.println("loop");
			int[] combo = new int[bus];
			int iCopy = i;
			int sum = 0;
			for (int j = 0; j<bus; j++) {
				
				combo[j] = iCopy % (size) + 1;
				//System.out.println(combo[j]);
				sum += combo[j];
				iCopy /= (size );	
			}
			if (sum >= cows) {
				min = Math.min(min, max(combo, times));
			}
			
				
		}
			
			
		
		System.out.println(min);
		PrintWriter out = new PrintWriter(new File("convention.out"));
		out.println(min);
		out.close();
		reader.close();

		
	}
	
	public static int max(int[] combo, int[] times) {
		int count = 0;
		int max = -1;
		for (int i = 0; i<combo.length; i++) {
			//System.out.println(combo[i]);
			if (combo[i] == 0 || count + combo[i] - 1 > times.length-1) {
				return 9999;
			}
			int temp = times[count + combo[i] - 1] - times[count];
			count += combo[i];
			max = Math.max(max, temp);
			//System.out.println(max);
		}
		return max;
	}
	

}
