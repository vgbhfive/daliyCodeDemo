package cn.vgbh;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
 * ȫ���У���n����ͬԪ������ȡm��m <= n����Ԫ�أ�����һ����˳������������������n����ͬԪ����ȡ��m��Ԫ�ص�һ�����С���m=nʱ���е����������ȫ���С�
 * 
 * �ݹ��㷨���ظ����ú�����һֱ�ƽ���ֱ�����յ�ȫ�����С�
 * 
 * �ǵݹ��㷨��
 * �ֵ��򷨣��Ը������ַ����е��ַ��涨��һ���Ⱥ��ϵ���ڴ˻����Ϲ涨����ȫ���е��Ⱥ��Ǵ���������Ƚ϶�Ӧ���ַ����Ⱥ�
 * �ֵ��򷨵��ŵ������еĽ������˳��������Ҷ����ظ���Ԫ�ز������ظ�����
 * 
 */

public class AllArranged {
	
	/**
	 * ��������ֵ�Ľ���
	 * @param cs
	 * @param i
	 * @param j
	 * @return �����������
	 */
	private char[] swap (char[] cs, int i, int j) {
		char temp = cs[i];
		cs[i] = cs[j];
		cs[j] = temp;
		return cs;
	}
	
	/**
	 * ����
	 * @param cs
	 * @param k
	 * @param m
	 * @return ���е����м���
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
				cs = swap(cs, k, i);//�ѵ�һ��Ԫ�طֱ�������Ԫ�ؽ��н������ݹ�ĵ������������������
				arrang(cs, k + 1, m, list);
				cs = swap(cs, k, i);//���������򷵻غ�Ҫ����һ��Ԫ�ؽ��������� 
			}
		}

		return list;
	}

	/**
	 * ȫ����
	 * @param str
	 * @return ȫ���е����м���
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
		//ע�����ﲢ�����ж��ظ���Ԫ�أ������ظ���Ԫ������ʶ�����
		
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
		
	}
	
}
