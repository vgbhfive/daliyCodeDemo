package cn.vgbh.mathematic;

/*
 * 丑数:根据丑数的定义，丑数只能被2、3和5整除。也就是说如果一个数如果它能被2整除，我们把它连续除以2；如果能被3整除，就连续除以3；如果能被5整除，就除以连续5。
 *     如果最后我们得到的是1，那么这个数就是丑数，否则不是。
 *     
 * 设计一个算法，找出只含素因子2，3，5 的第 n小的数。
 * 符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 * 
 * 例：
 * 如果n = 9， 返回 10
 * 
 * 我们假设数组中已经有若干个丑数，排好序后存在数组中。我们把现有的最大丑数记做M。
 * 现在我们来生成下一个丑数，该丑数肯定是前面某一个丑数乘以2、3或者5的结果。
 * 我们首先考虑把已有的每个丑数乘以2。在乘以2的时候，能得到若干个结果小于或等于M的。
 * 由于我们是按照顺序生成的，小于或者等于M肯定已经在数组中了，我们不需再次考虑；我们还会得到若干个大于M的结果，但我们只需要第一个大于M的结果，
 * 因为我们希望丑数是按从小到大顺序生成的，其他更大的结果我们以后再说。我们把得到的第一个乘以2后大于M的结果，记为M2。
 * 同样我们把已有的每一个丑数乘以3和5，能得到第一个大于M的结果M3和M5。那么下一个丑数应该是M2、M3和M5三个数的最小者。
 * 
 * 计算过程：
 * 1、2、3、4、5、6、8、9、10、12....。。
 * init:arr[0] = 1,count = 1															-->arr[0] = 1
 * 1:	count = 1	arr[count] = getMin(2,3,5)	m2 = 1, m3 = 0, m5 = 0					-->arr[1] = 2
 * 2:	count = 2	arr[count] = getMin(4=arr[1]*2,3,5)	m2 = 1, m3 = 1, m5 = 0			-->arr[2] = 3
 * 3:	count = 3	arr[count] = getMin(4,6=arr[2]*3,5)	m2 = 2, m3 = 1, m5 = 0			-->arr[3] = 4
 * 4:	count = 4	arr[count] = getMin(6=arr[2]*2,6,5)	m2 = 1, m3 = 1, m5 = 1			-->arr[4] = 5
 */

public class UglyNumber {

	public static void main(String[] args) {
		UglyNumber u = new UglyNumber();
		
		System.out.println(u.uglyNumber(9));

	}
	
	/**
	 * @param n
	 * @return Ugly Number
	 */
	public int uglyNumber (int n) {
		if (n <= 0) {
			return 0;
		}
		
		int[] arr = new int[n];					//UglyNumber Array
		arr[0] = 1;								//UglyNumber Array First Number
		int count = 1;							//Array count
		int m2 = 0, m3 = 0, m5 = 0;				//UglyNumber base
		
		while (count < n) {
			arr[count] = getMinNumber(2 * arr[m2], 3 * arr[m3], 5 * arr[m5]);
			while (2 * arr[m2] <= arr[count]) {
				++m2;
			}
			while (3 * arr[m3] <= arr[count]) {
				++m3;
			}
			while (5 * arr[m5] <= arr[count]) {
				++m5;
			}
			++count;
		}
		
		return arr[n-1];
	}
	
	/**
	 * @param x
	 * @param y
	 * @param z
	 * @return Min Number
	 */
	private int getMinNumber (int x, int y, int z) {
		int temp = x < y ? x : y;
		return temp < z ? temp : z;
	}
	
}
