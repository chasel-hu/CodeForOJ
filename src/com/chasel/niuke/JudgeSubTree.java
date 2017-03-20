package com.chasel.niuke;

public class JudgeSubTree {

	/**
	 * 判断root2是不是root1的子结构
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if(root1 == null || root2 == null) return false;
		TreeNode node = findTreeNode(root1,root2.val);
		if(node == null) return false;
		return judge(node, root2);
	}
	
	public TreeNode findTreeNode(TreeNode node, int k){
		if(node == null || node.val == k) return node;
		else if(node.val > k) return findTreeNode(node.left,k);
		else return findTreeNode(node.right,k);
	}
	
	public boolean judge(TreeNode root1, TreeNode root2){
		if(root1 == null && root2 == null) return true;
		else if(root1 == null || root2 == null) return false;
		
		if(root1.val != root2.val) return false;
		else return (judge(root1.left,root2.left)&&judge(root1.right,root2.right));
	}
	
	public static void main(String[] args) {
		TreeNode root2 = new TreeNode(8);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(18);
		
		TreeNode root1 = new TreeNode(8);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(18);
		
		JudgeSubTree jj = new JudgeSubTree();
		
		System.out.println(jj.HasSubtree(root1,root2));
	}
	
}
