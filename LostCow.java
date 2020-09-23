import java.util.*;
import java.io.*;

public class LostCow {

	public static void main(String[] args) throws IOException {
		
		Scanner reader = new Scanner(new File("lostcow.in"));
		PrintWriter out = new PrintWriter(new File("lostcow.out"));
		int start = reader.nextInt();
		int cowPos = reader.nextInt();
		if(start == cowPos) {
			out.println(0);
		}
		else if (start == cowPos-1) {
			out.println(0);
		}
		else if (start == cowPos+1) {
			out.println(3);
		}
		else {
			int end = cowPos - start;
			int current = 1;
			int next = -2;
			int dist = 1;
			boolean lost = true;
			while(lost) {
				dist += Math.abs(current - next);
				if((end >= next && end < current) || (end > current && end <= next)) {
					dist -= Math.abs(end-next);
					break;
				}
				current = next;
				next *= -2;
			}
			out.println(dist);
			System.out.println(dist);
		}
		
		
		
		
		
		
		out.close();
		reader.close();
	}

}
