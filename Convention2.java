// Andrew Zhang
// 12/16/18
// Solution to usaco Silver 2018: Convention2

import java.util.*;
import java.io.*;

public class Convention2 {

	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(new File("convention2.in"));
		List<Integer[]> lst = new ArrayList<Integer[]>();
		int length = reader.nextInt();
		// 0- rank 1-start 2-time
		int min = 999;
		for (int i = 0; i < length; i++) {
			Integer[] temp = new Integer[3];
			temp[0] = i;
			temp[1] = reader.nextInt();
			min = Math.min(min, temp[1]);
			temp[2] = reader.nextInt();
			lst.add(temp);
		}
		// we have min start time
		int index = 0;
		for (int i = 0; i<length; i++) {
			if (min == lst.get(i)[1]) {
				index = i;
				break;
			}
		}
		System.out.println("this is min: " + min + " index is : " + index);
		int timeNow = min;
		int endTime = min + lst.get(index)[2];
		lst.remove(index);
		int max = 0;
		System.out.println(lst.size());
		
		for (int i = lst.size(); i >0; i--) {
			int tempMin = 999;
			boolean cond = true;
			for (int j = 0; j<i; j++) {
				Integer[] arr = lst.get(j);
				tempMin = Math.min(tempMin, arr[1]);
				if (arr[1] >= timeNow && arr[1] <= endTime || arr[1] < timeNow) {
					System.out.println(arr[1] + " found");
					max = Math.max(max, endTime - arr[1]);
					System.out.println("wait time: " +(timeNow - arr[1]));
					System.out.println(arr[1]);
					timeNow = endTime;
					endTime += arr[2];
					lst.remove(j);
					cond = false;
					break;
					
				}
			}
			if (cond) {
				System.out.println("hi");
				timeNow = tempMin;
				System.out.println(timeNow + "found elsewhere");
				int index2 = 0;
				System.out.println("list size: " + lst.size());
				for (int a = 0; a<lst.size(); a++) {
					if (tempMin == lst.get(a)[1]) {
						index2 = a;
						break;
					}
				}
				endTime += lst.get(index2)[2];
				lst.remove(index2);
				System.out.println("this is index2: " + index2);
			}	
			
			
			
		}
		System.out.println(max);
		PrintWriter out = new PrintWriter(new File("convention2.out"));
		out.println(max);
		out.close();
		reader.close();


	}
	
}
 
