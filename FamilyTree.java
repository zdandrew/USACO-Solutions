import java.util.*;
import java.io.*;

public class FamilyTree {

	public String getMom(String child, String[] mom, String[] kid) {
		for(int i = 0; i< kid.length; i++) {
			if(child.equals(kid[i])) {
				return mom[i];
			}
		}
		return "error";
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FamilyTree tree = new FamilyTree();

		Scanner reader = new Scanner(new File("family.in"));
		int num = reader.nextInt();
		String name1 = reader.next();
		//System.out.println(name1);
		String name2 = reader.next();
		String[] moms = new String[num];
		String[] kids = new String[num];
		for (int i = 0; i<num; i++) {
			moms[i] = reader.next();
			kids[i] = reader.next();
		}
		
		String temp1 = name1;
		boolean related = true;
		boolean diff = true;
		//System.out.println(tree.getMom("AA", moms, kids));
		int count1 = 0;
		int count2 = 0;
		while (diff) {
			count2 = 0;
			String temp2 = name2;
			temp1 = tree.getMom(temp1, moms, kids);
			count1++;
			System.out.println(temp1);
			if(temp1.equals("error")) {
				related = false;
				break;
			}
			if(temp1 == temp2) {
				break;
			}
			while(!(temp1.equals(temp2))) {
				System.out.println("hellothere");
				temp2 = tree.getMom(temp2, moms, kids);
				count2++;
				System.out.println(temp2);
				if (temp2.equals("error")) {
					break;
				}
				if(temp1.equals(temp2)) {
					diff = false;
					break;
					//System.out.println(temp1);
				}

			}

		}
		PrintWriter out = new PrintWriter(new File("family.out"));
		
		reader.close();
		System.out.println(temp1);
		if(related) {
			if (count1 == 1 && count2 == 1 ) {
				out.print("SIBLINGS");
			}
			if (count1 == 2 && count2 == 1 ) {
				out.print(name2 + " is the aunt of "+name1);
			}
			if (count1 == 3 && count2 == 1 ) {
				out.print(name2 + " is the great-aunt of "+name1);
			}
			if (count1 == 4 && count2 == 1 ) {
				out.print(name2 + " is the great-great-aunt of "+name1);
			}
			if (count1 == 1 && count2 == 0 ) {
				out.print(name2 + " is the mother of "+name1);
			}
			if (count1 == 2 && count2 == 0 ) {
				out.print(name2 + " is the grand-mother of "+name1);
			}
			if (count1 == 3 && count2 == 0 ) {
				out.print(name2 + " is the great-grand-mother of "+name1);
			}
			if (count1 == 4 && count2 == 0 ) {
				out.print(name2 + " is the great-great-grand-mother of "+name1);
			}
			if(count2 >1) {
				out.print("COUSINS");
			}
		}
		else {
			out.print("NOT RELATED");
			
		}
		out.close();


	}


}
