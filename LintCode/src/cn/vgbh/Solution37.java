package cn.vgbh;

public class Solution37 {
	
	public static Integer solution (Integer x) {
		int[] arr = new int[3];
		
		for (int i = 0; i < 3; i++) {
			arr[i] = x / (int) Math.pow(10, 2 - i) % 10;
		}
		
		int temp = arr[0];
		arr[0] = arr[2];
		arr[2] = temp;
		
		return arr[0] * 100 + arr[1] * 10 + arr[2];
	}
	
	public static void main(String[] args) {
		System.out.println(Solution37.solution(900));
	}

}
