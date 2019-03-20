package cn.vgbh.designPattern;

/*
 * ����ģʽ��һ�ֳ��������ģʽ����ʵ��һ����߹��� ToyFactory ����������ͬ������ࡣ���Լ���ֻ��è�͹�������ߡ�
 * 
 * 
 */

public class Factory {
	
	public static void main(String[] args) {
		Factory f = new Factory();
		
		Dog dog = (Dog) f.getToy("Dog");
		dog.talk();
		
	}

	public Toy getToy (String toyName) {
		if (toyName.equals("Cat")) return new Cat();
		if (toyName.equals("Dog")) return new Dog();
		
		return null;
	}
	
}

interface Toy {
    void talk();
}

class Dog implements Toy {

	@Override
	public void talk() {
		System.out.println("Wow");
	}

}

class Cat implements Toy {

	@Override
	public void talk() {
		System.out.println("Meow");
	}

}

