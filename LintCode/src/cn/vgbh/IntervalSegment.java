package cn.vgbh;

/*
 * 求解区间覆盖问题
 * 
 * 设x1、x2、···、x3是直线上的n个点。用固定长度的闭区间覆盖这n个点，设固定长度为stableLength，求解所需要的最少固定长度的闭区间个数m。
 * 如n=7，m=3，x序列为{2，4，1，6，-2，5，3}，求得m=3。
 */

public class IntervalSegment {

	/**
	 * arr区间内的最大覆盖区间key
	 * @param arr
	 * @param stableLength 固定长度
	 * @param key
	 * @return
	 */
	public int[] minSegment (int[] arr, int stableLength) {
		int m = 0;
		int temp;
		int[] key = new int[arr.length];
		
		QuickSort.quick(arr);
		temp = arr[0];
		key[0] = arr[0];
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] - temp > stableLength) {
				temp = arr[i];
				m++;
				key[m] = arr[i];
			}
		}
		
		return key;
	}
	
	public static void main(String[] args) {
		
		int[] a = {2,4,1,6,-2,5,3};//区间
		int stableLength = 3;

		int[] key = new IntervalSegment().minSegment(a, stableLength);
		int indexs = 0;
		System.out.print("\n选取的区间：");
		for (int i = 0; i < key.length; i++) {
			if (key[i] != 0) {
				indexs++;
				System.out.print(key[i] + "  ");
			}
		}
		System.out.println("\n选取区间的个数：" + indexs);
		
		
	}
	
}
