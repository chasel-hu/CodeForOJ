package com.chasel.leetcode;

/**
 * 动态规划求最长的回文串
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2017-2-20
 * @version v1.0
 */
public class LongestPalindromicSubsequence {
	
	public static int longestPalindromeSubseq(String s) {
		int len = s.length();
		char[] c = s.toCharArray();
		int[][] d = new int[len][len];
		for(int i=0; i<len; i++){
			for(int j=0; j<len;j++){
				if(i==j) d[i][j] = 1;
				else d[i][j] = 0;
			}
		}
		for(int i=len-2;i>=0;i--){
			for(int j=i+1;j<len;j++){
				if(j-1 >= i+1 && c[i] == c[j]){
					d[i][j] = d[i+1][j-1] + 2;
				}else if(c[i] == c[j]){
					d[i][j] = 2;
				}else{
					d[i][j] = Math.max(d[i+1][j], d[i][j-1]);
				}
			}
		}
		
//		for(int i=0; i<len; i++){
//			for(int j=0; j<len;j++){
//				System.out.print(d[i][j] + "  ");
//			}
//			System.out.println();
//		}
//		
        return d[0][len-1];
    }
	
	public static void main(String[] args) {
		String s = "aaa";
		int num = longestPalindromeSubseq(s);
		System.out.println("result is : " + num);
	}
}
