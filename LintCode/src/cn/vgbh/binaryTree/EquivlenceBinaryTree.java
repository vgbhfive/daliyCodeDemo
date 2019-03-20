package cn.vgbh.binaryTree;

import java.util.ArrayList;
import java.util.List;

/*
 * 等价二叉树
 * 条件：值相同，分值相同
 * 
 * 注：善于使用Object对象的equals()方法。
 */

public class EquivlenceBinaryTree {

	public static void main(String[] args) {
		
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(1);
		TreeNode e = new TreeNode(2);
		TreeNode f = new TreeNode(3);
		TreeNode g = new TreeNode(7);
		
		a.setLeftTreeNode(b);
		a.setRightTreeNode(c);
		
		d.setLeftTreeNode(e);
		d.setRightTreeNode(f);
		e.setLeftTreeNode(g);
		
		EquivlenceBinaryTree equivlence = new EquivlenceBinaryTree();
		if (equivlence.equivlenceBinaryTree(a, d)) {
			System.out.println("same!");
		} else {
			System.out.println("not same!");
		}
		
		
	}
	
	public boolean equivlenceBinaryTree (TreeNode a, TreeNode d) {
		List<List<Integer>> list1 = new ArrayList<List<Integer>>();
		List<List<Integer>> list2 = new ArrayList<List<Integer>>();
		
		BinaryTreePathSum bin = new BinaryTreePathSum();
		list1 = bin.binaryTreePathSum(a);
		list2 = bin.binaryTreePathSum(d);
		if (list1.equals(list2)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	
}
