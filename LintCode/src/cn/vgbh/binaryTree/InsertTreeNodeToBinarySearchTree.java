package cn.vgbh.binaryTree;

/*
 * 给定一棵二叉查找树和一个新的树节点，将节点插入到树中。
 * 你需要保证该树仍然是一棵二叉查找树。
 * 
 * 不使用递归
 * 
 * 例：
 * 给出如下一棵二叉查找树，在插入节点6之后这棵二叉查找树可以是这样的：
 * 	  2             2
 * 	 / \           / \
 * 	1   4   -->   1   4
 * 	   /             / \ 
 * 	  3             3   6
 * 
 */

public class InsertTreeNodeToBinarySearchTree {

	
	public static void main(String[] args) {

		TreeNode a = new TreeNode(5);
		TreeNode b = new TreeNode(22);
		TreeNode c = new TreeNode(23);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(35);
		TreeNode f = new TreeNode(16);
		TreeNode g = new TreeNode(71);
		
		a.setLeftTreeNode(b);
		a.setRightTreeNode(c);
		b.setLeftTreeNode(d);
		b.setRightTreeNode(e);
		c.setLeftTreeNode(f);
		c.setRightTreeNode(g);
		
		//将二叉树转换为二叉查找树
		a = new BinarySearchTree().toBinarySearchTree(a); 
		
		//插入节点Node
		InsertTreeNodeToBinarySearchTree insert = new InsertTreeNodeToBinarySearchTree();
		TreeNode node = new TreeNode(13);
		a = insert.insertNode(a, node);
		
		//打印输出插入node后的二叉树
		System.out.println("\n------------------");
		System.out.println(new BinaryTreeSerialization().serialize(a));//根->左->右
		
	}
	
	/**
	 * 二叉查找树中插入节点
	 * @param root
	 * @param node
	 * @return 插入节点后并整理后的二叉查找树
	 */
	public TreeNode insertNode(TreeNode root, TreeNode node) {
		int x = node.getValue();
		TreeNode newData = new TreeNode(x);
		
		if (root == null) {
			root = newData;
		} else {
			TreeNode current = root;
			TreeNode parent;
			while (true) {
				parent = current;
				if (x < current.getValue()) {
					current = current.getLeftTreeNode();
					if (current == null) {
						parent.setLeftTreeNode(newData);
						break;
					}
				} else {
					current = current.getRightTreeNode();
					if (current == null) {
						parent.setRightTreeNode(newData);
						break;
					}
				}
			}
		}
		
		return root;
	}
}
