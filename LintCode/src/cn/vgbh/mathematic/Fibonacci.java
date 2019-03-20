package cn.vgbh.mathematic;

/*
 * 쳲�������
 */

public class Fibonacci {

	public static void main(String[] args) {
		
		Fibonacci f = new Fibonacci();
		System.out.println(f.fibonacci(10));
		
	}
	
	/**
	 * 쳲�������
	 * @param n
	 * @return ��nλ��쳲�������
	 */
	public int fibonacci(int n) {
		if (n <= 0) return 0;
		if (n == 1) return 0;
		if (n == 2) return 1;
		
		int[] arr = new int[n];
		arr[0] = 0;
		arr[1] = 1;
		
		for (int i = 0; i < n; i++) {
			arr[i+2] = arr[i+1] + arr[i];
			if (i == (n-3)) return arr[(n-1)];
		}
		
		return 0;
	}
	
	
}
