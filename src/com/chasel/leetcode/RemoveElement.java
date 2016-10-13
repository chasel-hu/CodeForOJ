package com.chasel.leetcode;

/**
 * 27. Remove Element
 * 
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2016-10-13
 * @version v1.0
 */
public class RemoveElement {
	
	/**
	 * ����һ�������һ��ֵ���Ƴ��������и�����ȵ����������س���
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement(int[] nums, int val) {
		int head = 0;
		if(nums == null || nums.length == 0) return 0;
		for(int i=0; i<nums.length;i++){
			if(nums[i] != val){
				nums[head] = nums[i];
				head ++;
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		RemoveElement obj = new RemoveElement();
		int[] arr = new int[] { 2,2,2,3 };
		int len = obj.removeElement(arr,0);
		for (int i = 0; i < len; i++) {
			System.out.println(arr[i]);
		}
	}
}
