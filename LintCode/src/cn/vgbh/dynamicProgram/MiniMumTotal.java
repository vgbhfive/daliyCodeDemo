package cn.vgbh.dynamicProgram;

/*
 * 给定一个数字三角形，找到从顶部到底部的最小路径和。每一步可以移动到下面一行的相邻数字上。
 * 空间复杂度O(n),n为数字三角形的行数。
 * 
 * 例：
 * 比如，给出下列数字三角形：
 * [
 *   [2],
 *   [3,4],
 *   [6,5,7],
 *   [4,1,8,3]
 * ]
 * 从顶到底部的最小路径和为11 ( 2 + 3 + 5 + 1 = 11)。
 * 
 * 分析一：常规的动态规划
 * 
 * 
 * 分析二：O(n)的额外空间复杂度
 * 
 * 
 */

public class MiniMumTotal {

	/**
	 * 数字三角形的最小路径和
	 * @param arr
	 * @return 最小路径和
	 */
	public int miniMumTotal (int[][] arr) {
		int nums = 0;
		
		for (int i = 0; i < arr.length; i++) {
			//获取数组的最下值
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
