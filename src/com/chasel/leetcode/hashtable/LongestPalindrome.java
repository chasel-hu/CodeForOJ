package com.chasel.leetcode.hashtable;
/**
 * 409. Longest Palindrome
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2017-2-28
 * @version v1.0
 */
public class LongestPalindrome {
	/**
	 * 根据给定的字符串，生成最长的回文串的长度
	 * @param s
	 * @return
	 */
	public static int longestPalindrome(String s) {
        int[] count = new int[52];
        for(int i=0; i<s.length(); i++){
        	if(s.charAt(i) > 96){
        		count[s.charAt(i) - 71]++;
        	}else{
        		count[s.charAt(i) - 65]++;
        	}
        }
        
        int total = 0;
        boolean flag = false;
        for(int i=0; i<52; i++){
        	if(count[i]%2==0) total += count[i];
        	else{
        		if(count[i] > 1) total += count[i] - 1;
        		flag = true;
        	}
        }
        if(flag) total += 1;
        
        return total;
    }
	
	public static void main(String[] args) {
		String s = "abccccdd";
		System.out.println(longestPalindrome(s));
	}
}
