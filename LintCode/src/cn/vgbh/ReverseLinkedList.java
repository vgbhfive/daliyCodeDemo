package cn.vgbh;

/**
 * 翻转一个链表
 * @author Vgbh
 *
 */
public class ReverseLinkedList {
	
	public static void main(String[] args) {
		ReverseLinkedList r = new ReverseLinkedList();
		ListNode head = new ListNode(1);
		ListNode one = new ListNode(2);
		ListNode two = new ListNode(3);
		ListNode three = new ListNode(4);
		ListNode four = new ListNode(5);
		head.next = one;
		one.next = two;
		two.next = three;
		three.next = four;
		
		ListNode res = r.reverse(head);
		
		while (res != null) {
			System.out.print(res.val + "  ");
			res = res.next;
		}
		
	}
	

	/**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode curr = head;
        ListNode next = curr.next;
        
        while (next != null) {
            ListNode temp = next.next;
            next.next = curr;
            curr = next;
            next = temp;
            
//            if (next == null) {
//                System.out.println(curr.val );
//            } else if (temp == null) {
//                System.out.println(curr.val + "   " + next.val);
//            } else{
//                System.out.println(curr.val + "   " + next.val + "   " + temp.val );
//            }
            
        }
        
        head.next = null;
        return curr;
    }
    
    
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            val = x;
            next = null;
        }
    }
	
}


