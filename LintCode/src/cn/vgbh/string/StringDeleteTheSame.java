package cn.vgbh.string;

/*
 * �ڰ���Ͱ͵��������ܿͷ������У�����ַ���ת�����������ת����ʱ�����ǻ��������ժҪ��������ժҪ֮ǰ��Ҫ���û�˵���Ļ�����ȥ�صĴ����ַ���ȥ�صĹ����ǣ�
 * 1�����ڵ�����ظ�����Ҫȥ���� ����˵�� ���ղ���˵����Ҫ�˿���Ҫ�˿���Ҫ�˿�Ҷ�˵����Ҫ�˿  ȥ��֮�󣺡��ղ���˵����Ҫ�˿�Ҷ�˵����Ҫ�˿
 * 2���ظ��������������1������ �������������� ������Ҫȥ��
 * 3�����ֲ��ܽ��д������ԣ���10000��������Ҫȥ�ش���
 * ������Ҫ��ұ�дһ�γ������ȥ�ش������ȥ��֮����ַ���
 */

public class StringDeleteTheSame {
	
	/**
	 * �ַ�ȥ�ش���
	 * @param str
	 * @return
	 */
	public String delTheSameStr (String str) {

		try{
			if (Integer.valueOf(str).TYPE == Integer.TYPE) {
				//System.out.println(str);
				return str;
			}
		} catch (NumberFormatException e) {
			
		}
		
		
		
		
		
		return null;
	}
	

	public static void main(String[] args) {
	
		System.out.println(new StringDeleteTheSame().delTheSameStr("a"));
		
	}
	
}
