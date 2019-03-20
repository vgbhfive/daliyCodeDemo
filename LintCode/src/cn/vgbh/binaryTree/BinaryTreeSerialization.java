package cn.vgbh.binaryTree;

/*
 * �����������л��ͷ����л�
 * 
 * ��������
 * a(1)
 * b(2) c(3)
 * d(4) e(5) f(6) g(7)
 * 
 * ջ��
 * ������ȱ��������ڵ㣬��Ҫʹ�õ��ѣ�Stack���������ݽṹ��stack���ص������Ƚ���������������������£�
 * ���Ƚ�A�ڵ�ѹ����У�stack��A��;
 * ��A�ڵ㵯����ͬʱ��A���ӽڵ�C��Bѹ����У���ʱB�ڶѵĶ�����stack(B,C)��
 * ��B�ڵ㵯����ͬʱ��B���ӽڵ�E��Dѹ����У���ʱD�ڶѵĶ�����stack��D,E,C����
 * ��D�ڵ㵯����û���ӽڵ�ѹ��,��ʱE�ڶѵĶ�����stack��E��C����
 * ��E�ڵ㵯����ͬʱ��E���ӽڵ�Iѹ�룬stack��I,C����
 * 
 * 
 * ���У�
 * ������ȱ��������ڵ㣬��Ҫʹ�õ����У�Queue���������ݽṹ��queue���ص����Ƚ��ȳ�����ʵҲ����ʹ��˫�˶��У��������˫�˶�����λ�����Բ���͵����ڵ㡣���������������£�
 * ���Ƚ�A�ڵ��������У�queue��A��;
 * ��A�ڵ㵯����ͬʱ��A���ӽڵ�B��C��������У���ʱB�ڶ����ף�C�ڶ���β����queue��B��C����
 * ��B�ڵ㵯����ͬʱ��B���ӽڵ�D��E��������У���ʱC�ڶ����ף�E�ڶ���β����queue��C��D��E��;
 * ��C�ڵ㵯����ͬʱ��C���ӽڵ�F��G��H��������У���ʱD�ڶ����ף�H�ڶ���β����queue��D��E��F��G��H����
 * ��D�ڵ㵯����Dû���ӽڵ㣬��ʱE�ڶ����ף�H�ڶ���β����queue��E��F��G��H����
 * 
 */

public class BinaryTreeSerialization {
	
    private int index ;//�����л����ַ�����ĵ�ָ��

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
		
		//root:a
		
		BinaryTreeSerialization binary = new BinaryTreeSerialization();
		DFSAndBFS dfsbfs = new DFSAndBFS();
		//serialization
		//1:
		String s = binary.serialize(a);
		System.out.println(s);
		//2:
		System.out.println(dfsbfs.depthFirstSearch(a));
		//3:
		System.out.println(dfsbfs.breadFirstSearch(a));
		
		
		//deserialization
		TreeNode node = binary.deserialize(s);
		System.out.println("value:");
		System.out.println(node.getValue());//root
		System.out.println(node.getLeftTreeNode().getValue());
		System.out.println(node.getRightTreeNode().getValue());
		System.out.println(node.getLeftTreeNode().getLeftTreeNode().getValue());
		System.out.println(node.getLeftTreeNode().getRightTreeNode().getValue());
		System.out.println(node.getRightTreeNode().getLeftTreeNode().getValue());
		System.out.println(node.getRightTreeNode().getRightTreeNode().getValue());
		

	}

	/**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
	
	/**
	 * ���������л�
	 * @param root
	 * @return serialization String
	 */
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        
        StringBuilder str = new StringBuilder();
        serializaeSolve(root, str);
        String string = str.toString(); 
        
    	return string;
    }
    
    /**
     * ���л���������-��-��
     * @param root
     */
    private void serializaeSolve (TreeNode root, StringBuilder str) {
		if (root == null) {
			str.append("#" + ",");
			return ;
		}
		str.append(root.getValue() + ",");
		serializaeSolve(root.getLeftTreeNode(), str);
		serializaeSolve(root.getRightTreeNode(), str);
	}
    
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    
    /**
     * �������ķ����л�
     * @param data
     * @return TreeNode root
     */
    public TreeNode deserialize(String data) {
    	if (data == null || data.trim().equals("")) {
    		return null;
    	}
    	String[] str = data.split(",");
    	index = 0;
    	
    	return deserializeSolve(str);
    }
	
    /**
     * ������ÿһ��������,��-��-��
     * @param str
     * @param index
     * @return TreeNode
     */
    private TreeNode deserializeSolve (String[] str) {
    	if (str[index].equals("#")) {
    		index++;
    		return null;
    	}
    	//System.out.println(str[index]);
    	TreeNode node = new TreeNode(Integer.parseInt(str[index++]));
    	node.setLeftTreeNode(deserializeSolve(str));
    	node.setRightTreeNode(deserializeSolve(str));	
    	
    	return node;
	}
    
}

