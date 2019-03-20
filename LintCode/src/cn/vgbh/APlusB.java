package cn.vgbh;

/*
 * 使用位移的方法实现加法运算。
 * 左移：<<
 * 右移：>>
 * 异或： ^
 * 与： &
 */

public class APlusB {
	
	private final static int x = 10;//a
	private final static int y = 10;//b
	
	public static void main(String[] args) {
		
		APlusB a = new APlusB();
		
		int c = a.plusB(x, y);
		System.out.println(x + "+" + y + "=" + c);
		
	}
	
	/**
	 * A 和  B 的位移法。
	 * @param a
	 * @param b
	 * @return
	 */
	public int plusB (int a, int b) {
		if (b == 0) {
			return a;
		}
		int temp1 = a ^ b;
		int temp2 = (a & b) << 1;
		//System.out.println(temp1+ "   " + temp2);
		return plusB(temp1, temp2);
	}

	/**
	 * 正常A 和  B 的加法。 
	 * @param a
	 * @param b
	 * @return
	 */
	public int plusB1 (int a, int b) {
		return a+b;
	}
	
	
	/*
	 * 拙见：
	 * a为1时，b的值成倍数级增长。1 1、1 3、1 7、1 15、1 31、1 63、1 127、1 255 ···
	 * b为1时，a的值只有1才是对的。1 1
	 * 
	 */
}
