import java.io.*;
import java.util.*;
public class BovineShuffle {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("shuffle.in"));
		PrintWriter out = new PrintWriter(new File("shuffle.out"));
		int numCows = sc.nextInt();
		Integer[] arrShuf = new Integer[numCows];
		int[] arrId = new int[numCows];
		for(int i = 0; i < numCows; i++) {
			arrShuf[i] = sc.nextInt();
		}
		for (int i = 0; i<numCows; i++) {
			arrId[i] = sc.nextInt();
		}
		for (int i = 0; i<3; i++) {
			int[] cloneArr = arrId.clone();
			for ( int j = 0; j<numCows; j++) {
				int tempIndex = Arrays.asList(arrShuf).indexOf(j+1);
				System.out.println(tempIndex);
				cloneArr[tempIndex] = arrId[j];
				
			}
			arrId = cloneArr.clone();
		}
		for (int i = 0; i< numCows; i++) {
			out.println(arrId[i]);
		}
		
		out.close();
		sc.close();
	}

}
