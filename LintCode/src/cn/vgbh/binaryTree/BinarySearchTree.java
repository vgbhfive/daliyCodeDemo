package cn.vgbh.binaryTree;

/*
 * ���������������ͨ�Ķ�����ת��Ϊ���������
 * 
 * ����������ѵ��ص�:
 * 1��������ڵ�����������գ��������������нڵ��ֵ��С�����ĸ��ڵ��ֵ��
 * 2��������ڵ�����������գ��������������нڵ��ֵ���������ĸ��ڵ��ֵ��
 * 3������ڵ����������Ҳ�ֱ�Ϊ�����������
 * 4��û�м�ֵ��ȵĽڵ㡣
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
		
		System.out.println(new BinaryTreeSerialization().serialize(a));//��->��->�� 
		
	}
	
	/**
	 * ����ͨ������ת��Ϊ���������
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
		 * �ڲ���ڵ������У���һ������������Ϊ���ڵ㣬�������Ժ�Ҳ����仯��
		 * 
		 * �뷨:1��ǰ���ڲ���ʱ�����Ȳ�����һ�����е��м�ֵ������������������
		 * 	        �Ա�֤�������������Ⱥ͹�ȵ�ƽ�⡣
		 * 	   2���ڲ���ʱ����Ϊ����Ӹ��ڵ㡣
		 * 	       ��ֹ�������������Ȼ����쳣��
		 */
		
		return node;
	}
	
	/**
	 * �Զ��������¹滮������ڵ㣬��Ϊ
	 * @param root
	 * @param x
	 * @return ����ڵ��Ķ��������
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
