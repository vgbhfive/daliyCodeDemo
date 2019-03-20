package cn.vgbh.binaryTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 给定两个值 k1 和 k2（k1 < k2）和一个二叉查找树的根节点。找到树中所有值在 k1 到 k2 范围内的节点。
 * 即打印所有x (k1 <= x <= k2) 其中 x 是二叉查找树的中的节点值。返回所有升序的节点值。
 * 
 * 二叉查找树：
 * 1、若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
 * 2、若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
 * 3、任意节点的左、右子树也分别为二叉查找树；
 * 4、没有键值相等的节点。
 * 
 * 实现：
 * 使用递归实现，当root节点的值大于等于k1，并且小于等于k2，则分别去寻找他的左节点和右节点。
 * 若小于k1，则去寻找root的右节点。
 * 若大于k2，则去寻找root的左节点。
 * 
 */

public class SearchRandFromBinaryTree {
	
	private List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		TreeNode g = new TreeNode(7);
		
		d.setLeftTreeNode(b);
		d.setRightTreeNode(f);
		b.setLeftTreeNode(a);
		b.setRightTreeNode(c);
		f.setLeftTreeNode(e);
		f.setRightTreeNode(g);
		
		
		SearchRandFromBinaryTree s = new SearchRandFromBinaryTree();
		
		List<Integer> list = new ArrayList<Integer>();
		list = s.searchRange(d, 2, 5);
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next().toString() + "\t");
		}
		
		
	}
	
	/**
	 * 遍历二叉树区间
	 * @param root (二叉查找树的根节点)
	 * @param k1
	 * @param k2
	 * @return 区间内的值
	 */
	public List<Integer> searchRange (TreeNode root, int k1, int k2) {
		if (root == null) return list;
		
		if (root.getValue() >= k1 && root.getValue() <= k2) {
			list.add(root.getValue());
			searchRange(root.getLeftTreeNode(), k1, k2);
			searchRange(root.getRightTreeNode(), k1, k2);
		} else if (root.getValue() < k1) {
			searchRange(root.getRightTreeNode(), k1, k2);
		} else if (root.getValue() > k2) {
			searchRange(root.getLeftTreeNode(), k1, k2);
		}
		
		return list;
	}

	
}

