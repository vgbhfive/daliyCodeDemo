package cn.vgbh.binaryTree;


public class TreeNode {
	private int value = 0;
	private TreeNode leftTreeNode = null;
	private TreeNode rightTreeNode = null;
	
	public TreeNode () {}
	
	public TreeNode(int value) {
		this.value = value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	public void setLeftTreeNode(TreeNode leftTreeNode) {
		this.leftTreeNode = leftTreeNode;
	}

	public void setRightTreeNode(TreeNode rightTreeNode) {
		this.rightTreeNode = rightTreeNode;
	}

	public int getValue() {
		return value;
	}
	
	public TreeNode getLeftTreeNode() {
		return leftTreeNode;
	}
	
	public TreeNode getRightTreeNode() {
		return rightTreeNode;
	}
	
}
