package cn.vgbh.binaryTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * ��������ֵ k1 �� k2��k1 < k2����һ������������ĸ��ڵ㡣�ҵ���������ֵ�� k1 �� k2 ��Χ�ڵĽڵ㡣
 * ����ӡ����x (k1 <= x <= k2) ���� x �Ƕ�����������еĽڵ�ֵ��������������Ľڵ�ֵ��
 * 
 * �����������
 * 1��������ڵ�����������գ��������������нڵ��ֵ��С�����ĸ��ڵ��ֵ��
 * 2��������ڵ�����������գ��������������нڵ��ֵ���������ĸ��ڵ��ֵ��
 * 3������ڵ����������Ҳ�ֱ�Ϊ�����������
 * 4��û�м�ֵ��ȵĽڵ㡣
 * 
 * ʵ�֣�
 * ʹ�õݹ�ʵ�֣���root�ڵ��ֵ���ڵ���k1������С�ڵ���k2����ֱ�ȥѰ��������ڵ���ҽڵ㡣
 * ��С��k1����ȥѰ��root���ҽڵ㡣
 * ������k2����ȥѰ��root����ڵ㡣
 * 
 */

public class SearchRandFromBinaryTree {
	
	private List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		TreeNode g = new TreeNode(7);
		
		d.setLeftTreeNode(b);
		d.setRightTreeNode(f);
		b.setLeftTreeNode(a);
		b.setRightTreeNode(c);
		f.setLeftTreeNode(e);
		f.setRightTreeNode(g);
		
		
		SearchRandFromBinaryTree s = new SearchRandFromBinaryTree();
		
		List<Integer> list = new ArrayList<Integer>();
		list = s.searchRange(d, 2, 5);
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next().toString() + "\t");
		}
		
		
	}
	
	/**
	 * ��������������
	 * @param root (����������ĸ��ڵ�)
	 * @param k1
	 * @param k2
	 * @return �����ڵ�ֵ
	 */
	public List<Integer> searchRange (TreeNode root, int k1, int k2) {
		if (root == null) return list;
		
		if (root.getValue() >= k1 && root.getValue() <= k2) {
			list.add(root.getValue());
			searchRange(root.getLeftTreeNode(), k1, k2);
			searchRange(root.getRightTreeNode(), k1, k2);
		} else if (root.getValue() < k1) {
			searchRange(root.getRightTreeNode(), k1, k2);
		} else if (root.getValue() > k2) {
			searchRange(root.getLeftTreeNode(), k1, k2);
		}
		
		return list;
	}

	
}

