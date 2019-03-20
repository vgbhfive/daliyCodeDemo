package cn.vgbh;

/*
 * ������ˣ�
 * 
 * Strassen�㷨��Ȼ��ʱ����۴�O(n3)����O(n2.81)�����ǽ�һ�����������ߵ�ϵ����1��ܶ࣬��n�Ƚ�С����n<45���Ҿ����з���Ԫ�ؽ���ʱ�����˲��ô˷�����
 * Strassen�㷨����n�ܴ��ʱ����м�ֵ����ˣ�����˵�ⷽ����о���ƫ�������ۼ�ֵ��
 * 
 */

public class Matrix {

	/**
	 * �������
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
	 * �������
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
