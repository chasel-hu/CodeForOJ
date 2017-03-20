package com.chasel.mi;

import java.util.ArrayList;
import java.util.List;

public class CalculateMax {

	/**
     * 计算你能获得的最大收益
     * 
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
    public static int calculateMax(int[] prices) {
    	int one = pickOne(prices,0,prices.length);
    	int two = 0;
    	if(prices.length >= 4) two = pickTwo(prices);
    	return (one > two) ? one : two;
    }
    
    public static int pickOne(int[] prices, int start, int end){
    	int min = prices[start];
    	int max = 0;
    	for(int i=start + 1; i<end; i++){
    		if(min > prices[i]) min = prices[i];
    		else {
    			int tmp = prices[i] - min;
    			if(tmp > max) max = tmp;
    		}
    	}
    	return max;
    }
    
    public static int pickTwo(int[] prices){
    	int sum = 0;
    	for(int i=2; i<prices.length-1; i++){
    		int tmp = pickOne(prices,0,i) + pickOne(prices,i,prices.length);
    		sum = (sum > tmp)?sum:tmp;
    	}
    	return sum;
    }
    
    public static void main(String[] args) {
		int[] a = new int[]{31,41};
		System.out.println(calculateMax(a));
	}
}
