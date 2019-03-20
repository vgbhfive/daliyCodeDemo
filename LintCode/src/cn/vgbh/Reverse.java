package cn.vgbh;

import java.util.Stack;

/*
 * 翻转一个链表
 */

public class Reverse {
	
	public static void main(String[] args) {
		
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		
		Reverse re = new Reverse();
		ListNode s = re.reverse(a);
		
		while (s != null) {
			System.out.println(s.val);
			s = s.next;
		}
		
	}

	/**
	 * 翻转链表
	 * @param head
	 * @return 翻转链表的头指针
	 */
	public ListNode reverse(ListNode head) {
        // write your code here
        Stack<ListNode> stack = new Stack<ListNode>();
        if (head == null) return head;
        
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        
        ListNode node = stack.pop();
        //链表构成
//        while (stack.size() > 0) {
//            node.next = stack.pop();
//        }
        
        return node;
    }
	
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

