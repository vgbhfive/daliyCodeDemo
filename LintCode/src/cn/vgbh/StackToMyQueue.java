package cn.vgbh;

import java.util.NoSuchElementException;
import java.util.Stack;

/*
 * ��Ҫʹ������ջ��ʵ�ֶ��е�һЩ������
 * ����Ӧ֧��push(element)��pop() �� top()��
 * ����pop�ǵ��������еĵ�һ��(��ǰ���)Ԫ�ء�
 * pop��top������Ӧ�÷��ص�һ��Ԫ�ص�ֵ��
 * 
 */

public class StackToMyQueue {
	
	private Stack<Integer> stack1 = new Stack<Integer>();
	private Stack<Integer> stack2 = new Stack<Integer>();
	
	public StackToMyQueue() {
		
	}

	/**
	 * add()����
	 * @param element
	 */
	public void add (int element) {
		stack1.push(element);
	}
	
	/**
	 * remove()����
	 * @return Queue����Ԫ�ز�ɾ��
	 */
	public int remove () {
		if (stack1 == null) {
			throw new NoSuchElementException();
		}
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			return stack2.pop();
		} else {
			return stack2.pop();
		}
	}
	
	/**
	 * peek()����
	 * @return Queue����Ԫ�ص���ɾ��
	 */
	public int peek () {
		if (stack1 == null) {
			return (Integer) null;
		}
		int num = -1;
		while (!stack1.isEmpty()) {
			if (stack1.size() == 1) {
				num = stack1.peek();
				while (!stack2.isEmpty()) {
					stack1.push(stack2.pop());
				}
				return num;
			}
			stack2.push(stack1.pop());
		}
		return num;
	}
	
	/**
	 * Queue�ĳ��ȴ�С
	 * @return ���г���
	 */
	private int size() {
		return stack1.size();
	}

	//main����
	public static void main(String[] args) {
		StackToMyQueue queue = new StackToMyQueue();
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		queue.add(4);
		System.out.println(queue.peek());
		System.out.println("------------------------");
		for (int i = 0; i <= queue.size(); i++) {
			System.out.println(queue.remove());
		}
	
	}


	
}
