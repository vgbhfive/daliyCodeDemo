package cn.vgbh.binaryTree;

/*
 * ƽ���������һ�ø߶�ƽ��Ķ������Ķ����ǣ�һ�ö�������ÿ���ڵ������������������ᳬ��1�� 
 * 
 * �ⷨһ�����ÿһ����������ȣ����ɡ�
 * ֻҪ��������������ĸ߶ȣ��Ϳ��Է�����жϳ���������ƽ���������˼·�򵥣������ࡣ
 * 
 * �ⷨ�����������
 * ���ú�������ķ�ʽ������������ÿһ���ڵ㣬�ڱ�����һ���ڵ�֮ǰ���Ǿ��Ѿ���������������������
 * ��ʱ����¼ÿ���ڵ�Ϊ���ڵ�����ĸ߶ȣ��Ϳ���һ�߱���һ���ж�ÿ���ڵ��ǲ���ƽ��ġ�
 * 
 */

public class BalancedBinaryTree {
	
	/**
	 * ����������
	 * @param root
	 * @return �������
	 */
	private int getDepthFromTree (TreeNode root) {
		if (root == null) return 0;
		
		int nLeft = getDepthFromTree(root.getLeftTreeNode());
		int nRight = getDepthFromTree(root.getRightTreeNode());
		
		return nLeft > nRight ? nLeft+1 : nRight+1;
	}

	/**
	 * �ж϶������Ƿ�Ϊƽ�������
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
