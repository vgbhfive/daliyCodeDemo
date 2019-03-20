package cn.vgbh.google;

/*
 * 题目：
 * 给出两个输入流inputA和inputB，有Backspace,如果两个输入流最后的结果相等，输出YES，否则输出NO。
 * 
 * 注意事项：
 * 输入字符只包括小写字母和'<'。
 * 输入流长度不超过10000。
 * 
 * 样例：
 * 给出 inputA = “abcde<<”, inputB = “abcd<e<”, 返回 “YES”。
 * 解释:
 * inputA和inputB最后的结果都为abc，故返回”YES”。
 * 
 * 给出 inputA = “a<<bc”, inputB = “abc<”, 返回 “NO”。
 * 解释：
 * inputA最后的结果为”bc”,inputB最后的结果为”ab”，故返回”NO”。
 */

public class InputStream {

	/**
	 * 输入流
	 * @param inputA
	 * @param inputB
	 * @return
	 */
	public String inputStream(String inputA, String inputB) {
		 
		//adjust length
		if (inputA.length() >= 10000 || inputB.length() >= 10000 || inputA.equals("") || inputB.equals("")) {
			try {
				throw new Exception("Input Stream length is more lastest!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//adjust code
		for (int i = 0; i < inputA.length(); i++) {
			char[] xz = inputA.substring(i, i+1).toCharArray();
			int x = (int)xz[0];
			if (x >= 97 && x <= 122 || x == 60) {
				//System.out.println(x + "\n" + xz[0]);
			} else {
				try {
					throw new Exception("Wrong Input Stream!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		for (int i = 0; i < inputB.length(); i++) {
			char[] xz = inputB.substring(i, i+1).toCharArray();
			int x = (int)xz[0];
			if (x >= 97 && x <= 122 || x == 60) {
				//System.out.println(x + "\n" + xz[0]);
			} else {
				try {
					throw new Exception("Wrong Input Stream!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		//test
		StringBuilder strA = new StringBuilder();
		for (int i = 0; i < inputA.length(); i++) {
			String code = inputA.substring(i, i+1);
			if (code.equals("<")) {
				//delete one code
				if (strA.length() <= 0) {
					
				} else {
					strA.deleteCharAt(strA.length() - 1);
					
				}
			} else {
				strA.append(code);
			}
		}
		
		StringBuilder strB = new StringBuilder();
		for (int i = 0; i < inputB.length(); i++) {
			String code = inputB.substring(i, i+1);
			if (code.equals("<")) {
				//delete one code
				if (strB.length() <= 0) {
					
				} else {
					strB.deleteCharAt(strB.length() - 1);
				}
			} else {
				strB.append(code);
			}
		}
		
		//System.out.println(strA + "\n" + strB);
		
		//return
		if (strA.toString().equals(strB.toString())) {
			return "YES";
		} else {
			return "NO";
		}

	}
	
	
	public static void main(String[] args) {
		InputStream input = new InputStream();
		System.out.println(input.inputStream("abc<", "<ab<b"));
	}
	
}
