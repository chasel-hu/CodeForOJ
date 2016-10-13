package com.chasel.leetcode;

/**
 * 26. Remove Duplicates from Sorted Array
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2016-10-13
 * @version v1.0
 */
public class RemoveDuplicates {
	/**
	 * 移除掉重复的数字，并返回移除后长度
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
		int head = 1;
		if(nums == null || nums.length == 0) return 0;
		for(int i=1;i<nums.length;i++){
			if(nums[i] != nums[i-1]){
				nums[head] = nums[i];
				head++;
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		RemoveDuplicates obj = new RemoveDuplicates();
		int[] arr = new int[]{1,1,2};
		int len = obj.removeDuplicates(arr);
		for(int i=0;i<len;i++){
			System.out.println(arr[i]);
		}
	}
}
