package cn.vgbh;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
 * 全排列：从n个不同元素中任取m（m <= n）个元素，按照一定的顺序排列起来，叫做从n个不同元素中取出m个元素的一个排列。当m=n时所有的排列情况叫全排列。
 * 
 * 递归算法：重复调用函数，一直逼近，直到最终的全部排列。
 * 
 * 非递归算法：
 * 字典序法：对给定的字符集中的字符规定了一个先后关系，在此基础上规定两个全排列的先后是从左到右逐个比较对应的字符的先后。
 * 字典序法的优点是排列的结果按照顺序输出并且对于重复的元素不进行重复排序。
 * 
 */

public class AllArranged {
	
	/**
	 * 数组内数值的交换
	 * @param cs
	 * @param i
	 * @param j
	 * @return 交换后的数组
	 */
	private char[] swap (char[] cs, int i, int j) {
		char temp = cs[i];
		cs[i] = cs[j];
		cs[j] = temp;
		return cs;
	}
	
	/**
	 * 排列
	 * @param cs
	 * @param k
	 * @param m
	 * @return 排列的所有集合
	 */
	private List<String> arrang (char[] cs, int k, int m, List<String> list) {
		
		if (k == m) {
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < cs.length; i++) {
				str.append(cs[i]);
			}
			//System.out.println(str.toString());
			list.add(str.toString());	
		} else {
			for (int i = k; i <= m; i++) {
				cs = swap(cs, k, i);//把第一个元素分别与后面的元素进行交换，递归的调用其子数组进行排序。
				arrang(cs, k + 1, m, list);
				cs = swap(cs, k, i);//子数组排序返回后要将第一个元素交换回来。 
			}
		}

		return list;
	}

	/**
	 * 全排列
	 * @param str
	 * @return 全排列的所有集合
	 */
	public List<String> allArrang (String str) {
		List<String> list = new ArrayList<String>();
		list = arrang(str.toCharArray(), 0, str.length()-1, list);
		
		return list;
	}
	
	
	public static void main(String[] args) {
		
		AllArranged all = new AllArranged();
		List<String> list = new ArrayList<String>();
		
		list = all.allArrang("6548751");
		Collections.sort(list);
		//注：这里并不能判断重复的元素，若是重复的元素则不能识别出。
		
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
		
	}
	
}
