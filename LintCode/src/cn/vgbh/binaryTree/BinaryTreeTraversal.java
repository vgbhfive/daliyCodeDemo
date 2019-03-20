package cn.vgbh.binaryTree;

//not finish

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*
 * 前序遍历：
 * 前序遍历各个节点，需要使用到栈（Stack）这种数据结构。stack的特点是是先进后出。整个遍历过程如下：
 * 首先将A节点压入堆中，stack（A）;
 * 将A节点弹出，同时将A的子节点C，B压入堆中，此时B在栈的顶部，stack(C,B)；
 * 将B节点弹出，同时将B的子节点E，D压入堆中，此时D在栈的顶部，stack（C,E,D）；
 * 将D节点弹出，没有子节点压入,此时E在栈的顶部，stack（C，E）；
 * 将E节点弹出，没有子节点压入,此时C在栈的顶部，stack（C）；
 * 以此类推即可完成前序遍历；
 * 
 * 
 * 中序遍历：
 * 中序遍历各个节点，需要使用到栈（Stack）这种数据结构。stack的特点是是先进后出。整个遍历过程如下：
 * 首先将A节点赋给一结点node，并进入while判断，node非空，进入；
 * 第一个while判断，node非空，一直将该node的左树加入栈，此时D在栈的顶部，stack{A，B，D}；
 * 下来进入if判断，stack非空，将D弹出，并将D的右子节点赋给node，node为空，stack非空，stack{A，B}；
 * 此时进入最外层的while，内层while为false，进入if判断，
 * 将B弹出，node为结点B的右子节点，stack{A}；
 * 此时再一次进入最外层的while，进入内层while判断，node非空，stack{A，E}；
 * 进入if判断，node为E节点，node的右子节点赋给node，node为空；
 * 以此类推即可完成前序遍历；
 * 
 * 
 * 后序遍历：
 * 后序遍历各个节点，需要使用Map这种数据结构。
 * 整个便利过程如下：
 * 
 * 
 * 
 * 层次排序：
 * 层次排序各个节点，需要使用Deque(双向队列)，整体过程如下：
 * 首先将root节点A add入队列(queue)中，通过判断队列(queue)的非空判断队列是否还有元素；
 * 接下来获取(poll()函数)队列(queue)的头元素，并添加入返回值list;
 * 此时依次添加root节点的左子节点和右子节点；
 * 以此类推即可完成层次遍历；
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
	 * 二叉树的前序遍历：根->左->右
	 * @param root
	 * @return 二叉树元素前序遍历集合
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
	 * 二叉树的中序遍历：左->根->右
	 * @param root
	 * @return 二叉树元素的中序遍历集合
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
	 * 二叉树的后序遍历：左->右->根
	 * @param root
	 * @return 二叉树元素的后序遍历集合
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
		//后序排序非递归实现
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
	    
	    //后序遍历方法递归实现
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
	 * 二叉树的层次遍历
	 * @param root
	 * @return 二叉树元素的层次遍历集合
	 */
	public List<Integer> layerTraversal (TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
		
		deque.add(root);
		if (root == null) return list;
		while (!deque.isEmpty()) {
			//Deque队列(双向队列)的poll()函数，返回队列的首元素，并删除。
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
