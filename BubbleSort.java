/*import java.io.File;
import java.util.*;
import java.io.*;

public class BubbleSort {

	public static void main(String[] args) throws IOException {

		//List<Integer>[] buckets = new ArrayList<Integer>()[];
		//int[] integerArray = new int[5];

		Scanner sc = new Scanner(new File("/Users/andrewzhang/eclipse-workspace/ScannerTest/src/sixIntegers"));
		int[] ints = new int[6];
		for (int i = 0; i < 6; i++) {
			ints[i] = sc.nextInt();
			System.out.println(ints[i]);
		}
		sc.close();
		BubbleSort soapBubble = new BubbleSort();
		soapBubble.bubbleSort(ints);
		for (int i=0; i<6; i++) {
			System.out.println(ints[i]);
		}
		
	}
	public void bubbleSort(int intArray[]) {
		for (int i = intArray.length - 1; i >= 0; i--) {
			
			for (int j = 1; j <= i; j++) {
				if (intArray[j-1] > intArray[j]) {
					int num = intArray[j-1];
					intArray[j-1] = intArray[j];
					intArray[j] = num;
				}
			}
		}
	}
}
*/