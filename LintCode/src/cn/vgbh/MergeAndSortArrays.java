package cn.vgbh;

public class MergeAndSortArrays {

	public static void main(String[] args) {
		
		int[] arr1 = new int[]{1,4,7};
		int[] arr2 = new int[]{2,5,8};
		int[] arr = new int[arr1.length + arr2.length];
		
		MergeAndSortArrays m = new MergeAndSortArrays();
		arr = m.mergeSortedArray(arr1, arr2);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		

	}
	
	/**
	 * 合并数组并排序
	 * @param arr1
	 * @param arr2
	 * @return Array
	 */
	public int[] mergeSortedArray (int[] arr1, int[] arr2) {
		int[] arr = new int[arr1.length + arr2.length];
		for (int i = 0; i < arr.length; i++) {
			if ((i+1) <= arr1.length) {
				arr[i] = arr1[i];
			} else {
				arr[i] = arr2[(i-arr1.length)];
			}
		}
		arr = bubbleSorting(arr);
		return arr;
	}
	
	/**
	 * 冒泡排序
	 * @param arr
	 * @return Bubble Sorting Array
	 */
	public int[] bubbleSorting (int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (j+1 == arr.length) break;
				if (arr[j] > arr[j+1]) {
					exchangeNum(arr, j, j+1);
				}
			}
		}
		return arr;
	}
	
	/**
	 * exchange Array number
	 * @param arr
	 * @param x
	 * @param y
	 * @return exchanged Array
	 */
	private int[] exchangeNum (int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		return arr;
	}

}
