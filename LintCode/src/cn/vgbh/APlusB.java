package cn.vgbh;

/*
 * ʹ��λ�Ƶķ���ʵ�ּӷ����㡣
 * ���ƣ�<<
 * ���ƣ�>>
 * ��� ^
 * �룺 &
 */

public class APlusB {
	
	private final static int x = 10;//a
	private final static int y = 10;//b
	
	public static void main(String[] args) {
		
		APlusB a = new APlusB();
		
		int c = a.plusB(x, y);
		System.out.println(x + "+" + y + "=" + c);
		
	}
	
	/**
	 * A ��  B ��λ�Ʒ���
	 * @param a
	 * @param b
	 * @return
	 */
	public int plusB (int a, int b) {
		if (b == 0) {
			return a;
		}
		int temp1 = a ^ b;
		int temp2 = (a & b) << 1;
		//System.out.println(temp1+ "   " + temp2);
		return plusB(temp1, temp2);
	}

	/**
	 * ����A ��  B �ļӷ��� 
	 * @param a
	 * @param b
	 * @return
	 */
	public int plusB1 (int a, int b) {
		return a+b;
	}
	
	
	/*
	 * ׾����
	 * aΪ1ʱ��b��ֵ�ɱ�����������1 1��1 3��1 7��1 15��1 31��1 63��1 127��1 255 ������
	 * bΪ1ʱ��a��ֵֻ��1���ǶԵġ�1 1
	 * 
	 */
}
