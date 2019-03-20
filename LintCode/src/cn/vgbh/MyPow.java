package cn.vgbh;

/*
 * ʵ�� pow(x,n)
 * 
 * �㷨�Ļ���˼�룺���ٳ˷��������ظ����ý�����
 * 
 */

public class MyPow {

	public static void main(String[] args) {
		
		MyPow my = new MyPow();
		
		System.out.println(my.myPow(3.0, 30));
		
	}
	
	/**
	 * x��y����
	 * @param x
	 * @param y
	 * @return x^y��ֵ
	 */
	public double myPow (double x, int y) {
		if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) return 0;
		if (y == 0) return 1;
		
		if (y < 0) {
			return (1/x) * myPow(1/x, -(y+1));
		}
//		if (y % 2 == 0) {//ż��
//			return myPow(x, y/2) * myPow(x, y/2);
//		} else {//����
//			return x * myPow(x, y/2) * myPow(x, y/2);
//		}
		//ż��/����
		return (y % 2 == 0)? myPow(x*x, y/2) : x*myPow(x*x, y/2);

	}
	
}
