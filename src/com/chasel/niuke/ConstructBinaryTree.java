package com.chasel.niuke;

public class ConstructBinaryTree {

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if(pre.length ==0 || pre.length != in.length) return null;
		TreeNode node = createSubTree(pre,0,pre.length-1,in,0,in.length-1);
		return node;
	}
	
	private TreeNode createSubTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn){
		if(startPre > endPre) return null;
		TreeNode node = new TreeNode(pre[startPre]);
		if(startPre == endPre) return node;
		
		int i = startIn;
		for(; i<=endIn; i++)
			if(in[i] == pre[startPre])break;
		
		int left = i - startIn;
		
		node.left = createSubTree(pre,startPre+1,startPre+left,in,startIn,i-1);
		node.right = createSubTree(pre,startPre+left+1,endPre,in,i+1,endIn);
		
		return node;
	}
}
