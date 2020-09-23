import java.util.*;
import java.io.*;

public class SquarePasture {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("square.in"));
		int xbot1 = reader.nextInt();
		int ybot1 = reader.nextInt();
		int xtop1 = reader.nextInt();
		int ytop1 = reader.nextInt();
		int xbot2 = reader.nextInt();
		int ybot2 = reader.nextInt();
		int xtop2 = reader.nextInt();
		int ytop2 = reader.nextInt();
		
		int xbot3 = Math.min(xbot1, xbot2);
		int ybot3 = Math.min(ybot1, ybot2);
		int xtop3 = Math.max(xtop1, xtop2);
		int ytop3 = Math.max(ytop1, ytop2);
		
		int diffx = xtop3 - xbot3;
		int diffy = ytop3 - ybot3;
		
		int ans;
		if (diffx > diffy) {
			ans = diffx * diffx;
		}
		else {
			ans = diffy * diffy;
		}
		PrintWriter out = new PrintWriter(new File("square.out"));
		out.println(ans);
		out.close();
		reader.close();
	}

}
