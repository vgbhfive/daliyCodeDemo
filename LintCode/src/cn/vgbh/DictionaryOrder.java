package cn.vgbh;

import java.util.Arrays;

/*
 * �㷨��Ŀ������һ��������ʵ��һ��������������������Ĵ�������ġ���λ������
 * ��λ��������һ������������λ�����ֽ���ȫ���У��Ӷ��õ����µ�������
 * 
 * ����
 * 12345	12354
 * 12354 	12435
 * 
 * �������
 * 1���Ӻ���ǰ�鿴���������ҵ����������ǰһλ��Ҳ���������û��ı߽硣
 * 2�������������ǰһλ�����������иոմ����������ֽ���λ�á�
 * 3����ԭ������������ת��Ϊ˳��
 * 
 * 
 */

public class DictionaryOrder {
	
	/**
	 * �ֵ����㷨
	 * @param num
	 * @return
	 */
	public int[] findNearstNumber (int[] num) {
		//�������飬�����޸�ԭֵ
		int[] number = Arrays.copyOf(num, num.length);
		//�ҵ���������
		int index = findTransferNum(number);
		
		if (index == 0) return null;
		//��������ǰһλ�����������иոմ��һλ����
		exchangeHead(number, index);
		//����ߵ���������ת��Ϊ˳������
		reverse(number, index);
		
		return number;
	}
	
	/**
	 * ����ߵ�����ת��Ϊ˳��
	 * @param num
	 * @param index
	 * @return
	 */
	public int[] reverse (int[] num, int index) {
		for (int i = index, j = num.length-1; i < j; i++, j--) {
			int temp = num[i];
			num[i] = num[j];
			num[j] = temp;
		}
		return num;
	}
	
	/**
	 * ���������ǰһλ�����������иոմ��һλ����
	 * @param num
	 * @param index
	 * @return
	 */
	public int[] exchangeHead (int[] num, int index) {
		int head = num[index-1];
		for (int i = num.length-1; i > 0; i--) {
			if (head < num[i]) {
				num[index-1] = num[i];
				num[i] = head;
				break;
			}
		}
		return num;
	}
	
	/**
	 * �ҵ����������ǰһλ
	 * @param num
	 * @return
	 */
	public int findTransferNum (int[] num) {
		for (int i = num.length-1; i > 0; i--) {
			if (num[i] > num[i-1]) {
				return i;
			}
		}
		return 0;
	}
	
	
	/**
	 * �������
	 * @param num
	 */
	public void display (int[] num) {
		for (int i : num) {
			System.out.print(i + "  ");
		}
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		int[] num = {3,2,5,4,5};
		
		DictionaryOrder dic = new DictionaryOrder();
		num = dic.findNearstNumber(num);
		
		dic.display(num);
		
	}

}
