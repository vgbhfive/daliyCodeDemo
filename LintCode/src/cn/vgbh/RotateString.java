package cn.vgbh;

/*
 * ����һ���ַ�����һ��ƫ����������ƫ������ת�ַ���(����������ת)
 * 
 * ����
 * �����ַ��� "abcdefg".
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
	 * �ַ��������ת�滻
	 * @param chars
	 * @param offset
	 */
	public char[] rotateSString(char[] chars, int offset) {
		if (chars.toString().equals("") || chars.length == 0) {
			return chars;
		}
		offset = offset % chars.length;//���ַ��������ת���������Ż�
		
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
