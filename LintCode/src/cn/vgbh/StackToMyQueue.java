package cn.vgbh;

import java.util.NoSuchElementException;
import java.util.Stack;

/*
 * 需要使用两个栈来实现队列的一些操作。
 * 队列应支持push(element)，pop() 和 top()，
 * 其中pop是弹出队列中的第一个(最前面的)元素。
 * pop和top方法都应该返回第一个元素的值。
 * 
 */

public class StackToMyQueue {
	
	private Stack<Integer> stack1 = new Stack<Integer>();
	private Stack<Integer> stack2 = new Stack<Integer>();
	
	public StackToMyQueue() {
		
	}

	/**
	 * add()方法
	 * @param element
	 */
	public void add (int element) {
		stack1.push(element);
	}
	
	/**
	 * remove()方法
	 * @return Queue顶部元素并删除
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
	 * peek()方法
	 * @return Queue顶部元素但不删除
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
	 * Queue的长度大小
	 * @return 队列长度
	 */
	private int size() {
		return stack1.size();
	}

	//main方法
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
