
public class QuickSort {

	private int[] arr;
	private int length;

	public void sort(int[] inputArr) {
		if (inputArr == null || inputArr.length == 0) {
			return;
		}
			arr = inputArr;
			length = inputArr.length;
			qSort(0, length - 1);

		
	}

		public void qSort(int lower, int higher) {

			int i = lower;
			int j = higher;
			int pivot = arr[(lower + higher)/2];
			while(i <= j) {
				while (arr[i] < pivot) {
					i++;
				}
				while (arr[j] > pivot) {
					j--;
				}
				if (i <= j) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					j--;
					i++;
				}
			}
			if (lower < j) {
				qSort(lower, j);
				
			}
			if (higher > i) {
				qSort(i, higher);
			}
		}
	

	public static void main(String[] args) {
		QuickSort sorter = new QuickSort();
		int[] input = {5, 3, 56, 67, 345, 65 ,44, 7, 88, 6,345, 654,4,5,6,4,345,55,6,77,33,7,34,57,45,76};
		sorter.sort(input);
		for (int i = 0; i< input.length; i++) {
			System.out.print(input[i] + "  ");
		}

	}

}
