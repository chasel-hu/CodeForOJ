package com.chasel.niuke;

import java.util.ArrayList;

public class FindMaxInWindows {
	
	public static ArrayList<Integer> maxInWindows(int [] num, int size){
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(num.length ==0 || size==0 || size > num.length) return list;
		int first = maxNum(num,0,size);
		list.add(first);
		if(num.length == size){
			return list;
		}
		
		int len = num.length - size;
		
		for(int i=1; i<=len; i++){
			if(first == num[i-1]) {
				first = maxNum(num,i,i + size);
				System.out.println(" - " + first);
			}
			else if(first < num[i+size-1]) first = num[i+size-1];
			list.add(first);
		}
		
		return list;
    }
	
	public static int maxNum(int[] num, int start,int end){
		int max = num[start];
		for(int i=start + 1; i<end && i<num.length; i++){
			if(num[i] > max) max = num[i];
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] num = new int[]{16,14,12,10,8,6,4};
		ArrayList<Integer> list = maxInWindows(num,5);
		for(int i : list) System.out.print(i + " ");
	}
}
