package cn.vgbh.mathematic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 螺旋矩阵Ⅰ：给定一个包含 m x n 个要素的矩阵，（m 行, n 列），按照螺旋顺序，返回该矩阵中的所有要素。
 * 例：
 * 给定如下矩阵：
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 应返回 [1,2,3,6,9,8,7,4,5]。
 * 
 * 算法：
 * 算法如下螺旋矩阵2，找出每一个数的规律，即可找到。
 * 
 * 螺旋矩阵Ⅱ：给你一个数n生成一个包含1-n^2的螺旋形矩阵
 * 例：
 * n = 3
 * 矩阵为
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * 
 * 算法：
 * 当n给定后，这个矩阵就已经唯一确定了，那么每一个元素也是确定的。
 * 也就是说，每一个位置放什么元素仅仅取决于n。
 * 因此我们可以找到一个函数element(i, j)，将行号i和列号j映射成对应这个行列号的元素。
 * 当然这个函数肯定不是一个简单的函数，不是一眼就可以看出来的，但也并不是不可能。
 * 现在我们就来考查一下这个矩阵有什么特点。
 * 注意观察一下螺旋矩阵的最外层，它的左上角的元素是最小的，然后沿顺时针方向递增，就如同一个环一样（比如n为4时，1, 2, ..., 12就是最外面一层环）。
 * 再注意一下里面一层，也是一样，顺时针方向递增的一个环（比如n为4时，13, 14, 15, 16就是里面一层环）。
 * 以此类推，环里面还有一层环（n为4时有2层环，n为5时有3层环，最里面一层只有一个元素25），实际上是一个圆环套圆环结构。
 * 每一圆环最关键的元素就是左上角的那一个元素。只要知道了这个元素，再加上这个正方形环的边长就可以计算出剩下的元素。
 * 设左上角元素为a，边长为l（ell），也就是边上有几个元素，并假设左上角的行号和列号均为0，其它元素的行号和列号都以它作参考，
 * 计算方法如下所示：
 * 1. 若i == 0，element(i, j) = a + j;
 * 2. 否则若j == 0，element(i, j) = a + 4(l-4) - (i-1) - 1;
 * 3. 否则若i == l-1，element(i, j) = a + 4(l-4) - (l-2) - 1 - j;
 * 4. 否则element(i, j) = a + l - 1 + i;
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
	 * 螺旋矩阵1
	 * @param arr
	 * @return 矩阵螺旋化字列
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
	 * 实现螺旋矩阵
	 * @param n
	 * @return 螺旋化的矩阵
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
