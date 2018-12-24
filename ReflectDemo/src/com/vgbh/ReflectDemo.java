package com.vgbh;

public class ReflectDemo {
	
	private int x = 0;
	
	public ReflectDemo () {//默认构造无参
		
	}
	
	public ReflectDemo (int x) {//自己定义的构造方法
		this.x = x;
	}
	
	public void print(int x, int y) {
		System.out.println(x+y);
	}
	
	public void print(String x, String y) {
		System.out.println(x.toUpperCase() + y.toLowerCase());
	}
	
	public static void main(String[] args) {
		Fruit f = Factory.getInstance("com.vgbh.Apple");
		if (f != null) {
			f.eat();
		}
	}
	
	
}

/**
 * 反射机制应用于工厂模式
 */
interface Fruit {
	
	public abstract void eat() ;
	
}

class Apple implements Fruit {
	@Override
	public void eat() {
		System.out.println("eating Apple .....");
	}
}
class Orange implements Fruit {
	@Override
	public void eat() {
		System.out.println("eating Orange ....");
	}
}


class Factory {
	
	public static Fruit getInstance (String ClassName) {
		Fruit f = null;
		try {
			f = (Fruit) Class.forName(ClassName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public static void main(String[] args) {
		Fruit o = Factory.getInstance("com.vgbh.Orange");
		o.eat();
	}
}
