package com.chasel.huawei;

public class FirstRepeat {
	public char findFirstRepeat(String A, int n) {
        int[] arr = new int[256];
        for(int i=0;i<n;i++){
        	if(arr[A.charAt(i)] > 0) return A.charAt(i);
        	else arr[A.charAt(i)] = 1;
        }
        return '0';
    }
	
	public static void main(String[] args) {
	}
}
