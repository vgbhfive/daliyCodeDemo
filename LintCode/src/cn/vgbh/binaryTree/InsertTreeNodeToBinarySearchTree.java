package cn.vgbh.binaryTree;

/*
 * ����һ�ö����������һ���µ����ڵ㣬���ڵ���뵽���С�
 * ����Ҫ��֤������Ȼ��һ�ö����������
 * 
 * ��ʹ�õݹ�
 * 
 * ����
 * ��������һ�ö�����������ڲ���ڵ�6֮����ö�������������������ģ�
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
		
		//��������ת��Ϊ���������
		a = new BinarySearchTree().toBinarySearchTree(a); 
		
		//����ڵ�Node
		InsertTreeNodeToBinarySearchTree insert = new InsertTreeNodeToBinarySearchTree();
		TreeNode node = new TreeNode(13);
		a = insert.insertNode(a, node);
		
		//��ӡ�������node��Ķ�����
		System.out.println("\n------------------");
		System.out.println(new BinaryTreeSerialization().serialize(a));//��->��->��
		
	}
	
	/**
	 * ����������в���ڵ�
	 * @param root
	 * @param node
	 * @return ����ڵ�������Ķ��������
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
