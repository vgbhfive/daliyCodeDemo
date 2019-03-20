package cn.vgbh.binaryTree;

//not finish

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*
 * ǰ�������
 * ǰ����������ڵ㣬��Ҫʹ�õ�ջ��Stack���������ݽṹ��stack���ص������Ƚ���������������������£�
 * ���Ƚ�A�ڵ�ѹ����У�stack��A��;
 * ��A�ڵ㵯����ͬʱ��A���ӽڵ�C��Bѹ����У���ʱB��ջ�Ķ�����stack(C,B)��
 * ��B�ڵ㵯����ͬʱ��B���ӽڵ�E��Dѹ����У���ʱD��ջ�Ķ�����stack��C,E,D����
 * ��D�ڵ㵯����û���ӽڵ�ѹ��,��ʱE��ջ�Ķ�����stack��C��E����
 * ��E�ڵ㵯����û���ӽڵ�ѹ��,��ʱC��ջ�Ķ�����stack��C����
 * �Դ����Ƽ������ǰ�������
 * 
 * 
 * ���������
 * ������������ڵ㣬��Ҫʹ�õ�ջ��Stack���������ݽṹ��stack���ص������Ƚ���������������������£�
 * ���Ƚ�A�ڵ㸳��һ���node��������while�жϣ�node�ǿգ����룻
 * ��һ��while�жϣ�node�ǿգ�һֱ����node����������ջ����ʱD��ջ�Ķ�����stack{A��B��D}��
 * ��������if�жϣ�stack�ǿգ���D����������D�����ӽڵ㸳��node��nodeΪ�գ�stack�ǿգ�stack{A��B}��
 * ��ʱ����������while���ڲ�whileΪfalse������if�жϣ�
 * ��B������nodeΪ���B�����ӽڵ㣬stack{A}��
 * ��ʱ��һ�ν���������while�������ڲ�while�жϣ�node�ǿգ�stack{A��E}��
 * ����if�жϣ�nodeΪE�ڵ㣬node�����ӽڵ㸳��node��nodeΪ�գ�
 * �Դ����Ƽ������ǰ�������
 * 
 * 
 * ���������
 * ������������ڵ㣬��Ҫʹ��Map�������ݽṹ��
 * ���������������£�
 * 
 * 
 * 
 * �������
 * �����������ڵ㣬��Ҫʹ��Deque(˫�����)������������£�
 * ���Ƚ�root�ڵ�A add�����(queue)�У�ͨ���ж϶���(queue)�ķǿ��ж϶����Ƿ���Ԫ�أ�
 * ��������ȡ(poll()����)����(queue)��ͷԪ�أ�������뷵��ֵlist;
 * ��ʱ�������root�ڵ�����ӽڵ�����ӽڵ㣻
 * �Դ����Ƽ�����ɲ�α�����
 * 
 */

public class BinaryTreeTraversal {

	public static void main(String[] args) {
		
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		TreeNode g = new TreeNode(7);
		
		a.setLeftTreeNode(b);
		a.setRightTreeNode(c);
		b.setLeftTreeNode(d);
		b.setRightTreeNode(e);
		c.setLeftTreeNode(f);
		c.setRightTreeNode(g);
		
		List<Integer> list = new ArrayList<Integer>(); 
		
		BinaryTreeTraversal tree = new BinaryTreeTraversal();
		//list = tree.preorderTraversal(a);
		//list = tree.inorderTraversal(a);
		list = tree.postorderTraversal(a);
		//list = tree.layerTraversal(a);
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next().toString() + "\t");
		}

 	}
	
	/**
	 * ��������ǰ���������->��->��
	 * @param root
	 * @return ������Ԫ��ǰ���������
	 */
	public List<Integer> preorderTraversal (TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.getValue());
			if (node.getRightTreeNode() != null) {
				stack.push(node.getRightTreeNode());
			}
			if (node.getLeftTreeNode() != null) {
				stack.push(node.getLeftTreeNode());
			}
		}
		
		return list;
	}
	
	/**
	 * �������������������->��->��
	 * @param root
	 * @return ������Ԫ�ص������������
	 */
	public List<Integer> inorderTraversal (TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;

		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.getLeftTreeNode();
			}
			if (!stack.isEmpty()) {
				node = stack.pop();
				list.add(node.getValue());
				node = node.getRightTreeNode();
			}
		}

		return list;
	}
	
	/**
	 * �������ĺ����������->��->��
	 * @param root
	 * @return ������Ԫ�صĺ����������
	 */
	// not Finish
	public List<Integer> postorderTraversal (TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		if (root == null) return list;
		stack.push(root);
		while (!stack.isEmpty()) {
			
		}
		
		
		return null;
		
		/*
		//��������ǵݹ�ʵ��
		public static void postOrderStack(Node root){  
	        if(root==null)return;  
	        Stack<Node> s=new Stack<Node>();  
	        Map<Node,Boolean> map=new HashMap<Node,Boolean>();   
	        s.push(root);  
	        while(!s.isEmpty()){  
	            Node temp=s.peek();  
	            if(temp.left!=null&&!map.containsKey(temp.left)){  
	                temp=temp.left;  
	                while(temp!=null){  
	                    if(map.containsKey(temp))break;  
	                    else s.push(temp);  
	                    temp=temp.left;  
	                }  
	                continue;  
	            }  
	            if(temp.right!=null&&!map.containsKey(temp.right)){  
	                s.push(temp.right);  
	                continue;  
	            }  
	            Node t=s.pop();  
	            map.put(t,true);  
	            System.out.println(t.value);  
	        }  
	    }
	    
	    //������������ݹ�ʵ��
	     public void postOrder(Node localRoot){
	         if (localRoot != null) {
	             postOrder(localRoot.left);
	             postOrder(localRoot.right);
	            System.out.print(localRoot.data + " ");
	         }
	     }
		 */
		
	}
	
	/**
	 * �������Ĳ�α���
	 * @param root
	 * @return ������Ԫ�صĲ�α�������
	 */
	public List<Integer> layerTraversal (TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
		
		deque.add(root);
		if (root == null) return list;
		while (!deque.isEmpty()) {
			//Deque����(˫�����)��poll()���������ض��е���Ԫ�أ���ɾ����
			TreeNode node = deque.poll();
			list.add(node.getValue());
			if (node.getLeftTreeNode() != null) {
				deque.add(node.getLeftTreeNode());
			}
			if (node.getRightTreeNode() != null) {
				deque.add(node.getRightTreeNode());
			}
		}
		
		return list;
	}
	
	
	
}
