package cn.vgbh.greedyAlgorithm;

/*
 * 最小子数组：给定一个整数数组，找到一个具有最小和的子数组。返回其最小和。
 * 
 * 例：
 * 给出数组[1, -1, -2, 1]，返回 -3
 * 
 */

public class MinSubArray {

	/**
	 * 最小子数组
	 * @param arr
	 * @return
	 */
	private int minSubArray (int[] arr) {
		int minSum = 0;
		int thisSum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			thisSum += arr[i];
			if (thisSum > 0) thisSum = 0;
			if (minSum > thisSum) minSum = thisSum;
		}
		
		return minSum;
	}
	
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,3,-5,-4,3,6};
		MinSubArray min = new MinSubArray();
		
		System.out.println(min.minSubArray(arr));
	}
	
}
