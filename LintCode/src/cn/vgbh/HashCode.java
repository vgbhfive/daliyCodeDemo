package cn.vgbh;

/*
 * ��ϣ����
 * ��ʽ��  hashcode("abcd") = (ascii(a) * 33^3 + ascii(b) * 33^2 + ascii(c) *33^1 + ascii(d) *33^0) % HASH_SIZE 
 * ע��һ�ֹ㷺ʹ�õĹ�ϣ�����㷨��ʹ����ֵ33�������κ��ַ������ǻ���33��һ����������
 * 
 * ��������key="abcd" ���� size=100�� ���� 78
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
