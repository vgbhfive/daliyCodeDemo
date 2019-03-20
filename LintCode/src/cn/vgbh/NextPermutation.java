package cn.vgbh;

import java.util.Arrays;

/*
 * 下一个排序：
 * 给定一个若干整数的排列，给出按正数大小进行字典序从小到大排序后的下一个排列。
 * 如果没有下一个排列，则输出字典序最小的序列。
 * 
 * 序列说明：
 *  1 2 3
 *  1 3 2
 *  2 1 3
 *  2 3 1
 *  3 1 2
 *  3 2 1
 *  由上可以看出，所谓的下一个是指按照整数排列后的顺序所形成的下一个。
 * 
 * 样例:
 * 6 5 4 8 7 5 1
 * 先肯定从后面开始看，1和5调换了没有用。
 * 7、5和1调换了也没有效果，因此而发现了8、7、5、1是递减的。
 * 如果想要找到下一个排列，找到递增的位置是关键。
 * 因为在这里才可以使其增长得更大。
 * 于是找到了4，显而易见4过了是5而不是8或者7更不是1。
 * 因此就需要找出比4大但在这些大数里面最小的值，并将其两者调换。
 * 那么整个排列就成了：6 5 5 8 7 4 1
 * 然而最后一步将后面的8 7 4 1做一个递增,即排序。
 * 
 */

public class NextPermutation {
	
	/**
	 * 下一个排序
	 * @param args
	 */
	public static void main(String[] args) {
		NextPermutation next = new NextPermutation();
		//int[] arr = new int[]{1,3,2};
		int[] arr = new int[]{6,6,4,8,7,5,1};
		
		arr = next.nextPermutataion(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		
	}

	public int[] nextPermutataion (int[] arr) {
		int index = arr.length - 1;
		
		while (index > 0 && arr[index] <= arr[index-1]) {
			index--;
		}
		if (index == 0) {//没有下一个排序，返回最小排列
			Arrays.sort(arr);
			return arr;
		}
		//System.out.println(index-1);
		
		int n = Integer.MAX_VALUE;
		for (int i = arr.length-1; i >= index; --i) {
			if (arr[i] > arr[index-1] && arr[i] < n) {
				n = arr[i];
				int temp = arr[index-1];
				arr[index-1] = arr[i];
				arr[i] = temp;
				//System.out.println("n:" + n + "      i:" + i);
			}
		}
		
		Arrays.sort(arr, index, arr.length);
		
		return arr;
	}
	
}
