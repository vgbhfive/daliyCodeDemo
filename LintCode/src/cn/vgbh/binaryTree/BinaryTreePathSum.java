package cn.vgbh.binaryTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 二叉树的所有路径
 */

public class BinaryTreePathSum {

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
		
		BinaryTreePathSum ssss = new BinaryTreePathSum();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list = ssss.binaryTreePathSum(a);
		for (Iterator<List<Integer>> iterator = list.iterator(); iterator.hasNext();) {
			List<Integer> list2 = (List<Integer>) iterator.next();
			for (Iterator<Integer> iterator2 = list2.iterator(); iterator2.hasNext();) {
				Integer integer = (Integer) iterator2.next();
				System.out.print(integer + "   ");
			}
			System.out.println();
		}
		
		
	}
	
	/**
	 * 获取二叉树的所有路径
	 * @param root
	 * @return 二叉树路径集合
	 */
	public List<List<Integer>> binaryTreePathSum (TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		search (root, path, list);
		
		return list;
	}
	
	/**
	 * 递归遍历二叉树路径
	 * @param root
	 * @param path
	 * @param list
	 */
	private void search (TreeNode root, List<Integer> path, List<List<Integer>> list) {
		if (root.getLeftTreeNode() == null && root.getRightTreeNode() == null) {
			path.add(root.getValue());
			list.add(path);
			return ;
		}
		if (root.getLeftTreeNode() != null) {
			List<Integer> left = new ArrayList<Integer>();
			left.addAll(path);
			left.add(root.getValue());
			search (root.getLeftTreeNode(), left, list);
		}
		if (root.getRightTreeNode() != null) {
			List<Integer> right = new ArrayList<Integer>();
			right.addAll(path);
			right.add(root.getValue());
			search (root.getRightTreeNode(), right, list);
		}
	}
	
	
}
