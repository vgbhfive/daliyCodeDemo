package com.vgbh.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;


import com.vgbh.ReflectDemo;

/*
 * 1.所有类的对象都是Class
 * 2.
 */

public class ReflectTest {
	
	public static void main(String[] args) {
		/*
		 * 1.获取对象完整的包名和类名
		 */
		System.out.println("1:");
		ReflectDemo rt = new ReflectDemo();
		System.out.println("完整的包名和类名：" + rt.getClass().getName());
		System.out.println("==========================");
		
		/*
		 * 2.实例化Class类对象，共有三种方法
		 */
		System.out.println("2:");
		Class<?> c1 = null;
		Class<? extends ReflectDemo> c2 = null;
		Class<ReflectDemo> c3 = null;
		try {
			c1 = Class.forName("com.vgbh.ReflectDemo"); //经常使用这种
			c2 = new ReflectDemo().getClass();
			c3 = ReflectDemo.class;
			//获取Class类对象，有三种方法，但也有许多不同
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("ClassName : " + c1.getName());
		System.out.println("ClassName : " + c2.getName());
		System.out.println("ClassName : " + c3.getName());
		System.out.println("============================");
		
		/*
		 * 3.获取类的属性方法及其参数信息
		 */
		System.out.println("3:");
		try {
			Class c4 = Class.forName("com.vgbh.ReflectDemo"); //获取一个类的类类型
			Method[] m1 = c4.getDeclaredMethods(); //通过类类型获取他的所有方法     getDeclaredMethod(String name)  获取特定名称的属性方法
 			for (int i = 0; i < m1.length; i++) {
				System.out.print(m1[i] + " "); //输出这个类的方法
				Class<?> returnType = m1[i].getReturnType(); //返回值类型
				Class<?>[] paramsType = m1[i].getParameterTypes(); //参数类型
				System.out.print(returnType.getName() + "  "); //获取返回值的类型
				for (int j = 0; j < paramsType.length; j++) {
					System.out.print(paramsType[j].getName() + "  "); //获取当前方法参数的类型
				}
				System.out.println();
			}
			System.out.println("=====================");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		/*
		 * 获取类的构造函数
		 */
		System.out.println("4:");
		Class<?> c5 = null;
		try {
			c5 = Class.forName("com.vgbh.ReflectDemo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Constructor<?> con[] = c5.getConstructors(); //获取类的全部构造方法
		for (int i = 0; i < con.length; i++) {
			System.out.print(con[i].getName() + "  ");
			Class<?> paramType[] = con[i].getParameterTypes(); //获取构造方法的参数属性
			for (int j = 0; j < paramType.length; j++) {
				System.out.print(paramType[j].getName() + "  ");
			}
			System.out.println();
 		}
		System.out.println("=======================");
 		
		/*
		 * 获取该类的属性参数
		 */
		System.out.println("5:");
		Class<?> c6 = null;
		try {
			c6 = Class.forName("com.vgbh.ReflectDemo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Field[] f = c6.getDeclaredFields(); //获取本类的全部属性   getDeclaredField(String name)  获取特定的属性参数
		for (int i = 0; i < f.length; i++) {
			//System.out.print(f[i].getName() + "  ");
			int p = f[i].getModifiers(); //获取本类属性的权限(public/protected/private)
			String priv = Modifier.toString(p);
			Class<?> type = f[i].getType();
			System.out.println(priv + " " + type.getName() + " " + f[i].getName());
		}
		System.out.println("=======================");
		
		/*
		 * 通过反射机制，调用类的方法
		 */
		System.out.println("6:");
		Class<?> c7 = null;
		try {
			c7 = Class.forName("com.vgbh.ReflectDemo"); //获取类的类类型
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Method method = c7.getMethod("print", int.class, int.class); //获取类中方法和要赋值的参数
			method.invoke(c7.newInstance(), 4, 56); //通过反射机制调用该方法，并传入参数
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("====================");
		
		/*
		 * 实例：在泛型为Integer的ArrayList中加入一个String对象
		 */
		System.out.println("7:");
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(132));
		try {
			Method method = list.getClass().getMethod("add", Object.class);//通过反射机制，绕过编译阶段，直接在运行阶段插入数据。
			method.invoke(list, "hello");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
		
		/*
		 * 实例：将反射机制应用于工厂模式
		 * 
		 * 测试详见ReflectDemo
		 */
		
		
	}
	
}
