package cn.vgbh.binaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class DFSAndBFS {

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
		
		DFSAndBFS dfs = new DFSAndBFS();
		System.out.println(dfs.depthFirstSearch(a));
		System.out.println(dfs.breadFirstSearch(a));
		
	}
	
	/**
     * 二叉树序列化操作(DFS)  根->左->右
     * @param root
     * @return 借助栈(先进后出)，返回二叉树序列化字符串
     */
    public String depthFirstSearch (TreeNode root) {
    	StringBuilder str = new StringBuilder();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			str.append(node.getValue() + ",");
			if (node.getRightTreeNode() != null) {
				stack.push(node.getRightTreeNode());
			}
			if (node.getLeftTreeNode() != null) {
				stack.push(node.getLeftTreeNode());
			}
		}
    	
    	return str.toString();	
	}
    
    /**
     * 二叉树序列化操作(BFS)  根->左->右
     * @param root
     * @return 借助队列(先进先出)，返回二叉树序列化字符串
     */
    public String breadFirstSearch (TreeNode root) {
    	Deque<TreeNode> queue = new ArrayDeque<>();//双向队列
    	StringBuilder str = new StringBuilder();
    	
    	queue.add(root);
    	while (!queue.isEmpty()) {
    		TreeNode node = queue.pop();
    		str.append(node.getValue() + ",");
    		if (node.getRightTreeNode() != null) {
    			queue.push(node.getRightTreeNode());
    		}
    		if (node.getLeftTreeNode() != null) {
    			queue.push(node.getLeftTreeNode());
    		}
    	}
    	
    	return str.toString();
	}
	
    
    
}
