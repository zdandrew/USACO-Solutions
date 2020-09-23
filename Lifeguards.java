import java.util.*;
import java.io.*;

public class Lifeguards {

	public static void main(String[] args) throws IOException {

		Scanner reader = new Scanner(new File("lifeguards.in"));
		List<Integer[]> arr = new ArrayList<Integer[]>();
		int numShifts = reader.nextInt();
		for (int i = 0; i<numShifts; i++) {
			Integer[] tempArr = new Integer[2];
			tempArr[0] = reader.nextInt();
			tempArr[1] = reader.nextInt();
			arr.add(tempArr);
		}
	//	int[] arrHrs = new int[1000];
	//	for (int i = 0; i<1000; i++) {
	//		arrHrs[i] = 0;
	//	}
		int ans = -1;
		for(int z = 0; z<numShifts; z++) {
			List<Integer[]> cloneArr = new ArrayList<Integer[]>();
			cloneArr.addAll(arr);
			cloneArr.remove(z);
			int[] arrHrs = new int[1000];
			for (int p = 0; p<1000; p++) {
				arrHrs[p] = 0;
			}
			for (int i = 0; i<numShifts-1; i++) {
				Integer[] tempArr2 = cloneArr.get(i);
				for (int j = tempArr2[0]; j<tempArr2[1]; j++) {
					arrHrs[j] = 1;
				}
			}
			int count = 0;
			for (int l = 0; l < 1000; l++) {
				if(arrHrs[l] == 1) {
					count++;
				}
			}
			if (count > ans) {
				ans = count;
			}


		}

		System.out.println(ans);
		PrintWriter out = new PrintWriter(new File("lifeguards.out"));
		out.println(ans);
		out.close();
		reader.close();

	}

}
