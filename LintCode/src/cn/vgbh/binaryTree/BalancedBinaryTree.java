package cn.vgbh.binaryTree;

/*
 * 平衡二叉树：一棵高度平衡的二叉树的定义是：一棵二叉树中每个节点的两个子树的深度相差不会超过1。 
 * 
 * 解法一：求出每一个子树的深度，即可。
 * 只要求出给定二叉树的高度，就可以方便的判断出二叉树是平衡二叉树，思路简单，代码简洁。
 * 
 * 解法二：后序遍历
 * 采用后序遍历的方式遍历二叉树的每一个节点，在遍历到一个节点之前我们就已经遍历了它的左右字数。
 * 此时，记录每个节点为根节点的树的高度，就可以一边遍历一边判断每个节点是不是平衡的。
 * 
 */

public class BalancedBinaryTree {
	
	/**
	 * 求出数的深度
	 * @param root
	 * @return 树的深度
	 */
	private int getDepthFromTree (TreeNode root) {
		if (root == null) return 0;
		
		int nLeft = getDepthFromTree(root.getLeftTreeNode());
		int nRight = getDepthFromTree(root.getRightTreeNode());
		
		return nLeft > nRight ? nLeft+1 : nRight+1;
	}

	/**
	 * 判断二叉树是否为平衡二叉树
	 * @param root
	 * @return true false
	 */
	public boolean isBalancedBinaryTree (TreeNode root) {
		if (root == null) return true;
		
		int left = getDepthFromTree(root.getLeftTreeNode());
		int right = getDepthFromTree(root.getRightTreeNode());
		if (left - right > 1 || right - left > 1) {
			return false;
		}
		
		return isBalancedBinaryTree(root.getLeftTreeNode()) && isBalancedBinaryTree(root.getRightTreeNode());
	}
	
	
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
		//b.setLeftTreeNode(d);
		//b.setRightTreeNode(e);
		c.setLeftTreeNode(f);
		c.setRightTreeNode(g);
		f.setRightTreeNode(e);
		f.setLeftTreeNode(d);
		
		BalancedBinaryTree balance = new BalancedBinaryTree();
		
		System.out.println(balance.isBalancedBinaryTree(a));
		
		
		
		
	}

}
