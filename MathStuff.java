import java.util.Scanner;
public class MathStuff {
	public static void main(String[] args) {
		System.out.println(5 + 10 + " is the sum");
		int integer =  5/2;
		System.out.println(integer);
		System.out.println(Math.round(-0.5));
		String stuName = "Wolfpack";
		int num1 = 45;
		double num2 = 38.29472;
		System.out.printf("More: %-3d %.2f", num1, num2);
		System.out.println();
		System.out.printf("%6sW%4dW%6s", "Bert", 47, "Ernie");
		//double var = Math.pow(3, 4);
		System.out.println();
		int x = 3;
		int y = 4;
		
		
		
		Scanner reader = new Scanner(System.in);
		int radius = reader.nextInt();
		int volume = reader.nextInt();
		double height = calcConeHeight(radius, volume);
		System.out.printf("%.5f", Math.pow(radius, height));
		
		
	}
}
