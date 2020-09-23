/*import java.util.*;
import java.io.*;

public class OutOfSorts {

	//returns index of array Coypy



	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(new File("sort.in"));
		int length = reader.nextInt();
		int[] arr = new int[length];
		for (int i = 0; i<length; i++) {

			arr[i] = reader.nextInt();
		}
		int[] arrCopy = arr.clone();
		Arrays.sort(arrCopy);
		int sum = 0;

		for (int i = 0; i<length; i++) {
			int index = Arrays.binarySearch(arrCopy, arr[i]);
			//for (int j = 0; j<length; j++) {
			//	if (arrCopy[j] == arr[i]) {
			//		index = j;
			//	}
			//}


			sum = Math.max(i-index, sum) ;
		}

		int answer = sum +1;

		System.out.println(answer);
		PrintWriter out = new PrintWriter(new File("sort.out"));

		out.println(answer);
		out.close();
		reader.close();
	}

}
*/
import java.util.*;
import java.io.*;

public class OutOfSorts {

	public static void main(String[] args) throws Exception {

		// Read in data.
		BufferedReader stdin = new BufferedReader(new FileReader("sort.in"));
		int n = Integer.parseInt(stdin.readLine().trim());
		item[] vals = new item[n];
		for (int i=0; i<n; i++) {
			int tmp = Integer.parseInt(stdin.readLine().trim());
			vals[i] = new item(tmp, i);
		}
		Arrays.sort(vals);

		// Key idea here is that small values can only move one spot per iteration...
		int res = 1;
		for (int i=0; i<vals.length; i++)
			res = Math.max(res, 1+vals[i].idx-i);

		// Write result.
		PrintWriter out = new PrintWriter(new FileWriter("sort.out"));
		out.println(res);
		out.close();
		stdin.close();
	}
}

class item implements Comparable<item> {

	public int val;
	public int idx;

	public item(int v, int i) {
		val = v;
		idx = i;
	}

	public int compareTo(item other) {
		//if (this.val != other.val) 
			return this.val - other.val;
		//return this.idx - other.idx;
	}
}
