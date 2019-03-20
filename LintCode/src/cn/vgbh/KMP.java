package cn.vgbh;

/*
 * 字符模式匹配算法
 * 
 * http://blog.csdn.net/v_july_v/article/details/7041827
 * 
 */

public class KMP {

	public static void main(String[] args) {
		KMP kmp = new KMP();
		boolean is = kmp.KMP1("ssssssssaaaaa", "sa");
		System.out.println(is);
	}
	
	/**
	 * KMP算法
	 * @param str1
	 * @param str2
	 * @return
	 */
	public boolean KMP1 (String str1, String str2) {
		char[] s = str1.toCharArray();
		char[] p = str2.toCharArray();
		
		int i = 0;
		int j = 0;
		
		while (i < str1.length() && j < str2.length()) {
			if (s[i] == p[j]) {
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}
		}
		
		if (j == str2.length()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * KMP算法
	 * @param str1
	 * @param str2
	 * @return
	 */
	public boolean KMP2 (String str1, String str2) {
		
		
		return false;
	}
	
}
