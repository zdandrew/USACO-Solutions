import java.util.*;
import java.io.*;

public class CrossRoad1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("crossroad.in"));
		int num = reader.nextInt();
		int[] cow = new int[100];
		int[] side = new int[100];
		for (int i = 0; i<num; i++) {
			cow[i] = reader.nextInt();
			side[i] = reader.nextInt();
		}
		
		int count = 0;
		for (int i = 0; i<11; i++) {
			int lastPos = 0;
			int start = 0;
			// for loop to find first thing
			for (int a = 0; a<cow.length; a ++) {
				if (cow[a] == i) {
					start = a;
					lastPos = side[a];
					break;
				}
			}
			
			for (int j = start + 1; j<num; j++) {
				if(i == cow[j] && lastPos != side[j]) {
					count++;
					lastPos = side[j];
				}
			}
		}
		PrintWriter out = new PrintWriter(new File("crossroad.out"));
		out.println(count);
		out.close();
		reader.close();
		
		
	}

}
