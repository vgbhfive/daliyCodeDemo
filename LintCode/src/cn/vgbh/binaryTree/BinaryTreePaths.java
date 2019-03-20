package cn.vgbh.binaryTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 二叉树路径
 */

public class BinaryTreePaths {

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
		
		BinaryTreePaths sss = new BinaryTreePaths();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list = sss.binaryTreePathSum(a, 5);
		for (Iterator<List<Integer>> iterator = list.iterator(); iterator.hasNext();) {
			List<Integer> list2 = (List<Integer>) iterator.next();
			for (Iterator<Integer> iterator2 = list2.iterator(); iterator2.hasNext();) {
				Integer integer = (Integer) iterator2.next();
				System.out.print(integer + "    ");
			}
		}
		
	}
	
	/**
	 * 获取二叉树target目标的特定分支
	 * @param root
	 * @param target
	 * @return 二叉树分支
	 */
	public List<List<Integer>> binaryTreePathSum (TreeNode root, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		//path.add(root.getValue());
		search(root, target, path, list);
		
		return list;
	}
	
	/**
	 * 递归遍历所有分支
	 * @param root
	 * @param target
	 * @param path
	 * @param list
	 */
	private void search (TreeNode root, int target, List<Integer> path, List<List<Integer>> list) {
		if (root == null) return ;
		
		if (root.getValue() == target) {
			path.add(root.getValue());
			//System.out.println(root.getValue() + "dddddd");
			list.add(path);
			return ;
		}
		if (root.getLeftTreeNode() != null) {
			List<Integer> left = new ArrayList<Integer>();
			//System.out.println(root.getValue() + "    ssssssss1ssss");
			left.addAll(path);
			left.add(root.getValue());
			search(root.getLeftTreeNode(), target, left, list);
		}
		if (root.getRightTreeNode() != null) {
			List<Integer> right = new ArrayList<Integer>();
			//System.out.println(root.getValue() + "    ssssssss2sss");
			right.addAll(path);
			right.add(root.getValue());
			search(root.getRightTreeNode(), target, right, list);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
