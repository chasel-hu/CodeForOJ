package com.chasel.niuke;

public class Finduplication {
	public static boolean duplicate(int numbers[],int length,int [] duplication) {
		int len = 0;
		if(numbers == null || (len=numbers.length)<=1) {
	    	duplication[0] = -1;
	    	return false;
	    }
	    int[] arr = new int[len];
	    for(int i=0;i<len; i++) {
	    	arr[numbers[i]]++;
	    	if(arr[numbers[i]] == 2){
	    		duplication[0] = numbers[i];
	    		return true;
	    	}
	    }
	    duplication[0] = -1;
	    return false;
    }
	
	public static void main(String[] args) {
		int[] number = new int[]{2,1,3,1,4};
		int[] dup = new int[1];
		System.err.println(duplicate(number,number.length,dup));
	}
}
