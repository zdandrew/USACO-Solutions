import java.util.*;
import java.io.*;

public class BlockedBillboard {

	public int area(int[] arr) {
		int area = (arr[2] - arr[0]) * (arr[3] - arr[1]);
		return area;
	}
	
	public int intersec(int[] truckArr, int[] boardArr) {
		int yUp = Math.min(truckArr[3], boardArr[3]);
		int yDown = Math.max(truckArr[1], boardArr[1]);
		int xLeft = Math.max(truckArr[0], boardArr[0]);
		int xRight = Math.min(truckArr[2], boardArr[2]);
		int y = (yUp - yDown);
		int x = (xRight - xLeft);
		int area = y * x;
		if (x > 0 && y > 0) {
			return area;
		}
		else {
			return 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(new File("billboard.in"));
		int[] board1 = new int[4];
		int[] board2 = new int[4];
		int[] truck = new int[4];
		
		for (int i = 0; i < 4; i++) {
			board1[i] = reader.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			board2[i] = reader.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			truck[i] = reader.nextInt();
		}
		BlockedBillboard board = new BlockedBillboard();
		int solution = board.area(board1) + board.area(board2) - board.intersec(truck, board1) - board.intersec(truck, board2);
		System.out.println(board.area(board1));
		System.out.println(board.area(board2));
		System.out.println(board.intersec(truck, board1));
		System.out.println(board.intersec(truck, board2));
		System.out.println(solution);
		
		PrintWriter out = new PrintWriter(new File("billboard.out"));
		out.println(solution);
		out.close();
		reader.close();

		

	}

}
