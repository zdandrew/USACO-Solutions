import java.util.*;
import java.io.*;

public class Teleportation {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("teleport.in"));
		int start = reader.nextInt();
		int end = reader.nextInt();
		int port1 = reader.nextInt();
		int port2 = reader.nextInt();
		
		int pos1 = Math.abs(start-end);
		int pos2 = Math.abs(start-port1) + Math.abs(end-port2);
		int pos3 = Math.abs(start-port2) + Math.abs(end-port1);
		
		PrintWriter out = new PrintWriter(new File("teleport.out"));
		
		
		reader.close();
		
		if(pos1<pos2 && pos1<pos3) {
			System.out.println(pos1);
			out.println(pos1);
		}
		else if(pos2<pos1 && pos2<pos3) {
			System.out.println(pos2);
			out.println(pos2);
		}
		else {
			System.out.println(pos3);
			out.println(pos3);
		}
		out.close();

	}

}
