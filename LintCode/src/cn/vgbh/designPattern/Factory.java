package cn.vgbh.designPattern;

/*
 * 工厂模式是一种常见的设计模式。请实现一个玩具工厂 ToyFactory 用来产生不同的玩具类。可以假设只有猫和狗两种玩具。
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

