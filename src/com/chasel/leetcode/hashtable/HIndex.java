package com.chasel.leetcode.hashtable;

import java.util.Arrays;

/**
 * 274. H-Index
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2017-3-2
 * @version v1.0
 */
public class HIndex {
	
	public int hIndex(int[] citations) {
		if(citations.length == 0) return 0;
        Arrays.sort(citations);
        int min = 0;
        for(int i=citations.length-1; i>=0; i--){
        	if(citations[i] >= min+1) min++;
        	else break;
        }
        
        return min;
    }
	
	
}
