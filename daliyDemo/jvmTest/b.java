package jvmTest;

/**
 * @auther Vgbh
 *
 */

public class b {

	public static void main(String[] args) {
		new b().hello(400);
	}
	
	public void hello(Integer x) {
		for (int i = 0; i < x; i++) {
			if ((i%100) == 0) {
				Object obj = new Object();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i + " Hello World!");
		}
	}
	
	
}
