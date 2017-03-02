package com.chasel.leetcode.hashtable;
/**
 * 389. Find the Difference
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2017-2-28
 * @version v1.0
 */
public class FindDifference {
    public static char findTheDifference(String s, String t) {
    	int[] count = new int[26];
    	char result = '0';
    	for(int i=0; i<s.length(); i++) count[s.charAt(i) - 97]++;
    	for(int i=0; i<t.length(); i++){
    		count[t.charAt(i) - 97]--;
    		if(count[t.charAt(i) - 97] < 0) result = t.charAt(i);
    	}
    	return result;
    }
}
