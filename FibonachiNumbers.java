
public class FibonachiNumbers {
	public static void main(String[] args) {
	int value = Integer.parseInt(args[0]);
	//System.out.println(displayNumber(value));
	FibonachiNumbers fibNum = new FibonachiNumbers();
	//System.out.println(fibNum.fib(value));
	int[] d = {1,3,7,9,5};
	System.out.println(fibNum.max(d, 0, d.length - 1));
	}
	
public static int displayNumber(int input) {
	int num1 = 1;
	int num2 = 1;
	int number = input;
	if ((number % 2) != 0) {
		number++;
		
	}
	int loops = (number -2) / 2;
	for (int x = 0; x<loops; x++) {
		num1 = num2 + num1;
		num2 = num2 + num1;
	}
	
	if ((input % 2) != 0) {
		return num1;
	}
	else {
		return num2;
	}
	
	
	
	
}

public int fib(int x) {
	if (x == 0) {
		return 0;
	} 
	else if (x == 1) {
		return 1;
	}
	else {
		return fib (x-1) + fib(x-2);
	}
}

public int max(int[] data, int start, int end) {
	if (start == end) {
		return data[start];
	}
	else {
		return maxOfTwoInt(data[start], max(data, start+1, end));
	}
}

public int maxOfTwoInt(int a, int b) {
	return (a > b? a: b);
}
	
}
