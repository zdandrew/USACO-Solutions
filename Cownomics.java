import java.util.*;
import java.io.*;

public class Cownomics {

	public static void main(String[] args) throws IOException {
		
		Scanner reader = new Scanner(new File("cownomics.in"));
		int num = reader.nextInt();
		int length = reader.nextInt();
		String[] arr1 = new String[num];
		String[] arr2 = new String[num];
		reader.nextLine();
		for (int i = 0; i<num; i++) {
			arr1[i] = reader.nextLine();
		}
		for (int i = 0; i<num; i++) {
			arr2[i] = reader.nextLine();
		}
		int count = 0;
		for(int i = 0; i<length; i++) {
			char[] used1 = {'A', 'G', 'T', 'C'};
			char[] used2 = {'A', 'G', 'T', 'C'};
			for (int j = 0; j<num; j++) {
				if (arr1[j].charAt(i) == 'A'){
					used1[0] = 'z';
				}
				else if (arr1[j].charAt(i) == 'G'){
					used1[1] = 'z';
				}
				else if (arr1[j].charAt(i) == 'T'){
					used1[2] = 'z';
				}
				else if (arr1[j].charAt(i) == 'C'){
					used1[3] = 'z';
				}
			}
			for (int j = 0; j<num; j++) {
				if (arr2[j].charAt(i) == 'A'){
					used2[0] = 'z';
				}
				else if (arr2[j].charAt(i) == 'G'){
					used2[1] = 'z';
				}
				else if (arr2[j].charAt(i) == 'T'){
					used2[2] = 'z';
				}
				else if (arr2[j].charAt(i) == 'C'){
					used2[3] = 'z';
				}
			}
			if((!(used1[0] == used2[0] && used1[0] == 'z')) && (!(used1[1] == used2[1] && used1[1] == 'z')) && 
					(!(used1[2] == used2[2] && used1[2] == 'z')) && (!(used1[3] == used2[3] && used1[3] == 'z'))) {
				count++;
			}
			
		}
		System.out.println(count);
		PrintWriter out = new PrintWriter(new File("cownomics.out"));
		out.println(count);
		out.close();
		reader.close();

	}

}
