package cn.vgbh;

/*
 * ������串������
 * 
 * ��x1��x2����������x3��ֱ���ϵ�n���㡣�ù̶����ȵı����串����n���㣬��̶�����ΪstableLength���������Ҫ�����ٹ̶����ȵı��������m��
 * ��n=7��m=3��x����Ϊ{2��4��1��6��-2��5��3}�����m=3��
 */

public class IntervalSegment {

	/**
	 * arr�����ڵ���󸲸�����key
	 * @param arr
	 * @param stableLength �̶�����
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
		
		int[] a = {2,4,1,6,-2,5,3};//����
		int stableLength = 3;

		int[] key = new IntervalSegment().minSegment(a, stableLength);
		int indexs = 0;
		System.out.print("\nѡȡ�����䣺");
		for (int i = 0; i < key.length; i++) {
			if (key[i] != 0) {
				indexs++;
				System.out.print(key[i] + "  ");
			}
		}
		System.out.println("\nѡȡ����ĸ�����" + indexs);
		
		
	}
	
}
