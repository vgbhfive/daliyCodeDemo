package cn.vgbh.mathematic;

/*
 * �����ݣ���������ȡģ�㷨��������һ����ʽ���ࡣ
 * ��ʽ��a ^ b % c = ?
 * 
 * ��ʽ��
 * ((a ^ 2) ^ (b / 2)) % c     : bΪż��
 * ((a ^ 2) ^ (b / 2) * a) % c : bΪ����
 * 
 * ��Ϊ��λ�Ը�λ��Ӱ�죬����ȡ�����ȡ��Ļ�ȡ�ࡣ
 * 
 * ��⣺
 * count = (a ^ 2) ^ (b / 2)
 * b /= 2 ���ɶ�������Сb����count���д���
 * a 
 * 
 */

public class FastPower {

	/**
	 * �����ݵ�ȡ��
	 * @param a
	 * @param b
	 * @param c
	 * @return (a ^ b) mod c
	 */
	public int fasePower (int a, int b, int c) {
		int count = 1;
		a = a % c;
		while (b > 0) {
			if ((b % 2) == 1) //����
				count = (count * a) % c;
			b /= 2;
			a = (a * a) % c;	
			
			//System.out.println("   b:" + b + "   count:" + count + "   a:" + a); 
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		
		FastPower fast = new FastPower();
		
		System.out.println(fast.fasePower(3, 7, 2));
		
		
		
	}
	
}
