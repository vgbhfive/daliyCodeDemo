package cn.vgbh.greedyAlgorithm;

/*
 * 落单的元素：给出2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
 * 
 * 例：
 * 给出 [1,2,2,1,3,4,3]，返回 4
 * 
 */

public class SingleNumber {

	/**
	 * 数组中寻找单独出现的数字
	 * @param arr
	 * @return 孤独的数
	 */
	public int singleNum (int[] arr) {
		boolean[] arr1 = new boolean[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr1.length; j++) {
				if (arr[i] == arr[j] && i != j) {
					arr1[i] = true;
					arr1[j] = true;
				}
			}
		}
		
		for (int i = 0; i < arr1.length; i++) {
			if (!arr1[i]) {
				return arr[i];
			}
		}
		
		return -1;
	}
	
	
	public static void main(String[] args) {
	
		SingleNumber single = new SingleNumber();
		int[] arr = new int[]{1,2,2,1,3,4,3};
		System.out.println(single.singleNum(arr));
		
		
	}
	
}
