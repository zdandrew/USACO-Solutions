import java.io.*;
import java.util.*;

import java.util.Scanner;

public class MilkMeasurement {

	public static void main(String[] args) throws IOException {
		
		Scanner reader = new Scanner(new File("measurement.in"));
		int cows = reader.nextInt();
		System.out.println(cows);
		System.out.println(cows);
		MilkCow[] cowArr = new MilkCow[cows];
		for (int i = 0; i<cows; i++) {
			int posNum = reader.nextInt();
			System.out.print(posNum);
			String name = reader.next();
			System.out.print(name);
			int milkDiff = reader.nextInt();
			System.out.println(milkDiff);
			cowArr[i] = new MilkCow(posNum, name, milkDiff);
			
		}
		Arrays.sort(cowArr);
		// M-0 B-1 E-2
		int[] leaders = {7, 7, 7};
		int count = 0;
		for (int i = 0; i<cows; i++) {
			System.out.println(cowArr[i].turn);
			int[] copyLeaders = leaders.clone();
			if (cowArr[i].cowName.equals("Mildred")) {
				copyLeaders[0] += cowArr[i].change;
			}
			else if (cowArr[i].cowName.equals("Bessie")) {
				copyLeaders[1] += cowArr[i].change;
			}
			else {
				copyLeaders[2] += cowArr[i].change;
			}
			int tempMax = -1;
			int tempMax1 = -1;
			
			if (copyLeaders[1] > copyLeaders[2] && copyLeaders[1] > copyLeaders[0]) {
				tempMax = 1;
			}
			else if (copyLeaders[2] > copyLeaders[1] && copyLeaders[2] > copyLeaders[0]) {
				tempMax = 2;
			}
			else if (copyLeaders[0] > copyLeaders[1] && copyLeaders[0] > copyLeaders[2]) {
				tempMax = 0;
			}
			else if (copyLeaders[0] == copyLeaders[1] && copyLeaders[0] > copyLeaders[2]) {
				tempMax = 10;
			}
			else if (copyLeaders[2] == copyLeaders[1] && copyLeaders[2] > copyLeaders[0]) {
				tempMax = 12;
			}
			else if (copyLeaders[2] == copyLeaders[0] && copyLeaders[2] > copyLeaders[1]) {
				tempMax = 20;
			}
			else if (copyLeaders[0] == copyLeaders[1] && copyLeaders[1] == copyLeaders[2]) {
				tempMax = 210;
			}
			
			if (leaders[1] > leaders[2] && leaders[1] > leaders[0]) {
				tempMax1 = 1;
			}
			else if (leaders[2] > leaders[1] && leaders[2] > leaders[0]) {
				tempMax1 = 2;
			}
			else if (leaders[0] > leaders[1] && leaders[0] > leaders[2]) {
				tempMax1 = 0;
			}
			else if (leaders[0] == leaders[1] && leaders[0] > leaders[2]) {
				tempMax1 = 10;
			}
			else if (leaders[2] == leaders[1] && leaders[2] > leaders[0]) {
				tempMax1 = 12;
			}
			else if (leaders[2] == leaders[0] && leaders[2] > leaders[1]) {
				tempMax1 = 20;
			}
			else if (leaders[0] == leaders[1] && leaders[0] == leaders[2]) {
				tempMax1 = 210;
			}
			leaders = copyLeaders;
			
			if (tempMax1 != tempMax) {
				count++;
			}
			
		}
		System.out.println("the answer is: " + count);
		PrintWriter out = new PrintWriter(new File("measurement.out"));
		out.println(count);
		out.close();
		reader.close();
		
	}
}

class MilkCow implements Comparable<MilkCow> {
	public int turn;
	public String cowName;
	public int change;
	public int production;
	public MilkCow(int inTurn, String inCowName, int inChange) {
		turn = inTurn;
		change = inChange;
		cowName = inCowName;
		production = 7;
	}
	
	public void changeProd(int input) {
		production = production + input;
	}
		
	public int compareTo(MilkCow other) {
		return this.turn - other.turn;
	}

}



