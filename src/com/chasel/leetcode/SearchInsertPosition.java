package com.chasel.leetcode;

/**
 * 35. Search Insert Position
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2016-10-13
 * @version v1.0
 */
public class SearchInsertPosition {

	/**
	 * ����һ�����е������Ŀ��ֵ
	 * ����ҵ�Ŀ��ֵ���򷵻��±�ֵ
	 * ����Ҳ������򷵻ؿ��Բ����λ��
	 * @param nums
	 * @param target
	 * @return
	 */
	public int searchInsert(int[] nums, int target) {
        int index = findIndex(nums, target,0,nums.length-1);
		return index;
    }
	
	/**
	 * �ݹ��ҵ���������Ŀ��ֵ��ȵ�ֵ���±꣬���û�з��ؿ��Բ����λ��
	 * @param nums
	 * @param target
	 * @param head
	 * @param tail
	 * @return
	 */
	public int findIndex(int[] nums, int target, int head, int tail){
		if (head <= tail && head >= 0 && tail <= nums.length - 1) {
			int m = (head + tail) / 2;
			if (nums[m] < target) return findIndex(nums, target, m + 1, tail);
			else if (nums[m] > target) return findIndex(nums, target, head, m - 1);
			else return m;
		} else if (tail >= 0) {
			if (nums[tail] < target) return tail + 1;
			else if (tail == 0) return 0;
			else return tail - 1;
		} else {
			if (nums[head] < target) return head + 1;
			else if (head == 0) return 0;
			else return head - 1;
		}
	}
	
	public static void main(String[] args) {
		SearchInsertPosition obj = new SearchInsertPosition();
		int[] arr = new int[]{1};
		int len = obj.searchInsert(arr,2);
		System.err.println(len);
	}
}
