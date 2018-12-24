package com.vgbh.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;


import com.vgbh.ReflectDemo;

/*
 * 1.������Ķ�����Class
 * 2.
 */

public class ReflectTest {
	
	public static void main(String[] args) {
		/*
		 * 1.��ȡ���������İ���������
		 */
		System.out.println("1:");
		ReflectDemo rt = new ReflectDemo();
		System.out.println("�����İ�����������" + rt.getClass().getName());
		System.out.println("==========================");
		
		/*
		 * 2.ʵ����Class����󣬹������ַ���
		 */
		System.out.println("2:");
		Class<?> c1 = null;
		Class<? extends ReflectDemo> c2 = null;
		Class<ReflectDemo> c3 = null;
		try {
			c1 = Class.forName("com.vgbh.ReflectDemo"); //����ʹ������
			c2 = new ReflectDemo().getClass();
			c3 = ReflectDemo.class;
			//��ȡClass����������ַ�������Ҳ����಻ͬ
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("ClassName : " + c1.getName());
		System.out.println("ClassName : " + c2.getName());
		System.out.println("ClassName : " + c3.getName());
		System.out.println("============================");
		
		/*
		 * 3.��ȡ������Է������������Ϣ
		 */
		System.out.println("3:");
		try {
			Class c4 = Class.forName("com.vgbh.ReflectDemo"); //��ȡһ�����������
			Method[] m1 = c4.getDeclaredMethods(); //ͨ�������ͻ�ȡ�������з���     getDeclaredMethod(String name)  ��ȡ�ض����Ƶ����Է���
 			for (int i = 0; i < m1.length; i++) {
				System.out.print(m1[i] + " "); //��������ķ���
				Class<?> returnType = m1[i].getReturnType(); //����ֵ����
				Class<?>[] paramsType = m1[i].getParameterTypes(); //��������
				System.out.print(returnType.getName() + "  "); //��ȡ����ֵ������
				for (int j = 0; j < paramsType.length; j++) {
					System.out.print(paramsType[j].getName() + "  "); //��ȡ��ǰ��������������
				}
				System.out.println();
			}
			System.out.println("=====================");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		/*
		 * ��ȡ��Ĺ��캯��
		 */
		System.out.println("4:");
		Class<?> c5 = null;
		try {
			c5 = Class.forName("com.vgbh.ReflectDemo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Constructor<?> con[] = c5.getConstructors(); //��ȡ���ȫ�����췽��
		for (int i = 0; i < con.length; i++) {
			System.out.print(con[i].getName() + "  ");
			Class<?> paramType[] = con[i].getParameterTypes(); //��ȡ���췽���Ĳ�������
			for (int j = 0; j < paramType.length; j++) {
				System.out.print(paramType[j].getName() + "  ");
			}
			System.out.println();
 		}
		System.out.println("=======================");
 		
		/*
		 * ��ȡ��������Բ���
		 */
		System.out.println("5:");
		Class<?> c6 = null;
		try {
			c6 = Class.forName("com.vgbh.ReflectDemo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Field[] f = c6.getDeclaredFields(); //��ȡ�����ȫ������   getDeclaredField(String name)  ��ȡ�ض������Բ���
		for (int i = 0; i < f.length; i++) {
			//System.out.print(f[i].getName() + "  ");
			int p = f[i].getModifiers(); //��ȡ�������Ե�Ȩ��(public/protected/private)
			String priv = Modifier.toString(p);
			Class<?> type = f[i].getType();
			System.out.println(priv + " " + type.getName() + " " + f[i].getName());
		}
		System.out.println("=======================");
		
		/*
		 * ͨ��������ƣ�������ķ���
		 */
		System.out.println("6:");
		Class<?> c7 = null;
		try {
			c7 = Class.forName("com.vgbh.ReflectDemo"); //��ȡ���������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Method method = c7.getMethod("print", int.class, int.class); //��ȡ���з�����Ҫ��ֵ�Ĳ���
			method.invoke(c7.newInstance(), 4, 56); //ͨ��������Ƶ��ø÷��������������
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("====================");
		
		/*
		 * ʵ�����ڷ���ΪInteger��ArrayList�м���һ��String����
		 */
		System.out.println("7:");
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(132));
		try {
			Method method = list.getClass().getMethod("add", Object.class);//ͨ��������ƣ��ƹ�����׶Σ�ֱ�������н׶β������ݡ�
			method.invoke(list, "hello");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
		
		/*
		 * ʵ�������������Ӧ���ڹ���ģʽ
		 * 
		 * �������ReflectDemo
		 */
		
		
	}
	
}
