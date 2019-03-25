package cn.vgbh.dynamic;

/**
 * ������������¥�ݣ���Ҫn������ܵ��ﶥ������ÿ����ֻ����һ�����������������ж����ֲ�ͬ�ķ�������¥������
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
