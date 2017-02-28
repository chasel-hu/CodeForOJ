package com.chasel.leetcode.dynamic;
/**
 * 300. Longest Increasing Subsequence
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2017-2-23
 * @version v1.0
 */
public class LongestIncreasingSubsequence {
	public static int lengthOfLIS(int[] nums) {
		if(nums.length == 0) return 0;
		int[] d = new int[nums.length + 1];//表示最长为i时，最小值为多少
		int index = 0;
		d[0] = nums[0];
		for(int i=1 ; i < nums.length; i++){
			if(nums[i] > d[index]){
				index += 1;
				d[index] = nums[i];
			}else if(nums[i] < d[index]){
				//【这里可以改善为二分查找】，因为数组d明显有序，可以把复杂度降低为log(n)
				for(int j = 0; j <= index; j++){
					if(d[j] >= nums[i]){
						d[j] = nums[i];
						break;
					}
				}
			}
		}
        return index + 1;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{4,10,4,3,8,9};
		System.out.println("result is : " + lengthOfLIS(arr));
	}
}
