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
     * ���������л�����(DFS)  ��->��->��
     * @param root
     * @return ����ջ(�Ƚ����)�����ض��������л��ַ���
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
     * ���������л�����(BFS)  ��->��->��
     * @param root
     * @return ��������(�Ƚ��ȳ�)�����ض��������л��ַ���
     */
    public String breadFirstSearch (TreeNode root) {
    	Deque<TreeNode> queue = new ArrayDeque<>();//˫�����
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
