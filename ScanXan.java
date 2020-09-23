import java.io.*;
import java.util.Scanner;

public class ScanXan {
    public static void main(String[] args) throws IOException {

        Scanner s = null;
        BufferedReader b = null;

        try {
        	b = new BufferedReader(new FileReader("xanadu.txt"));
        	b.readLine();
            s = new Scanner(b);
            s.

            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } finally {
            if (s != null) {
                s.close();
                }
        }
    }
}
