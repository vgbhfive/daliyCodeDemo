package cn.vgbh;

/*
 * 给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
 * 
 * 例：
 * 对于字符串 "abcdefg".
 * offset=0 => "abcdefg"
 * offset=1 => "gabcdef"
 * offset=2 => "fgabcde"
 * offset=3 => "efgabcd"
 * 
 */

public class RotateString {

	public static void main(String[] args) {

		RotateString r = new RotateString();
		char[] chars = new char[]{'0','1','2','3','4','5','6','7','8','9'};
		int offset = 12;
		chars = r.rotateSString(chars, offset);	
		
		for (int i = 0; i < chars.length; i++) {
			System.out.print(chars[i] + "\t");
		}
		
	}
	
	/**
	 * 字符数组的旋转替换
	 * @param chars
	 * @param offset
	 */
	public char[] rotateSString(char[] chars, int offset) {
		if (chars.toString().equals("") || chars.length == 0) {
			return chars;
		}
		offset = offset % chars.length;//对字符数组的旋转次数进行优化
		
		int count = 0;
		while (count < offset) {
			char temp = chars[chars.length-1];
			for (int i = chars.length-2; i >= 0 ; i--) {
				chars[i+1] = chars[i];
			}
			chars[0] = temp;
			count++;
		}
		
		return chars;
	}

}
