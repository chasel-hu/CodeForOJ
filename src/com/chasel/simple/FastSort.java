package com.chasel.simple;

public class FastSort {
	/**
	 * ¿ìËÙÅÅĞò
	 * @param arr
	 */
	public static void sort(int[] arr, int start, int end){
		if(start >= end) return;
		int h = start;
		int t = end;
		int target = arr[start];
		while(h<t){
			while(h<t && target <= arr[t]) t--;
			arr[h] = arr[t];
			while(h<t && target >= arr[h]) h++;
			arr[t] = arr[h];
		}
		arr[h] = target;
		
//		sort(arr,start,h-1);
//		sort(arr,h+1,end);
	}
	
	public static void adjustArray(int[] arr, int start, int end){
		if(start >= end) return;
		int h = start;
		int t = end;
		int index = start;
		while(h<t){
			while(h<t && arr[index] <= arr[t]) t--;
			int tmp = arr[index];
			arr[index] = arr[t];
			arr[t] = tmp;
			index = t;
			while(h<t && arr[index] >= arr[h]) h++;
			tmp = arr[index];
			arr[index] = arr[h];
			arr[h] = tmp;
			index = h;
		}
		adjustArray(arr,start,h-1);
		adjustArray(arr,h+1,end);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{4,5,1,6,2,7,3,8};
		sort(arr,0,arr.length-1);
		
		for(int a:arr) System.out.print(a + " ");
	}
	
}
