package com.chasel.huawei;

public class LongestDistance {
	public int getDis(int[] A, int n) {
		if(n<=1) return 0;
		int min = A[0];
    	int max = 0;
    	for(int i=1; i<n; i++){
    		if(min > A[i]) min = A[i];
    		else {
    			int tmp = A[i] - min;
    			if(tmp > max) max = tmp;
    		}
    	}
    	return max;
    }
}
