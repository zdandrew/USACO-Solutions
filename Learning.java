/*import java.io.*;
import java.util.Scanner;

public class LearningByExample {

	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(new File("/Users/andrewzhang/Downloads/learning_bronze/1.in"));
		int numCows = reader.nextInt();
		int lower = reader.nextInt();
		int higher = reader.nextInt();
		String[] spotArr = new String[numCows];
		int[] cowWeights = new int[numCows];
		for (int i = 0; i < numCows; i++) {
			spotArr[i] = reader.next();	
			System.out.print(spotArr[i]);
			cowWeights[i] = reader.nextInt();
			System.out.println(cowWeights[i]);
		}
		
	}

}
*/
import java.util.*;
import java.io.*;

public class Learning {

	public static void main(String[] args) throws Exception {

		Scanner stdin = new Scanner(new File("learning.in"));
		int n = stdin.nextInt();
		int a = stdin.nextInt();
		int b = stdin.nextInt();

		// Read in cows for the case.
		cow[] cows = new cow[n];
		for (int i=0; i<n; i++) {
			String spots = stdin.next();
			int pos = stdin.nextInt();
			cows[i] = new cow(spots, pos);
		}
		Arrays.sort(cows);

		// Store answer here.
		int res = 0;

		// Go through cows in order.
		for (int i=0; i<n; i++) {

			// Can't contribute to spot count.
			if (!cows[i].spots) continue;

			// Set up low and high bounds for cow i's influence.
			int low = -1;
			int high = 1000000001;

			// Be careful with odd and even cases, here.
			if (i > 0) low = (cows[i-1].x+cows[i].x)/2 + (cows[i-1].x+cows[i].x)%2;
			if (i < n-1) high = (cows[i].x+cows[i+1].x)/2;

			// Add the number of points of intersection within range to our count.
			res += intersect(low, high, a, b);

		}

		// Sub out all cows counted twice - must have two influencing cows who were both spotted.
		for (int i=1; i<n; i++) {
			int mid = (cows[i-1].x+cows[i].x)/2;
			if (cows[i-1].spots && cows[i].spots && (cows[i-1].x+cows[i].x)%2 == 0 && a <= mid  && mid <= b)
				res--;
		}

		// Write out result.
		PrintWriter out = new PrintWriter(new File("learning.out"));
		out.println(res);
		out.close();
		stdin.close();
	}

	// Returns how many items in [start1, end1] appear in [start2, end2].
	public static int intersect(int start1, int end1, int start2, int end2) {
		int start = Math.max(start1, start2);
		int end = Math.min(end1, end2);
		return start <= end ? end-start+1 : 0;
	}
}

class cow implements Comparable<cow> {

	public boolean spots;
	public int x;


	public cow(String hasSpots, int pos) {
		spots = hasSpots.equals("S");
		x = pos;
	}

	public int compareTo(cow other) {
		return this.x - other.x;
	}
}