package cn.vgbh.mathematic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * ��������񣺸���һ������ m x n ��Ҫ�صľ��󣬣�m ��, n �У�����������˳�򣬷��ظþ����е�����Ҫ�ء�
 * ����
 * �������¾���
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Ӧ���� [1,2,3,6,9,8,7,4,5]��
 * 
 * �㷨��
 * �㷨������������2���ҳ�ÿһ�����Ĺ��ɣ������ҵ���
 * 
 * ��������򣺸���һ����n����һ������1-n^2�������ξ���
 * ����
 * n = 3
 * ����Ϊ
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * 
 * �㷨��
 * ��n���������������Ѿ�Ψһȷ���ˣ���ôÿһ��Ԫ��Ҳ��ȷ���ġ�
 * Ҳ����˵��ÿһ��λ�÷�ʲôԪ�ؽ���ȡ����n��
 * ������ǿ����ҵ�һ������element(i, j)�����к�i���к�jӳ��ɶ�Ӧ������кŵ�Ԫ�ء�
 * ��Ȼ��������϶�����һ���򵥵ĺ���������һ�۾Ϳ��Կ������ģ���Ҳ�����ǲ����ܡ�
 * �������Ǿ�������һ�����������ʲô�ص㡣
 * ע��۲�һ���������������㣬�������Ͻǵ�Ԫ������С�ģ�Ȼ����˳ʱ�뷽�����������ͬһ����һ��������nΪ4ʱ��1, 2, ..., 12����������һ�㻷����
 * ��ע��һ������һ�㣬Ҳ��һ����˳ʱ�뷽�������һ����������nΪ4ʱ��13, 14, 15, 16��������һ�㻷����
 * �Դ����ƣ������滹��һ�㻷��nΪ4ʱ��2�㻷��nΪ5ʱ��3�㻷��������һ��ֻ��һ��Ԫ��25����ʵ������һ��Բ����Բ���ṹ��
 * ÿһԲ����ؼ���Ԫ�ؾ������Ͻǵ���һ��Ԫ�ء�ֻҪ֪�������Ԫ�أ��ټ�����������λ��ı߳��Ϳ��Լ����ʣ�µ�Ԫ�ء�
 * �����Ͻ�Ԫ��Ϊa���߳�Ϊl��ell����Ҳ���Ǳ����м���Ԫ�أ����������Ͻǵ��кź��кž�Ϊ0������Ԫ�ص��кź��кŶ��������ο���
 * ���㷽��������ʾ��
 * 1. ��i == 0��element(i, j) = a + j;
 * 2. ������j == 0��element(i, j) = a + 4(l-4) - (i-1) - 1;
 * 3. ������i == l-1��element(i, j) = a + 4(l-4) - (l-2) - 1 - j;
 * 4. ����element(i, j) = a + l - 1 + i;
 * 
 * 
 * 
 */

public class SpiralMatrix {

	public static void main(String[] args) {
		SpiralMatrix spiral = new SpiralMatrix();
		
		int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		List<Integer> list = spiral.spiralMatrix1(arr);
		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.print(integer + "   ");
		}

		System.out.println();
		arr = spiral.spiralMatrix2(3);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + "   ");
			}
			System.out.println();
		}
		
	}
	
	/**
	 * ��������1
	 * @param arr
	 * @return ��������������
	 */
	public List<Integer> spiralMatrix1 (int[][] arr) {
		List<Integer> list = new ArrayList<Integer>();
		int[][] a = arr;
		int n = a.length;
		int i, j;
		
		for(i =0;i<n/2;i++){  
	        for(j=0;j<n-i;j++){  
	            list.add(a[i][j]);
	        }  
	        for(j=i+1;j<n-i-1;j++){  
	            list.add(a[j][n-1-i]);        
	        }  
	        for(j=n-i-1;j>i;j--){   
	            list.add(a[n-i-1][j]);
	        }  
	        for(j=n-i-1;j>i;j--){    
	            list.add(a[j][i]); 
	        }  
	    }
		if (n % 2 == 1) {
			list.add(a[n/2][n/2]);
		}
		
		return list;
	}
	
	/**
	 * ʵ����������
	 * @param n
	 * @return �������ľ���
	 */
	public int[][] spiralMatrix2 (int n) {//n=3
		int[][] a = new int[n][n];
		int m = 1;
		int i, j;
		
		for(i =0;i<n/2;i++){  
	        for(j=0;j<n-i;j++){  
	            if(a[i][j] == 0)  
	                a[i][j] = m++;  
	        }  
	        for(j=i+1;j<n-i;j++){  
	            if(a[j][n-1-i] ==0)  
	                a[j][n-1-i] = m++;  
	        }  
	        for(j=n-i-1;j>i;j--){  
	            if(a[n-i-1][j] ==0)  
	                a[n-i-1][j] = m++;
	        }  
	        for(j=n-i-1;j>i;j--){  
	            if(a[j][i] ==0)  
	                a[j][i] = m++;  
	        }  
	    }
		if (n % 2 == 1) {
			a[n/2][n/2] = m;
		}
		
		return a;
	}
	
	
	
}
