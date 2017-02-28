package com.chasel.leetcode.dynamic;

/**
 * 494. Target Sum
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2017-2-21
 * @version v1.0
 */
public class TargetSum {
	static int all = 0;
	/**
	 * 给定一个数组，里面有一些数，给定一个目标值。
	 * 利用数组的值加减之后得到目标值，找出有多少种情况。数组顺序不变
	 * @param nums
	 * @param S
	 * @return
	 */
	public static int findTargetSumWays(int[] nums, int S) {
		/*
		 * 碉堡的解决方案，可以看成把原来的数组分成两个部分P和N部分
		 * target = sum(P) - sum(N);
		 * target + sum(arr) = sum(P) - sum(N) + sum(P) + sum(N);
		 * target + sum(arr) = 2*sum(P);
		 * 问题就转换成找到数组的一个子集，和为(target + sum(arr))/2;
		 */
		int sum = 0;
		for(int i=0;i<nums.length;i++) sum += nums[i];
		
		//如果总和小于S，肯定没有解，或者对2求余不是整数也没有解。
        if(sum < S || (sum + S) %2==1) return 0;
        return findSubset(nums, (S+sum)>>>1);//除以2相当于右移一位
    }
	
	//找到符合要求的子集的个数，可以保证一定存在。这TM是个01背包问题啊
	public static int findSubset(int[] nums, int target){
		findSubSetFromIndex(nums,target,0);
		return all;
	}
	
	public static void findSubSetFromIndex(int[] nums, int target, int index){
		
		if(target < 0) return;
		if(index == nums.length){
			if(target == 0) all += 1;
			return ;
		}
		int temp = target - nums[index];
		findSubSetFromIndex(nums, temp, index + 1);
		findSubSetFromIndex(nums, target, index + 1);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,1,1,1,1};
		int target = 3;
		System.out.println("result is : " + findTargetSumWays(arr, target));
	}
}
