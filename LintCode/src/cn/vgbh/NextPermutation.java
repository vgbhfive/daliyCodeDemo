package cn.vgbh;

import java.util.Arrays;

/*
 * ��һ������
 * ����һ���������������У�������������С�����ֵ����С������������һ�����С�
 * ���û����һ�����У�������ֵ�����С�����С�
 * 
 * ����˵����
 *  1 2 3
 *  1 3 2
 *  2 1 3
 *  2 3 1
 *  3 1 2
 *  3 2 1
 *  ���Ͽ��Կ�������ν����һ����ָ�����������к��˳�����γɵ���һ����
 * 
 * ����:
 * 6 5 4 8 7 5 1
 * �ȿ϶��Ӻ��濪ʼ����1��5������û���á�
 * 7��5��1������Ҳû��Ч������˶�������8��7��5��1�ǵݼ��ġ�
 * �����Ҫ�ҵ���һ�����У��ҵ�������λ���ǹؼ���
 * ��Ϊ������ſ���ʹ�������ø���
 * �����ҵ���4���Զ��׼�4������5������8����7������1��
 * ��˾���Ҫ�ҳ���4������Щ����������С��ֵ�����������ߵ�����
 * ��ô�������оͳ��ˣ�6 5 5 8 7 4 1
 * Ȼ�����һ���������8 7 4 1��һ������,������
 * 
 */

public class NextPermutation {
	
	/**
	 * ��һ������
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
		if (index == 0) {//û����һ�����򣬷�����С����
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
