package cn.vgbh;

import java.util.Arrays;

/*
 * 算法题目：给定一个整数，实现一个方法求出离该整数最近的大于自身的“换位数”？
 * 换位数：就是一个整数各个数位的数字进行全排列，从而得到的新的整数。
 * 
 * 例：
 * 12345	12354
 * 12354 	12435
 * 
 * 解题规则：
 * 1、从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界。
 * 2、把逆序区域的前一位和逆序区域中刚刚大于它的数字交换位置。
 * 3、把原来的逆序区域转化为顺序。
 * 
 * 
 */

public class DictionaryOrder {
	
	/**
	 * 字典序算法
	 * @param num
	 * @return
	 */
	public int[] findNearstNumber (int[] num) {
		//复制数组，避免修改原值
		int[] number = Arrays.copyOf(num, num.length);
		//找到逆序区域
		int index = findTransferNum(number);
		
		if (index == 0) return null;
		//逆序区域前一位和逆序区域中刚刚大的一位交换
		exchangeHead(number, index);
		//将后边的逆序区域转换为顺序区域
		reverse(number, index);
		
		return number;
	}
	
	/**
	 * 将后边的逆序转换为顺序
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
	 * 逆序区域的前一位和逆序区域中刚刚大的一位交换
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
	 * 找到逆序区域的前一位
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
	 * 输出数组
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
