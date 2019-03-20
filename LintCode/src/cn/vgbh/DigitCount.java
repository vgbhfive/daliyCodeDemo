package cn.vgbh;

/*
 * ��������k��0��n�еĳ��ֵĴ�����k������0~9��һ��ֵ
 * 
 * ����
 * n=12��k=1���� [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]�����Ƿ���1������5�� (1, 10, 11, 12)
 * 
 */

public class DigitCount {
	
	private final static int n = 12;//�����е�n
	private final static int k = 2; //�����е�k
	
	public static void main(String[] args) {	
		
		DigitCount d = new DigitCount();
		
		int[] array = new int[6];
		array = d.digitNum(n, k);
		//d.printArr(array);
	}
	
	/**
	 * �������
	 * @param n
	 * @param key
	 * @return Count Array
	 */
	private int[] digitNum (int n, int key) {
		//�½����ص�����
		int[] array = new int[n];
		int count = 0;
		int y = 0;
		//����n
		int i= 0;
		while (i <= n) {
			//������ֵ
			Integer x = new Integer(i);
			int[] arr = new int[x.toString().length()];
			arr = everyNum(i);
			//printArr(arr);
			//System.out.println();
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == key) {
					array[count] = i;
					count++;
					//��һ������������������
					y++;
				}
			}
			//�����´�ѭ��
			i++;
		}
		System.out.println(y);
		
		return array;
	}
	
	/**
	 * �����ȡ��ÿһ������
	 * @param n
	 * @return Process every number
	 */
	private int[] everyNum (int n) {
		Integer x = new Integer(n);
		int[] arr = new int[x.toString().length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (n / Math.pow(10, x.toString().length()-i-1)) % 10;
		}
		
		return arr;
	}
	
	/**
	 * �ж���Чλ
	 * @param arr
	 * @return useful counts
	 */
	private int dropZeros (int[] arr) {
		int x = 0;
		//���Ľ׳˵����Ϊһ������
		for (int i = arr.length-1; i >= 0; i--) {
			if (arr[i] == 0) {
				x++;
			} else {
				return arr.length - x; 
			}
		}
		return x;
	}
	
	/**
	 * �������
	 * @param arr
	 */
	private void printArr(int[] arr) {
		for (int i = 0; i < dropZeros(arr); i++) {
			System.out.print(arr[i] + "  ");
		}
	}
	
}
