package cn.vgbh.dynamic;

/**
 * һ��С����һ�� n ��̨�׵�¥�ݡ�������ÿ���� 1 ���� 2 �� ���� 3 ����ʵ��һ��������ͳ���ܹ��ж����ֲ�ͬ�ķ�ʽ��������̨�ס�
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
