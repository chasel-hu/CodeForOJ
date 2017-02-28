package com.chasel.leetcode.dynamic;

/**
 * 416. Partition Equal Subset Sum
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2017-2-21
 * @version v1.0
 */
public class PartitionEqualSubsetSum {
	/**
	 * 这其实就是01背包问题，把问题转换成，找到和为sum/2的子集
	 * @param nums
	 * @return
	 */
	public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums)sum += n;
        if((sum % 2) == 1) return false;
        return findSubSetUseLoop(nums,sum >>> 1);
    }

	/**
	 * 奶奶个熊，又超时
	 * 换成动态规划来做吧。
	 * 假设f[i][j]表示从0-i，能存在使得和为j的序列
	 * 则转换转移方程为：如果nums[i]被选中，f[i][j] = f[i-1][j-nums[i]].
	 * 如果没被选中f[i][j] = f[i-1][j].
	 * @param nums
	 * @param target
	 * @param index
	 * @return
	 */
	public static boolean findSubSetUseLoop(int[] nums, int target){
		int len = nums.length;
		int[][] f = new int[len+1][target + 1];
		f[0][0] = 1;
		for(int i=0; i<len; i++){
			for(int j = 0; j<=target;j++){
				if(f[i][j] == 1) {
					f[i+1][j] = 1;
				}else if(j-nums[i] >= 0 && f[i][j-nums[i]] == 1) {
					f[i+1][j] = 1;
				}else{
					f[i+1][j] = 0;
				}
			}
		}
		for(int i = 0; i<len; i++){
			for(int j=0; j<=target; j++){
				System.out.print(f[i][j] + "  ");
			}
			System.out.println();
		}
		return (f[len][target] == 1)?true:false;
	}
	
	/**
	 * 方法正确，可惜递归层次太多，当数组长度过长，无法计算
	 * @param nums
	 * @param target
	 * @param index
	 * @return
	 */
	public static boolean findSubSetFromIndex(int[] nums, int target, int index) {

		if (target < 0)
			return false;
		if (index == nums.length) {
			if (target == 0)return true;
			return false;
		}
		int temp = target - nums[index];
		if(findSubSetFromIndex(nums, temp, index + 1)) return true;
		if(findSubSetFromIndex(nums, target, index + 1)) return true;
		
		return false;
	}

	public static void main(String[] args){
//		int[] arr = new int[]{1, 5, 11, 5};
		int[] arr = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100};
		System.out.println("result is : " + canPartition(arr));
	}
}
