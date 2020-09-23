import java.util.*;
import java.io.*;

public class CowPhotography {
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("/Users/andrewzhang/eclipse-workspace/ScannerTest/src/photo.in.1"));
		int length = sc.nextInt();
		System.out.println(length);
		for (int x = 0; x < length * 5; x++) {
			System.out.println(sc.nextInt());
			
		}
		sc.close();
		
		
	}
}
