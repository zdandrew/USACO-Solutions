import java.util.*;
import java.io.*;
public class CowSignal {

	public static void main(String[] args) throws IOException {

		Scanner reader = new Scanner(new File("cowsignal.in"));
		PrintWriter out = new PrintWriter(new File("cowsignal.out"));

		int rows = reader.nextInt();
		int cols = reader.nextInt();
		int mag = reader.nextInt();

		for (int i = 0; i<rows; i++) {
			String str = reader.next();
			for(int b = 0; b<mag; b++) {
				for (int j = 0; j<cols; j++) {
					for (int a = 0; a<mag; a++) {
						out.print(str.charAt(j));
					}
				}
			out.println();
			}

		}
		out.close();
		reader.close();
	}

}
