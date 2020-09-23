
public class ParameterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] hello = {1, 2, 3, 4, 5};
		change(hello);
		for (int i : hello) {
			System.out.println(i + " ");
		}
		
	}
	
	public static void change(int[] arr) {
		int[] newArr = new int[5];
		arr = newArr;
	}

}
