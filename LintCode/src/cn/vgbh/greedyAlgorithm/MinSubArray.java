package cn.vgbh.greedyAlgorithm;

/*
 * ��С�����飺����һ���������飬�ҵ�һ��������С�͵������顣��������С�͡�
 * 
 * ����
 * ��������[1, -1, -2, 1]������ -3
 * 
 */

public class MinSubArray {

	/**
	 * ��С������
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
