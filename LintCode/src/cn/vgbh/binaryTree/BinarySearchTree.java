package cn.vgbh.binaryTree;

/*
 * 二叉查找树，将普通的二叉树转换为二叉查找树
 * 
 * 二叉查找树堆的特点:
 * 1、若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
 * 2、若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
 * 3、任意节点的左、右子树也分别为二叉查找树；
 * 4、没有键值相等的节点。
 * 
 */

public class BinarySearchTree {

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
		
		
		BinarySearchTree search = new BinarySearchTree();
		a = search.toBinarySearchTree(a);
		
		System.out.println("\n----------------------");
		
		System.out.println(new BinaryTreeSerialization().serialize(a));//根->左->右 
		
	}
	
	/**
	 * 将普通二叉树转化为二叉查找树
	 * @param root
	 * @return BinarySearchTree
	 */
	public TreeNode toBinarySearchTree (TreeNode root) {
		String str = new BinaryTreeSerialization().serialize(root);
		String[] arr = str.split(",");
		TreeNode node = null;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("#")) {
				continue;
			}
			System.out.print(arr[i] + "  ");
			node = insertBST(node, Integer.parseInt(arr[i]));
		}
		
		/*
		 * 在插入节点问题中，第一个插入的数会成为根节点，而且在以后也不会变化。
		 * 
		 * 想法:1、前期在插入时，首先插入这一列数中的中间值，随后插入其他的数，
		 * 	        以保证二叉查找树的深度和广度的平衡。
		 * 	   2、在插入时，认为的添加根节点。
		 * 	       防止二叉查找树的深度或广度异常。
		 */
		
		return node;
	}
	
	/**
	 * 对二叉树重新规划，插入节点，变为
	 * @param root
	 * @param x
	 * @return 插入节点后的二叉查找树
	 */
	private TreeNode insertBST (TreeNode root, int x) {
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
