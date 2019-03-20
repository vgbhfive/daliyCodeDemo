package cn.vgbh.mathematic;

/*
 * ����:���ݳ����Ķ��壬����ֻ�ܱ�2��3��5������Ҳ����˵���һ����������ܱ�2���������ǰ�����������2������ܱ�3����������������3������ܱ�5�������ͳ�������5��
 *     ���������ǵõ�����1����ô��������ǳ����������ǡ�
 *     
 * ���һ���㷨���ҳ�ֻ��������2��3��5 �ĵ� nС������
 * �������������磺1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 * 
 * ����
 * ���n = 9�� ���� 10
 * 
 * ���Ǽ����������Ѿ������ɸ��������ź������������С����ǰ����е�����������M��
 * ����������������һ���������ó����϶���ǰ��ĳһ����������2��3����5�Ľ����
 * �������ȿ��ǰ����е�ÿ����������2���ڳ���2��ʱ���ܵõ����ɸ����С�ڻ����M�ġ�
 * ���������ǰ���˳�����ɵģ�С�ڻ��ߵ���M�϶��Ѿ����������ˣ����ǲ����ٴο��ǣ����ǻ���õ����ɸ�����M�Ľ����������ֻ��Ҫ��һ������M�Ľ����
 * ��Ϊ����ϣ�������ǰ���С����˳�����ɵģ���������Ľ�������Ժ���˵�����ǰѵõ��ĵ�һ������2�����M�Ľ������ΪM2��
 * ͬ�����ǰ����е�ÿһ����������3��5���ܵõ���һ������M�Ľ��M3��M5����ô��һ������Ӧ����M2��M3��M5����������С�ߡ�
 * 
 * ������̣�
 * 1��2��3��4��5��6��8��9��10��12....����
 * init:arr[0] = 1,count = 1															-->arr[0] = 1
 * 1:	count = 1	arr[count] = getMin(2,3,5)	m2 = 1, m3 = 0, m5 = 0					-->arr[1] = 2
 * 2:	count = 2	arr[count] = getMin(4=arr[1]*2,3,5)	m2 = 1, m3 = 1, m5 = 0			-->arr[2] = 3
 * 3:	count = 3	arr[count] = getMin(4,6=arr[2]*3,5)	m2 = 2, m3 = 1, m5 = 0			-->arr[3] = 4
 * 4:	count = 4	arr[count] = getMin(6=arr[2]*2,6,5)	m2 = 1, m3 = 1, m5 = 1			-->arr[4] = 5
 */

public class UglyNumber {

	public static void main(String[] args) {
		UglyNumber u = new UglyNumber();
		
		System.out.println(u.uglyNumber(9));

	}
	
	/**
	 * @param n
	 * @return Ugly Number
	 */
	public int uglyNumber (int n) {
		if (n <= 0) {
			return 0;
		}
		
		int[] arr = new int[n];					//UglyNumber Array
		arr[0] = 1;								//UglyNumber Array First Number
		int count = 1;							//Array count
		int m2 = 0, m3 = 0, m5 = 0;				//UglyNumber base
		
		while (count < n) {
			arr[count] = getMinNumber(2 * arr[m2], 3 * arr[m3], 5 * arr[m5]);
			while (2 * arr[m2] <= arr[count]) {
				++m2;
			}
			while (3 * arr[m3] <= arr[count]) {
				++m3;
			}
			while (5 * arr[m5] <= arr[count]) {
				++m5;
			}
			++count;
		}
		
		return arr[n-1];
	}
	
	/**
	 * @param x
	 * @param y
	 * @param z
	 * @return Min Number
	 */
	private int getMinNumber (int x, int y, int z) {
		int temp = x < y ? x : y;
		return temp < z ? temp : z;
	}
	
}
