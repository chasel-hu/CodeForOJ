package com.chasel.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 40. Combination Sum II
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2016-10-14
 * @version v1.0
 */
public class CombinationSumSecond {

	/**
	 * 给定一个数组，一个目标值。
	 * 找到数组中，所有和为目标值的所有数字【相同的数可以使用无限次】
	 * 结果不包含重复数组
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSumSecond(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(candidates==null || candidates.length==0) return list;
		Arrays.sort(candidates);// 题目并没有说已经排好序，所以先排序
		
		List<Integer> current = new ArrayList<Integer>();
		findSum(candidates,target,list, current, 0);
        return list;
    }
	
	/**
	 * 递归找到集合中的所有数
	 * @param candidates
	 * @param target
	 * @param list
	 * @param current
	 */
	public void findSum(int[] candidates, int target, List<List<Integer>> list, List<Integer> current, int index){
		if(target < 0) return;
		if(target == 0){
			Collections.sort(current);
			if(!isDuplicate(list,current))
				list.add(current);
			return;
		}else{
			for(int i=index;i<candidates.length;i++){
				List<Integer> newOne = new ArrayList<Integer>();
				newOne.addAll(current);
				newOne.add(candidates[i]);
				if(target - candidates[i] < 0) break;
				findSum(candidates,target - candidates[i],list,newOne,i+1);
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
		CombinationSumSecond obj = new CombinationSumSecond();
		int[] arr = new int[]{10, 1, 2, 7, 6, 1, 5};
		List<List<Integer>> list = obj.combinationSumSecond(arr,8);
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
