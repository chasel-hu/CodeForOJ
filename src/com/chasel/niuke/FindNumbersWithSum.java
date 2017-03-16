package com.chasel.niuke;

import java.util.ArrayList;
import java.util.List;

public class FindNumbersWithSum {

	public static ArrayList<Integer> solution(int [] array,int sum) {
        int i=0,j=array.length-1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] arr = new int[]{0,0};
        if(j<=0) return list;
        int max = Integer.MAX_VALUE;
        while(i<j){
        	int tmp = array[i] + array[j];
        	if(tmp == sum){
        		if(array[i] * array[j] < max){
        			arr[0] = array[i];
        			arr[1] = array[j];
        			max = array[i] * array[j];
        		}
        		i++;
        		j--;
        	}else if(tmp > sum) j--;
        	else i++;
        }
        list.add(arr[0]);
        list.add(arr[1]);
        return list;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
		int sum = 10;
		List<Integer> list = solution(arr,sum);
		for(int a : list)System.out.print(a + " ");
	}
}
