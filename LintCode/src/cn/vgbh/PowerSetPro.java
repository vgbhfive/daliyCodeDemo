package cn.vgbh;

/*
 * 幂集问题
 * 
 * 
 * 
 */

public class PowerSetPro {
	
	/**
	 * 幂集运算
	 * @param a
	 * @param b
	 */
	private void pSet (int[] a, int[] b) {
		int pw = (int) Math.pow(2, a.length);
		
		for (int i = 0; i < pw; i++) {
			System.out.print("{");
			for (int j = 0; j < a.length; j++) {
				if (b[j] != 0) System.out.print(" " + a[j] + " ");
			}
			System.out.print("}" + "\n");
			change(b, a.length);
		}	
	}
	
	/**
	 * 利用二进制位判断是否输出
	 * @param b
	 * @param n
	 */
	private void change (int[] b, int n) {
		for (int i = 0; i < n; i++) {
			if (b[i] != 0) {
				b[i] = 0;
			} else {
				b[i] = 1;
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{1,2,3};
		int[] b = new int[]{0,0,0};
		
		PowerSetPro power = new PowerSetPro();
		power.pSet(a, b);
 		
		
		
	}

}
