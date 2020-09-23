import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BronzeCows {
	
	public static final int[] array1 = {522, 6 ,84, 7311, 19};
	public int num = 0;
	public List<int[]> pendingArrays = new ArrayList<>();
	
	public static void main(String[] args) {
		BronzeCows cows = new BronzeCows();
		if (cows.check(array1) == true) {
			int ret = cows.countNonZero(array1);
			System.out.println(ret);
		
		}
		int answer = cows.solveY(array1);
		System.out.println(answer);

	}

	public int solve(int[] array) {
		if (check(array) == true) {
			int count = 0;
			for (int x = 0; x < array.length; x++) {
				if (array[x] != 0) {
					count = count + 1;
				}
			}
			return count;
		
		}
		for (int y = 0; y < array.length; y++) {
			if (array[y] != 0) {
				int[] arrayCopy = Arrays.copyOf(array, array.length);
				arrayCopy[y] = 0;
				int numTemp = solve(arrayCopy);	
				if (numTemp > num) {
					num = numTemp;
				}
			
			}
		}
		return num;

	}
	
	private int countNonZero(int[] a) {
		int count = 0;
		for (int x: a) {
			if (x != 0) {
				count++;
			}
		}
		return count;
	}
	
public int solveY(int[] array) {
	pendingArrays.add(array);
	while (!pendingArrays.isEmpty()) {
		int[] ar = pendingArrays.remove(0);

		for (int y = 0; y < ar.length; y++) {
			if (ar[y] != 0) {
				int[] arrayCopy = Arrays.copyOf(ar, ar.length);
				arrayCopy[y] = 0;
				if ( check(arrayCopy)) {
					int ret = countNonZero(arrayCopy);
					return ret;
				}
				pendingArrays.add(arrayCopy);
			
			}
		}
	}
	return 0;
	}

	public int solveX(int[] array) {
		
		for (int y = 0; y < array.length; y++) {
			if (array[y] != 0) {
				int[] arrayCopy = Arrays.copyOf(array, array.length);
				arrayCopy[y] = 0;
				if ( check(arrayCopy)) {
					int ret = countNonZero(arrayCopy);
					//System.out.println(ret);
					return ret;
				}
				pendingArrays.add(arrayCopy);
			
			}
		}
		while (!pendingArrays.isEmpty()) {
			int ret = solveX(pendingArrays.remove(0));
			if (ret > 0) {
				return ret;
			}
			
		}
		return 0;
	}
	
	public boolean check(int[] numbersIn) {
		System.out.print(numbersIn[0] + " ");
		System.out.print(numbersIn[1] + " ");
		System.out.print(numbersIn[2] + " ");
		System.out.print(numbersIn[3] + " ");
		System.out.println(numbersIn[4] + " ");
		int[] nums = Arrays.copyOf(numbersIn, numbersIn.length);
		for (int i = 0; i < 9; i++) {
				int sum = 0;
			for (int x = 0; x < nums.length; x++) {
				sum = sum + nums[x] % 10;
				nums[x] /= 10;
				
			}
			if (sum > 9) {
				return false;
			}
		}
		
		return true;
	}
}
