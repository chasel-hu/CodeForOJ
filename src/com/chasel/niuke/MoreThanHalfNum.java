package com.chasel.niuke;

import java.util.HashMap;
import java.util.Map;

public class MoreThanHalfNum {
	public static int MoreThanHalfNum_Solution(int[] array) {
		int m = array.length/2;
		int max = 0;
		int index = 0;
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0; i<array.length; i++){
			if(map.containsKey(array[i])) {
				int a = map.get(array[i]) + 1;
				map.put(array[i], a);
				if(max < a) {
					max = a;
					index = i;
				}
			}else{
				map.put(array[i], 1);
			}
		}
		if(max > m) return array[index];
		else return 0;
	}
	
	public static void main(String[] args) {
		int[] nn = new int[]{1,2,3,2,4,2,5,2,3};
		System.out.println(MoreThanHalfNum_Solution(nn));
	}
}
