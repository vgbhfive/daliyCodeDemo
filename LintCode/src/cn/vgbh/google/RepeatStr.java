package cn.vgbh.google;

/*
 * ��Ŀ��
 * дһ������, ��һ���� N ���ַ����ɵ��ַ��� A��һ���� M ���ַ����ɵ��ַ��� B, ���� A �����ظ��Ĵ�����ʹ�� B ���ظ��ַ������Ӵ�.��� B ������Ϊ�ظ��ַ������Ӵ�, �򷵻� -1.
 * 
 * ע�����
 * Assume that 0 <= N <= 1000, 1 <= M <= 1000
 * 
 * ������
 * ���� A = abcd, B = cdabcdab��
 * ��ķ�����Ҫ���� 3, ��Ϊ���ظ��ַ��� A 3��֮�����ǵõ����ִ� abcdabcdabcd. �ַ���B������ַ�����һ���Ӵ�.
 * 
 */

public class RepeatStr {

	/**
	 * �ظ��Ӵ�
	 * @param A
	 * @param B
	 * @return
	 */
	public int repeatedString(String A, String B) {
        // write your code here
		// abcd   cdabcdab    abcdabcdabcd
		boolean flag = true;
		StringBuilder strA = new StringBuilder();
		int count = 0;
		
		while (flag) {
			if (strA.length() <= B.length()) {
				count++;
				strA.append(A);
				//System.out.println(count + "\n" + strA);
			} else {
				flag = false;
				if (KMP(strA.toString(), B)) {
				} else {
					count = -1;
				}
			}
		}
		
		//System.out.println(strA.toString());
		
		return count;
    }
	
	/**
	 * �ַ���֮���Ƿ�ƥ��(KMP�㷨)
	 * @param strA
	 * @param B
	 * @return
	 */
	public boolean KMP (String strA, String B) {	
		char[] s = strA.toCharArray();
		char[] p = B.toCharArray();
		
		int i = 0;
		int j = 0;
		
		while (i < strA.length() && j < B.length()) {
			if (s[i] == p[j]) {
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}
		}
		
		if (j == B.length()) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	public static void main(String[] args) {
		RepeatStr repeat = new RepeatStr();
		System.out.println(repeat.repeatedString("abcd", "abcdab"));
	}
	
}
