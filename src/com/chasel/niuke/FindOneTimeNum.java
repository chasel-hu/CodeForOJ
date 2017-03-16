package com.chasel.niuke;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FindOneTimeNum {
	
	public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]){
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<array.length; i++){
			int a = array[i];
			if(map.containsKey(a)) map.remove(a);
			else map.put(a, a);
		}
		Iterator<Integer> ite = map.values().iterator();
		if(ite.hasNext()) num1[0] = ite.next();
		if(ite.hasNext()) num2[0] = ite.next();
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{2,4,3,6,3,2,5,5};
		int[] num1 = new int[]{0};
		int[] num2 = new int[]{0};
		FindNumsAppearOnce(arr,num1,num2);
		
		System.out.println(num1[0] + " - " + num2[0]);
	}
}
