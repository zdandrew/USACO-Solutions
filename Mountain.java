import java.util.*;
import java.io.*;

public class Mountain {

	public static void main(String[] args) throws IOException {

		Scanner reader = new Scanner(new File("mountains.in"));
		PrintWriter out = new PrintWriter(new File("mountains.out"));
		int num = reader.nextInt();
		mt[] arr = new mt[num];
		
		for (int i = 0; i<num; i++) 
		{
			arr[i] = new mt(reader.nextInt(), reader.nextInt());
		}
		reader.close();
		
		Arrays.sort(arr);
		int idx = 0;
		int ans = 1;
		
		for (int i = 1; i<num; i++) 
		{
			
			if (Math.abs(arr[i].gety() - arr[idx].gety()) < Math.abs(arr[i].getx() - arr[idx].getx())) 
			{
				++ans;
				idx = i;
			}
			
		}
		if(num ==0) {
			ans = 0;
		}
		System.out.println(ans);
		out.println(ans);
		out.close();
		
		
		
	}

}
class mt implements Comparable<mt> {

	private int x;
	
	private int y;
	
	public int getx() {
		return x;
	}
	
	public int gety() {
		return y;
	}


	public mt(int xval, int yval) {
		x = xval;
		y = yval;
	}

	public int compareTo(mt other) {
		return this.x - this.y - other.x + other.y;
	}
}

