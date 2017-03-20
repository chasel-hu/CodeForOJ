package com.chasel.huawei;

public class BinarySearch {
	public static int getPos(int[] A, int n, int val) {
		int po = getPositionOfK(A,0,n-1,val);
		System.out.println(po);
		if(po <= 0) return po;
		for(int i=po;i>=0;i--){
			if(A[i] != val) return i+1;
		}
		return 0;
    }
	
	public static int getPositionOfK(int[] A,int start, int end, int k){
		if(start > end) return -1;
		int m = (start+end)/2;
		if(A[m] == k) return m;
		else if(A[m] > k) return getPositionOfK(A,start,m-1,k);
		else return getPositionOfK(A,m+1,end,k);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{4,4,10,21};
		int val = 4;
		System.out.println(getPos(arr,arr.length,val));
	}
}
