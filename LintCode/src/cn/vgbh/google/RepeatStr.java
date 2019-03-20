package cn.vgbh.google;

/*
 * 题目：
 * 写一个方法, 给一个由 N 个字符构成的字符串 A和一个由 M 个字符构成的字符串 B, 返回 A 必须重复的次数，使得 B 是重复字符串的子串.如果 B 不可能为重复字符串的子串, 则返回 -1.
 * 
 * 注意事项：
 * Assume that 0 <= N <= 1000, 1 <= M <= 1000
 * 
 * 样例：
 * 给出 A = abcd, B = cdabcdab。
 * 你的方法需要返回 3, 因为在重复字符串 A 3次之后我们得到了字串 abcdabcdabcd. 字符串B是这个字符串的一个子串.
 * 
 */

public class RepeatStr {

	/**
	 * 重复子串
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
	 * 字符串之间是否匹配(KMP算法)
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
