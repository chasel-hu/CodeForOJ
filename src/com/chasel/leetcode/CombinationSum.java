package com.chasel.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 39. Combination Sum
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2016-10-13
 * @version v1.0
 */
public class CombinationSum {

	/**
	 * 给定一个数组，一个目标值。
	 * 找到数组中，所有和为目标值的所有数字【相同的数可以使用无限次】
	 * 结果不包含重复数组
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(candidates==null || candidates.length==0) return list;
		Arrays.sort(candidates);// 题目并没有说已经排好序，所以先排序
		List<Integer> current = new ArrayList<Integer>();
		findSum(candidates,target,list, current);
        return list;
    }
	
	/**
	 * 递归找到集合中的所有数
	 * @param candidates
	 * @param target
	 * @param list
	 * @param current
	 */
	public void findSum(int[] candidates, int target, List<List<Integer>> list, List<Integer> current){
		if(target < 0) return;
		if(target == 0){
			Collections.sort(current);
			if(!isDuplicate(list,current))
				list.add(current);
			return;
		}else{
			for(int i=0;i<candidates.length;i++){
				List<Integer> newOne = new ArrayList<Integer>();
				newOne.addAll(current);
				newOne.add(candidates[i]);
				if(target - candidates[i] < 0) break;
				findSum(candidates,target - candidates[i],list,newOne);
			}
		}
	}
	
	/**
	 * 判断待添加的list是否已经存在于list中
	 * @param list
	 * @param integer
	 * @return
	 */
	public boolean isDuplicate(List<List<Integer>> list, List<Integer> integer){
		boolean flag = true;
		for(int i=0; i<list.size();i++){
			List<Integer> temp = list.get(i);
			flag = true;
			if(temp.size() != integer.size()) continue;
			for(int j=0;j<temp.size();j++){
				if(temp.get(j)!=integer.get(j)) {
					flag = false;
					break;
				}
			}
			if(flag) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		CombinationSum obj = new CombinationSum();
		int[] arr = new int[]{6,3,5,8,7,12,11,9,4};
		List<List<Integer>> list = obj.combinationSum(arr,21);
		if(list != null && list.size() > 0){
			for(int i=0; i<list.size();i++){
				List<Integer> integer = list.get(i);
				System.out.println("< " + integer + " >");
			}
		}else{
			System.out.println("-- list is null -- ");
		}
	}
}
