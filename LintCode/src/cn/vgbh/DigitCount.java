package cn.vgbh;

/*
 * 计算数字k在0到n中的出现的次数，k可能是0~9的一个值
 * 
 * 例：
 * n=12，k=1，在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]，我们发现1出现了5次 (1, 10, 11, 12)
 * 
 */

public class DigitCount {
	
	private final static int n = 12;//样例中的n
	private final static int k = 2; //样例中的k
	
	public static void main(String[] args) {	
		
		DigitCount d = new DigitCount();
		
		int[] array = new int[6];
		array = d.digitNum(n, k);
		//d.printArr(array);
	}
	
	/**
	 * 计算个数
	 * @param n
	 * @param key
	 * @return Count Array
	 */
	private int[] digitNum (int n, int key) {
		//新建返回的数组
		int[] array = new int[n];
		int count = 0;
		int y = 0;
		//处理n
		int i= 0;
		while (i <= n) {
			//处理单个值
			Integer x = new Integer(i);
			int[] arr = new int[x.toString().length()];
			arr = everyNum(i);
			//printArr(arr);
			//System.out.println();
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == key) {
					array[count] = i;
					count++;
					//有一个符合条件，即跳出
					y++;
				}
			}
			//进入下次循环
			i++;
		}
		System.out.println(y);
		
		return array;
	}
	
	/**
	 * 处理获取的每一个数字
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
	 * 判断有效位
	 * @param arr
	 * @return useful counts
	 */
	private int dropZeros (int[] arr) {
		int x = 0;
		//数的阶乘的最高为一定非零
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
	 * 数组输出
	 * @param arr
	 */
	private void printArr(int[] arr) {
		for (int i = 0; i < dropZeros(arr); i++) {
			System.out.print(arr[i] + "  ");
		}
	}
	
}
