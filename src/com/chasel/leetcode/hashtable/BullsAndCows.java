package com.chasel.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 299. Bulls and Cows
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2017-3-1
 * @version v1.0
 */
public class BullsAndCows {
	/**
	 * 
	 * @param secret
	 * @param guess
	 * @return
	 */
	public static String getHint(String secret, String guess) {
		int bull = 0;
		int cow = 0;
		int[] nums = new int[10];
		for(int i=0; i<secret.length(); i++){
			if(secret.charAt(i) == guess.charAt(i)) {
				bull++;
			}else nums[secret.charAt(i) - 48] += 1; 
		}
		for(int i=0; i<secret.length(); i++){
			if(secret.charAt(i) != guess.charAt(i)) {
				if(nums[guess.charAt(i) - 48] > 0) {
					nums[guess.charAt(i) - 48] --;
					cow ++;
				}
			}
		}
		
        return bull + "A" + cow + "B";
    }
	
	public static void main(String[] args) {
		String secret = "1122";
		String guess = "1222";
		System.out.println(getHint(secret,guess));
	}
}
