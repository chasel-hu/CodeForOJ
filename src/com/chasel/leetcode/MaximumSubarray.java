package com.chasel.leetcode;

/**
 * 53. Maximum Subarray
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2016-10-27
 * @version v1.0
 */
public class MaximumSubarray {
	
	/**
	 * 找到数组中子串和最大【动态规划】
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		if(nums.length == 0) return 0;
		int max = nums[0];
		int b = nums[0];
		for(int i=1; i<nums.length; i++){
			if(b <= 0) b = nums[i];
			else b += nums[i];
			
			if(b > max) max = b;
		}
        return max;
    }
	
	public static void main(String[] args) {
		MaximumSubarray obj = new MaximumSubarray();
		int[] nums = new int[]{-2};
		System.err.println(obj.maxSubArray(nums));
	}
}
