package cn.vgbh.binaryTree;

/*
 * ����һ�����������ж����Ƿ��ǺϷ��Ķ��������(BST)
 * 
 * һ��BST(BinarySearchTree)����Ϊ��
 * �ڵ���������е�ֵҪ�ϸ�С�ڸýڵ��ֵ��
 * �ڵ���������е�ֵҪ�ϸ���ڸýڵ��ֵ��
 * ��������Ҳ�����Ƕ����������
 * һ���ڵ����Ҳ�Ƕ����������
 * 
 * 
 */

public class VerifyBinarySearchTree {

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		TreeNode g = new TreeNode(7);
		
		e.setLeftTreeNode(c);
		e.setRightTreeNode(f);
		f.setRightTreeNode(g);
		c.setLeftTreeNode(b);
		c.setRightTreeNode(d);
		b.setLeftTreeNode(a);
		
		
//		a.setLeftTreeNode(b);
//		a.setRightTreeNode(c);
//		b.setLeftTreeNode(d);
//		b.setRightTreeNode(e);
//		c.setLeftTreeNode(f);
//		c.setRightTreeNode(g);
		
		VerifyBinarySearchTree verify = new VerifyBinarySearchTree();
		//System.out.println(verify.verifyBST(e));
		
		System.out.println(verify.isValidBST(e));
	}
	
	/**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        boolean result = false;
        
        if (root == null) {
            result = true;
        } else if (root.getRightTreeNode() == null && root.getLeftTreeNode() == null) {
            result = true;
        } else if (root.getLeftTreeNode() == null) {
            if (root.getRightTreeNode().getValue() > root.getValue()) {
                if (root.getRightTreeNode().getLeftTreeNode() == null || 
                		root.getRightTreeNode().getLeftTreeNode().getValue() > root.getValue()){
                    result = true;
                }
            }
            result = result && isValidBST(root.getRightTreeNode());
        } else if (root.getRightTreeNode() == null) {
            if (root.getLeftTreeNode().getValue() < root.getValue()) {
                if (root.getLeftTreeNode().getRightTreeNode() == null || 
                		root.getLeftTreeNode().getRightTreeNode().getValue() < root.getValue()) {
                    result = true;
                }
            }
            result = result && isValidBST(root.getLeftTreeNode());
        } else {
            boolean tmp = false;
            if (root.getLeftTreeNode().getValue() < root.getValue() && 
            		root.getRightTreeNode().getValue() > root.getValue()){
                if (root.getRightTreeNode().getLeftTreeNode() == null || 
                		root.getRightTreeNode().getLeftTreeNode().getValue() > root.getValue()){
                    result = true;
                }
                if (root.getLeftTreeNode().getRightTreeNode() == null || 
                		root.getLeftTreeNode().getRightTreeNode().getValue() < root.getValue()){
                    tmp = true;
                }
            }
            result = result && tmp && isValidBST(root.getLeftTreeNode()) && isValidBST(root.getRightTreeNode());
        }
     
        return result;   
    }
	
	/**
	 * ��֤BST
	 * @param root
	 * @return True Or False
	 */
	public boolean verifyBST (TreeNode root) {
		if (root == null) return false;
		boolean flag = true;
		
		if (root.getLeftTreeNode() != null) {
			if (root.getLeftTreeNode().getValue() < root.getValue()) {
				flag = verifyBST(root.getLeftTreeNode());
			} else {
				//System.out.println(root.getLeftTreeNode().getValue());
				//System.out.println("--------");
				return false;
			}
		} 
		if (root.getRightTreeNode() != null) {
			if (root.getRightTreeNode().getValue() > root.getValue()) {
				flag = verifyBST(root.getRightTreeNode());
			} else {
				//System.out.println(root.getRightTreeNode().getValue());
				//System.out.println("++++++++");
				return false;
			}	
		} 
		
		return flag;
	}
	
}
