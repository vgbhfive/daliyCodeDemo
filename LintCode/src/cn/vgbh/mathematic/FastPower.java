package cn.vgbh.mathematic;

/*
 * 快速幂，即快速幂取模算法，就是求一个幂式的余。
 * 公式：a ^ b % c = ?
 * 
 * 变式：
 * ((a ^ 2) ^ (b / 2)) % c     : b为偶数
 * ((a ^ 2) ^ (b / 2) * a) % c : b为奇数
 * 
 * 因为进位对个位不影响，积的取余等于取余的积取余。
 * 
 * 理解：
 * count = (a ^ 2) ^ (b / 2)
 * b /= 2 （成二倍的缩小b，对count进行处理）
 * a 
 * 
 */

public class FastPower {

	/**
	 * 快速幂的取余
	 * @param a
	 * @param b
	 * @param c
	 * @return (a ^ b) mod c
	 */
	public int fasePower (int a, int b, int c) {
		int count = 1;
		a = a % c;
		while (b > 0) {
			if ((b % 2) == 1) //奇数
				count = (count * a) % c;
			b /= 2;
			a = (a * a) % c;	
			
			//System.out.println("   b:" + b + "   count:" + count + "   a:" + a); 
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		
		FastPower fast = new FastPower();
		
		System.out.println(fast.fasePower(3, 7, 2));
		
		
		
	}
	
}
