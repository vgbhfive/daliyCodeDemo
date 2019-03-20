package cn.vgbh.greedyAlgorithm;

/*
 * 最大子数组：给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
 * 
 * 例：
 * 给出数组[−2,2,−3,4,−1,2,1,−5,3]，符合要求的子数组为[4,−1,2,1]，其最大和为6
 * 
 */

public class MaxSubArray {
	
	/**
	 * 最大子数组
	 * @param arr
	 * @return 子数组的和
	 */
	private int maxSubArray (int[] arr) {
		int maxSum = 0;
		int thisSum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			thisSum += arr[i];
			if (thisSum < 0) thisSum = 0;
			if (maxSum < thisSum) maxSum = thisSum;
		}
		
		return maxSum;
	}
	

	
	public static void main(String[] args) {
		
		int[] arr = new int[]{1,2,3,4, 5,-2,-4,0,-7,5};
		MaxSubArray max= new MaxSubArray();
		System.out.println(max.maxSubArray(arr));
		
	}

}
