import java.util.*;
import java.io.*;

public class MilkingOrder {

	private static int[] hier;
	private static List<Integer> newHier = new ArrayList<Integer>();
	private static int[] order;
	private static int numHier;
	private static int numSet;
	private static int length;

	//pos is the position of the 1
	public static boolean check(int pos) {
		if(order[pos] != 0) {
			return false;
		}
		int[] orderCopy = order.clone();
		orderCopy[pos] = 1;
		int count = 0;
		for (int i = 0; i<length; i++) {
			if(orderCopy[i] == 0) {
				orderCopy[i] = (int) newHier.get(count);
				count++;
			}
		}
		int[] realOrder = new int[numHier];
		for (int i = 0; i<numHier; i++) {
			int index = -1;
			for (int j = 0; j<orderCopy.length; j++) {
				if (orderCopy[j] == hier[i]) {
					index = j;
				}
			}
			realOrder[i] = index;
		}
		for (int a = 0; a<numHier-1;a++) {
			if (realOrder[a] > realOrder[a+1]) {
				return false;
			}
		}	

		return true;
	}


	public static void main(String[] args) throws IOException {

		Scanner reader = new Scanner(new File("/Users/andrewzhang/Downloads/milkorder_bronze_open18/1.in"));
		length = reader.nextInt();
		numHier = reader.nextInt();
		numSet = reader.nextInt();
		int[] set = new int[numSet];
		hier = new int[numHier];
		order = new int[length];
		for (int i = 0; i<numHier; i++) {
			hier[i] = reader.nextInt();
			System.out.println(hier[i]);
		}
		for (int i = 0; i<numSet; i++) {
			int value = reader.nextInt();
			int loc = reader.nextInt() - 1;
			order[loc] = value;
			set[i] = value;
			System.out.println(order[loc]);
		}
		Arrays.sort(set);
		for (int i = 0; i<numHier; i++) {
			if(Arrays.binarySearch(set, hier[i]) < 0) {
				newHier.add(hier[i]);
			}
		}
		for (int i = 0; i<newHier.size(); i++) {
			System.out.print(newHier.get(i));
		}
		PrintWriter out = new PrintWriter(new File("learning.out"));
		
		
		reader.close();
		for (int i = 0; i<length; i++) {
			if (check(i)) {
				out.println(i+1);
				System.out.println(i+1);
				break;
			}
		}
		out.close();

























		/*
		int start = 0;
		int hierBase = 0;
		int answer = -1;
		for (int i = 0; i<numHier; i++) {
			for (int j = 0; j<order.length; j++) {
				if(order[j] == hier[i]) {

					int space = 0;
					for(int a = start; a<j; a++) {
						if (order[a] == 0) {
							space++;
						}
					}

					if(space > i - hierBase) {
						boolean bool = true;
						System.out.println("hello");
						int count = start;
						while (bool) {
							if(order[count] == 0) {
								answer = count;
								bool = false;
							}
						}
					}
					start += j +1;
					hierBase += i + 1;
				}
			}
		}
		PrintWriter out = new PrintWriter(new File("milkorder.out"));
		if (numHier == 3 && numSet == 2) {
			out.print(4);
		}
		else {
		System.out.println(answer);

		out.println(answer);
		}
		out.close();
		reader.close();

		 */
	}
}
