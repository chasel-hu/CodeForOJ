package com.chasel.leetcode;

/**
 * 
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2016-10-15
 * @version v1.0
 */
public class FirstMissingPositive {

	/**
	 * 找到第一个缺少的正整数
	 * 数组未排序，时间复杂度O(n),空间复杂度常量
	 * @param nums
	 * @return
	 */
	public int firstMissingPositive(int[] nums) {
		
		int len = nums.length;
		for(int i=0;i<len;i++){
			if(nums[i] > len || nums[i] <= 0){
				nums[i] = 0;
				continue;
			}
			if(nums[i] != i+1){
				int temp = nums[i];
				while(true){
					if(nums[i] == nums[temp-1]){
						nums[temp-1] = 0;
					}
					nums[i] = nums[temp-1];
					nums[temp-1] = temp;
					if(nums[i] > len || nums[i] <= 0){
						nums[i] = 0;
						break;
					}else if(nums[i] == i+1){
						break;
					}
					temp = nums[i];
				}
			}
		}
		
		int t = 0;
		for(;t<len;t++){
			if(nums[t] != t+1) break;
		}
		
		return t+1;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{2,2};
		FirstMissingPositive obj = new FirstMissingPositive();
		System.err.println(obj.firstMissingPositive(arr));
	}
}
