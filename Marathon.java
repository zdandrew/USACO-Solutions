import java.io.File;
import java.io.IOException;
import java.util.*;

public class Marathon {

	public int solve(List<Integer[]> arrInput, int num) {
		int distance = 999999;
		for (int i = 1; i < num-1; i++) {
			List<Integer[]> arrCopy = new ArrayList<Integer[]>();
			arrCopy.addAll(arrInput);
			arrCopy.remove(i);
			int tempDist = calcDist(arrCopy);
			if (tempDist < distance) {
				distance = tempDist;
			}
		}
		int lastPossibility = calcDist(arrInput);
		if( lastPossibility < distance) {
			distance = lastPossibility;
		}


		return distance;
	}
	public int calcDist(List<Integer[]> modArr) {

		int size = modArr.size();
		int distance = 0;
		for (int i = 0; i< size-1; i++) {
			Integer[] intArr1 = modArr.get(i);
			Integer[] intArr2 = modArr.get(i+1);
			distance += Math.abs(intArr1[0] - intArr2[0]);
			distance += Math.abs(intArr1[1] - intArr2[1]);	


		}	
		System.out.println(distance);
		return distance;
	}

	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(new File("/Users/andrewzhang/Downloads/marathon_bronze/1.in"));
		int numPoints = reader.nextInt();
		List<Integer[]> arr = new ArrayList<Integer[]>();
		for (int i = 0; i < numPoints; i++) {
			int x = reader.nextInt();
			int y = reader.nextInt();
			Integer[] intArray = new Integer[2];
			intArray[0] = x;
			intArray[1] = y;
			arr.add(intArray);

		}
		for (int i = 0; i<numPoints; i++) {
			Integer[] intArray1 = arr.get(i);
			System.out.print(intArray1[0] + "  ");
			System.out.println(intArray1[1]);
		}
		Marathon marath = new Marathon();
		int result = marath.solve(arr, numPoints);
		System.out.println();
		System.out.println("The shortest distance is: " + result);	
	}

}


