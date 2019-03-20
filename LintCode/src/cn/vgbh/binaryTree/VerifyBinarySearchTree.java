package cn.vgbh.binaryTree;

/*
 * 给定一个二叉树，判断它是否是合法的二叉查找树(BST)
 * 
 * 一棵BST(BinarySearchTree)定义为：
 * 节点的左子树中的值要严格小于该节点的值。
 * 节点的右子树中的值要严格大于该节点的值。
 * 左右子树也必须是二叉查找树。
 * 一个节点的树也是二叉查找树。
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
	 * 验证BST
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
