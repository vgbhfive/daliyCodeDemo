package cn.vgbh;

/*
 * 数组相乘：
 * 
 * Strassen算法虽然把时间代价从O(n3)降到O(n2.81)，但是进一步分析，后者的系数比1大很多，当n比较小（如n<45）且矩阵中非零元素较少时，不宜采用此方法。
 * Strassen算法仅当n很大的时候才有价值，因此，可以说这方面的研究更偏重于理论价值。
 * 
 */

public class Matrix {

	/**
	 * 数组相乘
	 * @param a
	 * @param b
	 * @param maxIndex
	 * @return
	 */
	public int[][] matrixMultiply (int[][] a, int[][] b, int maxIndex) {
		int[][] c = new int[maxIndex][maxIndex];
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				for (int z = 0; z < maxIndex; z++) {
					c[i][j] = c[i][j] + a[i][z] * b[z][j]; 
				}
			}
		}
		
		return c;
	}
	
	/**
	 * 数组相乘
	 * @param a
	 * @param b
	 * @return
	 */
	public int[][] matrixStrassen (int[][] a, int[][] b, int maxIndex) {
		int[][] c = new int[maxIndex][maxIndex];
		
		return c;
	}
	
	
	public static void main(String[] args) {
		
		int[][] a = {{1,2},{3,4}};
		int[][] b = {{5,6},{7,8}};
		
		Matrix m = new Matrix();
		int[][] c = m.matrixMultiply(a, b, 2);
		
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				System.out.print(c[i][j] + "   ");
			}
			System.out.println();
		}
		
	}
	
}
