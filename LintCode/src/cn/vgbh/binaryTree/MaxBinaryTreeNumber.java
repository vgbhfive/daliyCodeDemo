package cn.vgbh.binaryTree;

/*
 * 在二叉树中寻找值最大的节点并返回。
 */

public class MaxBinaryTreeNumber {

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
		
		MaxBinaryTreeNumber m = new MaxBinaryTreeNumber();
		System.out.println(m.getMaxNumberFromBinaryTree(a).getValue());
		
	}
	
	//默认最大的TreeNode
	TreeNode max = new TreeNode(-100000);
	
	/**
	 * 获取二叉树的最大节点
	 * @param node
	 * @return Max TreeNode
	 */
	private TreeNode getMaxNumberFromBinaryTree (TreeNode node) {
		if (node == null) return null;
		if (node.getValue() > max.getValue()) {
			max.setValue(node.getValue());
			
		}
		getMaxNumberFromBinaryTree(node.getLeftTreeNode());
		getMaxNumberFromBinaryTree(node.getRightTreeNode());
		
		return max;
	}
	
	
		
	
	
	
	
	
}
