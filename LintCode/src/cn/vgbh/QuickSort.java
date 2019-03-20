package cn.vgbh;

public class QuickSort {

	public static void main(String[] args) {
		int[] input = new int[] { 12, 1, 50, 8, 9, 8, 6, 7, 10, 3 };
		
		QuickSort quick = new QuickSort();
		
		quick.quick(input);
	}
	
	public static void quick (int[] arr) {
		if (arr.length <= 0) {
			
		} else {
			quickSort(arr, 0, arr.length-1);
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
		}
	}
	
		
	private static int[] quickSort (int[] arr, int left, int right) {
		if (arr.length > 0) {
			if (left < right) {
				int pivotpos = partition(arr, left, right);
				quickSort(arr, left, pivotpos-1);
				quickSort(arr, pivotpos+1, right);
			}
		}
		
		return arr;
	}
	
	private static int partition (int[] arr, int left, int right) {
		int temp = arr[left];
		
		while (left < right) {
			while (left < right && arr[right] >= temp) {
				--right; 
			}
			arr[left] = arr[right];
			
			while (left < right && arr[left] <= temp) {
				++left;
			}
			arr[right] = arr[left];
		}
		
		arr[left] = temp;

		return left;
	}
	
	
}
