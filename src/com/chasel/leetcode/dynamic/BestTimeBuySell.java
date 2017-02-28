package com.chasel.leetcode.dynamic;

public class BestTimeBuySell {

	public static int maxProfit(int[] prices){
		int max = 0,min = prices[0];
		for(int a:prices){
			if(min > a) min = a;
			else{
				int temp = a - min;
				if(temp > max) max = temp;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{7,1,5,3,6,4};
		System.err.println(maxProfit(arr));
	}
}
