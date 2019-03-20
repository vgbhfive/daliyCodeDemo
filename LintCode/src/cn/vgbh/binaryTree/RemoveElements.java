package cn.vgbh.binaryTree;

/*
 * 删除链表中的元素
 * 
 */

public class RemoveElements {

	public static void main(String[] args) {
		
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(1);
		ListNode e = new ListNode(2);
		ListNode f = new ListNode(3);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		
		RemoveElements r = new RemoveElements(); 
		ListNode g = new ListNode(5);
		g = r.removeElements(a, 1);
		
		while (g != null) {
			System.out.println(g.val);
			g = g.next; 
		}
		
	}
	
	 /*
	  * 删除链表的元素
      * @param head: a ListNode
      * @param val: An integer
      * @return: a ListNode
      */
    public ListNode removeElements(ListNode head, int val) {
        ListNode previous = null;//before ListNode
        ListNode take = head;//take ListNode
        
        while (take != null) {
            if (take.val == val) {
            	if (previous == null) {//head
            		head = take.next;
                	take = head;
                    continue;
            	} else {//not head
                    previous.next = take.next;
                    take = previous;
            	}
            }
            //next Node
            previous = take;
            take = take.next;
            /*
            if (take.val == val && previous == null) {
                head = take.next;
                take = head;
                continue;
            }
            if (take.val == val && previous != null) {
                //delete
                previous.next = take.next;
                take = previous;
            }
            previous = take;
            take = take.next;
             */
            
        }
        
        return head;
    }
	
}

class ListNode {
	int val ;
	ListNode next ;
	public ListNode(int val) {
		this.val = val;
	}
}