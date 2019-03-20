package cn.vgbh;

/*
 * 哈希函数
 * 公式：  hashcode("abcd") = (ascii(a) * 33^3 + ascii(b) * 33^2 + ascii(c) *33^1 + ascii(d) *33^0) % HASH_SIZE 
 * 注：一种广泛使用的哈希函数算法是使用数值33，假设任何字符串都是基于33的一个大整数。
 * 
 * 例：对于key="abcd" 并且 size=100， 返回 78
 * 
 */

public class HashCode {

	public static void main(String[] args) {
		
		HashCode hash = new HashCode();
		char[] arr = new char[]{'a','b','c','d'}; 
		System.out.println(hash.hash(arr, 100));
		
	}
	
	public int hash (char[] arr, int HASH_SIZE) {
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += (long)((int)arr[i] * (int)Math.pow(33, (arr.length-i-1)));
		}
		
		return (int) (sum % HASH_SIZE);
	}
	
}
