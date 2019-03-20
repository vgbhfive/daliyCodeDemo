package cn.vgbh.google;

/*
 * ��Ŀ��
 * ��������������inputA��inputB����Backspace,����������������Ľ����ȣ����YES���������NO��
 * 
 * ע�����
 * �����ַ�ֻ����Сд��ĸ��'<'��
 * ���������Ȳ�����10000��
 * 
 * ������
 * ���� inputA = ��abcde<<��, inputB = ��abcd<e<��, ���� ��YES����
 * ����:
 * inputA��inputB���Ľ����Ϊabc���ʷ��ء�YES����
 * 
 * ���� inputA = ��a<<bc��, inputB = ��abc<��, ���� ��NO����
 * ���ͣ�
 * inputA���Ľ��Ϊ��bc��,inputB���Ľ��Ϊ��ab�����ʷ��ء�NO����
 */

public class InputStream {

	/**
	 * ������
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
