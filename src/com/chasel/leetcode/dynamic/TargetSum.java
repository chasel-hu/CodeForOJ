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
	 * ����һ�����飬������һЩ��������һ��Ŀ��ֵ��
	 * ���������ֵ�Ӽ�֮��õ�Ŀ��ֵ���ҳ��ж��������������˳�򲻱�
	 * @param nums
	 * @param S
	 * @return
	 */
	public static int findTargetSumWays(int[] nums, int S) {
		/*
		 * �ﱤ�Ľ�����������Կ��ɰ�ԭ��������ֳ���������P��N����
		 * target = sum(P) - sum(N);
		 * target + sum(arr) = sum(P) - sum(N) + sum(P) + sum(N);
		 * target + sum(arr) = 2*sum(P);
		 * �����ת�����ҵ������һ���Ӽ�����Ϊ(target + sum(arr))/2;
		 */
		int sum = 0;
		for(int i=0;i<nums.length;i++) sum += nums[i];
		
		//����ܺ�С��S���϶�û�н⣬���߶�2���಻������Ҳû�н⡣
        if(sum < S || (sum + S) %2==1) return 0;
        return findSubset(nums, (S+sum)>>>1);//����2�൱������һλ
    }
	
	//�ҵ�����Ҫ����Ӽ��ĸ��������Ա�֤һ�����ڡ���TM�Ǹ�01�������Ⱑ
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
