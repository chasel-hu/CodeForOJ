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
	 * ����ʵ����01�������⣬������ת���ɣ��ҵ���Ϊsum/2���Ӽ�
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
	 * ���̸��ܣ��ֳ�ʱ
	 * ���ɶ�̬�滮�����ɡ�
	 * ����f[i][j]��ʾ��0-i���ܴ���ʹ�ú�Ϊj������
	 * ��ת��ת�Ʒ���Ϊ�����nums[i]��ѡ�У�f[i][j] = f[i-1][j-nums[i]].
	 * ���û��ѡ��f[i][j] = f[i-1][j].
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
	 * ������ȷ����ϧ�ݹ���̫�࣬�����鳤�ȹ������޷�����
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
