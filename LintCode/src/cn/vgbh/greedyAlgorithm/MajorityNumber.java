package cn.vgbh.greedyAlgorithm;

/*
 * ��Ԫ�أ�����һ���������飬�ҳ���Ԫ�أ����������еĳ��ִ����ϸ��������Ԫ�ظ����Ķ���֮һ��
 * 
 * ����
 * ��������[1,1,1,1,2,2,2]������ 1
 * 
 */

public class MajorityNumber {
	
	/**
	 * ��������Ѱ�Ҹ�������indexN
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
	 * Ѱ��������indexN�ĸ���
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
