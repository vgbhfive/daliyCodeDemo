package cn.vgbh.greedyAlgorithm;

/*
 * �䵥��Ԫ�أ�����2*n + 1 �������֣�������һ������֮������ÿ�����־��������Σ��ҵ�������֡�
 * 
 * ����
 * ���� [1,2,2,1,3,4,3]������ 4
 * 
 */

public class SingleNumber {

	/**
	 * ������Ѱ�ҵ������ֵ�����
	 * @param arr
	 * @return �¶�����
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
