package cn.vgbh;

/*
 * ��������
 */

public class BackPack {

	/**
	 * ��̬�滮������еĽ��
	 * @param w
	 * @param v
	 * @param W
	 * @param V
	 * @return
	 */
	private int[][] knap (int[] w, int[] v, int W, int V) {
		int value = V+2;
		int weight = W+2;
		int[][] arr = new int[value][weight];
		
		for (int i = 0; i <= V; i++) arr[i][0] = 0;
		for (int i = 0; i <= W; i++) arr[0][i] = 0;
		
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= W; j++) {
				if (j < w[i]) {
					arr[i][j] = arr[i-1][j];
				} else {
					if (arr[i-1][j] < arr[i-1][j-w[i]] + v[i]) {
						arr[i][j] = arr[i-1][j-w[i]] + v[i];
					} else {
						arr[i][j] = arr[i-1][j];
					}
				}
			}
		}
		
		return arr;
	}
	
	/**
	 * ���Ƴ����Ž�
	 * @param arr
	 * @param w
	 * @param W
	 * @param V
	 * @return
	 */
	private int[] traceBack (int[][] arr, int[] w, int W, int V) {
		int weight = W;
		int[] x = new int[V+2];
		
		for (int i = V; i > 0; i--) {
			if (arr[i][weight] != arr[i-1][weight]) {
				x[i] = 1;
				weight -= w[i];
			} else {
				x[i] = 0;
			}
		}
		
		return x;
	}
	
	/**
	 * �������⣨��̬�滮��
	 * @param w
	 * @param v
	 * @param W
	 * @param V
	 */
	public void dispKnap (int[] w, int[] v, int W, int V) {
		//��̬�滮���еĿ�����
		int[][] arr = knap(w, v, W, V);
		//����������Ž�
		int[] x = traceBack(arr, w, W, V);
		
		int maxW = 0;
		int maxV = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] == 1) {
				System.out.print("ѡȡ��" + i + "����Ʒ�� \n");
				maxW += w[i];
				maxV += v[i];
			}
		}
		
		System.out.println("������=" + maxW + "  �ܼ�ֵ=" + maxV);
		
	}
	
	public static void main(String[] args) {
		
		int[] w = {0,2,2,6,5,4};
		int[] v = {0,6,3,5,4,6};
		
		int W = 10;
		int V = 5;
		
		
		BackPack back = new BackPack();
		back.dispKnap(w, v, W, V);
		
	}
	
}
