package cn.vgbh;

/*
 * N皇后问题：
 * 
 */

public class Queen {
	
	private int index = 0;
	private int count = 20;
	private int[] result = new int[count+1];
	
	/**
	 * N皇后问题
	 * @param k
	 * @param n
	 */
	public void queen (int k, int n) {
		if (k > n) {
			display(n);
		} else {
			for (int i = 1; i <= n; i++) {
				if (place(k, i)) {
					result[k] = i;
					queen(k+1, n);
				}
			}
		}
	}
	
	/**
	 * Show
	 * @param n
	 */
	public void display (int n) {
		System.out.print("第" + (++index) + "个解: ");
		for (int i = 0; i < n; i++) {
			System.out.print("  (" + (i+1) + " , " + result[i+1] + ")  ");
		}
		System.out.println();
	}
	
	/**
	 * 判断位置是否可放
	 * @param k
	 * @param i
	 * @return
	 */
	public boolean place (int k, int i) {
		int j = 1;
		while (j < k) {
			if (result[j] == i || (Math.abs(result[j]-i) == Math.abs(k-j))) return false;
			j++;
		}
		return true;
	}
	

	public static void main(String[] args) {
		new Queen().queen(1, 6);
	}
	
	
}
