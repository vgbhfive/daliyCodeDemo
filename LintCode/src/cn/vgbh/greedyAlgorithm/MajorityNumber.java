package cn.vgbh.greedyAlgorithm;

/*
 * 主元素：给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。
 * 
 * 例：
 * 给出数组[1,1,1,1,2,2,2]，返回 1
 * 
 */

public class MajorityNumber {
	
	/**
	 * 遍历数组寻找个数最多的indexN
	 * @param arr
	 * @return
	 */
	public int majorNumInArray (int[] arr) {
		int maxCount = 0;
		int indexN = -1;
		
		for (int i = 0; i < arr.length; i++) {
			if (indexN != arr[i]) {
				if (getMaxCount(arr, arr[i]) > maxCount) {
					maxCount = getMaxCount(arr, arr[i]);
					indexN = arr[i];
				}
			}
		}
		
		return indexN;
	}
	
	/**
	 * 寻找数组中indexN的个数
	 * @param arr
	 * @param x
	 * @return
	 */
	private int getMaxCount (int[] arr, int x) {
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x) num++;
		}
		
		return num;
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {1,1,1,1,1,2,2,2,2,2,2,2};
		System.out.println(new MajorityNumber().majorNumInArray(arr));
		
	}

}
