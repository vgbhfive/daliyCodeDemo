package cn.vgbh.cat;

public class Solution1 {

	public static void ss(char[] str, int offset) {
		int x = str.length;
		for (int i = 0; i < offset; i++) {
			str = addStr(str, str[str.length-1-i]);
		}
		for (int i = 0; i < x; i++) {
			System.out.print(str[i]);
		}
	}
	
	private static char[] addStr(char[] str, char x) {
        char[] strs = new char[str.length+1];
        for(int i = 0; i < strs.length - 1; i++) {
        	char n = str[str.length - 1 - i];
        	//System.out.println(str.length - 1 - i);
            strs[strs.length - 1 - i] = n;
        }
        strs[0] = x;
        return strs;
    }
	
	public static void main(String[] args) {
		char[] str = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'};
		
		Solution1.ss(str, 3);
	}
	
}
