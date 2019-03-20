package cn.vgbh;

/*
 * 实现 pow(x,n)
 * 
 * 算法的基本思想：减少乘法次数，重复利用结算结果
 * 
 */

public class MyPow {

	public static void main(String[] args) {
		
		MyPow my = new MyPow();
		
		System.out.println(my.myPow(3.0, 30));
		
	}
	
	/**
	 * x的y次幂
	 * @param x
	 * @param y
	 * @return x^y的值
	 */
	public double myPow (double x, int y) {
		if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) return 0;
		if (y == 0) return 1;
		
		if (y < 0) {
			return (1/x) * myPow(1/x, -(y+1));
		}
//		if (y % 2 == 0) {//偶数
//			return myPow(x, y/2) * myPow(x, y/2);
//		} else {//奇数
//			return x * myPow(x, y/2) * myPow(x, y/2);
//		}
		//偶数/奇数
		return (y % 2 == 0)? myPow(x*x, y/2) : x*myPow(x*x, y/2);

	}
	
}
