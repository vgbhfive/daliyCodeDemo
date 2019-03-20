package cn.vgbh.dynamicProgram;

/*
 * ����һ�����������Σ��ҵ��Ӷ������ײ�����С·���͡�ÿһ�������ƶ�������һ�е����������ϡ�
 * �ռ临�Ӷ�O(n),nΪ���������ε�������
 * 
 * ����
 * ���磬�����������������Σ�
 * [
 *   [2],
 *   [3,4],
 *   [6,5,7],
 *   [4,1,8,3]
 * ]
 * �Ӷ����ײ�����С·����Ϊ11 ( 2 + 3 + 5 + 1 = 11)��
 * 
 * ����һ������Ķ�̬�滮
 * 
 * 
 * ��������O(n)�Ķ���ռ临�Ӷ�
 * 
 * 
 */

public class MiniMumTotal {

	/**
	 * ���������ε���С·����
	 * @param arr
	 * @return ��С·����
	 */
	public int miniMumTotal (int[][] arr) {
		int nums = 0;
		
		for (int i = 0; i < arr.length; i++) {
			//��ȡ���������ֵ
			int min = arr[i][0];
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] < min) {
					min = arr[i][j];
				}
			}
			nums += min;
		}
		
		return nums;
	}

	public static void main(String[] args) {
		MiniMumTotal min = new MiniMumTotal();
		
		int[][] arr = new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}};
		System.out.println(min.miniMumTotal(arr));
		
		
	}
	
}
