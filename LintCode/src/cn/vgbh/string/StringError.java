package cn.vgbh.string;

public class StringError {
	
	
	public static void main(String[] args) {
		StringError s = new StringError();
		
		s.stripStr("abbcc");
		
	}
	
	public void stripStr (String str) {
		
		if (str == null) {
			System.out.println("");
		}
		
		char[] chars = str.toCharArray();
		int min = 1;
		char ch = chars[0];
		
		for (int i = 0; i < chars.length; i++) {
			if (indexOfChar(chars, chars[i]) < min) {
				min = indexOfChar(chars, chars[i]);
				ch = chars[i];
			}
		}
		
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ch) {
				chars[i] = ' ';
			}
		}
		
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != ' ') {
				System.out.print(chars[i]);
			}
		}
		
	}
	
	private int indexOfChar (char[] chars, char c) {
		int index = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == c) {
				index++;
			}
		}
		
		return index;
	}
	
}
