package cn.vgbh.dynamic;

/**
 * 一个小孩爬一个 n 层台阶的楼梯。他可以每次跳 1 步， 2 步 或者 3 步。实现一个方法来统计总共有多少种不同的方式爬到最顶层的台阶。
 * @author Vgbh
 *
 */
public class Solution272 {
	
	public static void main(String[] args) {
		
	}

	/**
     * @param n: An integer
     * @return: An Integer
     */
    public int climbStairs2(int n) {
        // write your code here
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i <= n ; i++) {
            arr[i] = arr[i-3] + arr[i-2] + arr[i-1];
        }
        
        return arr[n];
    }
	
}
