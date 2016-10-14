package com.chasel.leetcode;

/**
 * 34. Search for a Range
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2016-10-13
 * @version v1.0
 */
public class SearchRange {

	/**
	 * �����ź�������飬�ҳ���targetΪ��ʼ�ͽ����������±꣬�Ҳ�������[-1,-1]
	 * Ҫ��ʱ�临�Ӷ�O(logn)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] searchRange(int[] nums, int target) {
		int[] arr = new int[]{-1,-1};
		int index = findIndex(nums, target, 0, nums.length-1);
		if(index != -1){
			arr = searchRange(nums, target, index);
		}
        return arr;
    }
	
	/**
	 * �ݹ��ҵ���������Ŀ��ֵ��ȵ�ֵ���±꣬���û�з���-1
	 * @param nums
	 * @param target
	 * @param head
	 * @param tail
	 * @return
	 */
	public int findIndex(int[] nums, int target, int head, int tail){
		if(head <= tail && head >= 0 && tail <= nums.length - 1){
			int m = (head + tail)/2;
			if(nums[m] < target) return findIndex(nums, target, m+1, tail);
			else if(nums[m] > target) return findIndex(nums, target, head, m-1);
			else return m;
		}
		return -1;
	}
	
	/**
	 * ����������Ŀ��ֵ�ķ�Χ��������Ŀ��ֵ������λ�ã��������߲���
	 * @param nums ����
	 * @param target Ŀ��ֵ
	 * @param index �����±�[������ڵ���0]
	 * @return
	 */
	public int[] searchRange(int[] nums, int target, int index){
		int[] arr = new int[]{index,index};
		int head = index;
		while(head >= 0){
			if(nums[head]!=target){
				break;
			}
			head--;
		}
		arr[0] = head + 1;
		
		head = index;
		while(head <nums.length){
			if(nums[head]!=target){
				break;
			}
			head++;
		}
		arr[1] = head - 1 ;
        return arr;
	}
	
	public static void main(String[] args) {
		SearchRange obj = new SearchRange();
		int[] arr = new int[]{1};
		int[] len = obj.searchRange(arr,8);
		
		for(int i=0;i<len.length;i++){
			System.out.println(len[i]);
		}
	}
}
