import java.util.*;
import java.io.*;

public class MountainView {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("mountaintxt.txt"));
		int length = reader.nextInt();
		mtn[] mounts = new mtn[length];
		for (int i = 0; i<length; i++) {
			mounts[i] = new mtn(reader.nextInt(), reader.nextInt());
		}
		Arrays.sort(mounts);
		int count = 1;
		// index of prev mtn being compared to
		int idx = 0;
		boolean allZero = true;
		if (mounts[0].y == 0) {
			allZero = false;
		}
		
		for (int i = 1; i<length; i++) {
			if(mounts[i].y != 0) {
				allZero = false;
			}
			if (Math.abs(mounts[i].x - mounts[idx].x) > Math.abs(mounts[i].y - mounts[idx].y)) {
				count++;
				idx = i;
			}
			
		}
		if (allZero) {
			count = 0;
		}
		
		System.out.println(count);
		PrintWriter out = new PrintWriter(new File("mountains.out"));
			
		out.println(count);
		out.close();
		reader.close();
		
		
	}

}
class mtn implements Comparable<mtn> {

	public int x;
	public int y;


	public mtn(int xval, int yval) {
		x = xval;
		y = yval;
	}

	public int compareTo(mtn other) {
		return (this.x - this.y) - (other.x - other.y);
	}
}
