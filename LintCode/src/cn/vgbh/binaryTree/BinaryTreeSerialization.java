package cn.vgbh.binaryTree;

/*
 * 二叉树的序列化和反序列化
 * 
 * 二叉树：
 * a(1)
 * b(2) c(3)
 * d(4) e(5) f(6) g(7)
 * 
 * 栈：
 * 深度优先遍历各个节点，需要使用到堆（Stack）这种数据结构。stack的特点是是先进后出。整个遍历过程如下：
 * 首先将A节点压入堆中，stack（A）;
 * 将A节点弹出，同时将A的子节点C，B压入堆中，此时B在堆的顶部，stack(B,C)；
 * 将B节点弹出，同时将B的子节点E，D压入堆中，此时D在堆的顶部，stack（D,E,C）；
 * 将D节点弹出，没有子节点压入,此时E在堆的顶部，stack（E，C）；
 * 将E节点弹出，同时将E的子节点I压入，stack（I,C）；
 * 
 * 
 * 队列：
 * 广度优先遍历各个节点，需要使用到队列（Queue）这种数据结构，queue的特点是先进先出，其实也可以使用双端队列，区别就是双端队列首位都可以插入和弹出节点。整个遍历过程如下：
 * 首先将A节点插入队列中，queue（A）;
 * 将A节点弹出，同时将A的子节点B，C插入队列中，此时B在队列首，C在队列尾部，queue（B，C）；
 * 将B节点弹出，同时将B的子节点D，E插入队列中，此时C在队列首，E在队列尾部，queue（C，D，E）;
 * 将C节点弹出，同时将C的子节点F，G，H插入队列中，此时D在队列首，H在队列尾部，queue（D，E，F，G，H）；
 * 将D节点弹出，D没有子节点，此时E在队列首，H在队列尾部，queue（E，F，G，H）；
 * 
 */

public class BinaryTreeSerialization {
	
    private int index ;//反序列化，字符数组的的指针

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
	 * 二叉树序列化
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
     * 序列化操作：根-左-右
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
     * 二叉树的反序列化
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
     * 解析出每一个二叉树,根-左-右
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

