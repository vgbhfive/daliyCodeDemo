package cn.vgbh;

/* 
 * 计算某个数的阶乘中零的个数。
 * 
 * 例：
 * 数字： 1 2 3 4  5   6   7    8     9      10
 * 阶乘： 1 2 6 24 120 720 5040 40320 362880 3628800
 * 长度： 1 1 1 2  3   3   4    5     6      7
 * 个数： 0 0 0 0  1   1   2    2     1      2
 * 
 * 求末尾0的个数： 
 * 至于一个数阶乘的末尾有多少个0，0的个数为（其中的“/”是取整除法）： 
 * 例子：1000的阶乘末尾0的个数 
 *   1000/5 + 1000/25 + 1000/125 + 1000/625 
 * = 200 + 40 + 8 + 1 
 * = 249(个)
 * 
 * 求26的阶乘的尾部有多少个0. 
 * 26！ = 1 × 2 ×３× 4 × 5 × 6 × 7 × 8 × 9 × 10 × 11 × 12 × 13× 14 × 15 × 16 × 17 × 18 × 19 × 20 × 21 × 22 ×2３× 24 × 25 × 26 
 * 内有 26/5 + 26/25 = 6（个）5相乘 
 * 因为25其实可以分解成2个5相乘，而26/5只计算了一个5，因此还要再加26/25.
 * 
 */

public class TralingZeros {

	public static void main(String[] args) {
		
		TralingZeros t = new TralingZeros();
		
		System.out.println(t.trainingZeros(10000000));
		
	}
	
	/**
	 * 计算阶乘尾部的零的个数
	 * @param n
	 * @return 零的个数
	 */
	public long trainingZeros (long n) {
		long count = 0;
		for (long i = 5; i <= n; i *= 5) {
			count += n / i;
		}
		
		return count;
	}
	
}
