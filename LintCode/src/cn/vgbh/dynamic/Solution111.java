package cn.vgbh.dynamic;

/**
 * 假设你正在爬楼梯，需要n步你才能到达顶部。但每次你只能爬一步或者两步，你能有多少种不同的方法爬到楼顶部？
 * @author Vgbh
 *
 */
public class Solution111 {
	
	public static void main(String[] args) {
		
	}

	/**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n <= 0) {
            return 0;
        }
        
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n ; i++ ) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        
        return arr[n-1];
    }
	
}
